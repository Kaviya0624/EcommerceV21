# 🛒 EcommerceV21 – Selenium Test Automation Framework  

## 📌 Overview  
EcommerceV21 is a **Selenium Test Automation Framework** built using **Java, TestNG, and Maven**.  
It automates key test cases of an **eCommerce web application** (login, product search, cart, checkout, wishlist, etc.), following the **Page Object Model (POM)** design pattern.  

This project demonstrates:  
- ✅ Scalable test automation structure  
- ✅ Reusable page objects & utilities  
- ✅ Configurable test execution  
- ✅ Advanced reporting with **Extent Reports**  
- ✅ **Parallel execution** support for faster test runs  
- ✅ **Jenkins integration** for CI/CD pipelines  

---

## ⚙️ Tech Stack  
- **Language:** Java (JDK 17 or higher)  
- **Build Tool:** Maven  
- **Test Framework:** TestNG  
- **UI Automation:** Selenium WebDriver  
- **Design Pattern:** Page Object Model (POM)  
- **Reports:** TestNG Reports + Extent Reports  
- **CI/CD:** Jenkins (pipeline integration)  

---

## 📂 Project Structure  

```
EcommerceV21/
 ├── pom.xml                  # Maven dependencies
 ├── testng.xml               # TestNG suite configuration
 ├── src/
 │   ├── main/java/
 │   │    └── utilities/      # Utility classes (config, waits, reporting, etc.)
 │   └── test/java/
 │        ├── base/           # Base classes (driver setup, teardown)
 │        ├── pageObjects/    # Page classes (POM design)
 │        ├── testCases/      # Test classes (TestNG)
 │        └── dataProviders/  # Data-driven testing support
 ├── testData/                # Input data (Excel/CSV/JSON)
 ├── reports/                 # Test execution reports (auto-generated)
 ├── screenshots/             # Screenshots on failure (auto-generated)
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

### 4️⃣ Run Tests in Parallel  
Parallel execution is configured in `testng.xml`.  
Just trigger:
```bash
mvn test
```
and TestNG will handle multi-threaded execution.  

---

## ⚡ Features  
- Centralized **driver setup & teardown**  
- Test data from **properties / external files**  
- **Reusable page methods** to reduce code duplication  
- **Assertions** for validation  
- **Advanced Extent Reports** for detailed execution reports  
- **Screenshots on failure** for debugging  
- **Parallel execution support** for faster feedback  
- **CI/CD ready** with Jenkins pipeline  

---

## 📊 Sample Test Case Flow  
Example: **Login Test**  
1. Launch browser  
2. Navigate to ecommerce site  
3. Enter username & password  
4. Click login  
5. Assert that user is logged in successfully  

---

## 🔮 Future Enhancements  
- Add **Allure Reports** as an additional reporting layer  
- Expand **API testing** within the same framework  
- Dockerize execution for running tests in isolated containers  
- Add **cross-browser testing grid (Selenium Grid / cloud providers)**  

---

💡 *This framework is a professional-grade demo project showcasing advanced automation testing skills.*  
