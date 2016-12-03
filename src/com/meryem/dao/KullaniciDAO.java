package com.meryem.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import com.meryem.model.*;

public class KullaniciDAO {
	static String connectionURL;
	static Connection con = null;
	PreparedStatement ps = null;

	protected static void Connect() {
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			connectionURL = "jdbc:mysql://localhost:3306/db_eshop";
			con = DriverManager.getConnection(connectionURL, "root", "12345");
		} catch (Exception err) {
			System.out.println("mysql Driver Bulunamadý : " + err);
		}
	}
	
	public static void Kayit(Kullanici kullanici){
		try {
			Connect();
			String querry = "INSERT INTO tb_kullanici (kullaniciAd, kullaniciSoyad, kullaniciMail, kullaniciParola,  kullaniciYetki) VALUES (?, ?, ? ,?, ?)";
			PreparedStatement ps = (PreparedStatement) con.prepareStatement(querry);
			ps.setString(1, kullanici.getKullaniciAd());
			ps.setString(2, kullanici.getKullaniciSoyad());
			ps.setString(3, kullanici.getKullaniciMail());
			ps.setString(4, kullanici.getKullaniciParola());
			ps.setInt(5, kullanici.getKullaniciYetki());
			ps.executeUpdate();
			System.out.println("*** KAYIT BAÞARILI ***");

		} catch (Exception err) {
			System.out.print("*** KAYIT YAPILAMADI *** \n(" + err + ")");
		}
	}
	
	public static boolean KayitliMi(String kullaniciMail){
		try {
			Connect();
			String querry = "SELECT * FROM tb_kullanici WHERE kullaniciMail=?";
			PreparedStatement ps = (PreparedStatement) con.prepareStatement(querry);
			ps.setString(1, kullaniciMail);
			ResultSet row = ps.executeQuery();
			if(row.next()){
				System.out.println(" - ÜYE ÖNCEDEN KAYIT YAPMIÞ - -> " + kullaniciMail);
				return true;
			}else{
				return false;
			}
			
		}catch(Exception err){
			System.out.print(" !!! ÜYE GETÝRÝLEMEDÝ BAÞARISIZ !!! \n(" + err + ")");
		}
		return false;
		
	}
	
	public static boolean Giris(String kullaniciMail, String kullaniciParola){
		try {
			Connect();
			String querry = "SELECT kullaniciMail, kullaniciParola FROM tb_kullanici WHERE kullaniciMail=? AND kullaniciParola=?";
			PreparedStatement ps = (PreparedStatement) con.prepareStatement(querry);
			ps.setString(1, kullaniciMail);
			ps.setString(2, kullaniciParola);
			ResultSet row = ps.executeQuery();
			if(row.next()){
				System.out.println(" - Giriþ Biligileri Doðru - -> " + kullaniciMail + " - " + kullaniciParola);
				return true;
			}else{
				System.out.println(" - Giriþ Biligileri YANLIÞ - -> " + kullaniciMail + " - " + kullaniciParola);
				return false;
			}
		}catch(Exception err){
			System.out.print(" !!! ÜYE GETÝRÝLEMEDÝ BAÞARISIZ !!! \n(" + err + ")");
		}
		return false;
	}
}
