package com.meryem.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.meryem.dao.KullaniciDAO;
import com.meryem.model.Kullanici;

/**
 * Servlet implementation class Giris
 */
@WebServlet("/Giris")
public class Giris extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Giris() {
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
		String kullaniciMail = request.getParameter("mail");
		String kullaniciParola =  request.getParameter("parola");
		
		if(KullaniciDAO.KayitliMi(kullaniciMail)){
			if(KullaniciDAO.Giris(kullaniciMail, kullaniciParola)){
				HttpSession session = request.getSession(true);
				session.setAttribute("girisYapanKullanici", kullaniciMail);
				//FIX ME//
				session.setAttribute("girisYetki", 1);
				out.print("<meta charset='UTF-8' http-equiv='refresh' content='2; url=index.jsp' />Giriþ Baþarýlý");
			}else{
				out.print("<meta charset='UTF-8' http-equiv='refresh' content='2; url=index.jsp' />Parola Yanlýþ");
			}
		}else{
			out.print("<meta charset='UTF-8' http-equiv='refresh' content='2; url=kayit.jsp' />Mail Kayýtlý Deðil");
		}
	}

}
