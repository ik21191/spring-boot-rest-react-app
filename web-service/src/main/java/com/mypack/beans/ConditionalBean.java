package com.mypack.beans;

/**Spring will create object of this class based on condition e.g. ConditionalOnProperty*/
public class ConditionalBean {
	public ConditionalBean() {
		System.out.println("Object of ConditionalBean created.");
	}
}
