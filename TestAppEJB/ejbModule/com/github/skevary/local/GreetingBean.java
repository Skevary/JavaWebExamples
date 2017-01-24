package com.github.skevary.local;

import javax.ejb.Stateless;

@Stateless
public class GreetingBean implements GreetingLocal {

	@Override
	public String getMessage(String name) {
		return "Greeting " + name + " !";
	}

}
