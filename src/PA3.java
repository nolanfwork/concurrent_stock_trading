import java.io.*;
import java.lang.reflect.Type;
import java.util.*;
import java.util.concurrent.*;
import com.google.gson.*;

public class PA3 {
	private static Stock stock;
	private static Schedule schedule; 
	private static Map<String, Semaphore> sem;
	private static boolean readStockFile() {
    	 String getfile = "";
    	Gson gson = new GsonBuilder()
    	        .registerTypeAdapter(String.class, new StringTrimJsonDeserializer())
    	        .create();
    	System.out.println("What is the name of the file containing the company information?");
    	Scanner sc = new Scanner(System.in);
    	getfile = sc.nextLine().trim();
    	if (!Patterns.JsonPattern.matcher(getfile).matches()) {
    		System.out.println("Please enter the correct .json/.JSON file.");
    		return false;
    	}
		String content = "";//read json content
		try (Scanner freader =new Scanner(new File(getfile));){
			while (freader.hasNext()) {
				content += freader.nextLine();
			}
			stock = gson.fromJson(content, Stock.class);
			if (!stock.validateStock()) {String errormes = "";throw new JsonParseException(errormes);}
		}
		catch(JsonSyntaxException j) {
			System.out.println("Json syntax error detected. Re-prompt initializing...");
			return false;
		}
		catch (JsonParseException s) {
			System.out.println("Json reading error detected. Re-prompt initializing...");
			return false;
		}
		catch (FileNotFoundException e) {
			System.out.println("Cannot find such a file. Re-prompt initializing...");

			return false;
		}
		catch (Exception a) {
			a.printStackTrace();

			System.out.println("Json reading terminated abnormally.");
			return false;
		}
		System.out.println("=== Json Data accepted ===");
		return true;
    }

    /**
     * Read Stock Trades CSV File inputed by user
     */
    private static boolean readScheduleFile() {
    	schedule = new Schedule();
    	String getfile = "";
    	System.out.println("What is the name of the file containing the schedule information?");
    	Scanner sc = new Scanner(System.in);
    	getfile = sc.nextLine().trim();
    	if (!Patterns.CSVPattern.matcher(getfile).matches()) {
    		System.out.println("Please enter the correct .csv/.CSV file.");
    		return false;
    	}
		try (Scanner freader =new Scanner(new File(getfile));){
			while (freader.hasNext()) {
				String content = "";//read csv content

				content = freader.nextLine().trim();
				if (Patterns.tradePattern.matcher(content).matches()) {
					String[] str = new String[3];
					str = content.split(",");
					StringBuffer buffer = new StringBuffer(str[0]);
					for (int i = 0; i < buffer.length(); i++) {
						if (!Character.isDigit(buffer.charAt(i))) {buffer.setCharAt(i, ' ');}
					}//deal with unidentified garbage value
					str[0] = buffer.toString().trim();
					Integer term1 = Integer.parseInt(str[0]);
					Integer term3 = Integer.parseInt(str[2]);

					schedule.makeTask(term1, str[1], term3);
				}
				else {
					System.out.println("CSV reading error detected. Re-prompt initializing...");
					return false;
				}
			}
			if (!schedule.validTasks()) {
				System.out.println("CSV unable to upload. Re-prompt initializing...");
				return false;
			}
		}
		catch (FileNotFoundException e) {
			System.out.println("Cannot find such a file. Re-prompt initializing...");
			return false;
		}
		catch (Exception a) {
			a.printStackTrace();
			System.out.println("CSV reading terminated abnormally.");
			return false;
		}
		System.out.println("=== CSV Data accepted ===");
		return true;
	}

    /**
     *Set up Semaphore for Stock Brokers
     */

    private static void initializeSemaphor() {
    	sem = new HashMap<>();
    	for (Data d: stock.getData()) {
    		if (d.getStockBrokers()!=0)
    		sem.put(d.getTicker(), new Semaphore(d.getStockBrokers()));
    	}
    }

    private static void executeTrades() {
    	System.out.println("Starting execution of program...");
    	ScheduledExecutorService exe = Executors.newScheduledThreadPool(schedule.getSize());

    	for (int i = 0; i < schedule.getSize(); i++) {
        	Task temp = schedule.getTask(i);
        	if (sem.containsKey(temp.getFlicker())) {
	    		Trade trade = new Trade(temp, sem.get(temp.getFlicker()));
	    		exe.schedule(trade, temp.getStamp(), TimeUnit.SECONDS);
        	}
    	}
    	exe.shutdown();
    	while(!exe.isTerminated()) {}
    	System.out.println("All trades completed!");
    	
    }

    public static void main(String[] args) throws InterruptedException {
		while(!readStockFile()) {}
		while(!readScheduleFile()) {}
		initializeSemaphor();
		executeTrades();

    }
    
    
}

//trim string
class StringTrimJsonDeserializer implements JsonDeserializer<String> {

    @Override
    public String deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        final String value = json.getAsString();
        return value == null ? null : value.trim();
    }
}
