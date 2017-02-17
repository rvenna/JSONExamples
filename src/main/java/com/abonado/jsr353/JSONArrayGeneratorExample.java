package com.abonado.jsr353;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.json.Json;
import javax.json.stream.JsonGenerator;

import com.abonado.jsr353.model.Employee;

public class JSONArrayGeneratorExample {

	public static void main(String[] args) throws Exception{
           new JSONArrayGeneratorExample().generateJSONArray();
	}
	
	public void generateJSONArray() throws Exception{
	      List<Employee> employeeList = getEmployeeList();	
	      OutputStream os = new FileOutputStream("emp-array-output-stream.json");
	      JsonGenerator jsonGenerator = Json.createGenerator(os);
	      jsonGenerator.writeStartArray();
	      
	      for(Employee e:employeeList){
	    	  jsonGenerator.writeStartObject()
	    	               .write("fistName",e.getFirstName())
	    	               .write("lastName",e.getLastName())
	    	               .writeEnd();
	      }
	      
	      jsonGenerator.writeEnd();
	      jsonGenerator.close();
	      os.close();
	      
	      
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
