# 🏧 Object-Oriented Programming (OOP) Concepts — ATM Project Guide

> A practical, beginner-friendly guide to understanding **OOP concepts** using a real-world **ATM system** as the example throughout.

---

## 📚 Table of Contents

1. [Classes & Objects](#1-classes--objects)
2. [Encapsulation](#2-encapsulation)
3. [Inheritance](#3-inheritance)
4. [Polymorphism](#4-polymorphism)
5. [Abstraction](#5-abstraction)
6. [Composition](#6-composition)
7. [Interfaces](#7-interfaces)
8. [Complete ATM Example](#complete-atm-example-combining-all-concepts)

---

## 1. Classes & Objects

### 📖 What is it?
A **Class** is a blueprint or template for creating objects. An **Object** is a real instance created from that blueprint.

Think of a Class as the design blueprint of an ATM machine, and each physical ATM installed at a bank is an Object.

### 💡 Why use it?
- Define a structure **once**, create **many instances**
- Each object has its own data (state) and behavior (methods)

### 🏧 ATM Example

```java
// Class: Blueprint for an ATM
public class ATM {
    // Fields (state / attributes)
    private String atmId;
    private String location;
    private double cashAvailable;

    // Constructor: called when creating a new ATM object
    public ATM(String atmId, String location, double cashAvailable) {
        this.atmId = atmId;
        this.location = location;
        this.cashAvailable = cashAvailable;
    }

    // Method (behavior)
    public void displayInfo() {
        System.out.println("ATM ID: " + atmId);
        System.out.println("Location: " + location);
        System.out.println("Cash Available: ₹" + cashAvailable);
    }
}

// Main class to create objects
public class Main {
    public static void main(String[] args) {
        // Object 1: Instance of ATM class
        ATM atm1 = new ATM("ATM001", "Downtown Branch", 500000);

        // Object 2: Another instance of the same ATM class
        ATM atm2 = new ATM("ATM002", "Airport Terminal", 200000);

        atm1.displayInfo();
        System.out.println("---");
        atm2.displayInfo();
    }
}
```

**Expected Output:**
```
ATM ID: ATM001
Location: Downtown Branch
Cash Available: ₹500000.0
---
ATM ID: ATM002
Location: Airport Terminal
Cash Available: ₹200000.0
```

> ✅ **Key Takeaway:** One class `ATM`, two different objects (`atm1`, `atm2`) — each with their own data.

---

## 2. Encapsulation

### 📖 What is it?
**Encapsulation** is the concept of **wrapping data (fields) and methods together** inside a class, and **restricting direct access** to the data using access modifiers (`private`, `public`, `protected`).

Access to the data is provided through **getter** and **setter** methods.

### 💡 Why use it?
- Protects sensitive data (e.g., account balance)
- Controls how data is read or modified
- Prevents accidental or malicious data corruption

### 🏧 ATM Example

```java
public class BankAccount {
    // Private fields — hidden from outside world
    private String accountNumber;
    private String accountHolder;
    private double balance;
    private String pin;

    // Constructor
    public BankAccount(String accountNumber, String accountHolder,
                       double initialBalance, String pin) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = initialBalance;
        this.pin = pin;
    }

    // Getter — controlled read access to balance
    public double getBalance() {
        return balance;
    }

    // Getter — read account holder name
    public String getAccountHolder() {
        return accountHolder;
    }

    // Getter — read masked account number
    public String getMaskedAccountNumber() {
        return "XXXX-XXXX-" + accountNumber.substring(accountNumber.length() - 4);
    }

    // No direct setter for balance — use controlled methods instead
    public boolean withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid amount.");
            return false;
        }
        if (amount > balance) {
            System.out.println("Insufficient balance!");
            return false;
        }
        balance -= amount;
        System.out.println("Withdrawn: ₹" + amount + " | New Balance: ₹" + balance);
        return true;
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid deposit amount.");
            return;
        }
        balance += amount;
        System.out.println("Deposited: ₹" + amount + " | New Balance: ₹" + balance);
    }

    // PIN validation — PIN itself is never exposed
    public boolean validatePin(String enteredPin) {
        return this.pin.equals(enteredPin);
    }
}

// Usage
public class Main {
    public static void main(String[] args) {
        BankAccount account = new BankAccount("1234567890", "Alice", 10000.0, "1234");

        // account.balance = 99999; // ❌ ERROR: balance is private!

        System.out.println("Account: " + account.getMaskedAccountNumber());
        System.out.println("Balance: ₹" + account.getBalance());

        account.withdraw(2000);
        account.withdraw(20000); // Insufficient balance
    }
}
```

**Expected Output:**
```
Account: XXXX-XXXX-7890
Balance: ₹10000.0
Withdrawn: ₹2000.0 | New Balance: ₹8000.0
Insufficient balance!
```

> ✅ **Key Takeaway:** The `balance` field is private. No one can directly change it. All access goes through controlled methods like `withdraw()` and `deposit()`.

---

## 3. Inheritance

### 📖 What is it?
**Inheritance** allows a class (child/subclass) to **acquire the properties and methods** of another class (parent/superclass) using the `extends` keyword.

It models an **"is-a" relationship** — e.g., a `Withdrawal` **is-a** `Transaction`.

### 💡 Why use it?
- Reuse common code across related classes
- Build a clean class hierarchy
- Reduce code duplication

### 🏧 ATM Example

```java
import java.time.LocalDateTime;

// Parent class — common properties for all transactions
public class Transaction {
    protected String transactionId;
    protected double amount;
    protected LocalDateTime timestamp;
    protected String status;

    public Transaction(String transactionId, double amount) {
        this.transactionId = transactionId;
        this.amount = amount;
        this.timestamp = LocalDateTime.now();
        this.status = "INITIATED";
    }

    public void displayTransactionInfo() {
        System.out.println("Transaction ID : " + transactionId);
        System.out.println("Amount         : ₹" + amount);
        System.out.println("Time           : " + timestamp);
        System.out.println("Status         : " + status);
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

// Child class — Withdrawal inherits from Transaction
public class Withdrawal extends Transaction {
    private String withdrawalType; // ATM or Counter

    public Withdrawal(String transactionId, double amount, String withdrawalType) {
        super(transactionId, amount); // Call parent constructor
        this.withdrawalType = withdrawalType;
    }

    @Override
    public void displayTransactionInfo() {
        super.displayTransactionInfo(); // Reuse parent method
        System.out.println("Type           : Withdrawal (" + withdrawalType + ")");
    }
}

// Child class — Deposit inherits from Transaction
public class Deposit extends Transaction {
    private String depositSource; // Cash or Cheque

    public Deposit(String transactionId, double amount, String depositSource) {
        super(transactionId, amount);
        this.depositSource = depositSource;
    }

    @Override
    public void displayTransactionInfo() {
        super.displayTransactionInfo();
        System.out.println("Type           : Deposit (Source: " + depositSource + ")");
    }
}

// Usage
public class Main {
    public static void main(String[] args) {
        Withdrawal w = new Withdrawal("TXN001", 5000, "ATM");
        w.setStatus("SUCCESS");
        w.displayTransactionInfo();

        System.out.println("---");

        Deposit d = new Deposit("TXN002", 15000, "Cash");
        d.setStatus("SUCCESS");
        d.displayTransactionInfo();
    }
}
```

**Expected Output:**
```
Transaction ID : TXN001
Amount         : ₹5000.0
Time           : 2024-01-15T10:30:45
Status         : SUCCESS
Type           : Withdrawal (ATM)
---
Transaction ID : TXN002
Amount         : ₹15000.0
Time           : 2024-01-15T10:30:45
Status         : SUCCESS
Type           : Deposit (Source: Cash)
```

> ✅ **Key Takeaway:** `Withdrawal` and `Deposit` both inherit `transactionId`, `amount`, `timestamp`, and `displayTransactionInfo()` from `Transaction`. No code duplication!

---

## 4. Polymorphism

### 📖 What is it?
**Polymorphism** means **"many forms"**. The same method name behaves **differently** depending on the object it is called on.

There are two types:
- **Compile-time (Method Overloading):** Same method name, different parameters
- **Runtime (Method Overriding):** Child class overrides parent method

### 💡 Why use it?
- Write flexible, generic code
- Process different object types with the same method
- Simplify code and improve maintainability

### 🏧 ATM Example

```java
// ---- RUNTIME POLYMORPHISM (Method Overriding) ----

public class Transaction {
    public void process() {
        System.out.println("Processing generic transaction...");
    }
}

public class CashWithdrawal extends Transaction {
    @Override
    public void process() {
        System.out.println("Processing Cash Withdrawal: Verifying balance → Dispensing cash...");
    }
}

public class FundTransfer extends Transaction {
    @Override
    public void process() {
        System.out.println("Processing Fund Transfer: Verifying accounts → Transferring funds...");
    }
}

public class MiniStatement extends Transaction {
    @Override
    public void process() {
        System.out.println("Processing Mini Statement: Fetching last 5 transactions...");
    }
}

// ATMProcessor uses polymorphism — doesn't care about specific type
public class ATMProcessor {
    public void executeTransaction(Transaction transaction) {
        transaction.process(); // Calls the overridden method of actual object
    }
}

// ---- COMPILE-TIME POLYMORPHISM (Method Overloading) ----

public class Receipt {
    // Overloaded method — prints receipt in different formats
    public void print(String transactionId) {
        System.out.println("Receipt for Transaction: " + transactionId);
    }

    public void print(String transactionId, double amount) {
        System.out.println("Receipt | TX: " + transactionId + " | Amount: ₹" + amount);
    }

    public void print(String transactionId, double amount, String accountHolder) {
        System.out.println("Receipt | TX: " + transactionId +
                           " | Amount: ₹" + amount +
                           " | Account: " + accountHolder);
    }
}

// Usage
public class Main {
    public static void main(String[] args) {
        ATMProcessor processor = new ATMProcessor();

        // Polymorphism: same method call, different behavior
        Transaction t1 = new CashWithdrawal();
        Transaction t2 = new FundTransfer();
        Transaction t3 = new MiniStatement();

        processor.executeTransaction(t1);
        processor.executeTransaction(t2);
        processor.executeTransaction(t3);

        System.out.println("---");

        // Method Overloading
        Receipt receipt = new Receipt();
        receipt.print("TXN001");
        receipt.print("TXN002", 3000.0);
        receipt.print("TXN003", 5000.0, "Alice");
    }
}
```

**Expected Output:**
```
Processing Cash Withdrawal: Verifying balance → Dispensing cash...
Processing Fund Transfer: Verifying accounts → Transferring funds...
Processing Mini Statement: Fetching last 5 transactions...
---
Receipt for Transaction: TXN001
Receipt | TX: TXN002 | Amount: ₹3000.0
Receipt | TX: TXN003 | Amount: ₹5000.0 | Account: Alice
```

> ✅ **Key Takeaway:** `executeTransaction()` accepts any `Transaction` type. It automatically calls the correct `process()` based on the actual object — that's runtime polymorphism in action!

---

## 5. Abstraction

### 📖 What is it?
**Abstraction** hides the complex internal implementation and **shows only the essential features** to the user.

Achieved through:
- **Abstract Classes** (`abstract` keyword) — can have both abstract and concrete methods
- **Interfaces** — only method signatures (covered in section 7)

### 💡 Why use it?
- Reduces complexity for the end-user
- Forces subclasses to implement required methods
- Defines a clear contract for related classes

### 🏧 ATM Example

```java
// Abstract class — defines the template for all ATM operations
public abstract class ATMOperation {
    protected String operationName;

    public ATMOperation(String operationName) {
        this.operationName = operationName;
    }

    // Abstract methods — MUST be implemented by subclasses
    protected abstract boolean authenticate(String pin);
    protected abstract void execute();
    protected abstract void logOperation();

    // Concrete method — same for all operations (Template Method Pattern)
    public final void performOperation(String pin) {
        System.out.println("\n=== Starting: " + operationName + " ===");
        if (authenticate(pin)) {
            execute();
            logOperation();
        } else {
            System.out.println("❌ Authentication failed. Operation aborted.");
        }
        System.out.println("=== End: " + operationName + " ===");
    }
}

// Concrete class 1 — implements ATMOperation
public class CashWithdrawal extends ATMOperation {
    private double amount;
    private String correctPin;

    public CashWithdrawal(double amount, String correctPin) {
        super("Cash Withdrawal");
        this.amount = amount;
        this.correctPin = correctPin;
    }

    @Override
    protected boolean authenticate(String pin) {
        System.out.println("🔐 Verifying PIN...");
        return correctPin.equals(pin);
    }

    @Override
    protected void execute() {
        System.out.println("💵 Dispensing ₹" + amount + " in cash...");
    }

    @Override
    protected void logOperation() {
        System.out.println("📋 Withdrawal of ₹" + amount + " logged successfully.");
    }
}

// Concrete class 2 — implements ATMOperation
public class BalanceEnquiry extends ATMOperation {
    private double balance;
    private String correctPin;

    public BalanceEnquiry(double balance, String correctPin) {
        super("Balance Enquiry");
        this.balance = balance;
        this.correctPin = correctPin;
    }

    @Override
    protected boolean authenticate(String pin) {
        System.out.println("🔐 Verifying PIN...");
        return correctPin.equals(pin);
    }

    @Override
    protected void execute() {
        System.out.println("💰 Your current balance is: ₹" + balance);
    }

    @Override
    protected void logOperation() {
        System.out.println("📋 Balance enquiry logged.");
    }
}

// Usage
public class Main {
    public static void main(String[] args) {
        ATMOperation withdrawal = new CashWithdrawal(3000, "1234");
        ATMOperation enquiry = new BalanceEnquiry(25000, "1234");

        withdrawal.performOperation("1234");  // Correct PIN
        enquiry.performOperation("0000");     // Wrong PIN
    }
}
```

**Expected Output:**
```
=== Starting: Cash Withdrawal ===
🔐 Verifying PIN...
💵 Dispensing ₹3000.0 in cash...
📋 Withdrawal of ₹3000.0 logged successfully.
=== End: Cash Withdrawal ===

=== Starting: Balance Enquiry ===
🔐 Verifying PIN...
❌ Authentication failed. Operation aborted.
=== End: Balance Enquiry ===
```

> ✅ **Key Takeaway:** The user just calls `performOperation()` — they don't need to know how PIN authentication or cash dispensing works internally. The abstract class enforces the structure.

---

## 6. Composition

### 📖 What is it?
**Composition** is a design principle representing a **"has-a" relationship** — an object is composed of (contains) other objects.

It's preferred over inheritance when the relationship is not truly "is-a".

### 💡 Why use it?
- Builds complex systems from smaller, reusable components
- Makes code more modular and maintainable
- Each component can be changed independently

### 🏧 ATM Example

```java
// Component 1: Card Reader
public class CardReader {
    public boolean readCard(String cardNumber) {
        System.out.println("📇 Reading card: XXXX-XXXX-XXXX-" +
                           cardNumber.substring(cardNumber.length() - 4));
        return true;
    }

    public void ejectCard() {
        System.out.println("📇 Card ejected. Please collect your card.");
    }
}

// Component 2: PIN Pad
public class PinPad {
    public boolean verifyPin(String enteredPin, String correctPin) {
        System.out.println("🔢 PIN entered. Verifying...");
        return enteredPin.equals(correctPin);
    }
}

// Component 3: Cash Dispenser
public class CashDispenser {
    private double cashAvailable;

    public CashDispenser(double cashAvailable) {
        this.cashAvailable = cashAvailable;
    }

    public boolean dispenseCash(double amount) {
        if (amount > cashAvailable) {
            System.out.println("🚫 ATM has insufficient cash.");
            return false;
        }
        cashAvailable -= amount;
        System.out.println("💵 Dispensed ₹" + amount + ". Remaining in ATM: ₹" + cashAvailable);
        return true;
    }
}

// Component 4: Receipt Printer
public class ReceiptPrinter {
    public void printReceipt(String transactionId, double amount, String type) {
        System.out.println("🧾 ---- RECEIPT ----");
        System.out.println("   Transaction : " + transactionId);
        System.out.println("   Type        : " + type);
        System.out.println("   Amount      : ₹" + amount);
        System.out.println("   -------------------");
    }
}

// ATMSystem HAS-A CardReader, PinPad, CashDispenser, and ReceiptPrinter
public class ATMSystem {
    private CardReader cardReader;       // ATM "has-a" CardReader
    private PinPad pinPad;               // ATM "has-a" PinPad
    private CashDispenser cashDispenser; // ATM "has-a" CashDispenser
    private ReceiptPrinter printer;      // ATM "has-a" ReceiptPrinter
    private String atmId;

    public ATMSystem(String atmId, double initialCash) {
        this.atmId = atmId;
        this.cardReader = new CardReader();
        this.pinPad = new PinPad();
        this.cashDispenser = new CashDispenser(initialCash);
        this.printer = new ReceiptPrinter();
    }

    public void withdraw(String cardNumber, String enteredPin,
                         String correctPin, double amount) {
        System.out.println("\n[ATM: " + atmId + "] Withdrawal Session Started");

        if (!cardReader.readCard(cardNumber)) return;

        if (!pinPad.verifyPin(enteredPin, correctPin)) {
            System.out.println("❌ Incorrect PIN. Transaction cancelled.");
            cardReader.ejectCard();
            return;
        }

        System.out.println("✅ PIN verified.");
        if (cashDispenser.dispenseCash(amount)) {
            printer.printReceipt("TXN" + System.currentTimeMillis(), amount, "Withdrawal");
        }
        cardReader.ejectCard();
    }
}

// Usage
public class Main {
    public static void main(String[] args) {
        ATMSystem atm = new ATMSystem("ATM001", 100000);
        atm.withdraw("1234567890123456", "1234", "1234", 5000);
    }
}
```

**Expected Output:**
```
[ATM: ATM001] Withdrawal Session Started
📇 Reading card: XXXX-XXXX-XXXX-3456
🔢 PIN entered. Verifying...
✅ PIN verified.
💵 Dispensed ₹5000.0. Remaining in ATM: ₹95000.0
🧾 ---- RECEIPT ----
   Transaction : TXN1705123456789
   Type        : Withdrawal
   Amount      : ₹5000.0
   -------------------
📇 Card ejected. Please collect your card.
```

> ✅ **Key Takeaway:** `ATMSystem` is composed of 4 separate components. Each component handles its own responsibility. You can replace `CashDispenser` without touching `CardReader` — that's the power of composition!

---

## 7. Interfaces

### 📖 What is it?
An **Interface** is a **contract** that defines a set of method signatures that a class must implement. It represents a **"can-do" relationship**.

A class can implement **multiple interfaces** (unlike inheritance which is single).

### 💡 Why use it?
- Enforces consistency across unrelated classes
- Enables multiple "behaviors" for a class
- Supports loose coupling (depend on interface, not implementation)

### 🏧 ATM Example

```java
// Interface 1: Defines what any ATM transaction must do
public interface Processable {
    boolean validate();
    void process();
    void generateReceipt();
}

// Interface 2: Defines notifiable behavior
public interface Notifiable {
    void sendSMSAlert(String phoneNumber, String message);
    void sendEmailAlert(String email, String message);
}

// Interface 3: Defines reversible transactions
public interface Reversible {
    boolean reverse(String transactionId);
}

// Class implementing Processable and Notifiable
public class CashWithdrawal implements Processable, Notifiable {
    private double amount;
    private double balance;

    public CashWithdrawal(double amount, double balance) {
        this.amount = amount;
        this.balance = balance;
    }

    @Override
    public boolean validate() {
        System.out.println("✔ Validating: Checking balance for ₹" + amount + " withdrawal...");
        return amount > 0 && amount <= balance;
    }

    @Override
    public void process() {
        balance -= amount;
        System.out.println("✔ Processing: ₹" + amount + " dispensed. Remaining balance: ₹" + balance);
    }

    @Override
    public void generateReceipt() {
        System.out.println("✔ Receipt: Cash Withdrawal of ₹" + amount + " completed.");
    }

    @Override
    public void sendSMSAlert(String phoneNumber, String message) {
        System.out.println("📱 SMS to " + phoneNumber + ": " + message);
    }

    @Override
    public void sendEmailAlert(String email, String message) {
        System.out.println("📧 Email to " + email + ": " + message);
    }
}

// Class implementing Processable, Notifiable, and Reversible
public class FundTransfer implements Processable, Notifiable, Reversible {
    private double amount;
    private String toAccount;

    public FundTransfer(double amount, String toAccount) {
        this.amount = amount;
        this.toAccount = toAccount;
    }

    @Override
    public boolean validate() {
        System.out.println("✔ Validating: Transfer of ₹" + amount + " to " + toAccount);
        return amount > 0;
    }

    @Override
    public void process() {
        System.out.println("✔ Processing: ₹" + amount + " transferred to " + toAccount);
    }

    @Override
    public void generateReceipt() {
        System.out.println("✔ Receipt: Fund Transfer of ₹" + amount + " to " + toAccount + " done.");
    }

    @Override
    public void sendSMSAlert(String phoneNumber, String message) {
        System.out.println("📱 SMS to " + phoneNumber + ": " + message);
    }

    @Override
    public void sendEmailAlert(String email, String message) {
        System.out.println("📧 Email to " + email + ": " + message);
    }

    @Override
    public boolean reverse(String transactionId) {
        System.out.println("↩ Reversing transaction: " + transactionId);
        System.out.println("✔ ₹" + amount + " refunded from " + toAccount);
        return true;
    }
}

// Usage
public class Main {
    public static void main(String[] args) {
        CashWithdrawal withdrawal = new CashWithdrawal(5000, 20000);
        System.out.println("=== CASH WITHDRAWAL ===");
        if (withdrawal.validate()) {
            withdrawal.process();
            withdrawal.generateReceipt();
            withdrawal.sendSMSAlert("+91-9876543210", "₹5000 withdrawn from your account.");
        }

        System.out.println("\n=== FUND TRANSFER ===");
        FundTransfer transfer = new FundTransfer(10000, "ACC-9876");
        if (transfer.validate()) {
            transfer.process();
            transfer.generateReceipt();
            transfer.sendSMSAlert("+91-9876543210", "₹10000 transferred to ACC-9876.");
            transfer.reverse("TXN001"); // Can be reversed!
        }
    }
}
```

**Expected Output:**
```
=== CASH WITHDRAWAL ===
✔ Validating: Checking balance for ₹5000.0 withdrawal...
✔ Processing: ₹5000.0 dispensed. Remaining balance: ₹15000.0
✔ Receipt: Cash Withdrawal of ₹5000.0 completed.
📱 SMS to +91-9876543210: ₹5000 withdrawn from your account.

=== FUND TRANSFER ===
✔ Validating: Transfer of ₹10000.0 to ACC-9876
✔ Processing: ₹10000.0 transferred to ACC-9876
✔ Receipt: Fund Transfer of ₹10000.0 to ACC-9876 done.
📱 SMS to +91-9876543210: ₹10000 transferred to ACC-9876.
↩ Reversing transaction: TXN001
✔ ₹10000.0 refunded from ACC-9876
```

> ✅ **Key Takeaway:** `FundTransfer` implements 3 interfaces — it's `Processable`, `Notifiable`, AND `Reversible`. A class can have multiple "abilities" through interfaces!

---

## Complete ATM Example Combining All Concepts

This final example brings together **all 7 OOP concepts** into one cohesive ATM system.

```java
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

// ═══════════════════════════════════════════════
// INTERFACE (Concept 7) — Contract for transactions
// ═══════════════════════════════════════════════
interface Processable {
    boolean validate();
    void process();
    void generateReceipt();
}

// ═══════════════════════════════════════════════
// ABSTRACT CLASS (Concept 5 — Abstraction)
// Base template for all transactions
// ═══════════════════════════════════════════════
abstract class Transaction implements Processable {
    protected String transactionId;
    protected double amount;
    protected LocalDateTime timestamp;
    protected String status;

    public Transaction(String transactionId, double amount) {
        this.transactionId = transactionId;
        this.amount = amount;
        this.timestamp = LocalDateTime.now();
        this.status = "PENDING";
    }

    // Template method — defines the flow
    public final void execute() {
        if (validate()) {
            process();
            status = "SUCCESS";
            generateReceipt();
        } else {
            status = "FAILED";
            System.out.println("❌ Transaction " + transactionId + " failed validation.");
        }
    }

    public String getStatus() { return status; }
    public String getTransactionId() { return transactionId; }
}

// ═══════════════════════════════════════════════
// ENCAPSULATION (Concept 2) — BankAccount with private data
// ═══════════════════════════════════════════════
class BankAccount {
    private String accountNumber;  // Private — hidden
    private String accountHolder;
    private double balance;        // Private — protected
    private String pin;
    private List<String> transactionHistory;

    public BankAccount(String accountNumber, String accountHolder,
                       double balance, String pin) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
        this.pin = pin;
        this.transactionHistory = new ArrayList<>();
    }

    public double getBalance() { return balance; }
    public String getAccountHolder() { return accountHolder; }
    public String getAccountNumber() { return accountNumber; }

    public boolean validatePin(String enteredPin) {
        return this.pin.equals(enteredPin);
    }

    public boolean deduct(double amount) {
        if (amount > balance) return false;
        balance -= amount;
        transactionHistory.add("Deducted: ₹" + amount);
        return true;
    }

    public void credit(double amount) {
        balance += amount;
        transactionHistory.add("Credited: ₹" + amount);
    }

    public void printHistory() {
        System.out.println("📜 Transaction History for " + accountHolder + ":");
        for (String record : transactionHistory) {
            System.out.println("   → " + record);
        }
    }
}

// ═══════════════════════════════════════════════
// INHERITANCE (Concept 3) + POLYMORPHISM (Concept 4)
// CashWithdrawal extends Transaction
// ═══════════════════════════════════════════════
class CashWithdrawal extends Transaction {
    private BankAccount account;

    public CashWithdrawal(String txnId, BankAccount account, double amount) {
        super(txnId, amount);
        this.account = account;
    }

    @Override
    public boolean validate() {
        System.out.println("✔ Validating withdrawal of ₹" + amount + "...");
        return amount > 0 && account.getBalance() >= amount;
    }

    @Override
    public void process() {
        account.deduct(amount);
        System.out.println("💵 Dispensed ₹" + amount + " to " + account.getAccountHolder());
    }

    @Override
    public void generateReceipt() {
        System.out.println("🧾 Receipt: Withdrawal ₹" + amount +
                           " | Balance: ₹" + account.getBalance());
    }
}

// Deposit extends Transaction
class Deposit extends Transaction {
    private BankAccount account;

    public Deposit(String txnId, BankAccount account, double amount) {
        super(txnId, amount);
        this.account = account;
    }

    @Override
    public boolean validate() {
        System.out.println("✔ Validating deposit of ₹" + amount + "...");
        return amount > 0;
    }

    @Override
    public void process() {
        account.credit(amount);
        System.out.println("🏦 Deposited ₹" + amount + " for " + account.getAccountHolder());
    }

    @Override
    public void generateReceipt() {
        System.out.println("🧾 Receipt: Deposit ₹" + amount +
                           " | Balance: ₹" + account.getBalance());
    }
}

// ═══════════════════════════════════════════════
// COMPOSITION (Concept 6) — ATM "has-a" components
// CLASSES & OBJECTS (Concept 1) — ATM class/object
// ═══════════════════════════════════════════════
class ATMSystem {
    // ATM HAS-A CardReader, CashDispenser, Printer
    private String atmId;
    private String location;
    private double cashInMachine;

    // Constructor — creates ATM object
    public ATMSystem(String atmId, String location, double cashInMachine) {
        this.atmId = atmId;
        this.location = location;
        this.cashInMachine = cashInMachine;
        System.out.println("🏧 ATM [" + atmId + "] initialized at " + location);
    }

    // Polymorphism — accepts any Transaction type
    public void processTransaction(Transaction transaction) {
        System.out.println("\n--- Processing at ATM: " + atmId + " ---");
        transaction.execute();
        System.out.println("Status: " + transaction.getStatus());
    }

    public boolean hasSufficientCash(double amount) {
        return cashInMachine >= amount;
    }
}

// ═══════════════════════════════════════════════
// MAIN CLASS — Putting it all together
// ═══════════════════════════════════════════════
public class ATMDemo {
    public static void main(String[] args) {
        // 1. Create ATM Object (Classes & Objects)
        ATMSystem atm = new ATMSystem("ATM001", "City Center", 500000);

        // 2. Create BankAccount (Encapsulation)
        BankAccount aliceAccount = new BankAccount("ACC001", "Alice", 25000, "1234");

        System.out.println("\nInitial Balance: ₹" + aliceAccount.getBalance());

        // 3. Create Transactions (Inheritance, Abstraction)
        Transaction withdrawal = new CashWithdrawal("TXN001", aliceAccount, 5000);
        Transaction deposit    = new Deposit("TXN002", aliceAccount, 10000);
        Transaction bigWithdrawal = new CashWithdrawal("TXN003", aliceAccount, 100000); // Should fail

        // 4. Process Transactions (Polymorphism — same method, different objects)
        atm.processTransaction(withdrawal);
        atm.processTransaction(deposit);
        atm.processTransaction(bigWithdrawal);

        // 5. Print History (Encapsulation — controlled access)
        System.out.println("\nFinal Balance: ₹" + aliceAccount.getBalance());
        aliceAccount.printHistory();
    }
}
```

**Expected Output:**
```
🏧 ATM [ATM001] initialized at City Center

Initial Balance: ₹25000.0

--- Processing at ATM: ATM001 ---
✔ Validating withdrawal of ₹5000.0...
💵 Dispensed ₹5000.0 to Alice
🧾 Receipt: Withdrawal ₹5000.0 | Balance: ₹20000.0
Status: SUCCESS

--- Processing at ATM: ATM001 ---
✔ Validating deposit of ₹10000.0...
🏦 Deposited ₹10000.0 for Alice
🧾 Receipt: Deposit ₹10000.0 | Balance: ₹30000.0
Status: SUCCESS

--- Processing at ATM: ATM001 ---
✔ Validating withdrawal of ₹100000.0...
❌ Transaction TXN003 failed validation.
Status: FAILED

Final Balance: ₹30000.0
📜 Transaction History for Alice:
   → Deducted: ₹5000.0
   → Credited: ₹10000.0
```

---

## 🗂️ OOP Concepts Quick Reference

| Concept | Keyword | Relationship | Purpose |
|---|---|---|---|
| **Class & Object** | `class`, `new` | Blueprint → Instance | Define structure and create instances |
| **Encapsulation** | `private`, `public` | Data + Methods together | Hide data, control access |
| **Inheritance** | `extends` | Is-a | Reuse code in child classes |
| **Polymorphism** | `@Override` | Many forms | Same method, different behavior |
| **Abstraction** | `abstract` | Template | Hide complexity, show essentials |
| **Composition** | Has-a | Object contains objects | Build from components |
| **Interface** | `interface`, `implements` | Can-do | Define contracts |

---

## 📌 Key Principles to Remember

- **Encapsulation** → *"What data do I protect?"*
- **Inheritance** → *"What do I share with child classes?"*
- **Polymorphism** → *"How do different objects behave for the same call?"*
- **Abstraction** → *"What do I hide from the user?"*
- **Composition** → *"What components make up this object?"*
- **Interfaces** → *"What contract must this class follow?"*

---

*Made with ❤️ for learning OOP through practical ATM examples.*
