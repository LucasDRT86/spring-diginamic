package fr.diginamic.hello.controleurs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloControleur {
	
	@Autowired
	private HelloService hello;
	
	@GetMapping
	public String direHello() {
		return hello.salutation();
	}
}
