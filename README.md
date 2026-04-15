# 🎓 Student Feedback System

## 📌 Project Overview

The **Student Feedback System** is a web-based application built using **JSP, Servlets, JDBC, and Oracle Database**.
It allows students to register, log in, and submit feedback on faculty and subjects in a structured manner.

This system replaces manual feedback collection with a **digital, efficient, and secure platform**.

---

## 🚀 Features

### 👤 Student Module

* Register new account
* Secure login using register number & password
* Session-based authentication
* Logout functionality

### 📝 Feedback Module

* Submit feedback for subjects
* 15 structured rating questions (1–5 scale)
* Comments section
* Feedback stored in database

### ⚙️ Backend

* Java Servlets for request handling
* JDBC for database connectivity
* Oracle Database integration

---

## 🧱 Technologies Used

* **Frontend:** HTML, CSS, JSP
* **Backend:** Java Servlets
* **Database:** Oracle Database
* **Server:** Apache Tomcat
* **Connectivity:** JDBC

---

## 📁 Project Structure

```text
StudentFeedbackSystem/
│
├── login.jsp
├── register.jsp
├── dashboard.jsp
├── feedback.jsp
├── logout.jsp
├── css/
│   └── style.css
│
└── WEB-INF/
    ├── web.xml
    ├── classes/
    │   ├── DBConnection.class
    │   ├── RegisterServlet.class
    │   ├── LoginServlet.class
    │   ├── FeedbackServlet.class
    │
    └── lib/
        └── ojdbc8.jar
```

---

## 🗄️ Database Tables

### 1. Students

* reg_no (Primary Key)
* name
* password
* year
* semester
* branch
* created_at

### 2. Faculty

* faculty_id (Primary Key)
* name
* department

### 3. Subjects

* subject_id (Primary Key)
* subject_name
* faculty_id (Foreign Key)

### 4. Feedback

* id (Primary Key)
* reg_no (Foreign Key)
* subject_id (Foreign Key)
* q1–q15 (ratings)
* comments
* submitted_at

---

## ⚙️ Setup Instructions

### 1. Install Requirements

* Java JDK (8 or above)
* Oracle Database
* Apache Tomcat

---

### 2. Configure Database

* Create all tables using SQL scripts
* Insert sample faculty and subjects

---

### 3. Add JDBC Driver

Copy:

```
ojdbc8.jar → WEB-INF/lib/
```

---

### 4. Compile Servlets

```
javac -cp ".;tomcat/lib/servlet-api.jar;WEB-INF/lib/ojdbc8.jar" *.java
```

Move compiled `.class` files to:

```
WEB-INF/classes/
```

---

### 5. Deploy Project

Copy project folder into:

```
tomcat/webapps/
```

Start Tomcat server.

---

### 6. Run Application

Open browser:

```
http://localhost:9000/StudentFeedbackSystem/login.jsp
```

---

## 🔄 Application Flow

1. User registers
2. User logs in
3. Redirect to dashboard
4. Submit feedback
5. Data stored in database
6. Logout

---

## 🔐 Security Notes

* Session-based authentication
* Input validation recommended
* Password encryption can be added (future enhancement)

---

## 👨‍💻 Author

Developed as a **Full Stack Java Project using JSP & Servlets**

---

## ⭐ Conclusion

This project demonstrates:

* Full-stack Java web development
* Database integration using JDBC
* Real-world academic system design

---
