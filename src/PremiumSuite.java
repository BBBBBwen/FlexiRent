
final class PremiumSuite extends Property {

	public PremiumSuite(String ID, String Address, short Bedrooms, String Status) {
		this.ID = ID;
		this.Address = Address;
		this.Bedrooms = Bedrooms;
		this.Status = Status;
		this.Type = "Premium Suite";
	}

	public int PropRent(int days) {
		int num = 0;
		num = 662 * days;
		return num;
	}
	
}
