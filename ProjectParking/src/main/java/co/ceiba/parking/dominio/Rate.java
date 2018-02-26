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

	public String getRatename() {
		return ratename;
	}

	public int getRatevalue() {
		return ratevalue;
	}

}
