package exceptions;

public class WorkoutNotFoundException extends RuntimeException{
	 public WorkoutNotFoundException() {
		   super();
	 }

	 public WorkoutNotFoundException(String message) {
		   super(message);
	 }

	public WorkoutNotFoundException(String message, Throwable cause) {
			super(message, cause);
	}

	public WorkoutNotFoundException(Throwable cause) {
			super(cause);
	}

}
