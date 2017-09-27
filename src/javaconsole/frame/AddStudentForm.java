/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaconsole.frame;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import javaconsole.entity.Student;
import javaconsole.model.StudentModel;
import javaconsole.vaildate.VaildateInputData;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author dongvu
 */
public class AddStudentForm extends JFrame {

    public static void main(String[] args) {

        AddStudentForm add = new AddStudentForm();
        add.setVisible(true);

    }

    private JPanel background;
    private JLabel lblId;
    private JLabel lblName;
    private JLabel lblBirthday;
    private JLabel lblEmail;
    private JLabel lblPhone;
    private JLabel lblRollNumber;
    private JLabel lblClassName;

    private JLabel lblTotalMessage;
    private JLabel lblNameMessage;
    private JLabel lblBirthdayMessage;
    private JLabel lblEmailMessage;
    private JLabel lblPhonemessage;
    private JLabel lblRollNumberMessage;
    private JLabel lblClassNameMessage;

    private JTextField txtId;
    private JTextField txtName;
    private JTextField txtBirthday;
    private JTextField txtEmail;
    private JTextField txtPhone;
    private JTextField txtRollNumber;
    private JTextField txtClassName;
    private JButton btnSubmit;
    private JButton btnReset;
    private JButton btnCancel;

    public AddStudentForm() {
       

       

        this.background = new JPanel();
        this.background.setBackground(new Color(0, 0, 0, 80));
        this.background.setBounds(450, 40, 450, 550);
        this.background.setLayout(null);

        this.lblTotalMessage = new JLabel();
        this.lblTotalMessage.setBounds(10, 115, 420, 20);

        this.lblId = new JLabel("Student ID: ");
        this.lblId.setBounds(10, 145, 90, 30);
        this.lblId.setForeground(Color.white);
        this.lblId.setFont(new Font("Arial", 3, 12));

        this.txtId = new JTextField();
        this.txtId.setBounds(100, 145, 330, 30);
        this.txtId.setEditable(false);
        this.txtId.setText(String.valueOf(System.currentTimeMillis()));

        this.lblName = new JLabel("Name: ");
        this.lblName.setBounds(10, 200, 90, 30);
        this.lblName.setForeground(Color.white);
        this.lblName.setFont(new Font("Arial", 3, 12));

        this.txtName = new JTextField();
        this.txtName.setBounds(100, 200, 330, 30);

        this.lblNameMessage = new JLabel();
        this.lblNameMessage.setBounds(100, 235, 330, 10);
        this.lblNameMessage.setOpaque(true);
        this.lblNameMessage.setBackground(new Color(0, 0, 0, 0));

        this.lblBirthday = new JLabel("Birthday: ");
        this.lblBirthday.setBounds(10, 250, 90, 30);
        this.lblBirthday.setForeground(Color.white);
        this.lblBirthday.setFont(new Font("Arial", 3, 12));

        this.txtBirthday = new JTextField();
        this.txtBirthday.setBounds(100, 250, 330, 30);

        this.lblBirthdayMessage = new JLabel();
        this.lblBirthdayMessage.setBounds(100, 285, 330, 10);
        this.lblBirthdayMessage.setOpaque(true);
        this.lblBirthdayMessage.setBackground(new Color(0, 0, 0, 0));

        this.lblEmail = new JLabel("Email: ");
        this.lblEmail.setBounds(10, 300, 90, 30);
        this.lblEmail.setForeground(Color.white);
        this.lblEmail.setFont(new Font("Arial", 3, 12));

        this.txtEmail = new JTextField();
        this.txtEmail.setBounds(100, 300, 330, 30);

        this.lblEmailMessage = new JLabel();
        this.lblEmailMessage.setBounds(100, 335, 330, 10);
        this.lblEmailMessage.setOpaque(true);
        this.lblEmailMessage.setBackground(new Color(0, 0, 0, 0));

        this.lblPhone = new JLabel("Phone: ");
        this.lblPhone.setBounds(10, 350, 90, 30);
        this.lblPhone.setForeground(Color.white);
        this.lblPhone.setFont(new Font("Arial", 3, 12));

        this.txtPhone = new JTextField();
        this.txtPhone.setBounds(100, 350, 330, 30);

        this.lblPhonemessage = new JLabel();
        this.lblPhonemessage.setBounds(100, 385, 330, 10);
        this.lblPhonemessage.setOpaque(true);
        this.lblPhonemessage.setBackground(new Color(0, 0, 0, 0));

        this.lblRollNumber = new JLabel("Roll-number: ");
        this.lblRollNumber.setBounds(10, 400, 90, 30);
        this.lblRollNumber.setForeground(Color.white);
        this.lblRollNumber.setFont(new Font("Arial", 3, 12));

        this.txtRollNumber = new JTextField();
        this.txtRollNumber.setBounds(100, 400, 330, 30);

        this.lblRollNumberMessage = new JLabel();
        this.lblRollNumberMessage.setBounds(100, 435, 330, 10);
        this.lblRollNumberMessage.setOpaque(true);
        this.lblRollNumberMessage.setBackground(new Color(0, 0, 0, 0));

        this.lblClassName = new JLabel("Class-name: ");
        this.lblClassName.setBounds(10, 450, 90, 30);
        this.lblClassName.setForeground(Color.white);
        this.lblClassName.setFont(new Font("Arial", 3, 12));

        this.txtClassName = new JTextField();
        this.txtClassName.setBounds(100, 450, 330, 30);

        this.lblClassNameMessage = new JLabel();
        this.lblClassNameMessage.setBounds(100, 485, 330, 10);
        this.lblClassNameMessage.setOpaque(true);
        this.lblClassNameMessage.setBackground(new Color(0, 0, 0, 0));

        this.btnSubmit = new JButton("Submit");
        this.btnSubmit.setBounds(100, 500, 80, 30);
        this.btnSubmit.addActionListener(new loginHandle());

        this.btnReset = new JButton("Reset");
        this.btnReset.setBounds(185, 500, 70, 30);
        this.btnReset.addActionListener(new resetHandle());

        this.btnCancel = new JButton("View all");
        this.btnCancel.setBounds(340, 500, 90, 30);
      //  this.btnCancel.addActionListener();

        this.background.add(lblId);
        this.background.add(txtId);
        this.background.add(lblName);
        this.background.add(txtName);
        this.background.add(lblBirthday);
        this.background.add(txtBirthday);
        this.background.add(lblEmail);
        this.background.add(txtEmail);
        this.background.add(lblPhone);
        this.background.add(txtPhone);
        this.background.add(lblRollNumber);
        this.background.add(txtRollNumber);
        this.background.add(lblClassName);
        this.background.add(txtClassName);
        this.background.add(btnSubmit);
        this.background.add(btnReset);
        this.background.add(btnCancel);
        this.background.add(lblTotalMessage);
        this.background.add(lblNameMessage);
        this.background.add(lblEmailMessage);
        this.background.add(lblPhonemessage);
        this.background.add(lblRollNumberMessage);
        this.background.add(lblClassNameMessage);
        this.background.add(lblBirthdayMessage);

        
    }

    class loginHandle implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Student student = new Student(Long.parseLong(txtId.getText()), txtName.getText(), txtBirthday.getText(), txtPhone.getText(), txtEmail.getText(), txtClassName.getText(), txtRollNumber.getText());
            HashMap<String, String> errors = new VaildateInputData().errors(student);
            resetlblErrors();
            if (errors.isEmpty()) {
                StringBuilder alert = new StringBuilder();
                alert.append("Are you want to add this student ?\n");
                alert.append("Student Id: ");
                alert.append(txtId.getText());
                alert.append("\nName: ");
                alert.append(txtName.getText());
                alert.append("\nBirthday: ");
                alert.append(txtBirthday.getText());
                alert.append("\nEmail: ");
                alert.append(txtEmail.getText());
                alert.append("\nPhone: ");
                alert.append(txtPhone.getText());
                alert.append("\nRoll-number: ");
                alert.append(txtRollNumber.getText());
                alert.append("\nClass-name: ");
                alert.append(txtClassName.getText());

                int result = JOptionPane.showConfirmDialog(rootPane, alert.toString());
                if (result == 0) {
                    // Thực hiện insert student khi chọn yes.
                    StudentModel studentModel = new StudentModel();
                    studentModel.insert(student);
                } else if (result == 1) {
                    // Thực hiện reset các field khi chọn no.
                    resetField();
                }

            } else {
                showErrors(errors);

            }

        }
    }

    class resetHandle implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            resetField();
            resetlblErrors();

        }

    }


    private void resetlblErrors() {
        lblTotalMessage.setText("");
        lblNameMessage.setText("");
        lblBirthdayMessage.setText("");
        lblEmailMessage.setText("");
        lblPhonemessage.setText("");
        lblRollNumberMessage.setText("");
        lblClassNameMessage.setText("");
    }

    private void resetField() {
        txtId.setText(String.valueOf(System.currentTimeMillis()));
        txtName.setText("");
        txtBirthday.setText("");
        txtEmail.setText("");
        txtPhone.setText("");
        txtRollNumber.setText("");
        txtClassName.setText("");
    }

    private void showErrors(HashMap<String, String> errors) {
        lblTotalMessage.setForeground(Color.red);
        lblTotalMessage.setText("* Invalid student information, please change the errors !!");
       // lblTotalMessage.setOpaque(true);
        lblTotalMessage.setBackground(new Color(0, 0, 0, 0));
        if (errors.containsKey("txtName")) {
            lblNameMessage.setText(errors.get("txtName"));
            lblNameMessage.setForeground(Color.red);
        }
        if (errors.containsKey("txtBirthday")) {
            lblBirthdayMessage.setText(errors.get("txtBirthday"));
            lblBirthdayMessage.setForeground(Color.red);
        }
        if (errors.containsKey("txtEmail")) {
            lblEmailMessage.setText(errors.get("txtEmail"));
            lblEmailMessage.setForeground(Color.red);
        }
        if (errors.containsKey("txtPhone")) {
            lblPhonemessage.setText(errors.get("txtPhone"));
            lblPhonemessage.setForeground(Color.red);
        }
        if (errors.containsKey("txtRollNumber")) {
            lblRollNumberMessage.setText(errors.get("txtRollNumber"));
            lblRollNumberMessage.setForeground(Color.red);
        }
        if (errors.containsKey("txtClassName")) {
            lblClassNameMessage.setText(errors.get("txtClassName"));
            lblClassNameMessage.setForeground(Color.red);
        }
    }
 
   
}
