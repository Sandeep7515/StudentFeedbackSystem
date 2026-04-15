<link rel="stylesheet" href="css/style.css">

<div class="container">
<h2>Register</h2>

<form action="register" method="post">
<input name="reg_no" placeholder="Reg No">
<input name="name" placeholder="Name">
<input type="password" name="password" placeholder="Password">

<select name="year">
<option>1</option><option>2</option>
<option>3</option><option>4</option>
</select>

<select name="semester">
<% for(int i=1;i<=8;i++){ %>
<option><%=i%></option>
<% } %>
</select>

<select name="branch">
<option>CSE</option><option>IT</option>
<option>ECE</option><option>MECH</option>
<option>CSM</option><option>CSD</option>
<option>CIC</option><option>EEE</option>
<option>CHEMICAL</option><option>CIVIL</option>
</select>

<button>Register</button>
</form>
</div>