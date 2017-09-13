/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package javaconsole.controller;

import javaconsole.filehandle.FileHandle;
import java.util.Scanner;

/**
*
* @author dongvu
* @Since 12/09/2017
*/
public class MenuConsole {

    public static void main(String[] args) {
        MenuConsole menu = new MenuConsole();
        menu.createMenu();
    }

    public void createMenu() {
        while (true) {
            System.out.println("=========Student Manager========");
            System.out.println("1. Student list.");
            System.out.println("2. Add student.");
            System.out.println("3. Edit student.");
            System.out.println("4. Delete student.");
            System.out.println("5. Export to file.");
            System.out.println("6. Import from file.");
            System.out.println("7. Exit.");
            System.out.println("===========================");
            System.out.println("Please enter your choice: ");
            Scanner scan = new Scanner(System.in);

            String strChoice = scan.nextLine();

            // Kiểm tra dữ liệu người dùng nhập vào có là số hay không ?
            int choice;

            try {
                // Ép kiểu của biến strChoice về int.
                choice = Integer.parseInt(strChoice);
            } catch (java.lang.NumberFormatException e) {
                System.err.println("Please enter a number.");
                continue;
            }

            StudentController studentController = new StudentController();
            FileHandle fileHandle = new FileHandle();

            switch (choice) {
                case 1:
                    studentController.getList();
                    break;
                case 2:
                    studentController.addStudent();
                    break;
                case 3:
                    studentController.editStudent();
                    break;
                case 4:
                    studentController.deleteStudent();
                    break;
                case 5:
                    fileHandle.exportToFile();
                    break;
                case 6:
                    fileHandle.importFromFile();
                    break;
                case 7:
                    System.exit(0);
                    break;
                default:
                    System.err.println("Please enter number from 1 to 7.");
                    break;
            }

        }

    }
}