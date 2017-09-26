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
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.DateFormatter;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author dongvu
 */
public class AddStudentForm extends JFrame {

    public static void main(String[] args) {
        try {
            AddStudentForm add = new AddStudentForm();
            add.setVisible(true);
        } catch (ParseException ex) {
            System.out.println(ex.getMessage());
        }
    }

    private JPanel background;
    private JLabel lblId;
    private JLabel lblName;
    private JLabel lblBirthday;
    private JLabel lblEmail;
    private JLabel lblPhone;
    private JLabel lblRollNumber;
    private JLabel lblClassName;
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

    public AddStudentForm() throws ParseException {
        this.setSize(950, 650);
        this.setResizable(false);
        this.setLocationRelativeTo(null);

        try {
            this.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("/Users/dongvu/NetBeansProjects/javaconsole/src/javaconsole/frame/background.png")))));
        } catch (IOException ex) {
            System.out.println("Set background Failed " + ex.getMessage());
        }

        this.background = new JPanel();
        this.background.setBackground(new Color(0, 0, 0, 80));
        this.background.setBounds(450, 40, 450, 550);
        this.background.setLayout(null);

        this.lblId = new JLabel("Student ID: ");
        this.lblId.setBounds(10, 240, 90, 30);
        this.lblId.setForeground(Color.white);
        this.lblId.setFont(new Font("Arial", 3, 12));

        this.txtId = new JTextField();
        this.txtId.setBounds(100, 240, 330, 30);
        this.txtId.setEditable(false);
        String strId = String.valueOf(System.currentTimeMillis());
        this.txtId.setText(strId);

        this.lblName = new JLabel("Name: ");
        this.lblName.setBounds(10, 280, 90, 30);
        this.lblName.setForeground(Color.white);
        this.lblName.setFont(new Font("Arial", 3, 12));

        this.txtName = new JTextField();
        this.txtName.setBounds(100, 280, 330, 30);


        this.lblBirthday = new JLabel("Birthday: ");
        this.lblBirthday.setBounds(10, 320, 90, 30);
        this.lblBirthday.setForeground(Color.white);
        this.lblBirthday.setFont(new Font("Arial", 3, 12));

        this.txtBirthday = new JFormattedTextField(new MaskFormatter("##/##/####"));
       
        
        this.txtBirthday.setBounds(100, 320, 330, 30);

        this.lblEmail = new JLabel("Email: ");
        this.lblEmail.setBounds(10, 355, 90, 30);
        this.lblEmail.setForeground(Color.white);
        this.lblEmail.setFont(new Font("Arial", 3, 12));

        this.txtEmail = new JTextField();
        this.txtEmail.setBounds(100, 355, 330, 30);


        this.lblPhone = new JLabel("Phone: ");
        this.lblPhone.setBounds(10, 390, 90, 30);
        this.lblPhone.setForeground(Color.white);
        this.lblPhone.setFont(new Font("Arial", 3, 12));

        
        
        this.txtPhone = new JFormattedTextField(new MaskFormatter("###########"));
        this.txtPhone.setBounds(100, 390, 330, 30);
     

        this.lblRollNumber = new JLabel("Roll-number: ");
        this.lblRollNumber.setBounds(10, 425, 90, 30);
        this.lblRollNumber.setForeground(Color.white);
        this.lblRollNumber.setFont(new Font("Arial", 3, 12));

        this.txtRollNumber = new JTextField();
        this.txtRollNumber.setBounds(100, 425, 330, 30);
  

        this.lblClassName = new JLabel("Class-name: ");
        this.lblClassName.setBounds(10, 460, 90, 30);
        this.lblClassName.setForeground(Color.white);
        this.lblClassName.setFont(new Font("Arial", 3, 12));

        this.txtClassName = new JTextField();
        this.txtClassName.setBounds(100, 460, 330, 30);


        this.btnSubmit = new JButton("Submit");
        this.btnSubmit.setBounds(100, 500, 80, 30);
        this.btnSubmit.addActionListener(new loginHandle());

        this.btnReset = new JButton("Reset");
        this.btnReset.setBounds(185, 500, 70, 30);
        this.btnReset.addActionListener(new resetHandle());
        
        this.btnCancel = new JButton("Cancel");
        this.btnCancel.setBounds(360, 500, 70, 30);
        this.btnCancel.addActionListener(new resetHandle());

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

        this.add(this.background);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    class loginHandle implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
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
            
            JOptionPane.showConfirmDialog(rootPane, alert.toString());
        }
    }

    class resetHandle implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            txtId.setText(String.valueOf(System.currentTimeMillis()));
            txtName.setText("");
            txtBirthday.setText("");
            txtEmail.setText("");
            txtPhone.setText("");
            txtRollNumber.setText("");
            txtClassName.setText("");

        }

    }
   
}
