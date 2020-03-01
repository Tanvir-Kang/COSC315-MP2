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
	static List<Request> ll = new LinkedList<Request>();
	static List<Request> queue = Collections.synchronizedList(ll);

	public static void main(String[] args) throws InterruptedException {
		getInput();
		//slave threads to go to their own function or class and check queue for work 
		generateRequests();
		
	}
	
	/*
	 * This is the "Master Thread" generating Requests 
	 * called from main, it runs  do..while(true) structure
	 * it creates a request, checks the queue, then decides what function to call
	 *  
	 * */
	private static void generateRequests() throws InterruptedException  {
	
		int jobLength;
		int jobID = 0;
		boolean status; 
		do {
			jobID++;
			jobLength = new Random().nextInt((M+1) - 1) + 1; //random number with M > value > 1 
			Request request = new Request(jobID, jobLength);
			request.info();
			status = checkQueue();
			if (status ==true) {
				add(request);
				}
			else {
				wait(request);
			} 
			Thread.sleep(jobLength * 1000); //puts the master to sleep after checking queue
		}
		while(true);
		
	}
//this function will cause main to sleep, check queue again, then add the request and then sleep again
	private static void wait(Request r) throws InterruptedException {
//it will keep on sleeping for 0.5 seconds until the queue is finally free
		do {
			Thread.sleep(500);
		}
		while (checkQueue()==false);//do this while queue is still full
		add(r);//if condition is false then go to add the request to queue
		
	}

	private static void add(Request r) {
//have to secure this with monitors still but:
		queue.add(r);
		return;
	}

	public static boolean checkQueue () {
		return queue.size() < N? true : false;
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
