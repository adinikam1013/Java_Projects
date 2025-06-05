# 🏦 Online Banking Simulation - Spring Boot + MySQL + Security

This is a simple banking simulation app built using:

- Java 17
- Spring Boot
- Spring Security
- MySQL (JDBC)

## ✅ Features

- User & Admin roles
- Basic Auth with Spring Security
- Deposit money
- View balance

## 🚀 How to Run

### 🐳 Using Dockerized MySQL (Recommended in Codespaces)

Run MySQL separately using Docker:

```bash
docker run --name banking-mysql -e MYSQL_ROOT_PASSWORD=root -e MYSQL_DATABASE=banking_app -p 3306:3306 -d mysql:8

▶️ Start the app
./mvnw spring-boot:run

🔐 Test API (Basic Auth)
# View balance
curl -u user1:password1 "http://localhost:8080/user/balance"

# Deposit money
curl -u user1:password1 -X POST "http://localhost:8080/user/deposit?username=user1&amount=1000"

📦 Default Users
Username	Password	Role
user1	    password1	ROLE_USER
admin1	    adminpass	ROLE_ADMIN

🧠 Tech Stack
Spring Boot
Spring Security
JDBC
MySQL
