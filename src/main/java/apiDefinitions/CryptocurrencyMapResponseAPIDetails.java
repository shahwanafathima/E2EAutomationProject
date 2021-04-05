package apiDefinitions;

import java.util.List;

public class CryptocurrencyMapResponseAPIDetails {
	private CrytocurrencyMapResponseStatusDetails status;
	private List<CrytocurrencyMapResponseDataDetails> data;

	public List<CrytocurrencyMapResponseDataDetails> getData() {
		return data;
	}

	public void setData(List<CrytocurrencyMapResponseDataDetails> data) {
		this.data = data;
	}

	public CrytocurrencyMapResponseStatusDetails getStatus() {
		return status;
	}

	public void setStatus(CrytocurrencyMapResponseStatusDetails status) {
		this.status = status;
	}

}
