
import java.util.concurrent.*;

public class Trade extends Thread {
	private Semaphore sem;
	private String ticker;
	private Integer num_stocks;
	public Trade(){}
	public Trade(Task t, Semaphore s) {
		ticker=t.getFlicker();
		num_stocks=t.getTrade();
		sem = s;
	}

	/**
	 * Trading function using locks
	 */
	public void run() {
		try {
			sem.acquire();
			if (num_stocks < 0) {
				String begin = (" Starting sale of "+Math.abs(num_stocks)+" stocks of "+ticker);
				System.out.println(Utility.getZeroTimestamp()+begin);
				Thread.sleep(1000);
				String end = (" Finished sale of "+Math.abs(num_stocks)+" stocks of "+ticker);
				System.out.println(Utility.getZeroTimestamp()+end);
			}
			else if (num_stocks > 0) {
				String begin = (" Starting purchase of "+num_stocks+" stocks of "+ticker);
				System.out.println(Utility.getZeroTimestamp()+begin);
				Thread.sleep(1000);	
				String end = (" Finished purchase of "+num_stocks+" stocks of "+ticker);
				System.out.println(Utility.getZeroTimestamp()+end);
			}
		}
		catch(InterruptedException e) {
			e.printStackTrace();
		}
		finally {sem.release();}
	}
}
