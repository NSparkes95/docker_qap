# Golf Tournament API (Dockerized Spring Boot)

A simple Golf Club Tournament REST API, built with Spring Boot and MySQL, containerized using Docker and Docker Compose.  
**Purpose:** Demo basic CRUD operations and multi-container orchestration for a school assignment.

---

## 📁 Project Structure

docker_qap/

│

├── src/\
│ └── main/java/com/yourorg/dockerqap/ 

        ├── controller/
        ├── model/
        ├── repository/


    ├── docker-compose.yml
    ├── Dockerfile
    ├── pom.xml
    └── README.md



---

## 🚀 Quick Start

### **1. Prerequisites**
- [Docker Desktop](https://www.docker.com/products/docker-desktop/) installed and running
- [Java 17+](https://adoptopenjdk.net/) (only if building locally, *not needed for Docker*)
- [Maven](https://maven.apache.org/) installed (only if building locally)

---

### **2. Build the Project**

If you need to (optional, Docker does this for you):

```sh
mvn clean install
3. Run with Docker Compose

docker-compose up --build
This command will:

Build the Spring Boot app as a Docker image

Start both the API and a MySQL database as containers

4. Access the API
Open your browser and go to:


http://localhost:8080
You should see:
Golf Tournament API is running!

Try API endpoints (replace as needed):

GET /api/tournaments

POST /api/tournaments

etc.

5. Shut Down
When done, stop everything with:

docker-compose down
⚙️ Main Files
docker-compose.yml — Defines app & MySQL containers, ports, env variables.

Dockerfile — Builds the Spring Boot JAR as a container.

application.properties — Sets DB connection to the db service (container).

pom.xml — Maven build config and dependencies.

🐞 Troubleshooting
Port already in use:
Stop other apps using 3306 or 8080.

Database connection errors:
Make sure MySQL starts before the app 

📸 Screenshots
Project folder structure in IDE

Successful mvn clean install

Docker Compose up/build output

Running containers in Docker Desktop/CLI

API running in browser


👤 Author
Nicole Sparkes