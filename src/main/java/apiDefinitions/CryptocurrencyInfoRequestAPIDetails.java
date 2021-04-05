package apiDefinitions;

public class CryptocurrencyInfoRequestAPIDetails {
	private String CMC_PRO_API_KEY;
	private int id;

	public String getCMC_PRO_API_KEY() {
		return CMC_PRO_API_KEY;
	}

	public void setCMC_PRO_API_KEY(String api_key) {
		this.CMC_PRO_API_KEY = api_key;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
