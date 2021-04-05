package apiDefinitions;

public class PriceConversionRequestAPIDetails {
	private String CMC_PRO_API_KEY;
	private int id;
	private float amount;
	private String convert;

	public String getCMC_PRO_API_KEY() {
		return CMC_PRO_API_KEY;
	}

	public void setCMC_PRO_API_KEY(String CMC_PRO_API_KEY) {
		this.CMC_PRO_API_KEY = CMC_PRO_API_KEY;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getConvert() {
		return convert;
	}

	public void setConvert(String convert) {
		this.convert = convert;
	}

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

}
