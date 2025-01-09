// package com.exceptions.bicycle;

public class NegativeSpeedException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public NegativeSpeedException() {
		super("Cannot go a negative speed!");
	}

}