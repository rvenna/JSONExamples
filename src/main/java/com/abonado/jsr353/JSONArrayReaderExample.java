package com.abonado.jsr353;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.json.JsonReader;
import javax.json.JsonValue;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;

import com.abonado.jsr353.model.*;

public class JSONArrayReaderExample {
	
	public static void main(String[] args){
		try{
			JSONArrayReaderExample jre = new JSONArrayReaderExample();
			jre.readContentFromJSONFile();
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	/*
	 * 1. Create InputStream and Reader
	 * 2. Create JsonReader using Json factory and Reader
	 * 3. Create JsonArray by calling readArray() on JsonReader
	 * 4. Loop through JsonArray, convert each JsonValue in array into JsonObject
	 */
	public void readContentFromJSONFile() throws Exception{
		InputStream is = getClass().getResourceAsStream("/emp-array.json");
		//InputStream is = getClass().getClassLoader().getResourceAsStream("emp-array.json"); with out / in filename
				
		Reader reader = new InputStreamReader(is, "UTF-8");
		
		JsonReader jsonReader = Json.createReader(reader);
		JsonArray employeeJsonArray = jsonReader.readArray();
		
		List<Employee> employeeList = new ArrayList<Employee>();
		for(JsonValue jsonValue: employeeJsonArray){
			if(jsonValue.getValueType().equals(JsonValue.ValueType.OBJECT)){
				JsonObject jsonObject = (JsonObject)jsonValue;
				Employee emp = new Employee();
				emp.setFirstName(jsonObject.getString("firstName"));
				emp.setLastName(jsonObject.getString("lastName"));
				emp.setEmail(jsonObject.getString("email"));
				emp.setEmployeeId(jsonObject.getInt("employeeId"));
			    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			    Date hireDate = dateFormat.parse(jsonObject.getString("hireDate"));
				emp.setHireDate(hireDate);
				employeeList.add(emp);
			}
		}
		
		for(Employee e: employeeList){
			System.out.println(e.toString());
		}
		
	}

}
