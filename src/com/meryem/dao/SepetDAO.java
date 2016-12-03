package com.meryem.dao;

import java.sql.*;
import java.util.ArrayList;
import com.meryem.model.*;

public class SepetDAO {
	static String connectionURL;
	static Connection con = null;
	PreparedStatement ps = null;

	protected static void Connect() {
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			connectionURL = "jdbc:mysql://localhost:3306/db_eshop";
			con = DriverManager.getConnection(connectionURL, "root", "12345");
		} catch (Exception err) {
			System.out.println("mysql Driver Bulunamadý");
		}
	}
	
	public static void SepeteEkle(Sepet sepet){
		try{
			Connect();
			String querry = "INSERT INTO tb_sepet (sepetDurum, urunId, kullaniciMail) VALUES (?, ?, ?)";
			PreparedStatement ps = (PreparedStatement) con.prepareStatement(querry);
			ps.setInt(1, sepet.getSepetDurum());
			ps.setInt(2, sepet.getUrunId());
			ps.setString(3, sepet.getKullaniciMail());
			ps.executeUpdate();
			System.out.println(" --- Sepete Eklendi ---");
		}catch(Exception err){
			System.out.println(" !!! Sepete Ekleme Baþarýsýz !!!" + err);			
		}
	}
	
	public static ArrayList<Urun> KullaniciSepet(String kullaniciMail, int sepetDurum){
		ArrayList<Urun> kullaniciSepetListe = new ArrayList<Urun>();
		try{
			Connect();
			String querry = "SELECT urunId FROM tb_sepet WHERE kullaniciMail=? AND sepetDurum=?";
			PreparedStatement ps = (PreparedStatement) con.prepareStatement(querry);
			ps.setString(1, kullaniciMail);
			ps.setInt(2, sepetDurum);
			ResultSet row = ps.executeQuery();
			while(row.next()){
				//Sepet tablosundan çekilen ürün idleri UrunDAO nun Idye göre urun getir
				//metoduyla alýnan ürün, listeye eklenir. 
				kullaniciSepetListe.addAll(UrunDAO.IdUrunGetir(row.getInt("urunId")));
			}
			
		}catch(Exception err){
			System.out.println(" !!! Ürün getirilemedi !!! " + err);
		}
		return kullaniciSepetListe;
	}
	
	public static void SepetDurumDegistir(String kullaniciMail){
		try{
			Connect();
			String querry = "UPDATE tb_sepet SET urunDurum=? WHERE kullaniciMail=?";
			PreparedStatement ps = (PreparedStatement) con.prepareStatement(querry);
			ps.setInt(1, 1);
			ps.setString(2, kullaniciMail);
			ps.executeUpdate();
			System.out.println(" --- Sipariþ Verildi --- ");
		}catch(Exception err){
			System.out.println(" !!! Sipariþ verilmedi !!! " + err);	
		}
	}
	public static void SepetUrunSil(String kullaniciMail, int urunId){
		try{
			Connect();
			String querry = "DELETE FROM tb_sepet WHERE kullaniciMail=? AND urunId=? AND sepetDurum=0 LIMIT 1";
			PreparedStatement ps = (PreparedStatement) con.prepareStatement(querry);
			ps.setString(1, kullaniciMail);
			ps.setInt(2, urunId);
			ps.executeUpdate();
			System.out.println(" --- Ürün Silindi --- ");
		}catch(Exception err){
			System.out.println(" !!! Ürün Silinemedi !!! " + err);	
		}
	}
}
