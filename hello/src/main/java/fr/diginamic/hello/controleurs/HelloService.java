package fr.diginamic.hello.controleurs;

import org.springframework.stereotype.Service;

@Service
public class HelloService {
	
	public String salutation() {
		return "Je suis la clas1se de service et je vous dis Bonjour";
	}
}
