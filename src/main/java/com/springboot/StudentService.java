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

}
