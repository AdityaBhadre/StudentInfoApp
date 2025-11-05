<html>
<head>
  <title>Student Info</title>
</head>
<body>
  <h2>Student Information</h2>

  <%
     model.Student student = (model.Student) request.getAttribute("student");
  %>
  <p>ID: <%= student.getId() %></p>
  <p>Name: <%= student.getName() %></p>
  <p>E-mail: <%= student.getEmail() %></p>
  <p>Course: <%= student.getCourse() %></p>

  <br>
  <a href="index.jsp">Go Back</a>
</body>
</html>
