package com.meryem.dao;

import java.sql.*;
import java.util.ArrayList;

public class KategoriDAO {
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
	
	public static void KategoriEkle(String kategoriAd) {
		try {
			
			Connect();
			String querry = "INSERT INTO tb_kategori (kategoriAd) VALUES (?)";
			PreparedStatement ps = (PreparedStatement) con.prepareStatement(querry);
			ps.setString(1, kategoriAd);
			ps.executeUpdate();
			System.out.println("Kayýt Baþarýlý");
		}
		catch(Exception err)
		{
			System.out.println("Kategori Ekleme Baþarýsýz!!\nAyný kategori kullanýlýyor olabilir.\n(" + err + ")");
			
		}
		
}
	public static ArrayList<String> TumKategoriAd(){
		ArrayList<String> kategoriAdListe = new ArrayList<String>();
		try {
			Connect();
			String querry = "SELECT kategoriAd FROM tb_kategori";
			PreparedStatement ps = (PreparedStatement) con.prepareStatement(querry);
			ResultSet row = ps.executeQuery();
			while(row.next()){
				kategoriAdListe.add(row.getString("kategoriAd"));
			}
			
		}catch(Exception err){
			System.out.print(" !!! Kategori Getirilemedi !!! \n(" + err + ")");
		}
		return kategoriAdListe;
	}
	
	public static ArrayList<Integer> KategoriIdGetir(String kategoriAd){
		ArrayList<Integer> kategoriIdListe = new ArrayList<Integer>();
		try {
			Connect();
			String querry = "SELECT kategoriId FROM tb_kategori WHERE kategoriAd=?";
			PreparedStatement ps = (PreparedStatement) con.prepareStatement(querry);
			ps.setString(1, kategoriAd);
			ResultSet row = ps.executeQuery();
			if(row.next()){
				kategoriIdListe.add(row.getInt("kategoriId"));
			}
			else
			{
				System.out.println("Böyle bir kategori yok!!");
			}
			
		}catch(Exception err){
			System.out.print(" !!! Kategori Getirilemedi !!! \n(" + err + ")");
		}
		return kategoriIdListe;
	}
}
