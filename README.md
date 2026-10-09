# 🍕 Online Food Ordering System

A full-stack Food Ordering web application built with **Java Spring Boot**, **Spring Data JPA**, **MySQL**, and a responsive **HTML5/CSS3/JavaScript Frontend**.

---

## 📁 Project Structure

```text
OnlineFoodOrdering/
├── backend/
│   └── onlinefoofordering/
│       ├── pom.xml                                  # Maven dependencies
│       ├── mvnw / mvnw.cmd                          # Maven wrapper
│       ├── .mvn/                                    # Wrapper jar & properties
│       └── src/
│           ├── main/
│           │   ├── java/onlinefoofordering/
│           │   │   ├── OnlinefooforderingApplication.java  # Main entry point
│           │   │   ├── DataInitializer.java                # Automatic sample data loader
│           │   │   ├── HomeController.java                 # Health check endpoint
│           │   │   ├── model/
│           │   │   │   ├── Restaurant.java                 # Restaurant entity
│           │   │   │   ├── FoodItem.java                   # Food / Dish entity
│           │   │   │   └── Order.java                      # Customer order entity
│           │   │   ├── repository/
│           │   │   │   ├── RestaurantRepository.java
│           │   │   │   ├── FoodItemRepository.java
│           │   │   │   └── OrderRepository.java
│           │   │   └── controller/
│           │   │       ├── RestaurantController.java
│           │   │       ├── FoodController.java
│           │   │       └── OrderController.java
│           │   └── resources/
│           │       ├── application.properties             # MySQL & Port 8081 config
│           │       └── static/                            # Built-in Frontend (served at :8081)
│           │           ├── index.html
│           │           ├── styles.css
│           │           └── app.js
│           └── test/
└── frontend/                                        # Standalone Frontend
    ├── index.html                                   # FoodExpress Website
    ├── styles.css                                   # Styling, animations, responsive design
    └── app.js                                       # Cart, live tracking, REST API calls
```

---

## 🚀 Step-by-Step Guide: How to Run in VS Code

### Step 1: Open the Project in VS Code
1. Open **Visual Studio Code**.
2. Go to **File** $\rightarrow$ **Open Folder...**
3. Select the folder: `OnlineFoodOrdering`.

---

### Step 2: Make sure MySQL is Running
1. MySQL Service should be running on `localhost:3306`.
2. The database credentials in `backend/onlinefoofordering/src/main/resources/application.properties` are:
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/onlinefoodordering?createDatabaseIfNotExist=true&useSSL=false&serverTimezone=UTC
   spring.datasource.username=root
   spring.datasource.password=root
   server.port=8081
   ```
   *(If your MySQL password is different from `root`, update `spring.datasource.password`)*.

---

### Step 3: Run the Backend Server
1. In VS Code, open the integrated terminal (**Terminal** $\rightarrow$ **New Terminal** or press ``Ctrl + ` ``).
2. Navigate to the backend directory:
   ```cmd
   cd backend\onlinefoofordering
   ```
3. Run the application:
   ```cmd
   mvnw.cmd spring-boot:run
   ```
4. You will see:
   ```text
   Tomcat started on port 8081 (http) with context path '/'
   Started OnlinefooforderingApplication in ... seconds
   ```

---

### Step 4: Open the Frontend Website

You can view the frontend in **either of two easy ways**:

#### Method A: Directly via Spring Boot (Recommended)
Because the frontend is embedded directly in the backend `static` folder, simply open your browser and visit:
👉 **[http://localhost:8081](http://localhost:8081)**

#### Method B: Standalone Frontend
1. Open the file `frontend/index.html` in VS Code.
2. Right-click $\rightarrow$ **Open with Live Server** (or simply double-click `frontend/index.html` in Windows Explorer to open it in Chrome).

---

## 📡 Available REST API Endpoints

| Method | Endpoint | Description |
| :--- | :--- | :--- |
| `GET` | `/api/status` | System health check (`{"status":"UP"}`) |
| `GET` | `/api/restaurants` | List all restaurants with menus & ratings |
| `GET` | `/api/restaurants/{id}` | Get restaurant by ID |
| `GET` | `/api/restaurants/{id}/menu` | Get menu for a specific restaurant |
| `GET` | `/api/foods` | List all food items across restaurants |
| `GET` | `/api/foods/category/{category}` | Filter foods by category (Pizza, Burger, Curry, Rice, Sides) |
| `GET` | `/api/orders` | View recent customer orders |
| `POST` | `/api/orders` | Place a new order with items, customer details & delivery address |
