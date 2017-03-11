//************************************************************//
//              Saint Anselm College Directory                //
//                      Olivia Morsey                         //
//                Data Structures & Algorithms                //
//                        Fall 2015                           //
//************************************************************//
package project0;

import java.util.*;
import java.lang.*;

public class SACdriver {
    static boolean DBUG = false;
    static int studCount = 0;
    static int empCount = 0;
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Student [] students = new Student[10];  //array of students
        Employee [] employees = new Employee[10];  //array of employees
        int input = 0;  //input for menu options
        String fname;
        String lname;
        String major;
        String minor;
        float inputGpa;
        float salary;
        String doj;
        int jobID;
        char sex;
        int yog;
        
        int enterYOG = 0;
        String enterMAJOR;
        String enterLastName;
        String enterFirstName;
        
        long startTime;
        long endTime;
        long task;
        
        /***************************************/
        /*        10 initial students          */
        /***************************************/
            students[studcount++] = new Student("Nathan", "Scott", "Business", 'M', 2018);
            students[studcount++] = new Student("Lucas", "Scott", "English", 'M', 2018);
            students[studcount++] = new Student("Brooke", "Davis", "Fashion", 'F', 2018);
            students[studcount++] = new Student("Peyton", "Sawyer", "Music", 'F', 2018);
            students[studcount++] = new Student("Haley", "James", "Education", 'F', 2018);
            students[studcount++] = new Student("Tim", "Smith", "Undeclared", 'M', 2018);
            students[studcount++] = new Student("Antwon", "Taylor", "Business", 'M', 2018);
            students[studcount++] = new Student("Rachel", "Gatina", "Fashion", 'F', 2018);
            students[studcount++] = new Student("Marvin", "McFadden", "Broadcast Journalism", 'M', 2018);
            students[studcount++] = new Student("Chase", "Adams", "Business", 'M', 2018);
                
        /***************************************/
        /*        10 initial employees         */
        /***************************************/
            employees[empCount++] = new Employee("Dan", "Scott", 50000, 'M', "2005", 2);
            employees[empCount++] = new Employee("Karen", "Roe", 30000, 'F', "2005", 2);
            employees[empCount++] = new Employee("Deb", "Scott", 30000, 'F', "2006", 2);
            employees[empCount++] = new Employee("Keith", "Scott", 40000, 'M', "2005", 2);
            employees[empCount++] = new Employee("Andy", "Hargrove", 90000, 'M', "2007", 2);
            employees[empCount++] = new Employee("Whitey", "Durham", 40000, 'M', "1990", 1);
            employees[empCount++] = new Employee("Julian", "Baker", 70000, 'M', "2010", 1);
            employees[empCount++] = new Employee("Quinn", "James", 40000, 'F', "2010", 1);
            employees[empCount++] = new Employee("Clayton", "Evans", 70000, 'M', "2010", 1);
            employees[empCount++] = new Employee("Chris", "Keller", 60000, 'M', "2006", 1);
        
        menu();
        input = scan.nextInt();
        
        do {
            
            switch (input) {
                
                case 1: //display total number of students
                    System.out.println("There are currently " + studCount + " students in the system.");
                    menu();
                    input = scan.nextInt();
                    break;
                
                case 2: //display total number of employees
                    System.out.println("There are currently " + empCount + " employees in the system.");
                    menu();
                    input = scan.nextInt();
                    break;
                
                case 3: //add student
                    System.out.println("Enter first name: ");
                    fname = scan.next();
                    System.out.println("Enter last name: ");
                    lname = scan.next();
                    System.out.println("Enter major: ");
                    major = scan.next();
                    System.out.println("Enter sex (M or F): ");
                    sex = scan.next().charAt(0);
                    System.out.println("Enter year of graduation: ");
                    yog = scan.nextInt();
                    //**********************************************//
                    //      to expand the number of students        //
                    //**********************************************//

                         Student [] tempS = new Student[studCount*2];
                         for (int i = 0 ; i < studCount ; i++) {
                             tempS[i] = students[i];
                         }
                         students = tempS;   //transfers temp array to students array
                    //////////////////////////////////////////////////
                            
                    //**********************************************//
                    //           creates a new student              //
                    //**********************************************//
                        students[studCount++] = new Student(fname, lname, major, sex, yog);
                        menu();
                         input = scan.nextInt();
                         break;
                    
                case 4: //add employee 
                    System.out.println("Enter first name: ");
                    fname = scan.next();
                    System.out.println("Enter last name: ");
                    lname = scan.next();
                    System.out.println("Enter salary: ");
                    salary = scan.nextFloat();
                    System.out.println("Enter sex: ");
                    sex = scan.next().charAt(0);
                    System.out.println("Enter date of joining: ");
                    doj = scan.next();
                    System.out.println("Enter job ID (1=full time staff, 2=faculty, 3=part time staff): ");
                    jobID = scan.nextInt();
                    //**********************************************//
                    //      to expand the number of employees       //
                    //**********************************************//

                        Employee [] tempE = new Employee[empCount*2];
                            for (int i = 0 ; i < empCount ; i++) {
                                tempE[i] = employees[i];
                            }
                        employees = tempE;   //transfers temp array to employees array
                    //////////////////////////////////////////////////
                            
                    //**********************************************//
                    //           creates a new employee             //
                    //**********************************************//
                        employees[empCount++] = new Employee(fname, lname, salary, sex, doj, jobID);
                        menu();
                        input = scan.nextInt();
                        break;
                    
                case 5: //display students
                    startTime = System.nanoTime();
                    selectionSortStudents(students);
                    for (int i = 0 ; i < studCount ; i++) {
                        students[i].displayAll();
                    }
                    endTime = System.nanoTime();
                    task = endTime - startTime;
                    System.out.println("Time in nanoseconds = " + task);
                    menu();
                    input = scan.nextInt();
                    break;
                    
                case 6: //display employees
                    startTime = System.nanoTime();
                    insertionSortEmployees(employees);
                    for (int i = 0 ; i < empCount ; i++) {
                        employees[i].displayAll();
                    }
                    endTime = System.nanoTime();
                    task = endTime - startTime;
                    System.out.println("Time in nanoseconds = " + task);
                    menu();
                    input = scan.nextInt();
                    break;
                    
                case 7: //display all faculty
                    for (int i = 0 ; i < empCount ; i++) {
                        if("faculty".equals(employees[i].getJobID()))
                            employees[i].displayAll();
                    }
                    menu();
                    input = scan.nextInt();
                    break;
                    
                case 8: //display all staff
                    for (int i = 0 ; i < empCount ; i++) {
                        if ("full time staff".equals(employees[i].getJobID()) || "part time staff".equals(employees[i].getJobID()))
                            employees[i].displayAll();
                    }
                    menu();
                    input = scan.nextInt();
                    break;
                    
                case 9: //display students by yog
                    System.out.println("Search for year of graduation: ");
                    enterYOG = scan.nextInt();
                    for (int i = 0 ; i < studCount ; i++) {
                        if (students[i].getYog() == enterYOG) {
                            students[i].displayAll();
                        }
                    }  
                    menu();
                    input = scan.nextInt();
                    break;
                    
                case 10: //display students by major
                    System.out.println("Search for major: ");
                    enterMAJOR = scan.next();
                    for (int i = 0 ; i < studCount ; i++) {
                        if (students[i].getMajor().equalsIgnoreCase(enterMAJOR)) {
                            students[i].displayAll();
                        }
                    }
                    menu();
                    input = scan.nextInt();
                    break;
                
                case 11: //Linear search a student by last name
                    System.out.println("Search last name: ");
                    enterLastName = scan.next();
                    startTime = System.nanoTime();
                    for (int i = 0 ; i < studCount ; i++) {
                        if (students[i].getLastName().equalsIgnoreCase(enterLastName)) {
                            students[i].displayAll();
                        }
                    }
                    endTime = System.nanoTime();
                    task = endTime - startTime;
                    System.out.println("Time in nanoseconds = " + task);
                    menu();
                    input = scan.nextInt();
                    break;
                    
                case 12: //Linear search an employee by last name
                    System.out.println("Search last name: ");
                    enterLastName = scan.next();
                    startTime = System.nanoTime();
                    for (int i = 0 ; i < empCount ; i++) {
                        if (employees[i].getLastName().equalsIgnoreCase(enterLastName)) {
                            employees[i].displayAll();
                        }
                    }
                    endTime = System.nanoTime();
                    task = endTime - startTime;
                    System.out.println("Time in nanoseconds = " + task);
                    menu();
                    input = scan.nextInt();
                    break;
                   
                case 13: //Binary search a student by first name
                    System.out.println("Search first name: ");
                    enterFirstName = scan.next();
                    startTime = System.nanoTime();
                    bubbleSortStudents(students);
                    BinarySearchStudents(students, 0, studCount-1, enterFirstName);
                    endTime = System.nanoTime();
                    task = endTime - startTime;
                    System.out.println("Time in nanoseconds = " + task);
                    StudentSubMenu();
                    input = scan.nextInt();
                    do {
                        switch (input) {
                            case 1: //delete the student
                                for (int i = 0 ; i < studCount ; i++) {
                                    if (DBUG) {
                                        students[i].displayAll();
                                    }
                                    if (students[i].getFirstName().compareToIgnoreCase(enterFirstName) == 0) {
                                        if (DBUG) {
                                            System.out.println("found" + students[i].getFirstName() + i);
                                        }
                                        for (int j = i ; j < studCount-1 ; j++) {
                                            if (DBUG) {
                                                System.out.println("Replacing" + students[j].getFirstName() + " with " + students[j+1].getFirstName() + " at index " + j);
                                            }
                                            students[j] = students[j+1];
                                            if (j+1 == studCount-1) {
                                                students[j+1] = null;
                                                studCount--;
                                            }
                                        }
                                    break;
                                    } 
                                }
                                StudentSubMenu();
                                input = scan.nextInt();
                                break;
                                
                            case 2: //change GPA
                                System.out.println("Enter new GPA: ");
                                inputGpa = scan.nextFloat();
                                for (int i = 0 ; i < studCount ; i++) {
                                    if (students[i].getFirstName().compareToIgnoreCase(enterFirstName) == 0) {
                                        students[i].setGpa(inputGpa);
                                    }
                                }
                                StudentSubMenu();
                                input = scan.nextInt();
                                break;
                            case 3: //change major
                                System.out.println("Enter new Major: ");
                                major = scan.next();
                                for (int i = 0 ; i < studCount ; i++) {
                                    if (students[i].getFirstName().compareToIgnoreCase(enterFirstName) == 0) {
                                        students[i].setMajor(major);
                                    }
                                }
                                StudentSubMenu();
                                input = scan.nextInt();
                                break;
                            case 4: //change minor
                                System.out.println("Enter new Minor: ");
                                minor = scan.next();
                                for (int i = 0 ; i < studCount ; i++) {
                                    if (students[i].getFirstName().compareToIgnoreCase(enterFirstName) == 0) {
                                        students[i].setMinor(minor);
                                    }
                                }
                                StudentSubMenu();
                                input = scan.nextInt();
                                break;
                            case 5: //back to main menu
                                break;
                        }
                    } while(input != 5);
                    menu();
                    input = scan.nextInt();
                    break;
                    
                case 14: //Binary search an employee by first name
                    System.out.println("Search first name: ");
                    enterFirstName = scan.next();
                    startTime = System.nanoTime();
                    bubbleSortEmployees(employees);
                    BinarySearchEmployees(employees, 0, empCount-1, enterFirstName);
                    endTime = System.nanoTime();
                    task = endTime - startTime;
                    System.out.println("Time in nanoseconds = " + task);
                    EmployeeSubMenu();
                    input = scan.nextInt();
                    do {
                        switch (input) {
                            case 1: //delete the employee
                                for (int i = 0 ; i < empCount ; i++) {
                                    if (DBUG) {
                                        employees[i].displayAll();
                                    }
                                    if (employees[i].getFirstName().compareToIgnoreCase(enterFirstName) == 0) {
                                        if (DBUG) {
                                            System.out.println("found" + employees[i].getFirstName() + i);
                                        }
                                        for (int j = i ; j < empCount-1 ; j++) {
                                            if (DBUG) {
                                                System.out.println("Replacing" + employees[j].getFirstName() + " with " + employees[j+1].getFirstName() + " at index " + j);
                                            }
                                            employees[j] = employees[j+1];
                                            if (j+1 == empCount-1) {
                                                employees[j+1] = null;
                                                empCount--;
                                            }
                                        }
                                    break;
                                    } 
                                }
                                EmployeeSubMenu();
                                input = scan.nextInt();
                                break;
                            case 2: //change salary
                                System.out.println("Enter new Salary: ");
                                salary = scan.nextFloat();
                                for (int i = 0 ; i < empCount ; i++) {
                                    if (employees[i].getFirstName().compareToIgnoreCase(enterFirstName) == 0) {
                                        employees[i].setSalary(salary);
                                    }
                                }
                                EmployeeSubMenu();
                                input = scan.nextInt();
                                break;
                            
                            case 3: //back to main menu
                                break;
                        }
                    } while(input != 3);
                    menu();
                    input = scan.nextInt();
                    break;
                
                case 15: //merge sort students by first name
                    startTime = System.nanoTime();
                    sortStudents(students);
                    endTime = System.nanoTime();
                    task = endTime - startTime;
                    System.out.println("Time in nanoseconds = " + task);
                    menu();
                    input = scan.nextInt();
                    break;
                
                case 16: //quick sort employees by last name
                    startTime = System.nanoTime();
                    sortEmployees(employees);
                    endTime = System.nanoTime();
                    task = endTime - startTime;
                    System.out.println("Time in nanoseconds = " + task);
                    menu();
                    input = scan.nextInt();
                    break;
                case 17: //exit
                    System.exit(0);
                    
            }
            
        } while(input != 17);
        
    }
    
    ///////////Selection Sort//////////
    
        public static void selectionSortStudents(Student [] s) {
            Student temp;
            int min;
            for (int i = 0 ; i < studCount-1 ; i++) {
                if (s[i] == null) continue;
                min = i;
                for (int j = i+1 ; j < studCount ; j++) {
                    if (s[i] == null) continue;
                    if (s[j].getLastName().compareToIgnoreCase(s[min].getLastName()) < 0) {
                        min = j;
                    }
                }
                swap(s,min,i);
            }
        }
        
        public static void insertionSortEmployees(Employee [] e) {
            for (int i = 1 ; i < empCount ; i++) {
                Employee temp = e[i];
                int j = i;
                while(j > 0 && e[j-1].getFirstName().compareTo(temp.getFirstName()) > 0) {
                    e[j] = e[j-1];
                    j--;
                }
                e[j] = temp;
            }
        }
        
        public static void swap(Student [] s, int i , int j) {
            Student temp = s[i];
            s[i] = s[j];
            s[j] = temp;
        }
        
    ///////////Bubble Sort/////////////
    
        public static void bubbleSortStudents(Student [] s) {
                Student temp;
                    for (int i = 0 ; i < studCount-1 ; i++) {
                        for (int j = 1 ; j < studCount ; j++) {
                            if(s[j-1].getFirstName().compareToIgnoreCase(s[j].getFirstName()) > 0){
                                //swap the elements
                                //System.out.println(s[i].getFirstName());
                                temp = s[j-1];
                                s[j-1] = s[j];
                                s[j] = temp;
                            }
                        }
                    }
                    if (DBUG) {
                        for (int i = 0 ; i < studCount ; i++) {
                        System.out.println(s[i].getFirstName());
                        }
                    }
        }
        
        public static void bubbleSortEmployees(Employee [] e) {
                Employee temp;
                    for (int i = 0 ; i < empCount-1 ; i++) {
                        for (int j = 1 ; j < empCount ; j++) {
                            if(e[j-1].getFirstName().compareTo(e[j].getFirstName()) > 0){
                                //swap the elements
                                temp = e[j-1];
                                e[j-1] = e[j];
                                e[j] = temp;
                            }
                        }
                    }
                    if (DBUG) {
                        for (int i = 0 ; i < empCount ; i++) {
                           System.out.println(e[i].getFirstName());
                        }
                    }
        }
        
    /////////////Binary Search///////////////
        
        public static void BinarySearchStudents(Student [] s, int low, int high, String k) {
            int mid = (high == 1 ? 0 : (high-low) / 2);
            mid = low+mid;
            
            if (DBUG) { System.out.println("Trying " + mid + "compare val: " + s[mid].getFirstName().compareToIgnoreCase(k)); }
            
            if (s[mid].getFirstName().compareToIgnoreCase(k) == 0) {
                s[mid].displayAll(); 
                return;
            } 
            else if (k.compareToIgnoreCase(s[mid].getFirstName()) > 0) {  // input is greater than middle person...
                if (DBUG) { System.out.println(k + " is Greater than " + s[mid].getFirstName()); }
                BinarySearchStudents(s, mid+1 , high, k);
            } 
            else {  //input is less than middle person
                if (DBUG) { System.out.println(k + " is Less than " + s[mid].getFirstName()); }
                BinarySearchStudents(s, low, mid-1 , k);
            }
            
         }
        
        public static void BinarySearchEmployees(Employee [] e, int low, int high, String k) {
            int mid = (high == 1 ? 0 : (high-low) / 2);
            mid = low+mid;
            
            if (DBUG) { System.out.println("Trying " + mid + "compare val: " + e[mid].getFirstName().compareToIgnoreCase(k)); }
            
            if (e[mid].getFirstName().compareToIgnoreCase(k) == 0) {
                e[mid].displayAll(); 
                return;
            } 
            else if (k.compareToIgnoreCase(e[mid].getFirstName()) > 0) {  // input is greater than middle person...
                if (DBUG) { System.out.println(k + " is Greater than " + e[mid].getFirstName()); }
                BinarySearchEmployees(e, mid+1 , high, k);
            } 
            else {  //input is less than middle person
                if (DBUG) { System.out.println(k + " is Less than " + e[mid].getFirstName()); }
                BinarySearchEmployees(e, low, mid-1 , k);
            }
         }
        
    /////////////Merge Sort///////////////  
        
        public static void sortStudents(Student [] s) {
            mergeSortStudents(s,0,studCount-1);
            if (DBUG) {for (int i = 0 ; i < studCount ; i++) {
                System.out.println(s[i].getFirstName());
            }
            }
        }
        public static void mergeSortStudents(Student [] s,int low, int high) {
            if (low < high) {
                int mid = low + (high-low)/2;
                mergeSortStudents(s,low,mid);
                mergeSortStudents(s,mid+1,high);
                mergeStudents(s,low,mid,high);
            }
        }
        public static void mergeStudents(Student [] s, int low, int mid, int high) {
            Student [] temp = new Student[studCount];
            for (int i = low ; i <= high ; i++) {
                temp[i] = s[i];
            }
            int i = low;
            int j = mid+1;
            int k = low;
            while (i <= mid && j <= high) {
                if (temp[i].getFirstName().compareToIgnoreCase(temp[j].getFirstName()) <= 0) {
                    s[k] = temp[i];
                    i++;
                }
                else {
                    s[k] = temp[j];
                    j++;
                }
                k++;
            }
            while (i <= mid) {
                s[k] = temp[i];
                k++;
                i++;
            }
        }
        
    /////////////Quick Sort///////////////
        
        public static void sortEmployees(Employee [] e) {
            int left = 0;
            int right = empCount-1;
            quickSortEmployees(e,left,right);
            if (DBUG) {for (int i = 0 ; i < empCount ; i++) {
                System.out.println(e[i].getLastName());
            }
            }
        }
        
        public static void quickSortEmployees(Employee [] e, int left, int right) {
            if (left >= right) return;
            int pivot = right;
            int partition = partition(e,left,right,pivot);
            quickSortEmployees(e,0,partition-1);
            quickSortEmployees(e,partition+1,right);
        }
        
        public static int partition(Employee [] e, int left, int right, int pivot) {
            int leftPointer = left-1;
            int rightPointer = right;
            while(leftPointer < rightPointer) {
                while(e[++leftPointer].getLastName().compareToIgnoreCase(e[pivot].getLastName()) < 0) {}
                while(rightPointer > 0 && e[--rightPointer].getLastName().compareToIgnoreCase(e[pivot].getLastName()) > 0) {}
                if (leftPointer >= rightPointer) break;
                else {
                    swap(e,leftPointer,rightPointer);
                }
            }
            swap(e,leftPointer,right);
            if (DBUG) System.out.println(leftPointer);
            return leftPointer;
            
        }
        
        public static void swap(Employee [] e, int left, int right) { 
            Employee temp;
            temp = e[left];
            e[left] = e[right];
            e[right] = temp;
            if (DBUG) System.out.println(e[left].getLastName() +" is being swapped with " + e[right].getLastName());
        }
    
    //*******************************************//
    //                  menus                    //
    //*******************************************//
        
        public static void menu() { 
            System.out.println("*********************************************");
            System.out.println("|   Welcome to the Tree Hill HS Directory   |");
            System.out.println("|            by: Olivia Morsey              |");
            System.out.println("|   Choose an option from the menu below:   |");
            System.out.println("*********************************************");
            System.out.println("1. Total number of students");
            System.out.println("2. Total number of employees");
            System.out.println("3. Add a student");
            System.out.println("4. Add an employee");
            System.out.println("5. Display all Students by last name (sorted with selection sort");
            System.out.println("6. Display all Employees by first name (sorted with insertion sort");
            System.out.println("7. Display Faculty");
            System.out.println("8. Display Staff");
            System.out.println("9. Display all students by year of graduation");
            System.out.println("10. Display all students by major");
            System.out.println("11. Linear search a student by last name");
            System.out.println("12. Linear search an employee by last name");
            System.out.println("13. Binary search a student by  first name");
            System.out.println("14. Binary search an employee by first name");
            System.out.println("15. Merge Sort Students by First Name");
            System.out.println("16. Quick Sort Employees by Last Name");
            System.out.println("17. Exit");
        }
        
        public static void StudentSubMenu() {
            System.out.println("1. Delete the student");
            System.out.println("2. Change GPA");
            System.out.println("3. Change Major");
            System.out.println("4. Change Minor");
            System.out.println("5. Back to main menu");
        }
        
        public static void EmployeeSubMenu() {
            System.out.println("1. Delete the Employee");
            System.out.println("2. Change Salary");
            System.out.println("3. Back to main menu");
        }
    
}

