import utilities.DateTime;

public class RentalRecord extends Property {
	static String ID;
	DateTime RentDate, EsDate, ReDate;
	double Renfee, Latefee;

	public RentalRecord(String ID, DateTime RentDate, DateTime EsDate, DateTime ReDate, double Renfee, double Latefee) {
		RentalRecord.ID = ID;
		this.RentDate = RentDate;
		this.EsDate = EsDate;
		this.ReDate = ReDate;
		this.Renfee = Renfee;
		this.Latefee = Latefee;
	}

	public boolean rent(String customerId, DateTime rentDate, int numOfRentDay) {

	}

	public boolean returnProperty(DateTime returnDate) {
		Property.prolist.get(0).Status = "Available";
	}

	public String toString() {
		return String.format(
				"RecordID: = %s,Rent Date: = %s,Estimated Return Date: = %s,actual Return Date: = %s,Rental Fee: =%s,Late Fee: =%s",
				ID, RentDate, EsDate, ReDate, Renfee, Latefee);
	}

	@Override
	public int PropRent(int days) {
		// TODO Auto-generated method stub
		return 0;
	}

	public static String setID(String PropertyID, String CustomID, String RentalDate) {
		return ID = PropertyID + CustomID + RentalDate;
	}
}
