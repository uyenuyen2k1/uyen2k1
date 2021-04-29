/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author hp
 */
package studentmananger;

public class Student {
    int id;
    String fullname, studentCode, gender, email, address, phoneNumber;
    int age;

    public Student() {
    }

    public Student(String fullname, String studentCode, String gender, String email, String address, String phoneNumber, int age) {
        this.fullname = fullname;
        this.studentCode = studentCode;
        this.gender = gender;
        this.email = email;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.age = age;
    }

    public Student(int id, String fullname, String studentCode, String gender, String email, String address, String phoneNumber, int age) {
        this.id = id;
        this.fullname = fullname;
        this.studentCode = studentCode;
        this.gender = gender;
        this.email = email;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public String getFullname() {
        return fullname;
    }

    public String getStudentCode() {
        return studentCode;
    }

    public String getGender() {
        return gender;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public int getAge() {
        return age;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public void setStudentCode(String studentCode) {
        this.studentCode = studentCode;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setAge(int age) {
        this.age = age;
    }
    
}
