package pkg;

public class SlaveThread extends Main implements Runnable {

	@Override
	public void run() {
		while(true) {
		if (getSize()>0) {
			Request r = queue.get(0);
			try {
				Thread.sleep(r.getLengthReq()*1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			queue.remove(0);
			System.out.println(r.getId() + "removed");

		}
		}
		
	}

	private int getSize() {
			
		return queue.size();
	}
	
	
}
