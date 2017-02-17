package com.abonado.jsr353;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.json.Json;
import javax.json.stream.JsonParser;
import javax.json.stream.JsonParser.Event;

import com.abonado.jsr353.model.DateUtil;
import com.abonado.jsr353.model.Employee;

public class JSONArrayParserExample {

	public static void main(String[] args) {
		new JSONArrayParserExample().readJsonInStreamModel();

	}
	
	public void readJsonInStreamModel(){
		InputStream is = getClass().getResourceAsStream("/emp-array.json");
		JsonParser jsonParser = Json.createParser(is);
		Employee emp = null;
		List<Employee> employeeList = new ArrayList<Employee>();
		
		while(jsonParser.hasNext()){
			
			Event event = jsonParser.next();
			if(event.equals(JsonParser.Event.START_OBJECT)) {
				emp = new Employee();
				employeeList.add(emp);
			}else if(event.equals(JsonParser.Event.KEY_NAME)){
				String keyName = jsonParser.getString();
				
				switch(keyName){
					case "firstName":
						jsonParser.next();
						emp.setFirstName(jsonParser.getString());
						break;
					case "lastName":
						jsonParser.next();
						emp.setLastName(jsonParser.getString());
						break;
					case "hireDate":
						jsonParser.next();
						emp.setHireDate(DateUtil.getDate(jsonParser.getString()));
						break;
				}
			}
			
		}
		
		for(Employee e: employeeList)
		{
			System.out.println(e.toString());
		}
	}

}
