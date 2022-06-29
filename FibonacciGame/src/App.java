/**
 * @author prasad naik
 *
 */
import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		
		System.out.print("Row : ");
		int row=s.nextInt();
		System.out.println("Column :");
		int col=s.nextInt();
		
		FibonacciGame fibonacciGame=new FibonacciGame(row, col);
		fibonacciGame.start();
		s.close();
		
		

	}

}
