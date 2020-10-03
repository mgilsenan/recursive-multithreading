import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Arrays;
import java.util.Scanner; // Import the Scanner class to read text files

public class fileinput {

	public static int[] readFile(String fileName) {
		int arr[] = null;

		try {
			File myObj = new File(fileName);

			Scanner myReader = new Scanner(myObj);

			int size=myReader.nextInt();

			int i=0;

			arr=new int[size];

			while (myReader.hasNextInt()) {
			arr[i] = myReader.nextInt();
			if(arr[i]<0 || arr[i]>1)
			throw new InvalidNumberException();
			i++;
			}
			if (i != size) {
				System.out.println("not enough numbers");
				myReader.close();
				System.exit(1);
				
			}
			myReader.close();

		} 

		catch (FileNotFoundException e) {
			System.out.println("An error occurred. ");
			e.printStackTrace();
		} 
		catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("Array out of bounds ");
			System.exit(1);
		}
		catch(InvalidNumberException e) {
			System.out.println(e.getMessage());
			System.exit(1);
		}


		System.out.println(Arrays.toString(arr));



		return arr;
	}


}