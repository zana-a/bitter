plugins {
    java
    application

    id("org.springframework.boot") version "3.2.0"
    id("io.spring.dependency-management") version "1.1.4"
}

group = "com.zana"
version = "0.1.0"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")

    runtimeOnly("org.postgresql:postgresql")
    compileOnly("org.projectlombok:lombok")
    annotationProcessor("org.projectlombok:lombok")

    testImplementation("org.springframework.boot:spring-boot-starter-test")
}

java {
    toolchain {
        sourceCompatibility = JavaVersion.VERSION_21
        version = JavaVersion.VERSION_21
    }
}

application {
    mainClass = "com.zana.bitter.BitterApplication"
}

tasks.withType<Test> {
    useJUnitPlatform()
}
