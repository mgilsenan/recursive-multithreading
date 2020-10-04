public class InvalidNumberException extends Exception {
	
	
	public InvalidNumberException() {
		super("File should contain only 1 or 0 ");
	}
	public InvalidNumberException(String message){
		super(message);
	}

}
