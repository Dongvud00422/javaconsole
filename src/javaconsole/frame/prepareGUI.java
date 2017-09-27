/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaconsole.frame;

import java.awt.CardLayout;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author dongvu
 */
public class prepareGUI extends JFrame {

    private AddStudentForm addStudent = new AddStudentForm();
    private GetListstudentForm getListstudent = new GetListstudentForm();
    private CardLayout cLayout = new CardLayout();

    public prepareGUI() {
        this.setSize(950, 650);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setLayout(cLayout);
        try {
            this.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("/Users/dongvu/NetBeansProjects/javaconsole/src/javaconsole/frame/background.png")))));
        } catch (IOException ex) {
            System.out.println("Set background Failed " + ex.getMessage());
        }
        this.add(addStudent,"1");
        this.add(getListstudent,"2");

        cLayout.show(this, "addStudent");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
    
       public static void main(String[] args) {

        prepareGUI p = new prepareGUI();
        p.setVisible(true);

    }
}
