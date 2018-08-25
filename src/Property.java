import java.util.ArrayList;
import java.util.Scanner;

abstract class Property {
	String ID;
	String Address;
	short Bedrooms;
	String Status;
	String Type;
	static Scanner sc = new Scanner(System.in);
	static ArrayList<Property[]> prolist = new ArrayList<Property[]>();

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
		String Address = StreetNumber +" " + StreetName + " " + Suburb;
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
		String Address = StreetNumber +" " + StreetName + " " + Suburb;
		String ID = "S_" + StreetNumber + StreetName.substring(0, 1).toString().toUpperCase() + "S"
				+ Suburb.substring(0, 3).toString().toUpperCase();
		PremiumSuite premiumsuite = new PremiumSuite(ID, Address, (short) 3, "Available");
		return premiumsuite;
	}

	public String toString() {
		return String.format("Property ID= %s Address = %s Property Type = %s Bedrooms = %s Status = %s",ID,Address,Type,Bedrooms,Status);
	}
}
