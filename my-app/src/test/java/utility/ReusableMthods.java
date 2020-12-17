package utility;

import io.restassured.path.json.JsonPath;

public class ReusableMthods {
	
	public static JsonPath rawJson(String response)
	{
		JsonPath js1 = new JsonPath(response);
		
		return js1;

		
		
	}

}
