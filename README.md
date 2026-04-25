# 🛒 E-Commerce Application (Spring Boot)

A backend system built using **Spring Boot** for managing an **E-Commerce platform**, including products, users, cart, and order processing through REST APIs.

This project demonstrates real-world backend development concepts like API design, database management, and business logic implementation.

---

## 🚀 Features

### 👤 User Management

* User registration & login
* Manage user details

### 📦 Product Management

* Add products
* View all products
* Update product details
* Delete products

### 🛒 Cart Management

* Add items to cart
* Remove items from cart
* View cart items

### 📦 Order Management

* Place orders
* View order history

---

## 🏗️ Tech Stack

### Backend

* Java
* Spring Boot
* Spring Data JPA
* Hibernate
* Maven

### Database

* MySQL / H2 (configurable)

---

## 📁 Project Structure

```id="r8k3zn"
Ecommerce-Application/
│
├── src/
│   ├── main/
│   │   ├── java/com/ecommerce/
│   │   │   ├── controller/
│   │   │   ├── service/
│   │   │   ├── repository/
│   │   │   ├── model/
│   │   │   └── config/
│   │   └── resources/
│   │       ├── application.properties
│
├── pom.xml
└── README.md
```

---

## ⚙️ Setup & Installation

### 1️⃣ Clone Repository

```bash id="k3m9yt"
git clone https://github.com/your-username/springboot-ecommerce-api.git
cd springboot-ecommerce-api
```

---

### 2️⃣ Configure Database

Update `application.properties`:

```properties id="z1x7qp"
spring.datasource.url=jdbc:mysql://localhost:3306/ecommercedb
spring.datasource.username=root
spring.datasource.password=yourpassword

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

---

### 3️⃣ Run Application

```bash id="b2c8vl"
./mvnw spring-boot:run
```

---

## 🔌 API Endpoints

### 👤 User APIs

| Method | Endpoint            | Description   |
| ------ | ------------------- | ------------- |
| POST   | /api/users/register | Register user |
| POST   | /api/users/login    | Login user    |

---

### 📦 Product APIs

| Method | Endpoint           | Description      |
| ------ | ------------------ | ---------------- |
| GET    | /api/products      | Get all products |
| POST   | /api/products      | Add product      |
| PUT    | /api/products/{id} | Update product   |
| DELETE | /api/products/{id} | Delete product   |

---

### 🛒 Cart APIs

| Method | Endpoint              | Description      |
| ------ | --------------------- | ---------------- |
| GET    | /api/cart             | Get cart items   |
| POST   | /api/cart/add         | Add to cart      |
| DELETE | /api/cart/remove/{id} | Remove from cart |

---

### 📦 Order APIs

| Method | Endpoint    | Description     |
| ------ | ----------- | --------------- |
| POST   | /api/orders | Place order     |
| GET    | /api/orders | Get user orders |

---

## 🔄 Application Flow

```id="x6t2kp"
1. User registers / logs in
2. User browses products
3. User adds items to cart
4. User places order
5. Order is stored in database
```

---

## 🧪 Testing APIs

Use:

* Postman
* Thunder Client (VS Code)

---

## 📌 Future Improvements

* JWT Authentication & Security
* Payment Gateway Integration
* Admin Dashboard
* Product Reviews & Ratings

---

## 👨‍💻 Author

Harshil Gorasiya

---

## ⭐ Support

If you like this project, give it a ⭐ on GitHub!
