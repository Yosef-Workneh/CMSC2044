package application;

public class UnmatchedException extends Exception {


	public UnmatchedException() {
		super();

	}
	public String getMessage () {
		
		return "Passwords do not match";
	}
}
