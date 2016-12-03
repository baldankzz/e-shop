package com.meryem.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.meryem.dao.KullaniciDAO;
import com.meryem.model.Kullanici;

/**
 * Servlet implementation class Kayit
 */
@WebServlet("/Kayit")
public class Kayit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Kayit() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		
		Kullanici kullanici = new Kullanici();
		kullanici.setKullaniciAd(request.getParameter("isim"));
		kullanici.setKullaniciSoyad(request.getParameter("soyisim"));
		kullanici.setKullaniciMail(request.getParameter("mail"));
		kullanici.setKullaniciParola(request.getParameter("parola"));
		kullanici.setKullaniciYetki(0);
		
		try{
			KullaniciDAO.Kayit(kullanici);
			out.print("<meta charset='UTF-8' http-equiv='refresh' content='2; url=index.jsp' />Kayýt Baþarýlý");
		}catch(Exception err){
			out.print("<meta charset='UTF-8' http-equiv='refresh' content='2; url=kayit.jsp' />KAYIT BAÞARISIZ");
		}
	}

}
