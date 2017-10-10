package com.prateek.SocialLogin;

import com.google.gson.Gson; 
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class GsonUtils {

	static Gson gson = new Gson();

	public static String getJsonElementString(String name, String data) {
		try {
			JsonObject json = (JsonObject) new JsonParser().parse(data);
			
			System.out.println(json.get(name).getAsString());
			
			return json.get(name).getAsString();
			
		} catch (Exception localException) {
			
			localException.printStackTrace();
		}
		return null;
	}

}
