# ============================================================================
#  Test-runner image for the Celio website automation project
#  (Java 17 + Maven + Selenium + Cucumber)
#
#  IMPORTANT: this image does NOT run Firefox itself. Your Config.java uses
#  RemoteWebDriver, so the tests reach a Firefox+Selenium-Grid server over the
#  network. That server lives in a SEPARATE container, defined in
#  docker-compose.yml (service name: "firefox").
#
#  Build:  docker build -t celio-tests .
#  (or just use docker compose, which builds this for you)
# ============================================================================

# Base image: Maven 3.9 on top of Eclipse Temurin JDK 17.
# We choose JDK 17 because pom.xml sets maven.compiler.source/target = 17.
# This single image gives us the JDK, Maven, and a Linux shell — everything
# the test code needs to compile and run.
FROM maven:3.9-eclipse-temurin-17

# WORKDIR sets the "current folder" inside the container. Every following
# COPY / RUN / CMD happens relative to /app.
WORKDIR /app

# ---- Dependency cache layer ----------------------------------------------
# Copy ONLY pom.xml first and pre-download every dependency.
# Why copy pom.xml alone? Because Docker builds images as a stack of
# "layers". This layer is re-executed ONLY when pom.xml changes. If you only
# change Java source code later, Docker reuses this cached layer and the
# rebuild is fast (no re-download of Selenium, Cucumber, JUnit, ...).
COPY pom.xml .
# `-B` = batch mode (no progress spam). `|| true` keeps the build going even
# if a plugin can't be pre-resolved — `mvn test` will fetch anything missing.
RUN mvn -B dependency:go-offline || true

# ---- Where do the tests find Firefox? ------------------------------------
# Config.java reads SELENIUM_URL and falls back to http://localhost:4444.
# Inside compose we override this with http://firefox:4444 (the browser
# service). The default here is for running the image directly on the host
# with a Selenium Grid already listening on 4444.
ENV SELENIUM_URL=http://localhost:4444

# ---- Application code ----------------------------------------------------
# Copy the source tree. This changes often, so it comes last to keep the
# dependency cache layer valid as long as possible.
COPY src ./src

# ---- What runs when the container starts ---------------------------------
# `mvn test` compiles the test code and runs it. Surefire auto-discovers
# RunnerTest.java (it matches the default *Test.java pattern), which in turn
# runs the Cucumber feature(s) listed in its @CucumberOptions.
CMD ["mvn", "test"]
