<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student Info Form</title>
<style>
  body { font-family: Arial, sans-serif; margin: 40px; }
  h2 { color: #333; }
  .btn {
      background-color: #007bff;
      color: white;
      border: none;
      padding: 8px 16px;
      border-radius: 4px;
      cursor: pointer;
  }
  .btn:hover { background-color: #0056b3; }
</style>
</head>
<body>
 <h2>Enter Student Details</h2>

  <!-- Display error message if present -->
  <%
    String error = (String) request.getAttribute("errorMessage");
    if (error != null) {
  %>
    <p style="color:red;"><%= error %></p>
  <%
    }
  %>

  <form action="<%= request.getContextPath() %>>/student" method="post">
    Name: <input type="text" name="name" required><br><br>
    E-mail: <input type="text" name="email" required><br><br>
    Course: <input type="text" name="course" required><br><br>
    <input type="submit" class="btn" value="Submit">
  </form>
  <br><br>
  <form action="<%= request.getContextPath() %>/student" method="get">
  	<input type="submit" class="btn" value="View All Students">
  </form>
</body>
</html>