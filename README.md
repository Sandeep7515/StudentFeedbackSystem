# 🎓 Student Feedback System

## 📌 Project Overview

The **Student Feedback System** is a web-based application built using **JSP, Servlets, JDBC, and Oracle Database**.
It allows students to register, log in, and submit feedback on faculty and subjects.

---

## 🚀 Features

* Student Registration & Login
* Session Management
* Feedback Submission (15 Questions)
* Logout System
* Database Integration using JDBC

---

## 🧱 Technologies Used

* Frontend: HTML, CSS, JSP
* Backend: Java Servlets
* Database: Oracle Database
* Server: Apache Tomcat

---

## 📁 Project Structure

```text
StudentFeedbackSystem/
├── login.jsp
├── register.jsp
├── dashboard.jsp
├── feedback.jsp
├── logout.jsp
├── css/
│   └── style.css
└── WEB-INF/
    ├── web.xml
    ├── classes/
    └── lib/
        └── ojdbc8.jar
```

---

# 🗄️ Database Setup

## 👤 Students Table

```sql
CREATE TABLE students (
    reg_no VARCHAR2(20) PRIMARY KEY,
    name VARCHAR2(100),
    password VARCHAR2(100),
    year NUMBER(1),
    semester NUMBER(1),
    branch VARCHAR2(20),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
```

---

## 👨‍🏫 Faculty Table

```sql
CREATE TABLE faculty (
    faculty_id NUMBER PRIMARY KEY,
    name VARCHAR2(100),
    department VARCHAR2(50)
);
```

### Sequence & Trigger

```sql
CREATE SEQUENCE faculty_seq START WITH 1 INCREMENT BY 1;

CREATE OR REPLACE TRIGGER faculty_trigger
BEFORE INSERT ON faculty
FOR EACH ROW
BEGIN
    IF :NEW.faculty_id IS NULL THEN
        SELECT faculty_seq.NEXTVAL INTO :NEW.faculty_id FROM dual;
    END IF;
END;
/
```

---

## 📚 Subjects Table

```sql
CREATE TABLE subjects (
    subject_id NUMBER PRIMARY KEY,
    subject_name VARCHAR2(100),
    faculty_id NUMBER,
    FOREIGN KEY (faculty_id) REFERENCES faculty(faculty_id)
);
```

### Sequence & Trigger

```sql
CREATE SEQUENCE subjects_seq START WITH 1 INCREMENT BY 1;

CREATE OR REPLACE TRIGGER subjects_trigger
BEFORE INSERT ON subjects
FOR EACH ROW
BEGIN
    IF :NEW.subject_id IS NULL THEN
        SELECT subjects_seq.NEXTVAL INTO :NEW.subject_id FROM dual;
    END IF;
END;
/
```

---

## 📝 Feedback Table

```sql
CREATE TABLE feedback (
    id NUMBER PRIMARY KEY,
    reg_no VARCHAR2(20),
    subject_id NUMBER,

    q1 NUMBER(1), q2 NUMBER(1), q3 NUMBER(1), q4 NUMBER(1), q5 NUMBER(1),
    q6 NUMBER(1), q7 NUMBER(1), q8 NUMBER(1), q9 NUMBER(1), q10 NUMBER(1),
    q11 NUMBER(1), q12 NUMBER(1), q13 NUMBER(1), q14 NUMBER(1), q15 NUMBER(1),

    comments VARCHAR2(500),
    submitted_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,

    FOREIGN KEY (reg_no) REFERENCES students(reg_no),
    FOREIGN KEY (subject_id) REFERENCES subjects(subject_id)
);
```

### Sequence & Trigger

```sql
CREATE SEQUENCE feedback_seq START WITH 1 INCREMENT BY 1;

CREATE OR REPLACE TRIGGER feedback_trigger
BEFORE INSERT ON feedback
FOR EACH ROW
BEGIN
    IF :NEW.id IS NULL THEN
        SELECT feedback_seq.NEXTVAL INTO :NEW.id FROM dual;
    END IF;
END;
/
```

---

## ⚙️ Setup Instructions

### 1. Install

* Java JDK
* Oracle Database
* Apache Tomcat

---

### 2. Add JDBC Driver

Copy:

```
ojdbc8.jar → WEB-INF/lib/
```

---

### 3. Compile Servlets

```
javac -cp ".;tomcat/lib/servlet-api.jar;WEB-INF/lib/ojdbc8.jar" *.java
```

---

### 4. Deploy

Copy project to:

```
tomcat/webapps/
```

---

### 5. Run

```
http://localhost:9000/StudentFeedbackSystem/login.jsp
```

---

## 🔄 Application Flow

1. Register
2. Login
3. Dashboard
4. Submit Feedback
5. Logout

---

## 👨‍💻 Author

Student Feedback System using JSP, Servlets & Oracle DB

---
