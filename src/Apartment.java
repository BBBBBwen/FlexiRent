final class Apartment extends Property {
	

	public Apartment(String ID, String Address, short Bedrooms, String Status) {
		this.ID = ID;
		this.Address =Address;
		this.Bedrooms = Bedrooms;
		this.Status = Status;
		this.Type = "Apartment";
	}

	@Override
	public int PropRent(int days) {
		return 0;
	}

	public int ProRent(int days, short bedrooms) {
		int num = 0;
		switch (bedrooms) {
		case 1:
			num = 143 * days;
		case 2:
			num = 210 * days;
		case 3:
			num = 319 * days;
		}
		System.out.println("money" + num);
		return num;
	}
}
