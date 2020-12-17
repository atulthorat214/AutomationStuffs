package com.RestAssuared;

import org.junit.Test;

import io.restassured.path.json.JsonPath;
import utility.payload;

public class complexJson {
	
	
	@Test
	public void complxJsn()
	{
		
		JsonPath js=new JsonPath(payload.coursePrice());
		
		int count=js.getInt("courses.size()");
		
		System.out.println(count);
	}

}
