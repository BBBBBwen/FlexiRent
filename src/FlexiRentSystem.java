import java.util.Scanner;

import utilities.DateTime;

public class FlexiRentSystem {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (true) {
		System.out.println(
				"1.Add Property\n2.Rent Property\n3.Return Property\n4.Property maintenance\n5.Complete Maintenance\n6.Display All Properties\n7.Exit Prpgram\nEnter your choice");
		short i = sc.nextShort();
		
			switch (i) {
			case 1:
				System.out.println("1.Apartment\n2.PremiumSuite");
				i = sc.nextShort();
				switch (i) {
				case 1:
					Property.prolist.add(Property.addApartment());
					break;
				case 2:
					Property.prolist.add(Property.addPremiumSuite());
					break;
				}
				break;
			case 2:
				System.out.print("1." + Property.prolist.get(0).ID);
				i = sc.nextShort();
				switch (i) {
				case 1:
					Property.renlist.add(Property.RentalProperty());
					break;
				}
				break;
			case 6:
				System.out.print(Property.prolist);
				System.out.println("EnterPropertyID");
				String ID = sc.next();
				if(ID.matches(Property.prolist.get(0).ID)) {
					System.out.println(RentalRecord.renlist.get(0));
				}
				break;
			}
		}
	}

}