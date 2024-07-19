package com.kh.portfolio.test;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/req")
public class RequestController {
	
	private static Logger logger =
		LoggerFactory.getLogger(RequestController.class);
	
	//1)HttpRequest객체이용
	@GetMapping("/1")
	public void req1(HttpServletRequest req) {
		logger.info("void req1() 호출됨!");
		
		String name = req.getParameter("name");
		String age = req.getParameter("age");
		
		logger.info("name="	+ name);
		logger.info("age="	+ Integer.parseInt(age));
	}
	//2)@RequestParam 사용
	@GetMapping("/2")
	public void req2(
			@RequestParam("name") String rename, 
			@RequestParam("age") int reage) {
		logger.info("void req2() 호출됨!");
		
		
		logger.info("name="	+ rename);
		logger.info("age="	+ reage);
	}
	@GetMapping("/3")
	public void req3(
			@RequestParam Map<String,String> map) {
		logger.info("void req3() 호출됨!");
		
		logger.info("name="	+ map.get("name"));
		logger.info("age="	+ map.get("age"));
	}
	@GetMapping("/4")
	public void req4(Person person) {
		logger.info("void req4() 호출됨!");
		
		logger.info("name="	+ person.getName());
		logger.info("age="	+ person.getAge());
	}
	
}







