package br.ce.wcaquino.tasks.apitest;

import org.junit.BeforeClass;
import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class APITest {
	
	@BeforeClass
	public static void setup() {
		RestAssured.baseURI = "http://localhost:8001/tasks-backend/";
	}
	
	@Test
	public void deveRetornarTarefas() {
		RestAssured.given()
		.when()
			.get("todo")
		.then()
			.statusCode(200)
			.log().all();	
	}
	
	@Test
	public void deveAddTarefa() {
		RestAssured.given()
		.body("{\"task\":\"Silas3\",\"dueDate\":\"2020-12-12\"}")
		.contentType(ContentType.JSON)
		.when()
			.post("todo")
		.then()
			.statusCode(201)
			.log().all();	
	}
}
