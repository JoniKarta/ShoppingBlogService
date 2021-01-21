package com.example.demo.validator;

import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Component;

import com.example.demo.utility.TimeEnum;

@Component
public class Validator {

	public Date validDate(String value) {
		TimeEnum timeEnum;
		try {
			timeEnum = TimeEnum.valueOf(value);
		} catch (Exception ex) {
			return null;
		}
		switch (timeEnum) {
		case lastDay:
			return new Date(System.currentTimeMillis() - (TimeUnit.DAYS.toMillis(1))); // day before

		case lastWeek:
			return new Date(System.currentTimeMillis() - (TimeUnit.DAYS.toMillis(7)));// week before

		case lastMonth:
			return new Date(System.currentTimeMillis() - (TimeUnit.DAYS.toMillis(30))); // month before

		default:
			return null;
		}
	}
	
	public boolean validateEmail(String email) {
		if (email == null || email.isEmpty())  return false;
		String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+ 
                "[a-zA-Z0-9_+&*-]+)*@" + 
                "(?:[a-zA-Z0-9-]+\\.)+[a-z" + 
                "A-Z]{2,7}$"; 
		return Pattern.compile(emailRegex,
				Pattern.CASE_INSENSITIVE).matcher(email).matches();
	}

}
