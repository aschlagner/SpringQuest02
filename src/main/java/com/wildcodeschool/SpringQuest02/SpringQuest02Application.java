package com.wildcodeschool.SpringQuest02;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.server.ResponseStatusException;

@Controller
@SpringBootApplication
public class SpringQuest02Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringQuest02Application.class, args);
	}

	@GetMapping("/doctor/{incarnationNumber}")
    @ResponseBody
    public String showIncarnatedDoctor(@PathVariable("incarnationNumber") int number) {
		if (number == 9) {
			return "{\"number\": 9, \"name\": \"Christopher Eccleston\"}";
		} else if (number == 10) {
			return "{\"number\": 10, \"name\": \"David Tennant\"}";
		} else if (number == 11) {
			return "{\"number\": 11, \"name\": \"Matt Smith\"}";
		} else if (number == 12) {
			return "{\"number\": 12, \"name\": \"Peter Capaldi\"}";
		} else if (number == 13) {
			return "{\"number\": 13, \"name\": \"Jodie Whittaker\"}";
		} else if (number >= 1 && number <= 8) {
			throw new ResponseStatusException(HttpStatus.SEE_OTHER, "There was an unexpected error. (type=SEE OTHER, status=303)");
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Impossible to retrieve the incarnation " + number + ". (type=NOT FOUND, status=404)");
    	}
	}
}
