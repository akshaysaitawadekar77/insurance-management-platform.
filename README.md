# insurance-management-platform.
insurance management platform SpringBoot Project


**Stepwise procedure for run application**
Run using Sts/Eclips 
    -Import the project 
    - change Application.properties file (spring.datasource.url,spring.datasource.username,spring.datasource.password) as per user DataBase configuaration.
    -Then InsuranceManagenmanetPlatformApplication.java # Main class for running the application
 
 **Brief Discription about project**
   The Client class represents a client in the system and includes properties such as name, date of birth, address, and contact information.
   The InsurancePolicy class represents an insurance policy in the system and includes properties such as policy number, type, coverage amount, premium, start date, and end date. Each policy is associated with a client to allow for easy management of client policies.
    The Claim class represents an insurance claim in the system and includes properties such as claim number, description, claim date, and claim status. Each claim is associated with an insurance policy to allow for easy tracking of claims and policies.
    The system provides RESTful APIs for managing clients, insurance policies, and insurance claims. Users can perform CRUD (Create, Read, Update, Delete) operations on these entities using the provided APIs.
    To ensure proper API usage and data integrity, the system includes exception handling and validation. For example, when creating a new client, the system will check that all required fields are present and that the client's mobile number is valid. If any validation fails, the system will return an appropriate error message.
Overall, this insurance management system provides a comprehensive solution for managing clients, insurance policies, and claims.


**Structure of Project**
insurance-management-system/

├── src/
│   ├── main/
│   │   ├── java/
│   │   │   ├── com.insurance
│   │   │   │   ├── controller/           # REST controllers for handling HTTP requests
│   │   │   │   ├── pojo/                 # Java classes representing data models
│   │   │   │   ├── repo/                 # Interfaces for accessing the database
│   │   │   │   ├── service/              # Business logic layer services
│   │   │   │   └── InsuranceManagenmanetPlatformApplication.java # Main class for running the application
│   │   └── resources/
│   │       ├── application.properties    # Configuration properties
│   │       ├── templates/                # Database schema and scripts
│   │       └── static/                   # Static resources such as CSS and JS files
│   └── test/
│       ├── java/
│       │   └── com.insurance/
└── pom.xml                              # Maven build file

**Project Feature** 
  - Add a client: The user can input a client's information (name, date of birth, address, contact information) and create a new instance of the Client class.
  - Add an insurance policy: The user can input policy information (policy number, type, coverage amount, premium, start date, and end date).
 - View client information: The user can view a list of all clients and their associated policies. Clicking on a client's Id will show their personal information, as well as a list of their policies and claims.

File a claim: The user can input multipal claim information (claim number, description, claim date) and associate it with an existing insurance policy by update method in insurancepolicy by policy id 

View claim status: for thet by using client we have to find all claims and policy of client.

Update claim status: The user can change the status of a claim from "pending" to "approved" or "denied" based on their review of the claim information by update method of claim.

**Mapping between client policies and claims:**
mapping between clinet and policies is OnetoMany
mapping between policies and claims is OneToMany
