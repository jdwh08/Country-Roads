package hw;

import java.util.concurrent.TimeUnit;

public class HelloWorld {
	public static void main(String[] args) {
		String[] westVirginia = {"Almost heaven, ", "West Virginia,", 
				"Blue Ridge Mountain, ", "Shenandoah River",
				"Life is old there, ", "older than the trees,",
				"Younger than the mountains,", "blowing like a breeze",
				"Country Roads, ", "take me home",
				"To the place I belong,",
				"West Virginia,",
				"Mountain Momma, ", "take me home",
				"Country roads"};
		
		for(int i = 0; i < westVirginia.length; i++) {
			System.out.println(westVirginia[i]);
			
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
