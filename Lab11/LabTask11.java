/*
 * OOP Lab Task 11
 * Name: Syed Amaan Alam
 * ID: 20251-39878
 * Institute of Business Management (IoBM), Karachi
 * Topic: Exception Handling
 */

import java.util.Scanner;
import java.util.Stack;

// ================= Q1: Calculator with try-catch exception handling =================
class Q1_Main {
    static int add(int a, int b) { return a + b; }
    static int subtract(int a, int b) { return a - b; }
    static int multiply(int a, int b) { return a * b; }

    static double divide(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("Cannot divide by zero!");
        }
        return (double) a / b;
    }

    static double squareRoot(int a) {
        if (a < 0) {
            throw new IllegalArgumentException("Cannot find square root of negative number!");
        }
        return Math.sqrt(a);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("===== Calculator =====");
        System.out.print("Enter first number: ");
        int num1 = sc.nextInt();
        System.out.print("Enter second number: ");
        int num2 = sc.nextInt();

        try {
            System.out.println("Addition: " + add(num1, num2));
            System.out.println("Subtraction: " + subtract(num1, num2));
            System.out.println("Multiplication: " + multiply(num1, num2));
            System.out.println("Division: " + divide(num1, num2));
            System.out.println("Square Root of first number: " + squareRoot(num1));
        } catch (ArithmeticException e) {
            System.out.println("Math Error: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid Input: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Unexpected Error: " + e.getMessage());
        } finally {
            System.out.println("Calculator session ended.");
        }

        sc.close();
    }
}

// ================= Q2: Stack with custom EmptyStackException =================
class Q2_EmptyStackException extends Exception {
    Q2_EmptyStackException(String message) {
        super(message);
    }
}

class Q2_MyStack {
    Stack<Integer> stack = new Stack<>();

    void push(int value) {
        stack.push(value);
        System.out.println("Pushed: " + value);
    }

    void pop() {
        if (stack.isEmpty()) {
            System.out.println("Cannot pop: Stack is empty!");
        } else {
            System.out.println("Popped: " + stack.pop());
        }
    }

    void printStack() throws Q2_EmptyStackException {
        if (stack.isEmpty()) {
            throw new Q2_EmptyStackException("Reading from an Empty Stack");
        }
        System.out.println("Stack elements: " + stack);
    }
}

class Q2_Main {
    public static void main(String[] args) {
        Q2_MyStack myStack = new Q2_MyStack();

        System.out.println("===== Test 1: Print from Empty Stack =====");
        try {
            myStack.printStack();
        } catch (Q2_EmptyStackException e) {
            System.out.println("Exception caught: " + e.getMessage());
        }

        System.out.println("\n===== Test 2: Push Elements =====");
        myStack.push(10);
        myStack.push(20);
        myStack.push(30);
        try {
            myStack.printStack();
        } catch (Q2_EmptyStackException e) {
            System.out.println("Exception caught: " + e.getMessage());
        }

        System.out.println("\n===== Test 3: Pop Elements =====");
        myStack.pop();
        myStack.pop();
        myStack.pop();
        try {
            myStack.printStack();
        } catch (Q2_EmptyStackException e) {
            System.out.println("Exception caught: " + e.getMessage());
        }
    }
}

// ================= Q3: Bank Account with LessBalanceException =================
class Q3_LessBalanceException extends Exception {
    double amount;

    Q3_LessBalanceException(double amount) {
        this.amount = amount;
    }

    public String getMessage() {
        return "Withdraw Amount(" + amount + " Rs) is Not Valid";
    }
}

class Q3_Account {
    String owner;
    double balance;
    static final double MIN_BALANCE = 1000;

    Q3_Account(String owner, double initialDeposit) {
        this.owner = owner;
        this.balance = initialDeposit;
        System.out.println("Account created for " + owner + " with balance: " + balance + " Rs");
    }

    void deposit(double amount) {
        balance += amount;
        System.out.println("[" + owner + "] Deposited: " + amount + " Rs | New Balance: " + balance + " Rs");
    }

    void withdraw(double amount) throws Q3_LessBalanceException {
        if (balance - amount < MIN_BALANCE) {
            throw new Q3_LessBalanceException(amount);
        }
        balance -= amount;
        System.out.println("[" + owner + "] Withdrawn: " + amount + " Rs | Remaining Balance: " + balance + " Rs");
    }

    void viewBalance() {
        System.out.println("[" + owner + "] Current Balance: " + balance + " Rs");
    }
}

class Q3_Main {
    public static void main(String[] args) {
        System.out.println("======= Creating Accounts =======");
        Q3_Account acc1 = new Q3_Account("Ali", 1000);
        Q3_Account acc2 = new Q3_Account("Ahmed", 1000);

        System.out.println("\n======= Depositing Money =======");
        acc1.deposit(5000);
        acc2.deposit(3000);

        System.out.println("\n======= Viewing Balances =======");
        acc1.viewBalance();
        acc2.viewBalance();

        System.out.println("\n======= Withdrawing Money =======");
        try {
            System.out.println("[Ali] Trying to withdraw 4000 Rs...");
            acc1.withdraw(4000);
        } catch (Q3_LessBalanceException e) {
            System.out.println("Exception caught for Ali: " + e.getMessage());
        }

        try {
            System.out.println("[Ahmed] Trying to withdraw 5000 Rs...");
            acc2.withdraw(5000);
        } catch (Q3_LessBalanceException e) {
            System.out.println("Exception caught for Ahmed: " + e.getMessage());
        }

        System.out.println("\n======= Final Balances =======");
        acc1.viewBalance();
        acc2.viewBalance();
    }
}
