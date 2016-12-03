package com.meryem.model;

public class Sepet {
	int sepetId;
	int sepetDurum;
	int urunId;
	String kullaniciMail;
	
	public int getSepetId() {
		return sepetId;
	}
	public void setSepetId(int sepetId) {
		this.sepetId = sepetId;
	}
	public int getSepetDurum() {
		return sepetDurum;
	}
	public void setSepetDurum(int sepetDurum) {
		this.sepetDurum = sepetDurum;
	}
	public int getUrunId() {
		return urunId;
	}
	public void setUrunId(int urunId) {
		this.urunId = urunId;
	}
	public String getKullaniciMail() {
		return kullaniciMail;
	}
	public void setKullaniciMail(String kullaniciMail) {
		this.kullaniciMail = kullaniciMail;
	}
}
