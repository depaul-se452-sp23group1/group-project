# group-project

This repository serves as the group project for Spring 2023 SE453 Group 

**Project Scope Area**
---
E-commerce
We are developing a basic shopping application.
The user can create an account and browse various categories and products.
The user can place an order and make a payment through the application.

**Project Members**
---
| Name          | Functional Area                |
|---------------|--------------------------------|
| Karthik       | Account Management             |
| CHandrashekar | Category and Products Module   |
| Josh          | Orders & Cart Module           |
| Bramhashree   | Payment Transaction & Shipping |

**Conflict Resolution**
---
Decide as a group after team discussion

**Communication Mechanism**
---
MS Teams and Github. 
Will meet twice a week or more if needed.

**Decision Made**
---
1. IDE - IntelliJ
2. Dependency Management - Gradle
3. Code - Lombok
4. Configuration Management - Yaml
5. Database - H2

**Meeting Journal**
---
We all met in MS Teams and disucssed about the various scope areas. 
We then finalised on developing an E-commerce application (basic shopping application).
We then created a git repository for our project.
After assigning the functional areas for each team member, each of us tried to make changes in the README file and push it to the repository.
We finally created the Spring Skeleton with the above mentioned configurations and pushed it to the Git repository.
As of now everyone is working on their functional tables.
---
We created entities corresponding to each functional area and mapped them with the database tables.
Using CrudRepository we we were able to use the build-in functions such as save, delete, findById, finaAll, update, etc.
We created Controllers and Service classes accordingly and also successfully test it both through Postman and Junit testcases.
---
As per the feedback, we added the package-info files for each package
We implemented the Logging using Log4j2
We also included additional services that would support the Application flow.
Concepts such as relation mapping and inheritance were considered while designing the application.
We discussed about the UI layer in the meeting and finalised on implementing Angular JS.
Currently working on including NoSql to support certain features of the app.
