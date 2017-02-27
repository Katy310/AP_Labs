
public class mainClass {
	public static void main(String[] args) {
		producer p1 = new producer();
		producer2 p2 = new producer2();
		producer3 p3 = new producer3();
		p1.start();
		p2.start();
		p3.start();
		
	}
}
