package com.miguelbarrios.exerciseservice.exceptions;

public class ExerciseNotFoundException extends RuntimeException {

	public ExerciseNotFoundException(String message) {
		super(message);
	}
}
