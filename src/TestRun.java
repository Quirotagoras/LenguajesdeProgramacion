import org.apache.commons.lang3.time.StopWatch;
import java.util.Scanner;



public class TestRun {

    public static void main(String[]args){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Which week do you want to know my predictions ");
        String username = scanner.next();
        int jornada=Integer.parseInt(username);

        StopWatch performance = new StopWatch();
        performance.start();


        CreateResult res=new CreateResult(jornada);
        Thread res1 = new Thread(res);

        res1.start();


        try{
            res1.join();
        }catch(InterruptedException e){

        }
        performance.stop();
        long nn=performance.getNanoTime();
        System.out.println("Execution time is: "+ nn + " nanoseconds");




    }
}
