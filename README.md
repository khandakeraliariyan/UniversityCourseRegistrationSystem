# University Course Registration System

## 📌 Project Overview

The **University Course Registration System** is a Java-based application that demonstrates the **combined usage of four core object-oriented design patterns**:

- **Factory Pattern** – Creates different course types
- **Template Method Pattern** – Defines the course registration workflow  
- **Decorator Pattern** – Adds fees dynamically
- **Strategy Pattern** – Supports multiple payment methods

The system simulates how students register for different types of university courses, with flexible fee calculations and multiple payment options.

This project is developed as part of a **Software Engineering / Object-Oriented Design** academic assignment.

---

## 🎯 Problem Statement

In a university environment:

- Different **course types** (Theory, Lab, Online) exist with different base fees
- **Additional fees** (lab fee, exam fee, late registration fee) can be applied dynamically  
- Students need **multiple payment methods** available
- The registration process follows a **fixed workflow** regardless of course type

A flexible and maintainable design is required to handle these variations efficiently without modifying existing code.

---

## 🧩 Design Patterns Used

### 1️⃣ Factory Pattern
**Purpose:** Creates different course objects without exposing object creation logic.

**Implementation:**  
- `CourseFactory.createCourse(String type)` creates instances of:
  - `TheoryCourse`
  - `LabCourse`
  - `OnlineCourse`

**File:** [factory/CourseFactory.java](factory/CourseFactory.java)

---

### 2️⃣ Template Method Pattern
**Purpose:** Defines the skeleton of the course registration process, allowing subclasses to override specific steps.

**Template Workflow:**  
1. `selectCourse()` – Selects the course type
2. `calculateFee()` – Computes the total fee (with decorators)
3. `processPayment()` – Executes payment using the strategy
4. `confirmRegistration()` – Displays confirmation message

**Key Insight:** The registration sequence is fixed, but each course implements its own `selectCourse()` and `calculateFee()` methods.

**File:** [registration/CourseRegistration.java](registration/CourseRegistration.java)

---

### 3️⃣ Decorator Pattern
**Purpose:** Adds additional fees dynamically at runtime without modifying course classes.

**Decorators Implemented:**
- `LabFeeDecorator` – Adds lab fee to base course fee
- `ExamFeeDecorator` – Adds exam fee
- `LateFeeDecorator` – Adds late registration penalty

**Usage:** Decorators can be stacked to combine multiple fees:
```java
Fee fee = new LabFeeDecorator(new ExamFeeDecorator(new BaseFee()));
```

**Files:** [fee/](fee/) directory

---

### 4️⃣ Strategy Pattern
**Purpose:** Allows changing the payment method dynamically at runtime.

**Payment Methods Implemented:**
- `CreditCardPayment`
- `DebitCardPayment`
- `BkashPayment` (Mobile Banking)
- `NagadPayment` (Mobile Banking)
- `PayPalPayment` (Digital Wallet)

**Usage:**
```java
course.setPaymentStrategy(new BkashPayment());
```

**Files:** [payment/](payment/) directory

---

## 🗂️ Project Structure

```
UniversityCourseRegistrationSystem/
│
├── factory/
│   └── CourseFactory.java              # Factory Pattern
│
├── registration/                        # Template Method Pattern
│   ├── CourseRegistration.java          # Abstract base class
│   ├── TheoryCourse.java                # Theory course implementation
│   ├── LabCourse.java                   # Lab course implementation
│   └── OnlineCourse.java                # Online course implementation
│
├── fee/                                 # Decorator Pattern
│   ├── Fee.java                         # Fee interface
│   ├── BaseFee.java                     # Base implementation
│   ├── FeeDecorator.java                # Abstract decorator
│   ├── LabFeeDecorator.java             # Lab fee decorator
│   ├── ExamFeeDecorator.java            # Exam fee decorator
│   └── LateFeeDecorator.java            # Late fee decorator
│
├── payment/                             # Strategy Pattern
│   ├── PaymentStrategy.java             # Strategy interface
│   ├── CreditCardPayment.java           # Credit card strategy
│   ├── DebitCardPayment.java            # Debit card strategy
│   ├── BkashPayment.java                # Bkash strategy
│   ├── NagadPayment.java                # Nagad strategy
│   └── PayPalPayment.java               # PayPal strategy
│
├── Main.java                            # Entry point
└── README.md                            # This file
```

---

## ⚙️ How the System Works

1. **Client** requests a course from `CourseFactory.createCourse(String type)`
2. **Factory** returns the appropriate course object (Theory/Lab/Online)
3. **Client** sets the desired payment strategy via `course.setPaymentStrategy(...)`
4. **Client** calls `course.registerCourse()` to start registration
5. **Template Method** executes the registration workflow:
   - Selects the course
   - Calculates fees (base fee + applied decorators)
   - Processes payment using the chosen strategy
   - Displays confirmation message

---

## ▶️ How to Run the Project

### Requirements
- Java JDK 8 or later
- Any Java IDE (IntelliJ IDEA, Eclipse, NetBeans) or command line

### Steps
1. Clone or download the repository
2. Open the project in your IDE
3. Compile all Java files
4. Run `Main.java`

### Example Usage
```java
// Create a lab course
CourseRegistration course = CourseFactory.createCourse("lab");

// Set payment method
course.setPaymentStrategy(new BkashPayment());

// Register the course
course.registerCourse();
```

---

## 📚 Learning Outcomes

This project demonstrates:
- ✅ How design patterns solve real-world problems
- ✅ Loose coupling between components
- ✅ Open/Closed Principle (open for extension, closed for modification)
- ✅ Single Responsibility Principle
- ✅ Flexibility in runtime behavior changes

