package apiDefinitions;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PriceConversionResponseDataDetails {
	
	private int id;
	private String name;
	private String symbol;
	private int amount;
	private String last_updated;
	private PriceConversionResponseQuoteDetails quote;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getLast_updated() {
		return last_updated;
	}

	public void setLast_updated(String last_updated) {
		this.last_updated = last_updated;
	}

	public PriceConversionResponseQuoteDetails getQuote() {
		return quote;
	}

	public void setQuote(PriceConversionResponseQuoteDetails quote) {
		this.quote = quote;
	}

}
