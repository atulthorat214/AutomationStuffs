package com.mycompany.app;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import io.restassured.RestAssured;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
	
	App ap=new App();
	
	int c;
    @Test
    public void shouldAnswerWithTrue()
    {
        System.out.println("This is JUNIT Test First ");
        
       
        
        for(int i=0;i<10;i++)
        {
        	c=c+i;
        	System.out.println(c);
        	System.out.println("HJJGGHGJHG");
        }
    }
    
    @Test
    public void demoTestTwo()
    {
       System.out.println("This is JUNIT Test Second");
    	
    	ap.demoaddTest(12, 13);
    }
    

	@Test
	public void cv() {
		RestAssured.baseURI = "https://rahulshettyacademy.com";

		given().log().all().queryParam("key", "qaclick123").header("Content-Type", "application/json")
				.body("{\r\n" + "  \"location\": {\r\n" + "    \"lat\": -38.383494,\r\n" + "    \"lng\": 33.427362\r\n"
						+ "  },\r\n" + "  \"accuracy\": 50,\r\n" + "  \"name\": \"test house\",\r\n"
						+ "  \"phone_number\": \"(+91) 983 893 3937\",\r\n"
						+ "  \"address\": \"29, side layout, cohen 09\",\r\n" + "  \"types\": [\r\n"
						+ "    \"shoe park\",\r\n" + "    \"shop\"\r\n" + "  ],\r\n"
						+ "  \"website\": \"http://google.com\",\r\n" + "  \"language\": \"French-IN\"\r\n" + "}")
				.when().post("maps/api/place/add/json").then().log().all().assertThat().statusCode(200);

	}
}
