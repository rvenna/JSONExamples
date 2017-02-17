package com.abonado.jsr353;

import com.abonado.jsr353.model.*;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.*;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonWriter;

public class JSONArrayWriterExample {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		new JSONArrayWriterExample().convertObjArrayToJSONArray();

	}
	
	public void convertObjArrayToJSONArray() throws Exception{
		List<Employee> empList = getEmployeeList();
		JsonArrayBuilder jsonArrayBuilder = Json.createArrayBuilder();
		
		for(Employee emp: empList){
			jsonArrayBuilder.add(Json.createObjectBuilder()
					             .add("firstName", emp.getFirstName())
					             .add("lastName", emp.getLastName())
					             .add("employeeId", emp.getEmployeeId())
					             .add("hireDate", "2016-08-12")
					             .add("email", emp.getEmail())
					        );
		}
		JsonArray empJsonArray = jsonArrayBuilder.build();
		System.out.println(empJsonArray.toString());
		
		
		OutputStream outputStream = new FileOutputStream
		  ("emp-array-output.json");
		JsonWriter jsonWriter = Json.createWriter(outputStream);
		jsonWriter.writeArray(empJsonArray);

		
		outputStream.close();
		jsonWriter.close();
	}
	
	public List<Employee> getEmployeeList() throws Exception{
		List<Employee> empList = new ArrayList<Employee>();
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date hireDate = sdf.parse("2016-11-06");
		
		 Employee emp1 = new Employee("Echo","Chen","e.c@gmail.com",1,hireDate);
		 Employee emp2 = new Employee("Cath","xion","c.x@gmail.com",2,hireDate);
		 
		 empList.add(emp1);
		 empList.add(emp2);
		 
		 return empList;
		
	}

}
