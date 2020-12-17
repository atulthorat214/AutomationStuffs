package com.RestAssuared;

import org.junit.Test;
//import org.testng.annotations.DataProvider;

import groovy.grape.GrapeIvy;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import utility.ReusableMthods;
import utility.payload;

import static io.restassured.RestAssured.*;
public class dynamicLibAPI {
	
	//@org.testng.annotations.Test(dataProvider = "Booksdata")
	public void addBook(String isbn, String aisle)
	{
		
		
		RestAssured.baseURI="http://216.10.245.166";
		
		String response=given().log().all().header("Content-Type","application/json").
		body(payload.addBookData(isbn,aisle)).when().post("Library/Addbook.php").
		then().log().all().assertThat().statusCode(200).extract().response().asString();
  
	    JsonPath js=ReusableMthods.rawJson(response);
	    
	    String id=js.getString("ID");
	    
	    System.out.println("ID is=="+id);
	}

	
	//@DataProvider(name="Booksdata")
	public Object getData() {

		return new Object[][]

		{

				{ "erer", "345" }, { "fdfd", "454" }, { "ewr", "fdgd56" }

		};

	}
}
