package pkg;

public class Request {
	int id;
	int lengthReq;
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getLengthReq() {
		return lengthReq;
	}

	public void setLengthReq(int lengthReq) {
		this.lengthReq = lengthReq;
	}

	public void info() {
		System.out.println("ID: "+getId());
		System.out.println("Request Length: "+getLengthReq());
	}
	
	public Request(int i, int j) {
		id = i;
		lengthReq = j;
	}
}