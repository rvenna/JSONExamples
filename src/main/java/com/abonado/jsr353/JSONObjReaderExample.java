package com.abonado.jsr353;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;

import com.abonado.jsr353.model.Employee;

public class JSONObjReaderExample {

	public static void main(String[] args) throws Exception{
		JSONObjReaderExample jore = new JSONObjReaderExample();
		jore.readJsonObject();
	}
	
	public void readJsonObject() throws Exception{
		InputStream is = getClass().getClassLoader().getResourceAsStream("emp-obj.json");
		
		Reader reader = new InputStreamReader(is);
		JsonReader jsonReader = Json.createReader(reader);
				
		JsonObject jsonObj = jsonReader.readObject();
		Employee emp = new Employee();
		emp.setFirstName(jsonObj.getString("firstName"));
		emp.setLastName(jsonObj.getString("lastName"));
		System.out.println(emp.getFirstName());
		System.out.println(emp.getLastName());
		
		if(is != null){
			is.close();
		}
		if(reader != null) {
			reader.close();
		}
		if(jsonReader != null){
			jsonReader.close();
		}
		
	}

}
