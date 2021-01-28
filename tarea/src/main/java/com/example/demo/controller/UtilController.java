package com.example.demo.controller;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.LocaleResolver;

public class UtilController {

	private LocaleResolver localResolver;

	private HttpServletRequest httpServletRequest;

	private HttpServletResponse httpServletResponse;

	public ResponseEntity<Void> changeLocale(@PathVariable("loc") String loc) {

		Locale userLocale = null;

		switch (loc) {
		case "en":
			userLocale = Locale.ENGLISH;
			break;
		case "fr":
			userLocale = Locale.FRENCH;
			break;
		default:
			userLocale = Locale.ROOT;
			break;
		}
		localResolver.setLocale(httpServletRequest, httpServletResponse, userLocale);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

}
