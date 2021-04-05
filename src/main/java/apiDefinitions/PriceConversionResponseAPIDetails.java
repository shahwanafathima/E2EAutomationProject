package apiDefinitions;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PriceConversionResponseAPIDetails {

	private PriceConversionResponseStatusDetails status;
	private PriceConversionResponseDataDetails data;

	public PriceConversionResponseStatusDetails getStatus() {
		return status;
	}

	public void setStatus(PriceConversionResponseStatusDetails status) {
		this.status = status;
	}

	public PriceConversionResponseDataDetails getData() {
		return data;
	}

	public void setData(PriceConversionResponseDataDetails data) {
		this.data = data;
	}

}
