package model;

import model.Student;
import java.sql.*;
import java.util.*;
import util.DBUtil;

public class StudentDAO {
	 public boolean saveStudent(Student s) {
	        String sql = "INSERT INTO students(name, email, course) VALUES(?, ?, ?)";
	        try (Connection con = DBUtil.getConnection();
	             PreparedStatement ps = con.prepareStatement(sql)) {

	            ps.setString(1, s.getName());
	            ps.setString(2, s.getEmail());
	            ps.setString(3, s.getCourse());
	            return ps.executeUpdate() > 0;

	        } catch (Exception e) {
	            e.printStackTrace();
	            return false;
	        }
	    }

	    public List<Student> getAllStudents() {
	        List<Student> list = new ArrayList<>();
	        String sql = "SELECT * FROM students";
	        try (Connection con = DBUtil.getConnection();
	             Statement st = con.createStatement();
	             ResultSet rs = st.executeQuery(sql)) {

	            while (rs.next()) {
	                Student s = new Student();
	                s.setId(rs.getInt("id"));
	                s.setName(rs.getString("name"));
	                s.setEmail(rs.getString("email"));
	                s.setCourse(rs.getString("course"));
	                list.add(s);
	            }

	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return list;
	    }
}
