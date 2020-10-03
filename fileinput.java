
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

				arr[i++] = myReader.nextInt();

			}
			myReader.close();

		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		} 
		System.out.println(Arrays.toString(arr));
		for(int m=0;m<arr.length;m++)
			if(arr[m]!=0&& arr[m]!=1) {
				System.out.println("array doesnt contains 1 or 0");

			}
		return arr;
	}


}