<%
String user = (String) session.getAttribute("user");
if(user == null){
    response.sendRedirect("login.jsp");
}
%>

<link rel="stylesheet" href="css/style.css">

<div class="container" style="width:600px;">
<h2>Faculty Feedback</h2>

<form action="submitFeedback" method="post">

<input name="faculty" placeholder="Faculty Name" required>
<input name="subject" placeholder="Subject" required>

<%
String[] questions = {
"Syllabus Coverage",
"Clarity of Concepts",
"Course Relevance",
"Content Structure",
"Teaching Clarity",
"Use of Examples",
"Student Engagement",
"Use of Teaching Tools",
"Communication Clarity",
"Language Simplicity",
"Response to Doubts",
"Fair Evaluation",
"Assignment Feedback",
"Availability for Doubts",
"Overall Performance"
};

for(int i=0;i<questions.length;i++){
%>

<label><%= (i+1) + ". " + questions[i] %></label>

<select name="q<%=i+1%>">
<% for(int j=1;j<=5;j++){ %>
<option value="<%=j%>"><%=j%></option>
<% } %>
</select>

<% } %>

<textarea name="comments" placeholder="Additional Comments"></textarea>

<button type="submit">Submit Feedback</button>

</form>
</div>