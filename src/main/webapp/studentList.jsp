<html>
<head><title>Student List</title></head>
<body>
  <h2>All Students</h2>
  <%
      java.util.List<model.Student> list = (java.util.List<model.Student>) request.getAttribute("students");
      if(list == null || list.isEmpty()) {
    %>
    <p>No Students found!</p>
    <%
      } else {
    %>
  <table border="1">
    <tr><th>ID</th><th>Name</th><th>Email</th><th>Course</th></tr>
      <% for (model.Student s : list) { %>
      <tr>
        <td><%= s.getId() %></td>
        <td><%= s.getName() %></td>
        <td><%= s.getEmail() %></td>
        <td><%= s.getCourse() %></td>
      </tr>
    <% } %>
  </table>
  <% } %>
  <br>
  <a href="index.jsp">Add New</a>
</body>
</html>
