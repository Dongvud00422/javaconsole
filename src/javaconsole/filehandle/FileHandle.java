/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaconsole.filehandle;

import javaconsole.entity.Student;
import javaconsole.model.StudentModel;
import java.io.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dongvu
 * @since 12/09/2107
 */
public class FileHandle {

    public void exportToFile() {
        StudentModel studentModel = new StudentModel();
        ArrayList<Student> listStudent = studentModel.getListStudent();
        FileWriter fw = null;
        BufferedWriter bw = null;

        try {
            bw = new BufferedWriter(new FileWriter("Assignment.txt"));
            
            for (Student student : listStudent) {

                // Lần lượt viết các giá trị vào file.
                bw.write("ID: " + student.getId());
                bw.newLine();
                bw.write("Name: " + student.getName());
                bw.newLine();
                bw.write("Email: " + student.getEmail());
                bw.newLine();
                bw.write("Class-name: " + student.getClassName());
                bw.newLine();
                bw.write("Roll-number: " + student.getRollNumber());
                bw.newLine();
                bw.write("Status: " + student.getStatus());
                bw.newLine();
                bw.write("--------------------");
                bw.newLine();
            }
            System.out.println("-- Write to file success --");
        } catch (IOException e) {
            System.err.println("Write to file erorr !!!\n" + e.getMessage());
        } finally {
            try {
                bw.close();
            } catch (IOException ex) {
                System.err.println("Close stream erorr !!!\n" + ex.getMessage());
            }
        }
    }

    public void importFromFile() {
        FileReader fr = null;
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader("Assignment.txt"));
            String read;
            while ((read = br.readLine()) != null) {
                System.out.println(read);
            }
        } catch (FileNotFoundException ex) {
            System.err.println("File not found !!!\n" + ex.getMessage());
        } catch (IOException ex) {
            System.err.println("Read from file erorr !!!\n" + ex.getMessage());
        } finally{
            try {
                br.close();
            } catch (IOException ex) {
                Logger.getLogger(FileHandle.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

}
