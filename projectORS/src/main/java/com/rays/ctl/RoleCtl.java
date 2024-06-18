package com.rays.ctl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rays.common.BaseCtl;
import com.rays.common.DropdownList;
import com.rays.common.ORSResponse;
import com.rays.dto.RoleDTO;
import com.rays.form.RoleForm;
import com.rays.service.RoleServiceInt;

/**
 * @author Paras Mahajan
 *
 */
@RestController
@RequestMapping(value = "Role")
public class RoleCtl extends BaseCtl<RoleForm, RoleDTO, RoleServiceInt> {

	/*
	 * @GetMapping("/preload") public ORSResponse preload() { ORSResponse res = new<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">

	<modelVersion>4.0.0</modelVersion>

	<parent>
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-starter-parent</artifactId>
		<version>2.1.2.RELEASE</version>
		<relativePath /> <!-- lookup parent from repository -->
	</parent>

	<groupId>com.sunilos</groupId>
	<artifactId>springboottest</artifactId>
	<version>0.0.1-SNAPSHOT</version>
	<name>springboottest</name>
	<packaging>jar</packaging>
	<description>Demo project for Spring Boot</description>

	<properties>
		<java.version>1.8</java.version>
		<!-- <maven-war-plugin.version>3.2.3</maven-war-plugin.version> -->


	

	</properties>

	<dependencies>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-actuator</artifactId>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-devtools</artifactId>
			<scope>runtime</scope>
			<optional>true</optional>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-data-jpa</artifactId>
		</dependency>

		<dependency>
			<groupId>mysql</groupId>
			<artifactId>mysql-connector-java</artifactId>
			<version>8.0.28</version>
		</dependency>

		<dependency>
			<groupId>c3p0</groupId>
			<artifactId>c3p0</artifactId>
			<version>0.9.1.2</version>
		</dependency>

		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-web</artifactId>
		</dependency>

		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-test</artifactId>
			<scope>test</scope>
		</dependency>

		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-mail</artifactId>
		</dependency>

		<!-- <dependency> <groupId>org.springframework.session</groupId> <artifactId>spring-session-core</artifactId> 
			</dependency> <dependency> <groupId>org.springframework.session</groupId> 
			<artifactId>spring-session-jdbc</artifactId> </dependency> -->
		<!-- https://mvnrepository.com/artifact/net.sf.jasperreports/jasperreports -->
		<dependency>
			<groupId>net.sf.jasperreports</groupId>
			<artifactId>jasperreports</artifactId>
			<version>6.11.0</version>
		</dependency>

		<dependency>
			<groupId>log4j</groupId>
			<artifactId>log4j</artifactId>
			<version>1.2.17</version>
		</dependency>


		<!-- JWT dependencies -->

		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-security</artifactId>
		</dependency>

		<dependency>
			<groupId>io.jsonwebtoken</groupId>
			<artifactId>jjwt</artifactId>
			<version>0.9.1</version>
		</dependency>
		<!-- <dependency> <groupId>org.springframework.security</groupId> <artifactId>spring-security-test</artifactId> 
			<scope>test</scope> </dependency> -->
	</dependencies>



	<build>
		<plugins>
			<plugin>
				<groupId>org.springframework.boot</groupId>
				<artifactId>spring-boot-maven-plugin</artifactId>
			</plugin>
		</plugins>
		<pluginManagement>
			<plugins>
				<plugin>
					<groupId>org.apache.maven.plugins</groupId>
					<artifactId>maven-war-plugin</artifactId>
					<version>${maven-war-plugin.version}</version>
					<executions>
						<execution>
							<goals>
								<goal>war</goal>
							</goals>
							<phase>package</phase>
						</execution>
					</executions>
					<configuration>
						<warSourceIncludes>WEB-INF/**,META-INF/**</warSourceIncludes>
						<failOnMissingWebXml>false</failOnMissingWebXml>
						<warSourceDirectory>target/classes/static/</warSourceDirectory>
						<webResources>
							<resource>
								<directory>src/main/webapp</directory>
								<includes>
									<include>WEB-INF/**</include>
								</includes>
							</resource>
						</webResources>
					</configuration>
				</plugin>
			</plugins>
		</pluginManagement>
	</build>

	<profiles>
		<profile>
			<id>war</id>
			<build>
				<plugins>
					<plugin>
						<groupId>org.springframework.boot</groupId>
						<artifactId>spring-boot-maven-plugin</artifactId>
					</plugin>
				</plugins>
			</build>
		</profile>
	</profiles>



</project>
	 * ORSResponse(true); return res; }
	 */
	@Autowired
	private RoleServiceInt roleService;
	
	@GetMapping("/preload")
	public ORSResponse preload() {
		System.out.println("inside preload");
		ORSResponse res = new ORSResponse(true);
		RoleDTO dto = new RoleDTO();
		dto.setStatus(RoleDTO.ACTIVE);
		List<DropdownList> list = roleService.search(dto, userContext);
		res.addResult("roleList", list);
		return res;
	}

	@GetMapping("name/{name}")
	public ORSResponse get(@PathVariable String name) {
		ORSResponse res = new ORSResponse(true);
		RoleDTO dto = baseService.findByName(name, userContext);
		System.out.println("Role " + dto);
		if (dto != null) {
			res.addData(dto);
		} else {
			res.setSuccess(false);
			res.addMessage("Record not found");
		}
		return res;
	}

}
