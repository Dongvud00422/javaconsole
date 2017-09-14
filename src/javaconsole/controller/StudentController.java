/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaconsole.controller;

import javaconsole.entity.Student;
import javaconsole.model.StudentModel;
import java.util.Scanner;
import javaconsole.vaildate.VaildateInputData;

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
                        + "Phone: " + student.getPhone() + "\n"
                        + "Class-name: " + student.getClassName() + "\n"
                        + "Roll-number: " + student.getRollNumber() + "\n"
                        + "Status: " + student.getStatus() + "\n"
                        + "--------------");
            }
        }
    }

    public void addStudent() {
        Scanner scan = new Scanner(System.in);
        VaildateInputData vaildate = new VaildateInputData();
        System.out.println("Please enter student infomation.");
        System.out.println("Please enter name: ");
        String name = scan.nextLine();
        System.out.println("Please enter email: ");
        String email;
        while (true) {
            email = scan.nextLine();
            if (vaildate.vaildateEmail(email)) {
                break;
            } else {
                System.err.println("Email foromat erorr, please try again...");
            }
        }
        System.out.println("Please enter phone: ");
        String phone;
        while (true) {
            phone = scan.nextLine();
            if (vaildate.vaildatePhone(phone)) {
                break;
            } else {
                System.err.println("Phone format erorr, please try again...");
            }
        }
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
        student.setPhone(phone);
        student.setClassName(className);
        student.setRollNumber(rollNumber);
        student.setStatus(statusInt);

        // Lưu thông tin sinh viên vào db.
        StudentModel studentModel = new StudentModel();
        studentModel.insert(student);
    }

    public void editStudent() {
        StudentModel studentModel = new StudentModel();
        VaildateInputData vaildate = new VaildateInputData();
        if (studentModel.getListStudent().isEmpty()) {
            System.err.println("List student is empty !!");
        } else {
            System.out.println("Student searching......");
            Scanner scan = new Scanner(System.in);

            // Kiểm tra Id nhập vào là số lớn hơn 0;
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
                System.out.println("-- Student found -- \nId: "
                        + oldStudent.getId() + "\n"
                        + "Name: " + oldStudent.getName() + "\n"
                        + "Email: " + oldStudent.getEmail() + "\n"
                        + "Phone: " + oldStudent.getPhone() + "\n"
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
                // Kiểm tra nếu không nhập vào email sẽ nhận giá trị cũ và vaildate email
                String email;
                while (true) {
                    email = scan.nextLine();
                    if (email.isEmpty()) {
                        email = oldStudent.getEmail();
                        break;
                    } else if (vaildate.vaildateEmail(email)) {
                        break;
                    } else {
                        System.err.println("Email foromat erorr, please try again...");
                    }
                }
                
                System.out.println("Please enter new phone (press Enter for skip): ");
                // Kiểm tra nếu không nhập vào phone sẽ nhận giá trị cũ và vaildate phone
                String phone;
                while (true) {
                  phone = scan.nextLine();
                    if (phone.isEmpty()) {
                        phone = oldStudent.getPhone();
                        break;
                    } else if (vaildate.vaildatePhone(phone)) {
                        break;
                    } else {
                        System.err.println("Phone foromat erorr, please try again...");
                    }
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

                Student updateStudent = new Student(searchingId, name, email, phone, className, rollNumber, statusInt);
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
                        + "Phone: " + student.getPhone()+ "\n"
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
