package com.mycompany.app;

import static io.restassured.RestAssured.given;
import org.junit.Test;
//import org.testng.Assert;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import utility.ReusableMthods;
import utility.payload;

import static org.hamcrest.Matchers.*;
//import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class rest {

	@Test
	public void cv() throws IOException {
		RestAssured.baseURI = "https://rahulshettyacademy.com";

		// add place
		String response = given().log().all().queryParam("key", "qaclick123").header("Content-Type", "application/json")
				.body(new String(Files.readAllBytes(Paths.get("C:\\Users\\Atul_Thorat\\Desktop\\addPlace.json")))).when().log().all().post("maps/api/place/add/json").then().log().all().assertThat()
				.statusCode(200).body("scope", equalTo("APP")).extract().response().asString();

		System.out.println(response);

		JsonPath js = new JsonPath(response);

		String placeiD = js.getString("place_id");

		System.out.println("Place Id==" + placeiD);

		// update place

		String UpdAddress = "Test sadasdas";

		given().log().all().queryParam("key", "qaclick123").header("Content-Type", "application/json")
				.body("{\r\n" + "\"place_id\":\"" + placeiD + "\",\r\n" + "\"address\":\"" + UpdAddress + "\",\r\n"
						+ "\"key\":\"qaclick123\"\r\n" + "}\r\n" + "")
				.when().log().all().put("maps/api/place/update/json").then().log().all().assertThat().statusCode(200)
				.body("msg", equalTo("Address successfully updated"));

		// get place

		String getplacerespone = given().log().all().queryParam("key", "qaclick123").queryParam("place_id", placeiD)
				.when().log().all().get("maps/api/place/get/json").then().assertThat().log().all().statusCode(200).extract()
				.response().asString();

		//JsonPath js1 = new JsonPath(getplacerespone);
		JsonPath js1=ReusableMthods.rawJson(getplacerespone);
		String actualAddress = js1.getString("address");
		
		//Assert.assertEquals(actualAddress, UpdAddress);

	}

}
