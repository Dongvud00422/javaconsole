/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaconsole.frame;

import java.awt.Color;
import java.awt.Event;
import java.awt.Font;
import javaconsole.entity.Student;
import javaconsole.model.StudentModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author dongvu
 */
public class AddStudentFrame {

    public static void main(String[] args) {
        AddStudentFrame add = new AddStudentFrame();
        add.addStudent();
    }

    public void addStudent() {
        JFrame addFrame = new JFrame("=== Add student ===");
        addFrame.setSize(500, 600);
        addFrame.setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(225, 225, 225, 110));
        panel.setBounds(30, 30, 440, 520);
        panel.setLayout(null);

        JLabel lblId = new JLabel("Student ID: ");
        lblId.setBounds(10, 20, 90, 30);
        lblId.setForeground(Color.white);
        lblId.setFont(new Font("Arial", 3, 12));
        JTextField txtId = new JTextField();
        txtId.setBounds(100, 20, 330, 30);
        txtId.setEditable(false);
        String strId = String.valueOf(System.currentTimeMillis());
        txtId.setText(strId);

        JLabel lblName = new JLabel("Name: ");
        lblName.setBounds(10, 65, 90, 30);
        lblName.setForeground(Color.white);
        lblName.setFont(new Font("Arial", 3, 12));
        JTextField txtName = new JTextField();
        txtName.setBounds(100, 65, 330, 30);
        txtName.requestFocus();
        String name = txtName.getText();

        JLabel lblEmail = new JLabel("Email: ");
        lblEmail.setBounds(10, 110, 90, 30);
        lblEmail.setForeground(Color.white);
        lblEmail.setFont(new Font("Arial", 3, 12));
        JTextField txtEmail = new JTextField();
        txtEmail.setBounds(100, 110, 330, 30);
        String email = txtEmail.getText();

        JLabel lblPhone = new JLabel("Phone: ");
        lblPhone.setBounds(10, 155, 90, 30);
        lblPhone.setForeground(Color.white);
        lblPhone.setFont(new Font("Arial", 3, 12));
        JTextField txtPhone = new JTextField();
        txtPhone.setBounds(100, 155, 330, 30);
        String phone = txtPhone.getText();

        JLabel lblRollNumber = new JLabel("Roll-number: ");
        lblRollNumber.setBounds(10, 200, 90, 30);
        lblRollNumber.setForeground(Color.white);
        lblRollNumber.setFont(new Font("Arial", 3, 12));
        JTextField txtRollNumber = new JTextField();
        txtRollNumber.setBounds(100, 200, 330, 30);
        String rollNumber = txtRollNumber.getText();

        JLabel lblClassName = new JLabel("Class-name: ");
        lblClassName.setBounds(10, 245, 90, 30);
        lblClassName.setForeground(Color.white);
        lblClassName.setFont(new Font("Arial", 3, 12));
        JTextField txtClassName = new JTextField();
        txtClassName.setBounds(100, 245, 330, 30);
        String className = txtClassName.getText();

        JButton btnSubmit = new JButton("Submit");
        btnSubmit.setBounds(100, 290, 80, 30);
        btnSubmit.action(new Event(student, 1, ));
        Student student = new Student(Long.valueOf(strId), name, email, phone, rollNumber, className, 1);

        StudentModel studentModel = new StudentModel();
        studentModel.insert(student);

        JButton btnReset = new JButton("Reset");
        btnReset.setBounds(185, 290, 70, 30);

        panel.add(lblId);
        panel.add(txtId);
        panel.add(lblName);
        panel.add(txtName);
        panel.add(lblEmail);
        panel.add(txtEmail);
        panel.add(lblPhone);
        panel.add(txtPhone);
        panel.add(lblRollNumber);
        panel.add(txtRollNumber);
        panel.add(lblClassName);
        panel.add(txtClassName);
        panel.add(btnSubmit);
        panel.add(btnReset);

        JLabel lblBackgroundImg = new JLabel();
        lblBackgroundImg.setSize(500, 600);
        lblBackgroundImg.setIcon(new ImageIcon("/Users/dongvu/NetBeansProjects/StudentManager/src/StudentManager/Frame/background.jpg"));

        addFrame.add(panel);
        addFrame.getContentPane().add(lblBackgroundImg);
        addFrame.setLayout(null);
        addFrame.setVisible(true);
        addFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}
