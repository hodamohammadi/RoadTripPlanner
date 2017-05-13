
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

public class parserCities {
	public static ArrayList<City> cities;

	public static ArrayList<City> Parse(String file) throws FileNotFoundException {

		Scanner input = new Scanner(new File(file));
		cities = new ArrayList<City>();
		input.nextLine();
		while (input.hasNext()) {
			String line = input.nextLine();
			String[] items = line.split(",");
			City city = new City(items[3], Double.parseDouble(items[4]), Double.parseDouble(items[5]));
			cities.add(city);
		}
		return cities;
	}
}
