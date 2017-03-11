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
public class Employee {
    private String fname;
    private String lname;
    private float salary;
    private String ssn;
    private String displaySSN;
    private char sex;
    private String doj;
    private int jobID;
    
    /////////////////////////////////////////////////////
    ////////// Constructor for all employees ////////////
    /////////////////////////////////////////////////////

    public Employee(String n1, String n2, float salary, char sex, String doj, int jobID) {
        this.fname = n1;
        this.lname = n2;
        this.salary = salary;
        this.sex = sex;
        this.doj = doj;
        this.jobID = jobID;
        setSSN();
    }
    
    public void setSalary(float salary) {
        this.salary = salary;
    }
    
    public float getSalary() {
        return this.salary;
    }
    
    public void setJobID(int id) {
        this.jobID = id;
    }
    
    public String getJobID() {
        if (this.jobID == 1) {
            return "full time staff";
        }
        else if (this.jobID == 2) {
            return "faculty";
        }
        else if (this.jobID == 3) {
            return "part time staff";
        }
        else { 
            return "Invalid job ID";
        }
    }
    
    public void setSex(char sex) {
        this.sex = sex;
    }
    
    public char getSex() {
        return this.sex;
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
    
    public void setDoj(String doj) {
        this.doj = doj;
    }
    
    public String getDoj() {
        return this.doj;
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
        System.out.println("salary: \t$" + this.salary);
        System.out.println("date joined: \t" + this.doj);
        System.out.println("job ID: \t" + getJobID());
        System.out.println("sex: \t\t" + this.sex);
        System.out.println("SSN: \t\t" + this.displaySSN);
        System.out.println();
    }
}
