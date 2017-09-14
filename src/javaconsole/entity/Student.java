/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaconsole.entity;

/**
 *
 * @author dongvu
 */
public class Student {

    private int id;
    private String name;
    private String phone;
    private String email;
    private String className;
    private String rollNumber;
    private int status;

    public Student() {

    }

    public Student(int id, String name, String phone, String email, String className, String rollNumber, int status) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.className = className;
        this.rollNumber = rollNumber;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getRollNumber() {
        return rollNumber;
    }

    public void setRollNumber(String rollNumber) {
        this.rollNumber = rollNumber;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

}
