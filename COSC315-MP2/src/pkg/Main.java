package pkg;

import java.util.Scanner;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.lang.*;


public class Main {
	static int N;
	static int M;
	/*first creates a new linked list with <Request> data type
	 * and then the list called queue is a synchronized list that holds the
	 * linked list within that in order to prevent concurrency errors */
	List<Request> ll = new LinkedList<Request>();
	List<Request> queue = Collections.synchronizedList(ll);

	public static void main(String[] args) throws InterruptedException {
		getInput();
		//slave threads to go to their own function or class and check queue for work 
		getToWork();
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
			
			Thread.sleep(jobLength * 1000); //puts the master to sleep after checking queue
		}
		while(true);
		
	}
	public boolean checkQueue () {
		
		return false;
		
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
