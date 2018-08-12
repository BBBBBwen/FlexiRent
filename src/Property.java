
public class Property {
	private String ID;
	private int StreetNumber;
	private String StreetName;
	private String Suburb;
	private short Bedrooms;
	private String Type;
	private String Status;

	public Property(String ID, int StreetNumber, String StreetName, String Suburb, short Bedrooms, String Type,
			String Status) {
		this.ID = ID;
		this.StreetNumber = StreetNumber;
		this.StreetName = StreetName;
		this.Suburb = Suburb;
		this.Bedrooms = Bedrooms;
		this.Type = Type;
		this.Status = Status;
	}

	public String getID() {
		if (getType().equals("Apartment")) {
			ID = "A_" + getStreetNumber() + getStreetName().charAt(0) + getSuburb().charAt(0);
		}
		if (getType().equals("PremiumSuite")) {
			ID = "S_" + getStreetNumber() + getStreetName().charAt(0) + getSuburb().charAt(0);
		}
		return ID;
	}

	public void setStreetNumber(int StreetNumber) {
		this.StreetNumber = StreetNumber;
	}

	public int getStreetNumber() {
		return StreetNumber;
	}

	public void setStreetName(String StreetName) {
		this.StreetName = StreetName;
	}

	public String getStreetName() {
		return StreetName;
	}

	public void setSuburb(String Suburb) {
		this.Suburb = Suburb;
	}

	public String getSuburb() {
		return Suburb;
	}

	public void setBedrooms(short Bedrooms) {
		if (Bedrooms == 1 || Bedrooms == 2 || Bedrooms == 3) {
			this.Bedrooms = Bedrooms;
		}
	}

	public short getBedrooms() {
		return Bedrooms;
	}

	public void setType(String Type) {
		if (Type.equals("Apartment") || Type.equals("PremiumSuite")) {
			this.Type = Type;
		}
	}

	public String getType() {
		return Type;
	}

	public void setStatus(String Status) {
		if (Status.equals("Available") || Status.equals("Rented") || Status.equals("Maintenance")) {
			this.Status = Status;
		}
	}

	public String getStatus() {
		return Status;
	}


}
