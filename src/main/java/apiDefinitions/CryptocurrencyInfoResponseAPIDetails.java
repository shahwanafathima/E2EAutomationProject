package apiDefinitions;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CryptocurrencyInfoResponseAPIDetails {

	private CrytocurrencyInfoResponseStatusDetails status;
	private CrytocurrencyInfoResponseDataDetails data;

	public CrytocurrencyInfoResponseStatusDetails getStatus() {
		return status;
	}

	public void setStatus(CrytocurrencyInfoResponseStatusDetails status) {
		this.status = status;
	}

	public CrytocurrencyInfoResponseDataDetails getData() {
		return data;
	}

	public void setData(CrytocurrencyInfoResponseDataDetails data) {
		this.data = data;
	}
}
