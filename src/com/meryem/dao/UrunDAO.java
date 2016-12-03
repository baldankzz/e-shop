package com.meryem.dao;
import java.sql.*;
import java.util.ArrayList;
import com.meryem.model.*;

public class UrunDAO {
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
	
	public static void UrunEkle(Urun urun){
		try{
			Connect();
			String querry = "INSERT INTO tb_urun(urunAd, urunBilgi, urunFiyat, kategoriId) VALUE (?, ?, ?, ?)";
			PreparedStatement ps = (PreparedStatement) con.prepareStatement(querry);
			ps.setString(1, urun.getUrunAd());
			ps.setString(2, urun.getUrunBilgi());
			ps.setInt(3, urun.getUrunFiyat());
			ps.setInt(4, urun.getKategoriId());
			ps.executeUpdate();
			System.out.println(" - Ürün Ekleme Baþarýlý - ");
		}catch(Exception err){
			System.out.println(" !!! Ürün Eklenemedi !!! " + err);
		}
	}
	public static ArrayList<Urun> TumUrunler(){
		ArrayList<Urun> tumUrunListe = new ArrayList<Urun>();
		try{
			Connect();
			String querry = "SELECT * FROM tb_urun";
			PreparedStatement ps = (PreparedStatement) con.prepareStatement(querry);
			ResultSet row = ps.executeQuery();
			while(row.next()){
				Urun urun = new Urun();//Ürün nesnesi oluþturulur
				urun.setUrunId(row.getInt("urunId"));
				urun.setUrunAd(row.getString("urunAd"));
				urun.setUrunBilgi(row.getString("urunBilgi"));
				urun.setUrunFiyat(row.getInt("urunFiyat"));
				urun.setKategoriId(row.getInt("kategoriId"));//deðerler atandý
				tumUrunListe.add(urun);//nesne listeye eklendi
				
				//[* , * , * , *]
				//*.getAd()
			}
		}catch(Exception err){
			System.out.println(" !!! Ürün Listelenirken Hata Oluþtu !!! " + err);
		}
		return tumUrunListe;
	}
	public static ArrayList<Urun> IdUrunGetir(int urunId){
		ArrayList<Urun> urunIdListe = new ArrayList<Urun>();
		try{
			Connect();
			String querry = "SELECT * FROM tb_urun WHERE urunId=?";
			PreparedStatement ps = (PreparedStatement) con.prepareStatement(querry);
			ps.setInt(1, urunId);
			ResultSet row = ps.executeQuery();
			while(row.next()){
				Urun urun = new Urun();
				urun.setUrunId(row.getInt("urunId"));
				urun.setUrunAd(row.getString("urunAd"));
				urun.setUrunBilgi(row.getString("urunBilgi"));
				urun.setUrunFiyat(row.getInt("urunFiyat"));
				urunIdListe.add(urun);
			}
		}catch(Exception err){
			System.out.println(" !!! Ürün Listelenirken Hata Oluþtu !!! " + err);			
		}
		return urunIdListe;
	}
	
	public static ArrayList<Urun> KategoriUrunGetir(int kategoriId){
		ArrayList<Urun> urunKategoriListe = new ArrayList<Urun>();
		try{
			Connect();
			String querry = "SELECT * FROM tb_urun WHERE kategoriId=?";
			PreparedStatement ps = (PreparedStatement) con.prepareStatement(querry);
			ps.setInt(1, kategoriId);
			ResultSet row = ps.executeQuery();
			while(row.next()){
				Urun urun = new Urun();
				urun.setUrunId(row.getInt("urunId"));
				urun.setUrunAd(row.getString("urunAd"));
				urun.setUrunBilgi(row.getString("urunBilgi"));
				urun.setUrunFiyat(row.getInt("urunFiyat"));
				urunKategoriListe.add(urun);
			}
		}catch(Exception err){
			System.out.println(" !!! Ürün Listelenirken Hata Oluþtu !!! " + err);			
		}
		return urunKategoriListe;
	}
}
