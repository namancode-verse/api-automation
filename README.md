# GoRest API Automation – User CRUD

## 📌 Project Overview
This project automates the **GoRest Users API** using **Java, RestAssured, Maven, and TestNG**.  
It performs an **end-to-end CRUD (Create, Read, Update, Delete)** flow with proper validations and request chaining.

The focus of this project is:
- Clean automation design
- Secure authentication handling
- Real-world API testing practices

---

## 🛠 Tech Stack
- Java 17
- Maven
- RestAssured
- TestNG
- Hamcrest Assertions

---

## 🌐 Base URL
https://gorest.co.in



---


## 🔐 Authentication
- Bearer Token authentication is used
- Token is **NOT hardcoded**
- Token is read from an **environment variable**


Environment Variable:

GOREST_TOKEN=Bearer YOUR_GOREST_ACCESS_TOKEN



---


## 📂 Project Structure

api-automation/
│
├── pom.xml
│
└── src
└── test
└── java
└── org.example
├── base
│ └── BaseTest.java
│
└── tests
└── UserTest.java



---


## ✅ Automated Test Flow (End-to-End CRUD)


### 1️⃣ Create User
- **POST** `/public/v2/users`
- Assertions:
    - Status code `201`
    - Response fields: `id`, `name`, `email`, `gender`, `status`
- Extracts `userId` from response


### 2️⃣ Get User
- **GET** `/public/v2/users/{userId}`
- Assertions:
    - Status code `200`
    - Response data matches created user


### 3️⃣ Update User
- **PUT** `/public/v2/users/{userId}`
- Updates user name
- Assertions:
    - Status code `200`
    - Updated field reflected in response


### 4️⃣ Delete User
- **DELETE** `/public/v2/users/{userId}`
- Assertion:
    - Status code `204`


### 5️⃣ Verify Deletion
- **GET** `/public/v2/users/{userId}`
- Assertion:
    - Status code `404`


---


## ▶️ How to Run Tests


### Prerequisites
- Java 11+
- Maven
- Internet connection


### Steps
1. Set environment variable:

GOREST_TOKEN=Bearer YOUR_GOREST_ACCESS_TOKEN



2. Run tests using Maven:

mvn test



---


## 📊 Expected Result

POST → 201
GET → 200
PUT → 200
DELETE → 204
GET → 404

BUILD SUCCESS



---


## 🧠 Key Highlights
- Secure token handling
- Request chaining using extracted userId
- Clean and readable test flow
- Real-world API automation scenario
- Interview-ready SDET assignment


---


## 👤 Author
**Naman Kumar**