/* Displays the first n Fibonacci numbers */

import acm.program.*;

public class Fibonacci extends ConsoleProgram {
	public void run() {
		int n =readInt("Enter n. ");
		println("F(1) = 0.");
		println("F(2) = 1.");
		int sum=1;
		int sum1=0;
		int sum2=0;
		for (int i =3; i<=n ; i++) {
			sum2=0+sum1;
			sum1=0+sum;
			sum=sum1+sum2;
			println("F("+i+") ="+sum+".");
		}
		
	}

}
