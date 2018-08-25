import utilities.DateTime;

public class RentalRecord extends Property {
	static String ID;
	static DateTime RentDate, EsDate, ReDate;
	static double Renfee;
	double Latefee;

	public RentalRecord(String ID, DateTime RentDate, DateTime EsDate, DateTime ReDate, double Renfee, double Latefee) {
		RentalRecord.ID = ID;
		RentalRecord.RentDate = RentDate;
		RentalRecord.EsDate = EsDate;
		RentalRecord.ReDate = ReDate;
		RentalRecord.Renfee = Renfee;
		this.Latefee = Latefee;
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
