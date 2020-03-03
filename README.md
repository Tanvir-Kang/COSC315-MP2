# COSC315-MP2
COSC315 Mini-project 2: Implementation of multi-threaded request scheduler using Java and monitors, followed by C++ and semaphores
How to Compile and Run

On your desktop create a folder named anything
In the newly created folder, create two more folders, the first is called “Source” and the second is “classes”
Using the provided three .java files copy and paste “Main.java”, “SlaveThread.java”, and “request.java” to the source folder
Open the terminal, and navigate into the source directory with the java files 
Execute the following command “javac -d ../classes *.java” 
This creates “className.class” objects in the classes folder
(Not in terminal), create a text file, and type the following “Main-Class: pkg.Main” followed by enter(carriage return). 
Save the file as “manifest.txt” in the classes folder
In the terminal enter cd ../classes, now we should be in the classes folder with one file called manifest and a pkg folder that holds all the “className.class” files
Enter “jar -cvmf manifest.txt assignment.jar pkg/*.class”
This will create a .jar file called assignment.jar, using the classes in pkg folder
To run this program, ensure you are in the directory where it is located and enter the following command “java -jar assignment.jar”
The program should now have started in the existing terminal window
Note: This is a .jar file and cannot be clicked on to run however, it must be launched from terminal using the provided instructions. If this does not work for you, there is an additional picture guide walkthrough of the steps taken for proof on concept. 

Functions and Usage
void getInput()
Get Input Prompts the user for input, where N is the number of slave threads and size of the input buffer, and M is the maximum number of seconds any one request can take. Both N and M are positive integers.
void createSlaves()
	Creates a new array of SlaveThread objects, as well as a new Thread array that creates the runnable slave instances, both of these arrays are of length N, where N is specific by the input from the user with the getInput() function. createSlaves returns the program flow back to the main function.
void generateRequests()
	This is the master thread that generates requests. It first calls the startSlaves() function, then runs a do-while loop, where it creates a request and checks the queue by calling checkQueue(). If checkQueue() returns true, then add(request) is called. If checkQueue() returns false, then wait(request) is called, and the master Thread is put to sleep for 1 second. 
void startSlaves()
	This will start executing the slave threads in a first-in, first-out basis, until there are no more threads to start. 
void wait(Request r)
	This will cause the main Thread to sleep for 500 milliseconds, then check the queue to see if it is full. If it’s full, it will sleep for another 500 milliseconds and repeat this process until the queue is not full. Once the queue is not full, it will add the request to the queue and return execution back to the calling function.
void add(Request r)
	Adds the request, passed in as the parameter, to the queue. 
boolean checkQueue()
	checkQueue looks to see if the queue is full by checking if the size of the queue is equal to N, specified by the input from the getInput() function. The function returns a boolean value back to the calling function. If the queue is full, it will return false. If the queue is not full, then it will return true.
Int getN()
	Returns the value of N, which is given from the input from the user with the getInput() function.


