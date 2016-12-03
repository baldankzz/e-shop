package com.meryem.model;

public class Urun {
	int urunId;
	String urunAd;
	String urunBilgi;
	int urunFiyat;
	int kategoriId;
	
	
	public int getUrunId() {
		return urunId;
	}
	public void setUrunId(int urunId) {
		this.urunId = urunId;
	}
	public String getUrunAd() {
		return urunAd;
	}
	public void setUrunAd(String urunAd) {
		this.urunAd = urunAd;
	}
	public String getUrunBilgi() {
		return urunBilgi;
	}
	public void setUrunBilgi(String urunBilgi) {
		this.urunBilgi = urunBilgi;
	}
	public int getUrunFiyat() {
		return urunFiyat;
	}
	public void setUrunFiyat(int urunFiyat) {
		this.urunFiyat = urunFiyat;
	}
	public int getKategoriId() {
		return kategoriId;
	}
	public void setKategoriId(int kategoriId) {
		this.kategoriId = kategoriId;
	}
}
