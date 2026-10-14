# 🍕 Online Food Ordering System

A full-stack Food Ordering web application built with **Java Spring Boot**, **Spring Data JPA**, **MySQL**, and a modern **React (Vite) Frontend**.

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
│           │   │   ├── model/                              # Entities (Restaurant, FoodItem, Order, User)
│           │   │   ├── repository/                         # Spring Data JPA Repositories
│           │   │   └── controller/                         # REST Controllers
│           │   └── resources/
│           │       ├── application.properties             # MySQL & Port 8081 config
│           │       └── static/                            # Compiled React frontend (served at :8081)
│           └── test/
└── frontend/                                        # React Frontend (Vite)
    ├── package.json                                 # React & Vite dependencies
    ├── vite.config.js                               # Vite config (proxy to :8081)
    ├── index.html                                   # HTML root template
    └── src/
        ├── main.jsx                                 # React root entry
        ├── App.jsx                                  # State, search, routing & modals
        ├── index.css                                # Design system & animations
        ├── services/api.js                          # REST API client with fallback demo mode
        ├── data/fallbackData.js                     # Fallback demo restaurant data
        └── components/                              # Modular React components
            ├── Navbar.jsx                           # Search bar, auth badge & cart trigger
            ├── Hero.jsx                             # Promo banner & fast stats
            ├── CategoryChips.jsx                    # Category filter pills
            ├── RestaurantCard.jsx                   # Individual restaurant preview
            ├── RestaurantList.jsx                   # Grid & sorting by rating/name
            ├── FoodCard.jsx                         # Menu item card with add to cart
            ├── MenuSection.jsx                      # Restaurant menu & category dishes
            ├── CartDrawer.jsx                       # Slide-out cart with subtotal/tax
            ├── CheckoutModal.jsx                    # Checkout form with payment choice
            ├── OrderSuccessModal.jsx                # Live status order tracking stepper
            ├── PastOrdersModal.jsx                  # Order history modal
            └── AuthModal.jsx                        # Sign in & registration modal
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

You can run the frontend in **two ways**:

#### Method A: React Development Server (Recommended for Frontend Dev)
1. Open a new terminal and navigate to `frontend`:
   ```cmd
   cd frontend
   npm run dev
   ```
2. Open your browser at:
   👉 **[http://localhost:3000](http://localhost:3000)**
   *(Vite automatically proxies backend API calls to `http://localhost:8081`)*

#### Method B: Directly via Spring Boot
Because the compiled React app is embedded in `backend/onlinefoofordering/src/main/resources/static`, once your Spring Boot backend is running, you can visit:
👉 **[http://localhost:8081](http://localhost:8081)**

To recompile changes to the backend static folder at any time:
```cmd
cd frontend
npm run build:backend
```

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
"# OnlineFoodOrdering-Frontend" 
