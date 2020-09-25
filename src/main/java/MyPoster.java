import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MyPoster implements Runnable{
    public static void main(String[] args) {
        //  The start() method of thread class is used to begin the execution of thread.
        //  The result of this method is two threads that are running concurrently: the current thread
        //  (which returns from the call to the start method) and the other thread (which executes its run method).
        //  The start() method internally calls the run() method of Runnable interface to execute the code specified in the run() method
        //  in a separate thread.
        new Thread(new MyPoster()).start();
    }
    public void run() {
        //this int includes numbers of buildings
        int numberOfBuildings;
        //this table is create in order to save buildings highests
        int[] table;

        try {
            //i use bufferReader
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            String string = bufferedReader.readLine();
            //very usefull object stringTokanizer :)
            StringTokenizer stringTokenizer = new StringTokenizer(string);
            //use parse int in order to same number od buildings
            numberOfBuildings = Integer.parseInt(stringTokenizer.nextToken());

            //1 condition from the task
            if (numberOfBuildings > 250000 || numberOfBuildings < 1) {
                throw new RuntimeException("Numbers of building must be greater than 0 and less than 250 001 ");
            }

            //result - number of posters
            int result = 0;
            int i = 0;
            //table initialization
            table = new int[numberOfBuildings];
            //result number of posters
            int result2=0;
            //do while loop - one of the solution
            do {
                string = bufferedReader.readLine();
                stringTokenizer = new StringTokenizer(string);
                stringTokenizer.nextToken();
                //save last element in line
                int numberToCompare = Integer.parseInt(stringTokenizer.nextToken());

                //2 condition from the task
                if (numberToCompare > 1000000000 || numberToCompare < 1) {
                    throw new RuntimeException("\n" +
                            "Height of the building must be greater than 0 and less than 1 000 000 001");
                }
                //first iteration
                while (result2 > 0 && table[result2-1]>numberToCompare) {
                    //checking if the height of the next building is different from the height of the previous building
                    result++;
                    result2--;
                }
                if (result2 == 0 || table[result2-1]<numberToCompare) {
                    table[result2] = numberToCompare;
                    result2++;
                    //always at least 1 poster
                }
                i++;
            }
            //condition ending a loop
            while (i < numberOfBuildings);
            //print out number of posters
            System.out.println(result+result2);
        }
        //runtime exceptions
        catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
