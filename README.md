---

# 🎓 Student Information Management System

A simple **Java Web Application** built using **Servlets, JSP, JDBC, and MySQL**, following the **MVC (Model–View–Controller)** architecture.
This project allows users to add, validate, store, and view student details dynamically from a web interface.

---

## 🚀 Features

* 🧾 Add new student details (Name, Email, Course) through a clean form interface
* ✅ Validate inputs (check for empty fields, email format, etc.)
* 💾 Store data in **MySQL database** using **JDBC**
* 📋 Display all student records in a dynamic HTML table
* 🔁 Navigate easily between form and student list views
* 🧠 Follows **MVC architecture** for clean separation of concerns

---

## 🧩 Technologies Used

| Layer                    | Technology                  |
| ------------------------ | --------------------------- |
| **Frontend (View)**      | JSP, HTML, CSS              |
| **Backend (Controller)** | Java Servlets               |
| **Database (Model)**     | MySQL (via JDBC)            |
| **Architecture**         | MVC (Model–View–Controller) |
| **Server**               | Apache Tomcat               |
| **IDE (optional)**       | Eclipse / IntelliJ IDEA     |

---

## 🧱 Project Structure

```
StudentInfoApp/
├── src/
│   ├── controller/
│   │   └── StudentController.java
│   ├── model/
│   │   ├── Student.java
│   │   └── StudentDAO.java
│   └── util/
│       └── DBUtil.java
│
├── WebContent/
│   ├── index.jsp
│   ├── studentList.jsp
│   ├── studentView.jsp
│   └── WEB-INF/
│       └── web.xml
```

---

## ⚙️ Setup Instructions

1. **Clone this repository:**

   ```bash
   git clone https://github.com/<your-username>/StudentInfoApp.git
   ```

2. **Create a MySQL database:**

   ```sql
   CREATE DATABASE studentinfoapp;

   USE studentinfoapp;

   CREATE TABLE students (
     id INT AUTO_INCREMENT PRIMARY KEY,
     name VARCHAR(100),
     email VARCHAR(100),
     course VARCHAR(50)
   );
   ```

3. **Configure database credentials** in `util/DBUtil.java`:

   ```java
   private static String url = "jdbc:mysql://localhost:3306/studentinfoapp?useSSL=false&serverTimezone=UTC";
   private static String user = "root";
   private static String pass = "yourpassword";
   ```

4. **Add MySQL JDBC Driver** to your project build path:
   Download from: [MySQL Connector/J](https://dev.mysql.com/downloads/connector/j/)

5. **Deploy the project on Tomcat Server**

   * Start Tomcat
   * Access the app at:
     👉 `http://localhost:8080/StudentInfoApp/index.jsp`

---

## 🔄 Application Flow

1. User opens `index.jsp` → fills student form
2. Form submits data → handled by `StudentController` (Servlet)
3. Controller validates inputs and calls `StudentDAO` to save data in MySQL
4. Servlet redirects to `/student` → displays all student records
5. `studentList.jsp` shows data dynamically using JSP expressions

---

## 🧠 Learning Highlights

* Learned **how web servers (Tomcat)** handle HTTP requests and responses
* Built a full **MVC architecture manually** using JSP and Servlets
* Understood **database integration** with JDBC
* Improved understanding of **request forwarding, redirection, and validation**
* Transitioned from **console-based Java** to **web-based application development**

---

## ✨ Future Enhancements

* 🧩 Add Edit & Delete student functionality
* 🔐 Add user authentication (login/logout)
* 🌱 Migrate to **Spring Boot + Thymeleaf** for cleaner architecture
* 📊 Integrate Bootstrap for better UI design

---
## 🧑‍💻 Author

**Aditya Bhadre**
📚 B.E. Information Technology | Sinhgad Academy of Engineering
💼 Passionate about Full-Stack Java Development
🌱 Exploring Spring Boot and modern frameworks
📫 [LinkedIn Profile](https://www.linkedin.com/in/aditya-bhadre-5982a12a8/)

---
