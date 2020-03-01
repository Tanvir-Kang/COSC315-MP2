package pkg;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Request r1 = new Request(1,5);
		r1.info();
		getInput();
	
	}
	
	public static void getInput() {
		Scanner in = new Scanner(System.in);
		System.out.println("Info: \nN = The number of slave threads and size of input buffer (INT). M = Max seconds of any one request can take(N)");
		
		while(true) {
			
		}
		System.out.println("Please enter N: followed by enter");
		int N = in.nextInt();

		System.out.println("Please enter M: followed by enter");
		int M = in.nextInt();
	}

}
