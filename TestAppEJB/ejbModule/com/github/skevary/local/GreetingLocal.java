package com.github.skevary.local;

import javax.ejb.Local;

@Local
public interface GreetingLocal {
	public String getMessage(String name);
}