<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page
import="com.meryem.dao.*"
import="com.meryem.model.*"
import="java.util.*"
%>
    <% ArrayList<Urun> urunler = new ArrayList<Urun>(UrunDAO.TumUrunler()); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<jsp:include page="_header.jsp" />
</head>
<body>
<jsp:include page="_navbar.jsp" />
<div class="banner">
		<div class="container">
			<section class="rw-wrapper">
				<h1 class="rw-sentence">
					<span>Moda &amp; Güzellik</span>
					<div class="rw-words rw-words-2">
						<span>Kendi Modanızı Yaratın</span>
						<span>Güzelliğiniz Konuşsun</span>
						<span>Moda Sizden Sorulsun</span>
					</div>
				</h1>
			</section>
		</div>
	</div>
	<!--content-->
	<div class="content">
		<div class="container">
			<!--products-->
			<div class="content-mid">
				<h3>Örnek Ürünler</h3>
				<label class="line"></label>
				<div class="mid-popular">

					<!--***************************************************************************-->
					<%for(int i = 0; i < 4 && i < urunler.size(); i++){ %>
					<div class="col-md-3 item-grid simpleCart_shelfItem">
						<div class=" mid-pop">
							<div class="pro-img">
								<img src="images/pc.jpg" class="img-responsive" alt="">
								<div class="zoom-icon ">
									<a class="picture" href="images/pc.jpg" rel="title" class="b-link-stripe b-animate-go  thickbox"><i class="glyphicon glyphicon-search icon "></i></a>
									<a href="single.jsp?urunId=<%= urunler.get(i).getUrunId() %>"><i class="glyphicon glyphicon-menu-right icon"></i></a>
								</div>
							</div>
							<div class="mid-1">
								<div class="women">
									<div class="women-top">
										<span><%= urunler.get(i).getUrunAd() %></span>
									</div>
									<div class="clearfix"></div>
								</div>
								<div class="mid-2">
									<p ><%= urunler.get(i).getUrunFiyat() %> TL</p>
									<div class="block">
										<div class="starbox small ghosting"> </div>
									</div>

									<div class="clearfix"></div>
								</div>

							</div>
						</div>
					</div>
					<%} %>
					<!--***************************************************************************-->
					<div class="clearfix"></div>
				</div>
			</div>
		</div>
	</div>
<jsp:include page="_footer.jsp" />
</body>
</html>