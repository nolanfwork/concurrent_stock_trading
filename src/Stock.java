import java.io.FileNotFoundException;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import com.google.gson.JsonSyntaxException;

public class Stock {
    /**
	 * Here: all the needed class members and their getters and setters
	 */
	private List<Data> data = null;

	public Stock() {}
	public Stock(List<Data> data) {
		super();
		this.data = data;
		}

		public List<Data> getData() {
		return data;
		}

		public void setData(List<Data> data) {
		this.data = data;
		}
		private boolean validDataRepete() {
			List<String> tickers = new CopyOnWriteArrayList<>();
			for (int i = 0; i < data.size(); i++) {
				if (!tickers.contains(data.get(i).getTicker())) {
					tickers.add(data.get(i).getTicker());
				}
				else {
					return false;
				}
			}
			return true;
			
		}
		public boolean validateStock() {
			if (!validDataRepete()) {System.out.println("Stock information repeated."); return false;}//check if repetition
			for (int i = 0; i < data.size(); i++) {
				int x = data.get(i).validateData();
				if (x==1) {
					System.out.println("Stock name null.");
					return false;
				}
				if (x==2) {
					System.out.println("Stock ticker null.");
					return false;
				}
				if (x==3) {
					System.out.println("Stock start date null.");
					return false;
				}
				if (x==4) {
					System.out.println("Stock brokers null.");
					return false;
				}
				if (x==5) {
					System.out.println("Stock description null.");
					return false;
				}
				if (x==6) {
					System.out.println("Stock exchange code null.");
					return false;
				}
				if (x==7) {
					System.out.println("Stock name malformed.");
					return false;
				}
				if (x==8) {
					System.out.println("Stock ticker malformed.");
					return false;
				}
				if (x==9) {
					System.out.println("Stock start date malformed.");
					return false;
				}
				if (x==10) {
					System.out.println("Stock brokers malformed.");
					return false;
				}
				if (x==11) {
					System.out.println("Stock exchange code malformed.");
					return false;
				}
				
			}
			
			return true;
		}

}

