# 💳 Payment Gateway Backend System

This is a modular, microservices-based backend system for simulating an **e-commerce payment gateway**, built entirely in **Java (Spring Boot)**. It consists of four independently functioning services that simulate real-world financial transaction flows between a customer, vendor, bank, and payment processor.

---

## 📊 Microservice Overview

| Microservice             | Description                                                           |
| ------------------------ | --------------------------------------------------------------------- |
| **BankServer**           | Validates card number, expiry date, and checks available balance      |
| **MerchantServer**       | Initiates and handles transaction logic from the merchant's side      |
| **PaymentGatewayServer** | Central gateway that routes transactions between merchant and bank    |
| **VendorApp**            | Simulates a product/vendor-facing component of the transaction system |

Each service is standalone and contains its own Spring Boot application, `pom.xml`, and RESTful API endpoints.

---

## 📚 Project Structure

```
payment-gateway-backend/
├── BankServer/
├── MerchantServer/
├── PaymentGatewayServer/
├── VendorApp/
└── README.md
```

---

## 🎓 Technologies Used

* Java 11+
* Spring Boot (Web, MVC)
* Maven
* REST APIs (JSON)
* IntelliJ IDEA
* CORS configuration for frontend integration (Angular)

---

## ⚙️ How to Run Each Service

### Prerequisites

* Java 11+
* Maven
* IntelliJ IDEA or any IDE with Spring support

### To Build and Run (for each service):

```bash
cd BankServer     # or MerchantServer, etc.
mvn clean install
mvn spring-boot:run
```

Each service runs independently on its own port (configured in `application.properties`).

---

## 📉 Example Flow

1. **VendorApp** displays product and collects payment request.
2. **MerchantServer** processes the request and forwards to **PaymentGatewayServer**.
3. **PaymentGatewayServer** routes request to **BankServer**.
4. **BankServer** validates the card, expiry, and balance.
5. Response flows back from **BankServer → PaymentGatewayServer → MerchantServer** to vendor UI.

---

## 🔗 API Communication Map

```text
VendorApp
   ↓
MerchantServer
   ↓
PaymentGatewayServer
   ↓
BankServer
```

All communication is RESTful and uses JSON.

---

## 👩‍💼 Author

**Shubham Kanse**

---

## 📄 License

This repository is intended for academic, demonstration, and portfolio purposes only.
