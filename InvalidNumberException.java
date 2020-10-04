public class InvalidNumberException extends Exception {
	
	
	public InvalidNumberException() {
		super("Numbers should be between 1 and 0 ");
	}
	public InvalidNumberException(String message){
		super(message);
	}

}
