package co.ceiba.parking.dominio;

public class Rate {
	
	private String type;
	private String ratename;
	private int ratevalue;
	
	public Rate(String type, String ratename, int ratevalue) {
		this.type = type;
		this.ratename = ratename;
		this.ratevalue = ratevalue;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getRatename() {
		return ratename;
	}

	public void setRatename(String ratename) {
		this.ratename = ratename;
	}

	public int getRatevalue() {
		return ratevalue;
	}

	public void setRatevalue(int ratevalue) {
		this.ratevalue = ratevalue;
	}

}
