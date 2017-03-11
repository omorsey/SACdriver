/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project0;

import java.util.*;

/**
 *
 * @author omorsey
 */
public class Student {
    private String fname;
    private String lname;
    private String major;
    private String minor;
    private String ssn;
    private String displaySSN;
    private char sex;
    private int yog;
    private float gpa;
    
    /////////////////////////////////////////////////////
    ///////// Constructor for transfer student //////////
    /////////////////////////////////////////////////////

    public Student(String n1, String n2, String major, char sex, int yog, float gpa) {
        this.fname = n1;
        this.lname = n2;
        this.major = major;
        this.minor = null;
        this.sex = sex;
        this.yog = yog;
        this.gpa = gpa;
        setSSN();
    }
    
    /////////////////////////////////////////////////////
    ///////// Constructor for freshman student //////////
    /////////////////////////////////////////////////////
    
    public Student(String n1, String n2, String major, char sex, int yog) {
        this.fname = n1;
        this.lname = n2;
        this.major = major;
        this.sex = sex;
        this.yog = yog;
        this.minor = null;
        this.gpa = (float) 0.0;
        setSSN();
    }
    
    public void setFirstName(String n1) {
        this.fname = n1;
    }
    
    public String getFirstName() {
        return this.fname;
    }
    
    public void setLastName(String n2) {
        this.lname = n2;
    }
    
    public String getLastName() {
        return this.lname;
    }
    
    public void setMajor(String ma) {
        this.major = ma;
    }
    
    public String getMajor() {
        return this.major;
    }
    
    public void setMinor(String mi) {
        this.minor = mi;
    }
    
    public String getMinor() {
        return this.minor;
    }
    
    public void setYog(int yog) {
        this.yog = yog;
    }
    
    public int getYog() {
        return this.yog;
    }
    
    public void setGpa(float gpa) {
        this.gpa = gpa;
    }
    
    public float getGpa() {
        return this.gpa;
    }
    
    public void setSex(char sex) {
        this.sex = sex;
    }
    
    public char getSex() {
        return this.sex;
    }
    
    /////////////////////////////////////////////////////
    ///// Creates random ssn in form of XXX-XX-XXXX /////
    /////////////////////////////////////////////////////
    
    private void setSSN() {
        Random gen = new Random();
        String ssn1String = "";
        String ssn2String = "";
        String ssn3String = "";
        int ssn1 = gen.nextInt(999) + 1;
            if (ssn1 < 10) {
                ssn1String = "00"+Integer.toString(ssn1);
            }
            else if (ssn1 < 100) {
                ssn1String = "0"+Integer.toString(ssn1);
            }
            else {
                ssn1String = Integer.toString(ssn1);
            }
        int ssn2 = gen.nextInt(99) + 1;
            if (ssn2 < 10) {
                ssn2String = "0"+Integer.toString(ssn2);
            }
            else {
                ssn2String = Integer.toString(ssn2);
            }
        int ssn3 = gen.nextInt(9999) + 1;
            if (ssn3 < 10) {
                ssn3String = "000"+Integer.toString(ssn3);
            }
            else if (ssn3 < 100) {
                ssn3String = "00"+Integer.toString(ssn3);
            }
            else if (ssn3 < 1000) {
                ssn3String = "0"+Integer.toString(ssn3);
            }
            else {
                ssn3String = Integer.toString(ssn3);
            }
        this.ssn = ssn1String+"-"+ssn2String+"-"+ssn3String;
        this.displaySSN = "XXX-XX-"+ssn3String;
    }
    
    public void displayAll() {
        System.out.println("first name: \t" + this.fname);
        System.out.println("last name: \t" + this.lname);
        System.out.println("major: \t\t" + this.major);
        System.out.println("minor: \t\t" + this.minor);
        System.out.println("YOG: \t\t" + this.yog);
        System.out.println("GPA: \t\t" + this.gpa);
        System.out.println("Sex: \t\t" + this.sex);
        System.out.println("SSN: \t\t" + this.displaySSN);
        System.out.println();
    }

}
