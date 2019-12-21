package hackerrank.com.chikoinc.supportclass;

public class RandomNumberGenerator {
	static void startThread() {
		
	}
	public static void main(String[] args) {
		Runnable task = () -> {
	        try {
	            while (true) {
	                Thread.sleep(5000);
	            	System.out.println(System.currentTimeMillis());
	            }
	        } catch(InterruptedException e) {
	        	e.printStackTrace();
	        }
	    };

	    Thread thread = new Thread(task);
	    thread.start();
	}
}
