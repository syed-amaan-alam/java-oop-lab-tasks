// ============================================
// OOP LAB TASK 8 - Inheritance and Polymorphism
// Name: Syed Amaan
// University: IoBM - BS Data Science
// ============================================

// ---- Q1: Employee Hierarchy - Inheritance ----
class Q1_Employee {
    String name;
    String jobTitle;

    Q1_Employee(String name, String jobTitle) {
        this.name = name;
        this.jobTitle = jobTitle;
    }

    String getName() { return name; }
    String getJobTitle() { return jobTitle; }
    void setName(String name) { this.name = name; }
    void setJobTitle(String jobTitle) { this.jobTitle = jobTitle; }

    double calculateWeeklyPay() {
        return 0;
    }
}

class Q1_SalaryEmployee extends Q1_Employee {
    double weeklySalary;

    Q1_SalaryEmployee(String name, String jobTitle, double weeklySalary) {
        super(name, jobTitle);
        this.weeklySalary = weeklySalary;
    }

    double getWeeklySalary() { return weeklySalary; }
    void setWeeklySalary(double weeklySalary) { this.weeklySalary = weeklySalary; }

    double calculateWeeklyPay() {
        return weeklySalary;
    }
}

class Q1_HourlyEmployee extends Q1_Employee {
    double payRate;
    double hoursWorked;

    Q1_HourlyEmployee(String name, String jobTitle, double payRate, double hoursWorked) {
        super(name, jobTitle);
        this.payRate = payRate;
        this.hoursWorked = hoursWorked;
    }

    double getPayRate() { return payRate; }
    double getHoursWorked() { return hoursWorked; }
    void setPayRate(double payRate) { this.payRate = payRate; }
    void setHoursWorked(double hoursWorked) { this.hoursWorked = hoursWorked; }

    double calculateWeeklyPay() {
        return payRate * hoursWorked;
    }

    public static void main(String[] args) {
        Q1_SalaryEmployee s1 = new Q1_SalaryEmployee("Ali", "Manager", 20000);
        Q1_HourlyEmployee h1 = new Q1_HourlyEmployee("Ahmed", "Clerk", 500, 40);
        System.out.println("Salary Employee Pay: " + s1.calculateWeeklyPay());
        System.out.println("Hourly Employee Pay: " + h1.calculateWeeklyPay());
    }
}

// ---- Q2: Card Hierarchy - Polymorphism ----
class Q2_Card {
    void greeting() {
        System.out.println("Hello!");
    }
}

class Q2_Valentine extends Q2_Card {
    void greeting() {
        System.out.println("Happy Valentine Day");
    }
}

class Q2_Holiday extends Q2_Card {
    void greeting() {
        System.out.println("Season's Greetings.");
    }
}

class Q2_Birthday extends Q2_Card {
    void greeting() {
        System.out.println("Happy Birthday.");
    }

    public static void main(String[] args) {
        Q2_Card c1 = new Q2_Valentine();
        Q2_Card c2 = new Q2_Holiday();
        Q2_Card c3 = new Q2_Birthday();
        c1.greeting();
        c2.greeting();
        c3.greeting();
    }
}

// ---- Q3: Course, Student and Teacher Classes ----
class Q3_Student {
    private String name;
    private int rollNo;
    private String address;
    private double gpa;

    Q3_Student(String name, int rollNo, String address, double gpa) {
        this.name = name;
        this.rollNo = rollNo;
        this.address = address;
        this.gpa = gpa;
    }

    String getName() { return name; }
    int getRollNo() { return rollNo; }
}

class Q3_Teacher {
    private String name;
    private String address;
    private String phone;
    private String degree;

    Q3_Teacher(String name, String address, String phone, String degree) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.degree = degree;
    }

    void displayTeacher() {
        System.out.println("Teacher Name: " + name);
        System.out.println("Address: " + address);
        System.out.println("Phone: " + phone);
        System.out.println("Degree: " + degree);
    }
}

class Q3_Course {
    private String courseName;
    private Q3_Student[] students;
    private Q3_Teacher teacher;

    Q3_Course(String courseName, Q3_Student[] students, Q3_Teacher teacher) {
        this.courseName = courseName;
        this.students = students;
        this.teacher = teacher;
    }

    void printDetails() {
        System.out.println("Course Name: " + courseName);
        System.out.println("\n--- Teacher Details ---");
        teacher.displayTeacher();
        System.out.println("\n--- Student Details ---");
        for (Q3_Student s : students) {
            System.out.println("Name: " + s.getName() + ", Roll No: " + s.getRollNo());
        }
    }

    public static void main(String[] args) {
        Q3_Student s1 = new Q3_Student("Ali", 101, "Karachi", 3.5);
        Q3_Student s2 = new Q3_Student("Ahmed", 102, "Lahore", 3.2);
        Q3_Student s3 = new Q3_Student("Sara", 103, "Islamabad", 3.8);
        Q3_Student s4 = new Q3_Student("Ayesha", 104, "Karachi", 3.6);
        Q3_Student s5 = new Q3_Student("Bilal", 105, "Multan", 3.1);

        Q3_Student[] studentList = {s1, s2, s3, s4, s5};
        Q3_Teacher t1 = new Q3_Teacher("Dr. Khan", "Karachi", "03001234567", "PhD");
        Q3_Course c1 = new Q3_Course("OOP in Java", studentList, t1);
        c1.printDetails();
    }
}
