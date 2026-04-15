<%@ page language="java" %>
<link rel="stylesheet" href="css/style.css">

<div class="container">
<h2>Login</h2>

<% if(request.getParameter("error") != null){ %>
<p style="color:red;">Invalid Login</p>
<% } %>

<% if("success".equals(request.getParameter("msg"))){ %>
<p style="color:green;">Registration Successful! Please login.</p>
<% } %>

<form action="login" method="post">
<input type="text" name="reg_no" placeholder="Register Number" required>
<input type="password" name="password" placeholder="Password" required>
<button type="submit">Login</button>
</form>

<a href="register.jsp">Register</a>
</div>