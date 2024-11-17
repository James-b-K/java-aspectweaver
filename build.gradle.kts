import org.springframework.boot.gradle.tasks.run.BootRun

plugins {
	java
	id("org.springframework.boot") version "3.3.5"
	id("io.spring.dependency-management") version "1.1.6"
}

group = "com.example"
version = "0.0.1-SNAPSHOT"

java {
	toolchain {
		languageVersion = JavaLanguageVersion.of(21)
	}
}

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("org.springframework:spring-aspects")
	implementation("org.springframework:spring-instrument")
	implementation("org.springframework.boot:spring-boot-starter-aop")

	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

tasks.getByName<BootRun>("bootRun") {
	doFirst {
		project.configurations.runtimeClasspath.get().forEach {
			if(it.name.contains("spring-instrument")) {
				print(it.absolutePath)
				jvmArgs("-javaagent:${it.absolutePath}")
			}
			if(it.name.contains("aspectjweaver")) {
				print(it.absolutePath)
				jvmArgs("-javaagent:${it.absolutePath}")
			}
		}
	}
}

tasks.withType<Test> {
	useJUnitPlatform()

	doFirst {
		project.configurations.runtimeClasspath.get().forEach {
			if(it.name.contains("spring-instrument")) {
				print(it.absolutePath)
				jvmArgs("-javaagent:${it.absolutePath}")
			}
			if(it.name.contains("aspectjweaver")) {
				print(it.absolutePath)
				jvmArgs("-javaagent:${it.absolutePath}")
			}
		}
	}
}
