# 🛒 EcommerceV21 – Selenium Test Automation Framework  

## 📌 Overview  
EcommerceV21 is a **Selenium Test Automation Framework** built using **Java, TestNG, and Maven**.  
The framework is designed to automate key test cases of an **eCommerce web application** (login, product search, cart, checkout, wishlist, etc.), following the **Page Object Model (POM)** design pattern.  

This project demonstrates:  
- ✅ Scalable test automation structure  
- ✅ Reusable page objects & utilities  
- ✅ Configurable test execution  
- ✅ Reporting & screenshots on failure  

---

## ⚙️ Tech Stack  
- **Language:** Java (JDK 17 or higher)  
- **Build Tool:** Maven  
- **Test Framework:** TestNG  
- **UI Automation:** Selenium WebDriver  
- **Design Pattern:** Page Object Model (POM)  
- **Reports:** TestNG Reports / Extent Reports (if configured)  

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

---

## ⚡ Features  
- Centralized **driver setup & teardown**  
- Test data from **properties / external files**  
- **Reusable page methods** to reduce code duplication  
- **Assertions** for validation  
- **Reports & Screenshots** for failed cases  
- **CI/CD ready** (can integrate with GitHub Actions / Jenkins)  

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
- Add **Extent Reports** for better visualization  
- Integrate with **Allure Reports**  
- Setup **GitHub Actions / Jenkins pipeline**  
- Add **parallel execution support**  
- Expand **API testing layer**  

---

💡 *This framework is a learning + demo project for showcasing automation testing skills. Contributions and improvements are welcome!*  
