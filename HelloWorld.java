import java.util.Random;

class HelloWorld {
	public static void main(String[] args) {
		Random random = new Random();
		for(int i=0; i<50; i++) {
			System.out.print(5 + random.nextInt(10) + " ");
		}
	}
}