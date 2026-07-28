/*
 * OOP Lab Task 10
 * Name: Syed Amaan Alam
 * ID: 20251-39878
 * Institute of Business Management (IoBM), Karachi
 * Topic: Interfaces
 */

import java.util.*;

// ================= Q1: Interface with abstract add/sub, implemented by a class =================
interface Q1_CalculationInterface {
    double add(double a, double b);
    double sub(double a, double b);
}

class Q1_Calculation implements Q1_CalculationInterface {
    public double add(double a, double b) { return a + b; }
    public double sub(double a, double b) { return a - b; }
}

class Q1_Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Q1_Calculation obj = new Q1_Calculation();

        System.out.print("Enter 1st number: ");
        double num1 = scanner.nextDouble();
        System.out.print("Enter 2nd number: ");
        double num2 = scanner.nextDouble();

        System.out.println("Add: " + obj.add(num1, num2));
        System.out.println("Sub: " + obj.sub(num1, num2));

        scanner.close();
    }
}

// ================= Q2: Vehicle interface with speed() =================
interface Q2_Vehicle {
    void speed();
}

class Q2_Car implements Q2_Vehicle {
    public void speed() {
        System.out.println("Car is running");
    }
}

class Q2_VehicleInterface {
    public static void main(String[] args) {
        Q2_Car obj = new Q2_Car();
        obj.speed();
    }
}

// ================= Q3: Greetable interface with greet() =================
interface Q3_GreetableInterface {
    void greet();
}

class Q3_Person implements Q3_GreetableInterface {
    public void greet() {
        System.out.println("Hello! Welcome!");
    }
}

class Q3_Greetable {
    public static void main(String[] args) {
        Q3_Person obj = new Q3_Person();
        obj.greet();
    }
}

// ================= Q4: Calculator interface with add(int a, int b) =================
interface Q4_CalculatorInterface {
    double add(double a, double b);
}

class Q4_Calculate implements Q4_CalculatorInterface {
    public double add(double a, double b) { return a + b; }
}

class Q4_Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter 1st number: ");
        double num1 = scanner.nextDouble();
        System.out.print("Enter 2nd number: ");
        double num2 = scanner.nextDouble();

        Q4_Calculate obj = new Q4_Calculate();
        System.out.println("Sum: " + obj.add(num1, num2));

        scanner.close();
    }
}

// ================= Q5: Multiple classes implementing same interface (Animal) =================
interface Q5_Animal {
    void sound();
}

class Q5_Dog implements Q5_Animal {
    public void sound() { System.out.println("Dog says: Woof!"); }
}

class Q5_Cat implements Q5_Animal {
    public void sound() { System.out.println("Cat says: Meow!"); }
}

class Q5_Cow implements Q5_Animal {
    public void sound() { System.out.println("Cow says: Moo!"); }
}

class Q5_AnimalSound {
    public static void main(String[] args) {
        Q5_Dog d = new Q5_Dog();
        Q5_Cat c = new Q5_Cat();
        Q5_Cow cw = new Q5_Cow();

        d.sound();
        c.sound();
        cw.sound();
    }
}

// ================= Q6: Interface with multiple methods - Shape (area, perimeter) =================
interface Q6_Shape {
    double area();
    double perimeter();
}

class Q6_Rectangle implements Q6_Shape {
    double length, width;

    Q6_Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    public double area() { return length * width; }
    public double perimeter() { return 2 * (length + width); }
}

class Q6_ShapeCalculations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Length: ");
        double length = scanner.nextDouble();
        System.out.print("Enter Width: ");
        double width = scanner.nextDouble();

        Q6_Rectangle obj = new Q6_Rectangle(length, width);
        System.out.println("Area: " + obj.area());
        System.out.println("Perimeter: " + obj.perimeter());

        scanner.close();
    }
}

// ================= Q7: Payment system - Payment interface with pay(amount) =================
interface Q7_Payment {
    void pay(double amount);
}

class Q7_CreditCard implements Q7_Payment {
    public void pay(double amount) {
        System.out.println("Paid " + amount + " using Credit Card");
    }
}

class Q7_Cash implements Q7_Payment {
    public void pay(double amount) {
        System.out.println("Paid " + amount + " using Cash");
    }
}

class Q7_PayPal implements Q7_Payment {
    public void pay(double amount) {
        System.out.println("Paid " + amount + " using PayPal");
    }
}

class Q7_PaymentMethods {
    public static void main(String[] args) {
        Q7_CreditCard cc = new Q7_CreditCard();
        Q7_Cash cash = new Q7_Cash();
        Q7_PayPal pp = new Q7_PayPal();

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Amount: ");
        double creditCardAmt = scanner.nextDouble();
        System.out.print("Enter Amount: ");
        double cashAmt = scanner.nextDouble();
        System.out.print("Enter Amount: ");
        double paypalAmt = scanner.nextDouble();

        cc.pay(creditCardAmt);
        cash.pay(cashAmt);
        pp.pay(paypalAmt);

        scanner.close();
    }
}

// ================= Q8: Payment + Refund - two interfaces, not all classes implement both =================
interface Q8_Payment {
    void pay(double amount);
}

interface Q8_Refund {
    void refund(double amount);
}

class Q8_CreditCard implements Q8_Payment, Q8_Refund {
    public void pay(double amount) {
        System.out.println("Paid " + amount + " using Credit Card");
    }
    public void refund(double amount) {
        System.out.println("Refunded " + amount + " to Credit Card");
    }
}

class Q8_Cash implements Q8_Payment {
    public void pay(double amount) {
        System.out.println("Paid " + amount + " using Cash");
    }
}

class Q8_PayPal implements Q8_Payment, Q8_Refund {
    public void pay(double amount) {
        System.out.println("Paid " + amount + " using PayPal");
    }
    public void refund(double amount) {
        System.out.println("Refunded " + amount + " to PayPal");
    }
}

class Q8_PaymentRefundMethods {
    public static void main(String[] args) {
        Q8_CreditCard cc = new Q8_CreditCard();
        Q8_Cash cash = new Q8_Cash();
        Q8_PayPal pp = new Q8_PayPal();

        cc.pay(1500.34);
        cc.refund(1300.43);

        cash.pay(4000);

        pp.pay(30000);
        pp.refund(23000);
    }
}

// ================= Q9: Vehicle system - Vehicle and Electric interfaces =================
interface Q9_Vehicle {
    void speed();
    void fuel();
}

interface Q9_Electric {
    void batteryLevel();
    void charge();
}

class Q9_Car implements Q9_Vehicle {
    public void speed() { System.out.println("Car is running at 98 km/h"); }
    public void fuel() { System.out.println("Car uses Petrol"); }
}

class Q9_Bicycle implements Q9_Vehicle {
    public void speed() { System.out.println("Bicycle is running at 16 km/h"); }
    public void fuel() { System.out.println("Bicycle uses no fuel"); }
}

class Q9_ElectricCar implements Q9_Vehicle, Q9_Electric {
    public void speed() { System.out.println("Electric Car is running at 76 km/h"); }
    public void fuel() { System.out.println("Electric Car uses no fuel"); }
    public void batteryLevel() { System.out.println("Battery Level: 78%"); }
    public void charge() { System.out.println("Electric Car is charging"); }
}

class Q9_ElectricBike implements Q9_Vehicle, Q9_Electric {
    public void speed() { System.out.println("Electric Bike is running at 78 km/h"); }
    public void fuel() { System.out.println("Electric Bike uses no fuel"); }
    public void batteryLevel() { System.out.println("Battery Level: 47%"); }
    public void charge() { System.out.println("Electric Bike is charging"); }
}

class Q9_VehicleManagementSystem {
    public static void main(String[] args) {
        Q9_Car car = new Q9_Car();
        Q9_Bicycle bicycle = new Q9_Bicycle();
        Q9_ElectricCar ecar = new Q9_ElectricCar();
        Q9_ElectricBike ebike = new Q9_ElectricBike();

        System.out.println("---| Car |---");
        car.speed(); car.fuel();

        System.out.println("---| Bicycle |---");
        bicycle.speed(); bicycle.fuel();

        System.out.println("---| Electric Car |---");
        ecar.speed(); ecar.fuel();
        ecar.batteryLevel(); ecar.charge();

        System.out.println("---| Electric Bike |---");
        ebike.speed(); ebike.fuel();
        ebike.batteryLevel(); ebike.charge();
    }
}

// ================= Q10: Interface extending interface - Shape -> ColoredShape =================
interface Q10_Shape {
    double area();
    double perimeter();
}

interface Q10_ColoredShape extends Q10_Shape {
    String getColor();
}

class Q10_Circle implements Q10_ColoredShape {
    double radius;
    String color;

    Q10_Circle(double radius, String color) {
        this.radius = radius;
        this.color = color;
    }

    public double area() { return 3.14 * radius * radius; }
    public double perimeter() { return 2 * 3.14 * radius; }
    public String getColor() { return color; }
}

class Q10_Rectangle implements Q10_ColoredShape {
    double length, width;
    String color;

    Q10_Rectangle(double length, double width, String color) {
        this.length = length;
        this.width = width;
        this.color = color;
    }

    public double area() { return length * width; }
    public double perimeter() { return 2 * (length + width); }
    public String getColor() { return color; }
}

class Q10_Main {
    public static void main(String[] args) {
        Q10_Circle c = new Q10_Circle(3.543, "Light Green");
        Q10_Rectangle r = new Q10_Rectangle(9.546, 3.436, "Black");

        System.out.println("--- Circle ---");
        System.out.println("Color: " + c.getColor());
        System.out.println("Area: " + c.area());
        System.out.println("Perimeter: " + c.perimeter());

        System.out.println("--- Rectangle ---");
        System.out.println("Color: " + r.getColor());
        System.out.println("Area: " + r.area());
        System.out.println("Perimeter: " + r.perimeter());
    }
}

// ================= Q11: Food delivery system - Orderable, Trackable, Cancelable =================
interface Q11_Orderable {
    void placeOrder(String item, int quantity);
}

interface Q11_Trackable {
    void trackOrder();
}

interface Q11_Cancelable {
    void cancelOrder();
}

class Q11_PizzaOrder implements Q11_Orderable, Q11_Trackable, Q11_Cancelable {
    public void placeOrder(String item, int quantity) {
        System.out.println("Order placed: " + quantity + " x " + item);
    }
    public void trackOrder() { System.out.println("Pizza order is on the way!"); }
    public void cancelOrder() { System.out.println("Pizza order has been cancelled"); }
}

class Q11_GroceryOrder implements Q11_Orderable, Q11_Trackable {
    public void placeOrder(String item, int quantity) {
        System.out.println("Order placed: " + quantity + " x " + item);
    }
    public void trackOrder() { System.out.println("Grocery order is being packed!"); }
}

class Q11_SnackOrder implements Q11_Orderable {
    public void placeOrder(String item, int quantity) {
        System.out.println("Order placed: " + quantity + " x " + item);
    }
}

class Q11_FoodDeliverySystem {
    public static void main(String[] args) {
        Q11_PizzaOrder pizza = new Q11_PizzaOrder();
        Q11_GroceryOrder grocery = new Q11_GroceryOrder();
        Q11_SnackOrder snack = new Q11_SnackOrder();

        System.out.println("---| Pizza Order |---");
        pizza.placeOrder("fajita Pizza", 3);
        pizza.trackOrder();
        pizza.cancelOrder();

        System.out.println("---| Grocery Order |---");
        grocery.placeOrder("Fresh Fish", 2);
        grocery.trackOrder();

        System.out.println("---| Snack Order |---");
        snack.placeOrder("Samosa", 12);
    }
}

// ================= Q12: Banking system - Bank, Account, SavingsAccount, CurrentAccount =================
interface Q12_Account {
    void deposit(double amount);
    void withdraw(double amount);
    void calculateInterest();
    void viewBalance();
}

class Q12_SavingsAccount implements Q12_Account {
    String owner;
    double balance;
    double interestRate = 0.032;

    Q12_SavingsAccount(String owner, double balance) {
        this.owner = owner;
        this.balance = balance;
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println("|Savings| Deposited: " + amount);
    }

    public void withdraw(double amount) {
        if (amount > balance) {
            System.out.println("|Savings| Insufficient balance!");
        } else {
            balance -= amount;
            System.out.println("|Savings| Withdrawn: " + amount);
        }
    }

    public void calculateInterest() {
        double interest = balance * interestRate;
        balance += interest;
        System.out.println("|Savings| Interest Added: " + interest);
    }

    public void viewBalance() {
        System.out.println("|Savings| Owner: " + owner + " | Balance: " + balance);
    }

    public void lockAccount() {
        System.out.println("|Savings| Account locked for " + owner);
    }
}

class Q12_CurrentAccount implements Q12_Account {
    String owner;
    double balance;
    double overdraftLimit = 50000;
    double interestRate = 0.013;

    Q12_CurrentAccount(String owner, double balance) {
        this.owner = owner;
        this.balance = balance;
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println("|Current| Deposited: " + amount);
    }

    public void withdraw(double amount) {
        if (amount > balance + overdraftLimit) {
            System.out.println("|Current| Overdraft limit exceeded!");
        } else {
            balance -= amount;
            System.out.println("|Current| Withdrawn: " + amount);
        }
    }

    public void calculateInterest() {
        double interest = balance * interestRate;
        balance += interest;
        System.out.println("|Current| Interest Added: " + interest);
    }

    public void viewBalance() {
        System.out.println("|Current| Owner: " + owner + " | Balance: " + balance);
    }

    public void businessReport() {
        System.out.println("|Current| Business Report for " + owner + " | Overdraft Limit: " + overdraftLimit);
    }
}

class Q12_Bank {
    String bankName;
    ArrayList<Q12_Account> accounts = new ArrayList<>();

    Q12_Bank(String bankName) {
        this.bankName = bankName;
    }

    void addAccount(Q12_Account account) {
        accounts.add(account);
        System.out.println("Account added to " + bankName);
    }

    void showAllAccounts() {
        System.out.println("\n---| All Accounts in " + bankName + " |---");
        for (Q12_Account acc : accounts) {
            acc.viewBalance();
        }
    }
}

class Q12_BankingSystem {
    public static void main(String[] args) {
        Q12_Bank bank = new Q12_Bank("Meezan Bank");
        Q12_SavingsAccount sa = new Q12_SavingsAccount("Farhan", 2000000);
        Q12_CurrentAccount ca = new Q12_CurrentAccount("Jawad", 1000000);

        bank.addAccount(sa);
        bank.addAccount(ca);

        System.out.println("\n---| Savings Account Operations |---");
        sa.deposit(7000);
        sa.withdraw(4400);
        sa.calculateInterest();
        sa.viewBalance();
        sa.lockAccount();

        System.out.println("\n---| Current Account Operations |---");
        ca.deposit(30000);
        ca.withdraw(45000);
        ca.calculateInterest();
        ca.viewBalance();
        ca.businessReport();

        bank.showAllAccounts();
    }
}

// ================= Q13: Playing cards - Rank and Suit enums =================
class Q13_PlayingCards {

    enum Rank {
        TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN,
        JACK, QUEEN, KING, ACE
    }

    enum Suit {
        HEARTS, DIAMONDS, CLUBS, SPADES
    }

    static class Card {
        Rank rank;
        Suit suit;

        Card(Rank rank, Suit suit) {
            this.rank = rank;
            this.suit = suit;
        }

        public String toString() {
            return rank + " of " + suit;
        }
    }

    public static void main(String[] args) {
        Card card1 = new Card(Rank.ACE, Suit.SPADES);
        Card card2 = new Card(Rank.KING, Suit.HEARTS);
        Card card3 = new Card(Rank.QUEEN, Suit.DIAMONDS);
        Card card4 = new Card(Rank.JACK, Suit.CLUBS);
        Card card5 = new Card(Rank.TEN, Suit.HEARTS);

        System.out.println("Card 1: " + card1);
        System.out.println("Card 2: " + card2);
        System.out.println("Card 3: " + card3);
        System.out.println("Card 4: " + card4);
        System.out.println("Card 5: " + card5);
    }
}
