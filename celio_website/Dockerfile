# Start from an image that already has Maven + Java 17
FROM maven:3.9-eclipse-temurin-17

# Set the working directory inside the container
WORKDIR /app

# Copy ONLY pom.xml first and download dependencies
# -> Docker caches this layer; it re-runs only when pom.xml changes
COPY pom.xml .
RUN mvn dependency:go-offline -B

# Now copy the source code (changes often, so it comes last)
COPY src ./src

# When the container starts, run the Cucumber tests
CMD ["mvn", "test"]