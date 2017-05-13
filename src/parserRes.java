
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

public class parserRes {
	
	public static Location location;
	public static double latitude;
	public static double longitude;
	public static ArrayList<Location> locations;

	public static ArrayList<Location> Parse(String file) throws FileNotFoundException {

		Scanner input = new Scanner(new File(file));
		locations = new ArrayList<Location>();

		input.nextLine();
		while (input.hasNext()) {
			String line = input.nextLine();
			String[] items = line.split(",");

			longitude = Double.parseDouble(items[0]);
			latitude = Double.parseDouble(items[1]);
			location = new Location(latitude, longitude);
			locations.add(location);

		}

		return locations;
	}
}
