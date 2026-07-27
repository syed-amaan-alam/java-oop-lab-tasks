// ============================================
// OOP LAB TASK 9 - Abstract Classes and Polymorphism
// Name: Syed Amaan
// University: IoBM - BS Data Science
// ============================================

// ---- Q1: Bank Interest Rate - Runtime Polymorphism ----
class Q1_Bank {
    double getRateOfInterest() {
        return 0;
    }
}

class Q1_MCB extends Q1_Bank {
    double getRateOfInterest() {
        return 6.4;
    }
}

class Q1_HBL extends Q1_Bank {
    double getRateOfInterest() {
        return 9.3;
    }
}

class Q1_SCB extends Q1_Bank {
    double getRateOfInterest() {
        return 9.7;
    }

    public static void main(String[] args) {
        Q1_Bank b;
        b = new Q1_MCB();
        System.out.println("MCB Interest Rate: " + b.getRateOfInterest() + "%");
        b = new Q1_HBL();
        System.out.println("HBL Interest Rate: " + b.getRateOfInterest() + "%");
        b = new Q1_SCB();
        System.out.println("SCB Interest Rate: " + b.getRateOfInterest() + "%");
    }
}

// ---- Q2: Shapes - Inheritance and Polymorphism ----
class Q2_Shapes {
    double area() {
        return 0;
    }
}

class Q2_Triangle extends Q2_Shapes {
    double base, height;

    Q2_Triangle(double b, double h) {
        base = b;
        height = h;
    }

    double area() {
        return 0.5 * base * height;
    }
}

class Q2_Circle extends Q2_Shapes {
    double radius;

    Q2_Circle(double r) {
        radius = r;
    }

    double area() {
        return Math.PI * radius * radius;
    }
}

class Q2_Rectangle extends Q2_Shapes {
    double length, width;

    Q2_Rectangle(double l, double w) {
        length = l;
        width = w;
    }

    double area() {
        return length * width;
    }

    public static void main(String[] args) {
        Q2_Shapes s;
        s = new Q2_Triangle(10, 5);
        System.out.println("Triangle Area: " + s.area());
        s = new Q2_Circle(7);
        System.out.println("Circle Area: " + s.area());
        s = new Q2_Rectangle(4, 6);
        System.out.println("Rectangle Area: " + s.area());
    }
}

// ---- Q3: Animal - Runtime Polymorphism ----
class Q3_Animal {
    void eat() {
        System.out.println("Animal eats food");
    }
}

class Q3_Herbivores extends Q3_Animal {
    void eat() {
        System.out.println("Herbivores eat plants");
    }
}

class Q3_Carnivores extends Q3_Animal {
    void eat() {
        System.out.println("Carnivores eat meat");
    }
}

class Q3_Omnivores extends Q3_Animal {
    void eat() {
        System.out.println("Omnivores eat both plants and meat");
    }

    public static void main(String[] args) {
        Q3_Animal a;
        a = new Q3_Herbivores();
        a.eat();
        a = new Q3_Carnivores();
        a.eat();
        a = new Q3_Omnivores();
        a.eat();
    }
}

// ---- Q4: Abstract Class Parent with Two Subclasses ----
abstract class Q4_Parent {
    abstract void message();
}

class Q4_FirstSubclass extends Q4_Parent {
    void message() {
        System.out.println("This is first subclass");
    }
}

class Q4_SecondSubclass extends Q4_Parent {
    void message() {
        System.out.println("This is second subclass");
    }

    public static void main(String[] args) {
        Q4_Parent obj1 = new Q4_FirstSubclass();
        obj1.message();
        Q4_Parent obj2 = new Q4_SecondSubclass();
        obj2.message();
    }
}

// ---- Q5: Abstract Class Animals - Cats and Dogs ----
abstract class Q5_Animals {
    abstract void cats();
    abstract void dogs();
}

class Q5_Cats extends Q5_Animals {
    void cats() {
        System.out.println("Cats meow");
    }
    void dogs() {
        // Not used in this class
    }
}

class Q5_Dogs extends Q5_Animals {
    void cats() {
        // Not used in this class
    }
    void dogs() {
        System.out.println("Dogs bark");
    }

    public static void main(String[] args) {
        Q5_Cats c = new Q5_Cats();
        c.cats();
        Q5_Dogs d = new Q5_Dogs();
        d.dogs();
    }
}
