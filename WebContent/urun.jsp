<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page
import="com.meryem.dao.*"
import="com.meryem.model.*"
import="java.util.*"
%>
<%
String girisYapanMail = (String) session.getAttribute("girisYapanKullanici");
//int girisYapanYetki = (int) session.getAttribute("girisYetki");

ArrayList<Urun> urun = new ArrayList<Urun>(UrunDAO.IdUrunGetir(Integer.valueOf(request.getParameter("urunId"))));%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

	<jsp:include page="_header.jsp" />
	
</head>
<body>
<jsp:include page="_navbar.jsp" />

<div class="single">

	<div class="container">
		<div class="col-md-9">
			<div class="col-md-5 grid">		
				<div class="flexslider">
					<div class="thumb-image"> <img src="images/si.jpg" data-imagezoom="true" class="img-responsive"> </div>
				</div>
			</div>	
			<div class="col-md-7 single-top-in">
				<div class="span_2_of_a1 simpleCart_shelfItem">
					<h3><%=urun.get(0).getUrunAd() %></h3>
					<div class="price_single">
						<span class="reducedfrom item_price"><%=urun.get(0).getUrunFiyat() %> TL </span>
						<div class="clearfix"></div>
					</div>
					<h4 class="quick">Ürün Hakkında:</h4>
					<p class="quick_desc"> <%=urun.get(0).getUrunBilgi() %></p>


					<a href="SepetEkle?urunId=<%=urun.get(0).getUrunId() %>&kullaniciMail=<%= girisYapanMail %>" class="add-to item_add hvr-skew-backward">Sepete Ekle</a>
					<div class="clearfix"> </div>
				</div>

			</div>
			<div class="clearfix"> </div>
			<!---->
			</div>
<!----->

	<div class="clearfix"> </div>
</div>

<jsp:include page="_footer.jsp" />
</body>
</html>