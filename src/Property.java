import java.util.ArrayList;
import java.util.Scanner;

import utilities.DateTime;

abstract class Property {
	String ID;
	String Address;
	short Bedrooms;
	String Status;
	String Type;
	static Scanner sc = new Scanner(System.in);
	static ArrayList<Property> prolist = new ArrayList<Property>();
	static ArrayList<RentalRecord> renlist = new ArrayList<RentalRecord>();

	public abstract int PropRent(int days);

	public short getBedrooms() {
		return Bedrooms;
	}

	public String getStatus() {
		return Status;
	}

	public static Apartment addApartment() {
		System.out.println("Street Number");
		int StreetNumber = sc.nextInt();
		System.out.println("Street Name");
		String StreetName = sc.next();
		System.out.println("Suburb");
		String Suburb = sc.next();
		String Address = StreetNumber + " " + StreetName + " " + Suburb;
		String ID = "A_" + StreetNumber + StreetName.substring(0, 1).toString().toUpperCase() + "S"
				+ Suburb.substring(0, 3).toString().toUpperCase();
		System.out.println("Enter number of bedrooms");
		short bedrooms = sc.nextShort();
		Apartment apartment = new Apartment(ID, Address, bedrooms, "Available");
		return apartment;
	}

	public static PremiumSuite addPremiumSuite() {
		System.out.println("Street Number");
		int StreetNumber = sc.nextInt();
		System.out.println("Street Name");
		String StreetName = sc.next();
		System.out.println("Suburb");
		String Suburb = sc.next();
		String Address = StreetNumber + " " + StreetName + " " + Suburb;
		String ID = "S_" + StreetNumber + StreetName.substring(0, 1).toString().toUpperCase() + "S"
				+ Suburb.substring(0, 3).toString().toUpperCase();
		PremiumSuite premiumsuite = new PremiumSuite(ID, Address, (short) 3, "Available");
		return premiumsuite;
	}

	public static RentalRecord RentalProperty() {
		System.out.println("Enter PropertyID");
		String PropertyID = sc.next();
		System.out.println("Enter CustomID");
		String CustomID = sc.next();
		System.out.println("Rental Date");
		int Ddays = sc.nextInt();
		int month = sc.nextInt();
		int year = sc.nextInt();
		DateTime dt = new DateTime(Ddays,month,year);
		System.out.println("Enter days");
		int days = sc.nextInt();
		DateTime edt = new DateTime(dt,days);
		int renfee = Apartment.ProRent(days, prolist.get(0).Bedrooms);
		RentalRecord.setID(PropertyID, CustomID, dt.getEightDigitDate());
		RentalRecord rr = new RentalRecord(RentalRecord.ID, dt, edt, dt, renfee, days);
		prolist.get(0).Status = "rented";
		return rr;
	}

	public String toString() {
		return String.format("Property ID= %s Address = %s Property Type = %s Bedrooms = %s Status = %s", ID, Address,
				Type, Bedrooms, Status);
	}
}
