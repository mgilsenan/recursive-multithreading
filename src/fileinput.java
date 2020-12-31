import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files

public class fileinput {

	public static int[] readFile(String fileName) {
		int findDefectiveArray[] = null;

		try {
			File inputFile = new File(fileName);

			Scanner fileReader = new Scanner(inputFile);

			int fileSize = fileReader.nextInt();

			int index = 0;

			findDefectiveArray = new int[fileSize];

			while (fileReader.hasNextInt()) {

				findDefectiveArray[index] = fileReader.nextInt();

				checkFormat(findDefectiveArray, index);

				index++;
			}

			checkFileSize(fileReader, fileSize, index);

			fileReader.close();

		} 
		catch (FileNotFoundException e) {
			System.out.println("File cannot be found");
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

		return findDefectiveArray;
	}

	private static void checkFileSize(Scanner fileReader, int fileSize, int lastIndex) {
		if (lastIndex != fileSize) {
			System.out.println("not enough numbers");
			fileReader.close();
			System.exit(1);
			
		}
	}

	private static void checkFormat(int[] findDefectiveArray, int index) throws InvalidNumberException {
		if(findDefectiveArray[index] < 0 || findDefectiveArray[index] > 1)
		throw new InvalidNumberException();
		
	}


}