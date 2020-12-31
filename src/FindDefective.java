import java.util.ArrayList;
import java.util.List;

public class FindDefective extends Thread {
    private static int threadcounter = 1;

    private int[] array;
    private int firstIndex;
    private int lastIndex;
    private int midIndex;

    static final List<Integer> defectiveArray = new ArrayList<Integer>();
    
    public FindDefective(int[] array, int firstIndex, int lastIndex){
        this.array = array;
        this.firstIndex = firstIndex;
        this.lastIndex = lastIndex;
    }

	//@Override
	public void run() {
        midIndex = (firstIndex+lastIndex)/2;
        
        //The isDefective method will return true if a 0 is found
        if(isDefective(array, firstIndex, lastIndex)){

            //the first and last index will be compared
            if(firstIndex<lastIndex){
                try{
                    //the child threads will be created, it will be done recursively as long as there is a defective bulb
                    creatingthreads();

                }catch (Exception e){
                    e.printStackTrace();
                }

            }else{

                //if the condition is not met, and an array element is equal to zero, it will be added to the defectiveArray
                if(array[midIndex] == 0) {
                    defectiveArray.add(midIndex+1);
                }
                
            }
        }
		
	}

    //the threads will be created recursively, its run method called using start(), and will be terminated using join()
    private void creatingthreads() throws InterruptedException {
        FindDefective f1 = new FindDefective(array,firstIndex,midIndex);
        threadcounter++;

        FindDefective f2 = new FindDefective(array, midIndex+1, lastIndex);
        threadcounter++;
        //System.out.println("Number of threads created till now " + threadcounter );
        f1.start();
        f2.start();
        f1.join();
        f2.join();
    }

    //the method checks for defective elements of array
    private boolean isDefective(int[] arr, int fIndex, int lIndex) {

        for (int i = fIndex; i <= lIndex; i++){
            if (arr[i] == 0){
                return true;
            }
        }

        return false;
    }

    //a get method that returns the defective array
    public ArrayList<Integer> getDefectiveArray(){
        return (ArrayList<Integer>) (defectiveArray);
    }

    //a get method that returns the number of threads created
    public int getThreadCounter(){
        return threadcounter;
    }

}
