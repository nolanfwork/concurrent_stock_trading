

import java.util.regex.Pattern;

public class Patterns {
	static public Pattern JsonPattern = Pattern.compile("(^(.[^ ]+)\\.json$)|(^(.[^ ]+)\\.JSON$)");
    static public Pattern namePattern = Pattern.compile("^[ A-Za-z]+$");
    static public Pattern tickerPattern = Pattern.compile("^[A-Z]+$");
    static public Pattern datePattern = Pattern.compile("^\\d{4}-(0[1-9]|1[0-2])-(0[1-9]|[12][0-9]|3[01])$");
    static public Pattern brokerPattern = Pattern.compile("^(\\d|[1-9](\\d+))$");
    static public Pattern exchangePattern = Pattern.compile("^[A-Z]+$");
    
	static public Pattern CSVPattern = Pattern.compile("(^(.[^ ]+)\\.csv$)|(^(.[^ ]+)\\.CSV$)");
    static public Pattern tradePattern = Pattern.compile("(^([0-9]|[^-0]\\d+)\\,([A-Z]+)\\,([0-9]|(-[1-9])|([1-9]\\d+)|(-[1-9](\\d+)))$)");
    
}
