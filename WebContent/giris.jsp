<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<jsp:include page="_header.jsp" />
</head>
<body>
<jsp:include page="_navbar.jsp" />
<div class="container">
		<div class="login">
			<form action="Giris" method="post">
			<div class="col-md-6 login-do">
				<div class="login-mail">
					<input name="mail" type="text" placeholder="Email" required="">
					<i  class="glyphicon glyphicon-envelope"></i>
				</div>
				<div class="login-mail">
					<input name="parola" type="password" placeholder="Parola" required="">
					<i class="glyphicon glyphicon-lock"></i>
				</div>
				<label class="hvr-skew-backward">
					<input type="submit" value="Kayıt">
				</label>
			
			</div>
			</form>
			<div class="col-md-6 login-right">
				 <h3>Completely Free Account</h3>
				 
				 <p>Pellentesque neque leo, dictum sit amet accumsan non, dignissim ac mauris. Mauris rhoncus, lectus tincidunt tempus aliquam, odio 
				 libero tincidunt metus, sed euismod elit enim ut mi. Nulla porttitor et dolor sed condimentum. Praesent porttitor lorem dui, in pulvinar enim rhoncus vitae. Curabitur tincidunt, turpis ac lobortis hendrerit, ex elit vestibulum est, at faucibus erat ligula non neque.</p>
				<a href="kayit.jsp" class="hvr-skew-backward">Kayıt Ol</a>

			</div>
			
			<div class="clearfix"> </div>
		</div>

</div>
<br>
<jsp:include page="_footer.jsp" />
</body>
</html>