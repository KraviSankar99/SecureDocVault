# SecureDocVault - Secure Document Management System

## Overview

SecureDocVault is a highly secure, scalable, and user-friendly document management system designed to store, manage, and protect sensitive documents efficiently. The application leverages cutting-edge security protocols and encryption methods to ensure data integrity and confidentiality at all times. With a strong emphasis on user privacy and organizational security, SecureDocVault provides robust features such as multi-factor authentication (MFA), role-based access control (RBAC), and comprehensive audit trails. These features work together to offer an intuitive and secure environment for managing critical documents, ensuring compliance with industry standards, and protecting against unauthorized access or data breaches. Whether used by small teams or large enterprises, SecureDocVault guarantees seamless document workflows and a secure repository for sensitive data, giving users peace of mind and complete control over their documents.

---

## Key Features

### **User Authentication & Authorization**
- **Multi-Factor Authentication (MFA):** Adds an additional layer of security by requiring users to verify their identity through a QR code from a mobile authenticator app.
- **Role-Based Access Control (RBAC):** Grants different access levels based on user roles, ensuring that only authorized users can perform sensitive actions like updating or deleting documents.

### **Document Management**
- **Document Upload & Storage:** Users can upload documents in formats like DOC, DOCX, XLS, PDF, etc. The system supports secure, encrypted document storage.
- **Document Search & Filtering:** Users can quickly search and filter documents using metadata like name, type, and date.
- **Document Details:** View detailed information about documents, including owner, type, size, and options to update or delete documents.

### **Audit Trail Logging**
- Tracks and logs all user activities, helping administrators monitor security events and maintain compliance.

---

## Technologies Used

- **Backend:** Java, Spring Boot, PostgreSQL, Docker
- **Frontend:** React, JavaScript
- **Security:** Multi-Factor Authentication, Role-Based Access Control, Audit Logging
- **Database Management:** pgAdmin, Docker (for PostgreSQL)

---

## Installation

### Prerequisites

Before setting up the project, make sure the following software is installed:
- Java 17+
- Spring Boot 3+
- PostgreSQL (and pgAdmin via Docker)
- React
- Node.js & npm
- Docker

### Backend Setup

1. Clone the repository:
   ```bash
   git clone https://github.com/yourusername/SecureDocVault.git
   cd SecureDocVault
   ```
2. Configure PostgreSQL in the `application.properties` file:
   ```properties
   spring.datasource.url=jdbc:postgresql://localhost:5432/securedocvault
   spring.datasource.username=admin
   spring.datasource.password=admin
   spring.jpa.database-platform=org.hibernate.dialect.PostgreSQLDialect
   ```
3. Build and run the Spring Boot application:
   ```bash
   mvn clean install
   mvn spring-boot:run
   ```

### Frontend Setup

1. Navigate to the frontend directory:
   ```bash
   cd frontend
   ```
2. Install dependencies and run the application:
   ```bash
   npm install
   npm start
   ```
3. Open `http://localhost:3000` in your browser.

### Docker Setup with PostgreSQL & pgAdmin

1. Create a `docker-compose.yml` file in the project root with the following content:

   ```yaml
   version: '3.8'
   services:
     postgres:
       image: postgres:latest
       container_name: postgres_db
       environment:
         POSTGRES_USER: admin
         POSTGRES_PASSWORD: admin
         POSTGRES_DB: securedocvault
       ports:
         - "5432:5432"
       volumes:
         - postgres_data:/var/lib/postgresql/data

     pgadmin:
       image: dpage/pgadmin4
       container_name: pgadmin
       environment:
         PGADMIN_DEFAULT_EMAIL: admin@admin.com
         PGADMIN_DEFAULT_PASSWORD: admin
       ports:
         - "8080:80"
       depends_on:
         - postgres
       volumes:
         - pgadmin_data:/var/lib/pgadmin

   volumes:
     postgres_data:
     pgadmin_data:
   ```

2. Start both PostgreSQL and pgAdmin containers:
   ```bash
   docker-compose up -d
   ```

3. Verify that the containers are running:
   ```bash
   docker ps
   ```

4. **Access pgAdmin:**
   - Open your browser and go to `http://localhost:8080`.
   - Login with the credentials `admin@admin.com` / `admin`.
   - Add a new server in pgAdmin with the following connection details:
     - Host: `postgres`
     - Port: `5432`
     - Username: `admin`
     - Password: `admin`

5. **Update the `application.properties`** file in your Spring Boot application to use the PostgreSQL instance.

6. **Restart the backend service** to apply the changes.

---

## API Endpoints

### **User Authentication & Authorization**

- `POST /api/auth/register` – Register a new user
- `POST /api/auth/login` – Authenticate user and issue JWT
- `POST /api/auth/mfa` – Verify Multi-Factor Authentication
- `POST /api/auth/forgot-password` – Send password reset link
- `POST /api/auth/reset-password` – Reset user password

### **Document Management**

- `GET /api/documents` – Retrieve all documents (with pagination and search)
- `POST /api/documents/upload` – Upload a document
- `GET /api/documents/{id}` – Get document details
- `DELETE /api/documents/{id}` – Delete a document

### **Access Control**

- `POST /api/users/assign-role` – Assign roles to users
- `GET /api/users/{id}/roles` – Retrieve roles of a specific user
- `PUT /api/users/{id}/update` – Update user information

### **Audit Trail**

- `GET /api/audit-trail` – Retrieve audit logs

---

## Functional Requirements

- **User Management:**
  - New user accounts require email verification.
  - Password reset functionality via email link.
  - MFA setup using QR codes for an extra layer of security.
  - Account lockout after 6 failed login attempts (15 minutes).
  - Password expiry every 90 days with required updates.

- **Document Management:**
  - Users can upload, download, update, and delete documents.
  - Pagination and filtering of document lists.
  - Document metadata such as name, size, and owner is displayed.

- **Access Control:**
  - Role-based access control defines user permissions (e.g., document deletion, account settings).
  - Admin users can update roles, while regular users can only update their profile.

- **Audit Trail:**
  - Tracks user actions like document creation, deletion, updates, and other significant events for security and compliance.

---



