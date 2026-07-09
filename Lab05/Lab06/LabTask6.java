// ============================================
// OOP LAB TASK 6 - Method Overloading
// Name: Syed Amaan
// University: IoBM - BS Data Science
// ============================================

// ---- Q1: Method Overloading - Square of Different Types ----
class Q1_Mathematics {
    void square(int num) {
        int result = num * num;
        System.out.println("Square of integer: " + result);
    }

    void square(double num) {
        double result = num * num;
        System.out.println("Square of double: " + result);
    }

    void square(float num) {
        float result = num * num;
        System.out.println("Square of float: " + result);
    }

    public static void main(String[] args) {
        Q1_Mathematics obj = new Q1_Mathematics();
        obj.square(5);      // integer
        obj.square(4.5);    // double
        obj.square(3.2f);   // float
    }
}

// ---- Q2: Constructor Overloading - Student Name ----
class Q2_Student {
    String name;

    Q2_Student() {
        name = "Unknown";
    }

    Q2_Student(String n) {
        name = n;
    }

    void display() {
        System.out.println("Student Name: " + name);
    }

    public static void main(String[] args) {
        Q2_Student s1 = new Q2_Student();
        Q2_Student s2 = new Q2_Student("Ali");
        s1.display();
        s2.display();
    }
}

// ---- Q3: Method Overloading - Area of Square and Rectangle ----
class Q3_Area {
    void area(int side) {
        int squareArea = side * side;
        System.out.println("Area of Square = " + squareArea);
    }

    void area(int length, int breadth) {
        int rectangleArea = length * breadth;
        System.out.println("Area of Rectangle = " + rectangleArea);
    }

    public static void main(String[] args) {
        Q3_Area obj = new Q3_Area();
        obj.area(5);
        obj.area(4, 6);
    }
}
