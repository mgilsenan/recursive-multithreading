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
        
        if(isDefective(array, firstIndex, lastIndex)){
            if(firstIndex<lastIndex){
                try{
                    creatingthreads();
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }else{
                if(array[midIndex] == 0) {
                    System.out.println("Defective bulbs are:" + midIndex);
                    //defectiveArray.add(midIndex);
                }
                
            }
        }
        
		
	}

    private void creatingthreads() throws InterruptedException {
        FindDefective f1 = new FindDefective(array,firstIndex,midIndex);
        threadcounter++;
        FindDefective f2 = new FindDefective(array, midIndex+1, lastIndex);
        threadcounter++;

        System.out.println("Number of threads created till now: " + threadcounter);
        f1.start();
        f2.start();
        f1.join();
        f2.join();
    }

    private boolean isDefective(int[] arr, int fIndex, int lIndex) {
        for (int i = fIndex; i <= lIndex; i++){
            if (arr[i] == 0){
                return true;
            }
        }
        return false;
    }

    public int getThreadCounter(){
        int counter = threadcounter;
        return counter;
    } 

    // public ArrayList<Integer> getDefectiveArray(){
    //     System.out.println((ArrayList<Integer>) (defectiveArray));
    //     return (ArrayList<Integer>) (defectiveArray);
    // }
}
