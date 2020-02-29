package pkg;

public class Main {

	public static void main(String[] args) {
		Request r1 = new Request(1,5);
		r1.info();
		System.out.println(r1.getId());
		System.out.println(r1.getLengthReq());

	}

}
