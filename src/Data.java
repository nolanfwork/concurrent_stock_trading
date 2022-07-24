

public class Data {
	
	private String name;
	private String ticker;
	private String startDate;
	private Integer stockBrokers;
	private String description;
	private String exchangeCode;

	public Data() {}
	public Data(String name, String ticker, String startDate, Integer stockBrokers, String description, String exchangeCode) {
	super();
	this.name = name;
	this.ticker = ticker;
	this.startDate = startDate;
	this.stockBrokers = stockBrokers;
	this.description = description;
	this.exchangeCode = exchangeCode;
	}
	
	public String getName() {
	return name;
	}
	
	public void setName(String name) {
	this.name = name;
	}
	
	public String getTicker() {
	return ticker;
	}
	
	public void setTicker(String ticker) {
	this.ticker = ticker;
	}
	
	public String getStartDate() {
	return startDate;
	}
	
	public void setStartDate(String startDate) {
	this.startDate = startDate;
	}
	
	public Integer getStockBrokers() {
	return stockBrokers;
	}
	
	public void setStockBrokers(Integer stockBrokers) {
	this.stockBrokers = stockBrokers;
	}
	
	public String getDescription() {
	return description;
	}
	
	public void setDescription(String description) {
	this.description = description;
	}
	
	public String getExchangeCode() {
	return exchangeCode;
	}
	
	public void setExchangeCode(String exchangeCode) {
	this.exchangeCode = exchangeCode;
	}
	
//	@Override
	public String toString() {
	StringBuilder sb = new StringBuilder();
	sb.append(Data.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
	sb.append("name");
	sb.append('=');
	sb.append(((this.name == null)?"<null>":this.name));
	sb.append(',');
	sb.append("ticker");
	sb.append('=');
	sb.append(((this.ticker == null)?"<null>":this.ticker));
	sb.append(',');
	sb.append("startDate");
	sb.append('=');
	sb.append(((this.startDate == null)?"<null>":this.startDate));
	sb.append(',');
	sb.append("stockBrokers");
	sb.append('=');
	sb.append(((this.stockBrokers == null)?"<null>":this.stockBrokers));
	sb.append(',');
	sb.append("description");
	sb.append('=');
	sb.append(((this.description == null)?"<null>":this.description));
	sb.append(',');
	sb.append("exchangeCode");
	sb.append('=');
	sb.append(((this.exchangeCode == null)?"<null>":this.exchangeCode));
	sb.append(',');
	if (sb.charAt((sb.length()- 1)) == ',') {
	sb.setCharAt((sb.length()- 1), ']');
	} else {
	sb.append(']');
	}
	return sb.toString();
	}
	public int validateData() {
		if (this.name == null) return 1;
		if (this.ticker == null) return 2;
		if (this.startDate == null) return 3;
		if (this.stockBrokers == null) return 4;
		if (this.description == null) return 5;
		if (this.exchangeCode == null) return 6;
		if (!Patterns.namePattern.matcher(this.name).matches()) return 7;
		if (!Patterns.tickerPattern.matcher(this.ticker).matches()) return 8;
		if (!Patterns.datePattern.matcher(this.startDate).matches()) return 9;
		if (!Patterns.brokerPattern.matcher(Integer.toString(this.stockBrokers)).matches()) return 10;
		if (!Patterns.exchangePattern.matcher(this.exchangeCode).matches()) return 11;
		
		return 0;
	}
	

}