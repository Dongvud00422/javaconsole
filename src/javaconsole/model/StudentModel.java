/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaconsole.model;

import javaconsole.entity.Student;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author dongvu
 */
public class StudentModel {

    public ArrayList<Student> getListStudent() {
        ArrayList<Student> listStudent = new ArrayList<>();
        try {
            Statement stt = DAO.getConnection().createStatement();
            ResultSet rs = stt.executeQuery("SELECT * FROM Student;");
            while (rs.next()) {
                Student student = new Student();
                student.setId(rs.getInt("id"));
                student.setName(rs.getString("name"));
                student.setEmail(rs.getString("email"));
                student.setClassName(rs.getString("class_name"));
                student.setRollNumber(rs.getString("roll_number"));
                student.setStatus(rs.getInt("status"));

                listStudent.add(student);
            }
        } catch (SQLException ex) {
            System.err.println("Get list erorr !!!\n" + ex.getMessage());
        }
        return listStudent;
    }

    public Student getById(int id) {
        Student student = new Student();
        try {
            Statement stt = DAO.getConnection().createStatement();
            ResultSet rs = stt.executeQuery("SELECT * FROM Student WHERE id=" + id);
            if (rs.next()) {
                student.setId(rs.getInt("id"));
                student.setName(rs.getString("name"));
                student.setEmail(rs.getString("email"));
                student.setClassName(rs.getString("class_name"));
                student.setRollNumber(rs.getString("roll_number"));
                student.setStatus(rs.getInt("status"));

                return student;
            }
        } catch (SQLException ex) {
            System.err.println("Get list by Id erorr !!!\n" + ex.getMessage());
        }

        return null;
    }

    public void insert(Student student) {
        try {
            PreparedStatement preStt = DAO.getConnection().prepareStatement("INSERT INTO Student VALUE (?,?,?,?,?,?);");
            preStt.setInt(1, student.getId());
            preStt.setString(2, student.getName());
            preStt.setString(3, student.getEmail());
            preStt.setString(4, student.getClassName());
            preStt.setString(5, student.getRollNumber());
            preStt.setInt(6, student.getStatus());

            preStt.execute();
            
            System.out.println("-- Add student success --");
        } catch (SQLException ex) {
            System.err.println("Add student erorr !!!\n" + ex.getMessage());
        }
    }

    public void updateStudent(Student updateStudent) {
        try {
            PreparedStatement preStt = DAO.getConnection().prepareStatement("UPDATE Student SET name=?, email=?, class_name=?, roll_number=?, status=? WHERE id=?");
            preStt.setString(1, updateStudent.getName());
            preStt.setString(2, updateStudent.getEmail());
            preStt.setString(3, updateStudent.getClassName());
            preStt.setString(4, updateStudent.getRollNumber());
            preStt.setInt(5, updateStudent.getStatus());
            preStt.setInt(6, updateStudent.getId());

            preStt.execute();
            System.out.println("-- Edit student success --");
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.err.println("Update student erorr !!!\n" + ex.getMessage());
        }
    }

    public void deleteStudent(int id) {
        try {
            PreparedStatement preStt = DAO.getConnection().prepareStatement("DELETE FROM Student WHERE id = ?");
            preStt.setInt(1, id);
            preStt.execute();
            System.out.println("-- Delete student success --");
        } catch (SQLException ex) {
            System.err.println("Delete student erorr !!!\n" + ex.getMessage());
        }
    }
}
