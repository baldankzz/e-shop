package com.meryem.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.meryem.dao.SepetDAO;
import com.meryem.dao.UrunDAO;
import com.meryem.model.Sepet;

/**
 * Servlet implementation class SepetEkle
 */
@WebServlet("/SepetEkle")
public class SepetEkle extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SepetEkle() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int urunId = Integer.valueOf(request.getParameter("urunId"));
		String kullaniciMail = request.getParameter("kullaniciMail");
		Sepet sepet = new Sepet();
		sepet.setKullaniciMail(kullaniciMail);
		sepet.setUrunId(urunId);
		sepet.setSepetDurum(0);
		SepetDAO.SepeteEkle(sepet);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
