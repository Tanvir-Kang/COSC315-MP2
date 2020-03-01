package pkg;

import java.util.Scanner;
import java.util.Random;
import java.lang.*;


public class Main {
	static int N;
	static int M;

	public static void main(String[] args) throws InterruptedException {
		getInput();
		generateRequests();
		
		/*
		 *1. Make a function that randomly generates requests and adds it to an object array
		 *2. Finding how to use threads in java, and creating slave threads */
		
		System.out.println(M + N);
	
	}
	
	//This is the "Master Thread" generating Requests 
	private static void generateRequests() throws InterruptedException  {
	
		int jobLength;
		int jobID = 0;
		do {
			jobID++;
			jobLength = new Random().nextInt((M+1) - 1) + 1; //random number with M > value > 1 
			Request request = new Request(jobID, jobLength);
			request.info();
			Thread.sleep(jobLength * 1000);
		}
		while(true);
		
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
