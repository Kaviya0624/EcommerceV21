# 🛒 EcommerceV21 – Selenium Test Automation Framework

## 📌 Overview

EcommerceV21 is a **Selenium Test Automation Framework** built using **Java, TestNG, and Maven**.
It automates key workflows of an **eCommerce web application** (login, product search, cart, checkout, wishlist, etc.) following the **Page Object Model (POM)** design pattern.

This project demonstrates:

* ✅ Scalable test automation structure
* ✅ Reusable page objects & utilities
* ✅ Configurable test execution
* ✅ **Data-driven testing** using CSV/Excel with TestNG `@DataProvider`
* ✅ Advanced reporting with **Extent Reports** (reports generated in `reports/` folder)
* ✅ **Parallel execution** support for faster test runs
* ✅ **Jenkins integration** for CI/CD pipelines

---

## ⚙️ Tech Stack

* **Language:** Java (JDK 17+)
* **Build Tool:** Maven
* **Test Framework:** TestNG
* **UI Automation:** Selenium WebDriver
* **Design Pattern:** Page Object Model (POM)
* **Data-Driven Testing:** CSV/Excel files (`@DataProvider` in TestNG)
* **Reports:** TestNG + Extent Reports (HTML in `reports/` folder)
* **CI/CD:** Jenkins (pipeline integration)

---

## 📂 Project Structure

```
EcommerceV21/
 ├── pom.xml                  # Maven dependencies
 ├── testng.xml               # TestNG suite configuration (thread count configured for parallel execution)
 ├── src/
 │   ├── main/java/
 │   │    └── utilities/      # Utility classes (config, waits, reporting, etc.)
 │   └── test/java/
 │        ├── base/           # Base classes (driver setup, teardown)
 │        ├── pageObjects/    # Page classes (POM)
 │        ├── testCases/      # Test scripts (TestNG)
 │        └── dataProviders/  # Data-driven test support
 ├── testData/                # Input data (CSV/Excel/JSON)
 ├── reports/                 # Test execution reports (HTML)
 ├── screenshots/             # Screenshots on failure
 └── README.md                # Project documentation
```

---

## 🚀 How to Run Tests

### 1️⃣ Clone the Repository

```bash
git clone https://github.com/Kaviya0624/EcommerceV21.git
cd EcommerceV21
```

### 2️⃣ Install Dependencies

```bash
mvn clean install
```

### 3️⃣ Run Tests via TestNG

```bash
mvn test
```

Or run a specific suite:

```bash
mvn clean test -DsuiteXmlFile=testng.xml
```

### 4️⃣ Parallel Execution

Parallel execution is configured in `Crossbrowsertesting.xml` (thread count can be adjusted).
Trigger:

```bash
mvn test
```

and TestNG will execute tests in multiple threads for faster feedback.

---

## ⚡ Features

* Centralized **driver setup & teardown**
* **Data-driven tests** using CSV/Excel via TestNG `@DataProvider`
* Reusable **page methods** to reduce code duplication
* **Assertions** for validation of expected results
* **Extent Reports** for detailed HTML execution reports (saved in `reports/` folder)
* **Screenshots on failure** for debugging
* Parallel execution for faster test runs
* **CI/CD ready** with Jenkins pipeline integration

---

## 📊 Sample Test Case Flow

Example: **Login Test**

1. Launch browser
2. Navigate to ecommerce site
3. Enter username & password
4. Click login
5. Assert successful login

---

## 🔮 Future Enhancements

* Add **Allure Reports** as an additional reporting layer
* Expand **API testing** integration
* Dockerize execution for isolated containers
* Add **cross-browser testing** (Selenium Grid / cloud)

---

## 👨‍💻 About Me

Hi, I’m Siva Kaviyamalya 👋 — an aspiring Automation Test Engineer passionate about building scalable frameworks and improving software quality.

* 🔎 Looking for opportunities in Automation Testing / QA
* 💡 Skilled in Java, Selenium, TestNG, Maven, Jenkins, Git, Extent Reports
* 🚀 Strong interest in CI/CD, parallel execution, and test optimization

---

## 📬 Contact

* 📧 Email: [kaviyamalya3000@gmail.com](mailto:kaviyamalya3000@gmail.com)
* 🔗 LinkedIn: [linkedin.com/in/kaviyamalya610](https://linkedin.com/in/kaviyamalya610)
