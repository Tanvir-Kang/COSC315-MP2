package pkg;

import java.util.Scanner;

public class Main {
	static int N;
	static int M;

	public static void main(String[] args) {
		getInput();
		System.out.println(M + N);
	
	}
	
	
	//This function is called first from main to retrieve M and N, and performs some basic data validation 
	//Will prompt repeatedly if M or N inputed is less then 0 
	public static void getInput() {
		Scanner in = new Scanner(System.in);
		System.out.println("Info: \nN = The number of slave threads and size of input buffer (POSITIVE INT). M = Max seconds of any one request can take (POSITIVE INT)");
		
		do {
			System.out.println("Please enter N");
			N = in.nextInt();
			
		}
		while (N < 0);
		
		do {
		System.out.println("Please enter M");
		M = in.nextInt();
			}
		while(M < 0);
		
		}

}
