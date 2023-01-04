
import java.util.Scanner;
public class Main {
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		System.out.println("Hello! This is an application!");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Type 1 for stopwatch & 2 for current time: ");
		int test = input.nextInt();
		if(test == 1) {
			StopWatch stopwatch = new StopWatch();
		}else if (test == 2){
			new ClockTime();
		}else {
			new TextEditor();
		}
		
	    
	}
}
