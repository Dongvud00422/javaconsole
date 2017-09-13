/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaconsole.controller;

import javaconsole.entity.Student;
import javaconsole.model.StudentModel;
import java.util.Scanner;

/**
 *
 * @author dongvu
 */
public class StudentController {

    public void getList() {
        StudentModel studentModel = new StudentModel();
        if (studentModel.getListStudent().isEmpty()) {
            System.err.println("List student is empty !!");
        } else {
            System.out.println("======== Student list ========");
            for (Student student : studentModel.getListStudent()) {
                System.out.println("Id: " + student.getId() + "\n"
                        + "Name: " + student.getName() + "\n"
                        + "Email: " + student.getEmail() + "\n"
                        + "Class-name: " + student.getClassName() + "\n"
                        + "Roll-number: " + student.getRollNumber() + "\n"
                        + "Status: " + student.getStatus() + "\n"
                        + "--------------");
            }
        }
    }

    public void addStudent() {
        System.out.println("Please enter student infomation.");
        System.out.println("Please enter name: ");
        Scanner scan = new Scanner(System.in);
        String name = scan.nextLine();
        System.out.println("Please enter email: ");
        String email = scan.nextLine();
        System.out.println("Please enter class-name: ");
        String className = scan.nextLine();
        System.out.println("Please enter Roll-number: ");
        String rollNumber = scan.nextLine();
        int statusInt;
        while (true) {
            System.out.println("Please enter status: ");
            String statusString = scan.nextLine();
            try {
                statusInt = Integer.parseInt(statusString);
                break;
            } catch (NumberFormatException e) {
                System.err.println("Please enter numberic !!");
            }

        }
        Student student = new Student();
        student.setName(name);
        student.setEmail(email);
        student.setClassName(className);
        student.setRollNumber(rollNumber);
        student.setStatus(statusInt);

        // Lưu thông tin sinh viên vào db.
        StudentModel studentModel = new StudentModel();
        studentModel.insert(student);
    }

    public void editStudent() {
        StudentModel studentModel = new StudentModel();
        if (studentModel.getListStudent().isEmpty()) {
            System.err.println("List student is empty !!");
        } else {
            System.out.println("Student searching......");

            Scanner scan = new Scanner(System.in);
            int searchingId;
            while (true) {
                System.out.println("Please enter Student's id :");
                String stringId = scan.nextLine();
                try {
                    searchingId = Integer.parseInt(stringId);
                    if (searchingId > 0) {
                        break;
                    }
                    System.err.println("Id must higher than zero !!");
                } catch (NumberFormatException e) {
                    System.err.println("Please enter numberic !!");
                }
            }
     
            // Tìm student vơi id đã nhập vào và xử lý thông tin trả về.
            Student oldStudent = studentModel.getById(searchingId);
            if (oldStudent != null) {
                System.out.println("-- Student found -- \nId: " + oldStudent.getId() + "\n"
                        + "Name: " + oldStudent.getName() + "\n"
                        + "Email: " + oldStudent.getEmail() + "\n"
                        + "Class-name: " + oldStudent.getClassName() + "\n"
                        + "Roll-number: " + oldStudent.getRollNumber() + "\n"
                        + "Status: " + oldStudent.getStatus() + "\n"
                        + "--------------");
                System.out.println("Editting......");
                System.out.println("Please enter new name (press Enter for skip): ");
                String name = scan.nextLine();
                if (name.isEmpty()) {
                    name = oldStudent.getName();
                }
                System.out.println("Please enter new email (press Enter for skip): ");
                String email = scan.nextLine();
                if (email.isEmpty()) {
                    email = oldStudent.getEmail();
                }
                System.out.println("Please enter new class name (press Enter for skip): ");
                String className = scan.nextLine();
                if (className.isEmpty()) {
                    className = oldStudent.getClassName();
                }
                System.out.println("Please enter roll number (press Enter for skip): ");
                String rollNumber = scan.nextLine();
                if (rollNumber.isEmpty()) {
                    rollNumber = oldStudent.getRollNumber();
                }
                int statusInt;
                while (true) {
                    System.out.println("Please enter status: ");
                    String statusString = scan.nextLine();
                    try {
                        statusInt = Integer.parseInt(statusString);
                        break;
                    } catch (NumberFormatException e) {
                        System.err.println("Please enter numberic !!");
                    }
                }

                Student updateStudent = new Student(searchingId, name, email, className, rollNumber, statusInt);
                studentModel.updateStudent(updateStudent);
            } else {
                System.err.println("Student not found !!!");
            }
        }

    }

    public void deleteStudent() {
        StudentModel studentModel = new StudentModel();
        if (studentModel.getListStudent().isEmpty()) {
            System.err.println("List student is empty !!");
        } else {
            System.out.println("Student searching......");
            System.out.println("Please enter Student's id :");
            Scanner scan = new Scanner(System.in);
            int searchingId;
            while (true) {
                System.out.println("Please enter Student's id :");
                String stringId = scan.nextLine();
                try {
                    searchingId = Integer.parseInt(stringId);
                    if (searchingId > 0) {
                        break;
                    }
                    System.err.println("Id must higher than zero !!");
                } catch (NumberFormatException e) {
                    System.err.println("Please enter numberic !!");
                }
            }

            Student student = studentModel.getById(searchingId);
            if (student != null) {
                System.out.println("-- Student found -- \nId: " + student.getId() + "\n"
                        + "Name: " + student.getName() + "\n"
                        + "Email: " + student.getEmail() + "\n"
                        + "Class-name: " + student.getClassName() + "\n"
                        + "Roll-number: " + student.getRollNumber() + "\n"
                        + "Status: " + student.getStatus() + "\n"
                        + "--------------");
                studentModel.deleteStudent(searchingId);
            } else {
                System.err.println("Have not student to delete !!");
            }
        }
    }
}
