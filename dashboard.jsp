<%
String user = (String) session.getAttribute("user");
if(user == null){
    response.sendRedirect("login.jsp");
}
%>

<link rel="stylesheet" href="css/style.css">

<div class="dashboard">
<h2>Welcome <%= user %></h2>

<a href="feedback.jsp">Give Feedback</a><br><br>
<a href="logout.jsp">Logout</a>
</div>