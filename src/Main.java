
import java.io.*;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
                //file is read and is returned as an array
                int arrayOfDefectiveBulbs[] = fileinput.readFile("java.txt");

                int length = arrayOfDefectiveBulbs.length;
        
                try{
                        //An instance of findDefective is created, the main thread. The parameters passes to the constructor is the array, its first index, and last index
                        FindDefective fMain = new FindDefective(arrayOfDefectiveBulbs,0,length-1);

                        //The thread is being started. The run method is being called
                        fMain.start();

                        //The join method will wait for the thread to terminate 
                        fMain.join();

                        System.out.println("Defective bulbs are: " + 
                                (fMain.getDefectiveArray())
                                .toString()
                                .replace("[", "")
                                .replace("]", ""));

                        System.out.println("The number of threads for this problem is " + fMain.getThreadCounter());
                }
                catch(Exception e){ 
                        e.printStackTrace();
                }

        
	}
	
}