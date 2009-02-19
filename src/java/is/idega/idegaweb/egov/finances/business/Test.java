package is.idega.idegaweb.egov.finances.business;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Test {
	public static void main(String[] args) {
		try {
			BufferedReader in = new BufferedReader(new FileReader("/Users/palli/endurvinnslutunnur.txt"));
			BufferedWriter out = new BufferedWriter(new FileWriter("/Users/palli/endurvinnslutunnur.csv"));
			try {
				String line = null;

				while ((line = in.readLine()) != null) {
					if (line.length() > 4) {
						if (line.substring(0, 4).equals("Nafn")) {
							String ssn = in.readLine();
							String address = in.readLine();
							String po = in.readLine();
							String phone = in.readLine();
							String email = in.readLine();
							String start = in.readLine();
							String end = in.readLine();
							String renter = in.readLine();
							
							String outString = parseEntry(line, ssn, address, po, phone, email, start, end, renter);
							out.write(outString);
						}
					}
				}
			} finally {
				in.close();
				out.close();
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static String parseEntry(String name, String ssn, String address,
			String po, String phone, String email, String start, String end,
			String renter) {
		
		StringBuffer returnBuffer = new StringBuffer("");
		//name
		Scanner scanner = new Scanner(name).useDelimiter("\\t\\t");
		scanner.next();
		if (scanner.hasNext()) {
			returnBuffer.append(scanner.next());
		}
		returnBuffer.append(";");

		//ssn
		scanner = new Scanner(ssn).useDelimiter("\\t\\t");
		scanner.next();
		if (scanner.hasNext()) {
			returnBuffer.append(scanner.next());
		}
		returnBuffer.append(";");

		//address
		scanner = new Scanner(address).useDelimiter("\\t\\t");
		scanner.next();
		if (scanner.hasNext()) {
			returnBuffer.append(scanner.next());
		}
		returnBuffer.append(";");

		//po
		scanner = new Scanner(po).useDelimiter("\\t\\t");
		scanner.next();
		if (scanner.hasNext()) {
			returnBuffer.append(scanner.next());
		}
		returnBuffer.append(";");

		//phone
		scanner = new Scanner(phone).useDelimiter("\\t\\t");
		scanner.next();
		if (scanner.hasNext()) {
			returnBuffer.append(scanner.next());
		}
		returnBuffer.append(";");
		
		//email
		scanner = new Scanner(email).useDelimiter("\\t\\t");
		scanner.next();
		if (scanner.hasNext()) {
			returnBuffer.append(scanner.next());
		}
		returnBuffer.append(";");

		//start
		scanner = new Scanner(start).useDelimiter("\\t\\t");
		scanner.next();
		if (scanner.hasNext()) {
			returnBuffer.append(scanner.next());
		}
		returnBuffer.append(";");

		//end
		scanner = new Scanner(end).useDelimiter("\\t\\t");
		scanner.next();
		if (scanner.hasNext()) {
			returnBuffer.append(scanner.next());
		}
		returnBuffer.append(";");
		
		//renter
		scanner = new Scanner(renter).useDelimiter("\\t\\t");
		scanner.next();
		if (scanner.hasNext()) {
			returnBuffer.append(scanner.next());
		}
		returnBuffer.append("\n");
		
		
		return returnBuffer.toString();
	}
}