package com.springboot;

import java.util.HashMap;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value="/rest/student")
public class StudentService {
	
	@RequestMapping(value="/", method = RequestMethod.GET)
	public HashMap<Long, Student> getAllStudents(){
		return Application.hmStudent;
	}
	
	@RequestMapping(value="/add", method = RequestMethod.POST)
	public Student addStudent(@RequestParam(value="name") String name,
			@RequestParam(value="subject", defaultValue = "unknown") String subject){
		Student student = new Student(name, subject);
		Application.hmStudent.put(new Long(student.getId()), student);
		return student;
	}
	
	@RequestMapping(value="/update", method = RequestMethod.PUT)
	public Student updateStudent(@RequestBody Student student) throws Exception {
		
		if(Application.hmStudent.containsKey(new Long(student.getId()))){
			Application.hmStudent.put(new Long(student.getId()), student);
		}else{
			throw new Exception("Student " + student.getId() + " does not exist");
		}
		
		return student;
	}

}
