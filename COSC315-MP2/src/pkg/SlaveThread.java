package pkg;

public class SlaveThread implements Runnable{

	@Override
	public void run() {
		System.out.println("Running from slave thread class");
	}
	
}
