<%@page import="com.meryem.model.Kategori"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page
import="com.meryem.dao.*"
import="java.util.*"
%>
<% ArrayList<String> kategoriler = new ArrayList<String>(KategoriDAO.TumKategoriAd()); %>
<div class="header">
		<div class="container">
			<div class="head">
				<div class=" logo">
					<a href="index.html"><img src="images/logo.png" alt=""></a>	
				</div>
			</div>
		</div>
		
		<div class="container">

			<div class="head-top">

				<div class="col-sm-8 col-md-offset-2 h_menu4">
					<nav class="navbar nav_bottom" role="navigation">

						<!-- Brand and toggle get grouped for better mobile display -->
						<div class="navbar-header nav_2">
							<button type="button" class="navbar-toggle collapsed navbar-toggle1" data-toggle="collapse" data-target="#bs-megadropdown-tabs">
								<span class="sr-only">Toggle navigation</span>
								<span class="icon-bar"></span>
								<span class="icon-bar"></span>
								<span class="icon-bar"></span>
							</button>

						</div> 
						<!-- Collect the nav links, forms, and other content for toggling -->
						<div class="collapse navbar-collapse" id="bs-megadropdown-tabs">
							<ul style="width: 145%" class="nav navbar-nav nav_1">
								<li><a class="color" href="index.html">Home</a></li>
								<li><a class="color3" href="product.html">Ürünler</a></li>
								<li><a class="color4" href="404.html">Giriş Yap</a></li>
								<li><a class="color5" href="typo.html">Kayıt Ol</a></li>
								<li ><a class="color6" href="contact.html">Admin</a></li>
								<li ><a class="color6" href="contact.html">Sepet</a></li>
								<%for(int i=0; i < kategoriler.size(); i++){ %>
								<li><a class="color" href="urun.jsp?kategoriId=<%= KategoriDAO.KategoriIdGetir(kategoriler.get(i)).get(0) %>"><%= kategoriler.get(i) %></a></li>
								<% } %>
							</ul>
						</div><!-- /.navbar-collapse -->

					</nav>
				</div>
				
			</div>
			<div class="clearfix"></div>
		</div>	
	</div>l>