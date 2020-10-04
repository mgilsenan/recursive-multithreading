
import java.io.*;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
        // int somearray[] = fileinput.readFile("java.txt");
        
        // System.out.println(Arrays.toString(somearray));
        int [] a = {8,1,1,0,1,1,0,1,1};
        FindDefective test = new FindDefective(a,1,8);
        test.start();

        //System.out.println("Defective bulbs are: " + test.getDefectiveArray());
        System.out.println("The number of threads for this problem is " + test.getThreadCounter());
	}
	
}