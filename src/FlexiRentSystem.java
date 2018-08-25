import java.util.ArrayList;
import java.util.Scanner;

import utilities.DateTime;

public interface FlexiRentSystem {
	Scanner sc = new Scanner(System.in);
	ArrayList<Property> prolist = new ArrayList<Property>();
	ArrayList<RentalRecord> renlist = new ArrayList<RentalRecord>();

	public static void main(String[] args) {
		int max = 0;
		while (true) {
			System.out.println(
					"1.Add Property\n2.Rent Property\n3.Return Property\n4.Property maintenance\n5.Complete Maintenance\n6.Display All Properties\n7.Exit Prpgram");
			short i = sc.nextShort();
			switch (i) {
			case 1:
				System.out.println("1.Apartment\n2.PremiumSuite");
				i = sc.nextShort();
				switch (i) {
				case 1:
					Property.prolist.add(Property.addApartment());
					max += 1;
					break;
				case 2:
					Property.prolist.add(Property.addPremiumSuite());
					max += 1;
					break;
				}
				break;
			case 2:
				for (int j = 0; j < max; j++) {
					System.out.print((j + 1) + "." + Property.prolist.get(j).ID);
				}
				i = sc.nextShort();
				Property.renlist.add(RentalProperty(i));
				break;
			case 3:
				for (int j = 0; j < max; j++) {
					System.out.print((j + 1) + "." + Property.prolist.get(j).ID);
				}
				System.out.println("which property to return");
				i = sc.nextShort();
				System.out.println("Enter return date (dd mm yy)");
				int Ddays = sc.nextInt();
				int month = sc.nextInt();
				int year = sc.nextInt();
				DateTime rd = new DateTime(Ddays, month, year);
				int late = DateTime.diffDays(rd, RentalRecord.EsDate);
				renlist.get(i - 1).Latefee = Property.latefee(prolist.get(i - 1).Type, late);
				if (returnProperty(rd, i)) {
					System.out.println("this property is returned succesfully");
					System.out.println(renlist.get(i - 1));
				} else {
					System.out.println("this property cannot be returned,please check");
				}

				break;
			case 4:
				for (int j = 0; j < max; j++) {
					System.out.print((j + 1) + "." + Property.prolist.get(j).ID);
				}
				i = sc.nextShort();
				if (Property.prolist.get(i - 1).Status == "avilabe") {
					Property.prolist.get(i - 1).Status = "Maintenance";
					System.out.println("this property is performing a maintenance right now");
				} else {
					System.out.println("this property cannot perform maintenance right now");
				}

				break;
			case 5:
				for (int j = 0; j < max; j++) {
					System.out.print((j + 1) + "." + Property.prolist.get(j).ID);
				}
				i = sc.nextShort();
				Property.prolist.get(i - 1).Status = "Avilable";
				break;
			case 6:
				for (int j = 0; j < max; j++) {
					System.out.print((j + 1) + "." + Property.prolist.get(j));
				}
				int j = sc.nextInt();
				System.out.println(RentalRecord.renlist.get(j - 1));
				break;
			case 7:
				System.exit(0);
			}
		}
	}

	public static RentalRecord RentalProperty(int i) {
		String PropertyID = prolist.get(i - 1).ID;
		System.out.println("Enter CustomID");
		String CustomID = sc.next();
		System.out.println("Enter return date (dd mm yy)");
		int Ddays = sc.nextInt();
		int month = sc.nextInt();
		int year = sc.nextInt();
		DateTime dt = new DateTime(Ddays, month, year);
		System.out.println("Enter days");
		int days = sc.nextInt();
		DateTime edt = new DateTime(dt, days);
		double renfee = Apartment.ProRent(days, Property.prolist.get(i-1).Bedrooms);
		RentalRecord.setID(PropertyID, CustomID, dt.getEightDigitDate());
		RentalRecord rr = new RentalRecord(RentalRecord.ID, dt, edt, null, renfee, 0);
		Property.prolist.get(i - 1).Status = "rented";
		return rr;
	}

	public static boolean returnProperty(DateTime returnDate, int i) {
		if (Property.prolist.get(i - 1).Status == "rented") {
			Property.prolist.get(i - 1).Status = "Available";
			return true;
		} else {
			return false;
		}
	}
}