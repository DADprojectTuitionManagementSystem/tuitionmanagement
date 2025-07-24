# TUITION MANAGEMENT
A web based tuition class management system for tutors, students and payments

## Table of Contents

1. [Introduction](##1.0-introduction)  
    [1.1 Project Overview](###1.1-project-overview)  
    [1.2 Commercial Value / Third-Party Integration](###1.2-commercial-value--third-party-integration)

2. [System Architecture](#2-system-architecture)  
   - [2.1 High-Level Diagram](#21-high-level-diagram)

3. [Backend Application](#3-backend-application)  
   - [3.1 Technology Stack](#31-technology-stack)  
   - [3.2 API Documentation](#32-api-documentation)  
     - [3.2.1 Endpoints List](#321-endpoints-list)  
     - [3.2.2 Request Format](#322-request-format)  
     - [3.2.3 Example Responses](#323-example-responses)  
     - [3.2.4 Security Measures](#324-security-measures)

4. [Frontend Applications](#4-frontend-applications)  
   - [4.1 Student App](#41-student-app)  
     - [4.1.1 Purpose](#411-purpose)  
     - [4.1.2 Technology Stack](#412-technology-stack)  
     - [4.1.3 API Integration](#413-api-integration)  
   - [4.2 Admin App](#42-admin-app)  
     - [4.2.1 Purpose](#421-purpose)  
     - [4.2.2 Technology Stack](#422-technology-stack)  
     - [4.2.3 API Integration](#423-api-integration)

5. [Database Design](#5-database-design)  
   - [5.1 Entity-Relationship Diagram (ERD)](#51-entity-relationship-diagram-erd)  
   - [5.2 Schema Justification](#52-schema-justification)

6. [Business Logic and Data Validation](#6-business-logic-and-data-validation)  
   - [6.1 Use Case Diagrams / Flowcharts](#61-use-case-diagrams--flowcharts)  
   - [6.2 Data Validation Rules](#62-data-validation-rules)

7. [Conclusion](#7-conclusion)


## 1.0 Introduction

  ### 1.1 Project Overview
  Tuition Management System helps tutors and students manage tuition classes in organizing and managing tuition related data. The system provides key features such as class scheduling, schedule status, student enrollment and payment management. Our team focuses on automating manual processes like registration, fee tracking, students attendance tracking and timetable coordination. The system aims to reduces administrative workload and human error. 

  Tutors can add easily create and update class sessions, update class time, class status and access list of students. Students can browse available classes, register new classes, display tuition fees and proceed to payment. 

  ### 1.2 Commercial Value / Third-Party Integration
The Tuition Management System has a strong commercial potential especially for private tutors, freelance educator and tuition centers as the system can cater from small to big audience. The system seek a streamlined digital solution in managing daily operation usually done by human. This system can be offered as a software-as-a-services (SaaS) platform, targeting small to medium tuition educators.

The system architecture separates the frontend and backend layers, enabling easier maintenance and future scalability. The frontend interface is built using **HTML**, offering a lightweight and accessible UI for users. Communication between the frontend and backend is handled using **JavaScript** and **JSON**, allowing smooth asynchronous data exchange.

The backend is powered by **Java with Spring Boot**, ensuring a secure server-side application. Data is stored in a MySQL database, and the system enforces user roles and access control through authentication mechanisms.

To enhance its functionality and security, the system also integrated with the following third-party services:

- **Firebase Authentication**  
  Handles secure user registration and login. Supports role-based access (student, tutor, admin) and simplifies password management.

- **JWT (JSON Web Token)**  
  Used for securing API routes. After login, a token is generated and attached to each request header, ensuring only authorized users can access sensitive operations.



## 2.0 System Architecture

  ### 2.1 High-Level Diagram
The high-level architecture illustrates how the core components of the tuition management system interact:

<img width="598" height="576" alt="image" src="https://github.com/user-attachments/assets/85b93fdc-97a1-4486-9d77-e609d10a2005" />

## 3.0 Backend Application

### 3.1 Technology Stack

The backend of this tuition management system is built using a combination of powerful technologies to ensure scalability, maintainability and performance. The Tuition Management System is developed using Spring Boot, a Java-based framework that simplifies the development of web application. Eclipse IDE is used as development environment and providing tools for efficient coding. The system uses MySQL database to store and manage data.

| Component        | Technology           |
|------------------|----------------------|
| Language          | Java                |
| IDE               | Eclipse              |
| Framework         | Spring Boot          |
| Database          | MySQL                |

---

### 3.2 API Documentation
This system provides RESTful API endpoints that allow communication between the frontend (HTML/JavaScript) and the backend (Java Spring Boot). All data is exchanged in JSON format. The endpoints below are used for user authentication, class management and payment processing.

#### 3.2.1 Endpoints List
The table below outlines the main API endpoints used in the tuition management system. These endpoints allow users to authenticate, view or manage class schedules, and process payments. All endpoints follow REST principles and return data in JSON format.

| Endpoint                         | Method | Description                     | Authentication Required |
|----------------------------------|--------|----------------------------------|---------------|
| `/api/auth/login`               | POST   | Log in and receive access token | No             |
| `/api/classes/`                 | GET    | Get list of all classes         | Yes            |
| `/api/classes/`                 | POST   | Create a new class              | Yes            |
| `/api/payments/`                | GET    | Get payment records             | Yes            |
| `/api/payments/`                | POST   | Submit a payment                | Yes            |


#### 3.2.2 Request Format
##### 🟢 `POST /api/auth/login`

**Headers:**  
`Content-Type: application/json`

**Body:**
```json
{
  "username": "student1",
  "password": "password123"
}
```

---

##### 🟢 `POST /api/classes/`

**Headers:**  
`Content-Type: application/json`  
`Authorization: Bearer <token>`

**Body:**
```json
{
  "subject": "Mathematics",
  "day": "Monday",
  "start_time": "10:00",
  "end_time": "11:30",
  "tutor_id": 2
}
```

---

##### 🟢 `POST /api/payments/`

**Headers:**  
`Content-Type: application/json`  
`Authorization: Bearer <token>`

**Body:**
```json
{
  "student_id": 5,
  "amount": 150.00,
  "method": "Online Transfer",
  "status": "Paid"
}
```

---

---
### 3.2.3 Example Success
<img width="1594" height="993" alt="image" src="https://github.com/user-attachments/assets/6fe99180-5888-49f2-a4cf-de423aa23220" />

### 3.2.4 Security Measure
package com.tuition.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
          .csrf(csrf -> csrf.disable())
          .authorizeHttpRequests(auth -> auth
                .requestMatchers(
                    "/tms-login.html",
                    "/tms-student-dashboard.html",
                    "/tms-tutor-dashboard.html",
                    "/api/auth/**", 
                    "/api/classes/**",
                    "/api/payments/**",
                    "/css/**", 
                    "/js/**",
                    "/images/**"
                ).permitAll()
                .anyRequest().permitAll()
          )
          .formLogin(form -> form.disable())
          .httpBasic(httpBasic -> httpBasic.disable());
        return http.build();
    }
}

Security measures implemented:

Disabled CSRF protection → because the backend is likely a stateless REST API using tokens (e.g., JWT), so CSRF isn’t needed.

Allowed public access (permitAll) to login pages, dashboards, API endpoints for auth/classes/payments, and static resources (CSS, JS, images) → so the frontend can load properly and users can access login features without being blocked.

Disabled Spring’s default form login and HTTP Basic auth → because the app uses a custom frontend login page and handles authentication via its own API.

Why:

The backend serves as an API for a separate frontend rather than a traditional server-rendered app.

Token-based authentication makes CSRF protection and built-in login mechanisms unnecessary.

Public access is needed for initial pages and resources, while actual data protection would be handled by custom API security (e.g., JWT).

## 4.0 Frontend Application

### 4.1 Student App

#### 4.1.1 Purpose
The Student App is designed to empower students with self-service functionalities for managing their tuition activities. It allows students to view enrolled classes (subject, schedule, status), check tuition fees, enroll in new classes, and make payments seamlessly. The app also generates downloadable PDF receipts for completed payments, ensuring transparency and record-keeping. Key features like dynamic class listings (loaded via API) and a multi-step payment flow (subject selection → payment → receipt) streamline the user experience, reducing administrative overhead.

#### 4.1.2 Technology Stack
The app is built with vanilla HTML5, CSS3, and JavaScript for lightweight performance and broad compatibility. The UI uses responsive design principles (e.g., flexbox, viewport units) to adapt to mobile and desktop screens. For PDF generation, it integrates the jsPDF library, and session management relies on sessionStorage to persist user data (e.g., userId) post-login. No frontend frameworks are used, keeping the stack simple and maintainable.

#### 4.1.3 API Integration
The app interacts with a RESTful backend via fetch API calls to endpoints like:

GET /classes/student/{studentId}: Loads enrolled classes.

GET /payments/student/{studentId}: Retrieves payment history.

POST /classes: Enrolls in a new class.

POST /payments: Processes payments.
Data is exchanged in JSON format, with error handling for failed requests (e.g., alerts for API errors). The API base URL (http://localhost:8080/api) is centralized for easy configuration.

### 4.2 Admin (Tutor) App

#### 4.2.1 Purpose
The Admin App caters to tutors, providing tools to manage classes (add/edit schedules, update statuses) and monitor students. Tutors can view a filterable list of students (search by name, filter by payment status) and edit class details (day, time, status) via modal forms. The app emphasizes efficiency, with real-time updates to class tables and student lists fetched from the backend, ensuring tutors have up-to-date information for decision-making.

#### 4.2.2 Technology Stack
Like the Student App, it uses vanilla HTML/CSS/JS but includes additional UI components like modals (for editing classes) and interactive tables with sorting/filtering. Font Awesome icons enhance navigation (e.g., logout button), and CSS-driven status badges (e.g., "Paid," "Pending") improve data visibility. The app avoids external dependencies except for Font Awesome (for icons) and shares the same session management approach (sessionStorage).

#### 4.2.3 API Integration
The Admin App integrates with the backend through endpoints such as:

GET /classes/tutor/{tutorId}: Fetches classes taught by the tutor.

PUT /classes/{classId}: Updates class details (day, time, status).

POST /classes: Creates new classes.

GET /student/all: Retrieves all students for management.
Search/filter operations are handled client-side (e.g., filtering allStudents array), reducing API calls. Error handling includes user alerts and console logging for debugging.


## 5.0 Database Design
### 5.1 ERD diagram
The ERD below represents the core structure of the tuition management system's database. It includes four main entities:

- *User*: Stores all users of the system (students and tutors). The role field distinguishes their function, either STUDENT or TUTOR.
- *Class Entity*: Represents a tuition class, including its subject, schedule and the tutor assigned to each class.
- *Class Entity Student IDs*: A bridge table that links students to the classes they are enrolled in, enabling a many-to-many relationship.
- *Payment*: Records all payment transactions made by students for tuition classes.


The diagram helps visualize how users, classes and payments are related, ensuring the system is well-structured, relational, and scalable.
<img width="1594" height="993" alt="image" src="https://github.com/user-attachments/assets/b58143b9-b452-4e9b-bd82-4c205befa516" />


### 5.2 Schema Justification
The database schema is designed to support the system's core functionalities such as user management, class scheduling and payment tracking. The schema follows normalization principles to avoid redundancy and ensure data integrity.

---

####  user Table
- *Purpose: Stores both **students* and *tutors*.
- *Key Fields*:
  - id: Primary key.
  - name, email, username: Basic identity fields.
  - role: Differentiates between 'STUDENT' and 'TUTOR'.
- *Justification*: A single unified table with a role field simplifies user management and authentication without needing separate tables for tutors and students.

---

#### class_entity Table
- *Purpose*: Stores information about tuition classes.
- *Key Fields*:
  - id: Primary key.
  - subject, day, start_time, end_time: Class details.
  - tutor_id: Foreign key to user.id (must have role = 'tutor').
- *Justification*: Each class is linked to one tutor. Storing class timing and subject allows for flexible scheduling and conflict checking.

---

#### class_entity_student_ids Table
- *Purpose*: Bridge for classes and students.
- *Key Fields*:
  - class_entity_id: Foreign key to class_entity.id.
  - student_ids: Foreign key to user.id (must have role = 'student').
- *Justification*: Supports assigning multiple students to a class and reusing classes across terms. It maintains relational integrity without storing arrays or comma-separated lists.

---

#### payment Table
- *Purpose*: Records payment transactions from students.
- *Key Fields*:
  - id: Primary key.
  - student_id: Foreign key to user.id.
  - amount, method, status: Details of each payment.
  - created_date: Timestamp of the transaction.
- *Justification*: This allows tracking of who paid, how much, and by which method. The status field helps in monitoring pending or failed payments.

---

## 6.0 Business Logic & Data Validation

### 6.1 Use Case Diagram

<img width="842" height="561" alt="image" src="https://github.com/user-attachments/assets/8d7e6f9c-cdb7-4487-832e-6fe16acf7a37" />


### 6.2 Data Validation Rules

This section outlines the key validation rules implemented across both the **Student** and **Tutor** applications. These rules ensure user inputs are complete, correct, and compatible with backend requirements.

#### Student App Validation

| Field              | Rule                                                                       | Type             | Message / Action                    |
| ------------------ | -------------------------------------------------------------------------- | ---------------- | ----------------------------------- |
| Subject Selection  | Must select a subject from the dropdown (not default)                      | Required Field   | `alert("Select a subject")`         |
| Payment Method     | Must select a payment method                                               | Required Field   | `alert("Choose payment method")`    |
| Subject Price      | Only allowed values: "Bahasa Melayu", "English", "Math", "Science"         | Enumerated List  | Subject not in list → block payment |
| Payment Amount     | Calculated from subject (e.g., Math = RM120)                               | Internal Logic   | Prevent price tampering             |
| Receipt Generation | PDF auto-generated after successful payment                                | System Generated | File: `receipt.pdf`                 |

#### Tutor App Validation

| Field                   | Rule                                                 | Type             | Message / Action                       |
| ----------------------- | ---------------------------------------------------- | ---------------- | -------------------------------------- |
| Add Class - Subject     | Subject name cannot be blank                         | Required Field   | `alert("Please enter a subject name")` |
| Edit Class - Day        | Must select a valid day from dropdown (Mon–Sun)      | Required Field   | Validation at modal level              |
| Edit Class - Time       | Start time must be before end time                   | Logical Check    | If invalid: prevent save               |
| Edit Class - Status     | Must be one of: Completed, Scheduled, Canceled       | Enumerated Field | Invalid status blocks update           |
| Filter/Search Students  | Optional; no restrictions                            | Optional         | —                                      |

#### Backend API Validation (Spring Boot)

| Field                          | Rule                                       | HTTP Error if Violated   |
| ------------------------------ | ------------------------------------------ | ------------------------ |
| POST `/api/classes`            | Subject, day, time must be provided        | 400 Bad Request          |
| POST `/api/payments`           | Amount, method, and studentId are required | 400 Bad Request          |
| All endpoints with ID params   | Must be valid integers and exist in DB     | 404 Not Found / 400      |
