
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

public class parserConnected {
	public static void Parse(String file, ArrayList<City> cities) throws FileNotFoundException {

		Scanner input = new Scanner(new File(file));

		while (input.hasNext()) {

			String line = input.nextLine();
			StringBuilder city1 = new StringBuilder();
			StringBuilder city2 = new StringBuilder();
			

			for (int i = 0; i < line.length(); i++) {
				if (line.charAt(i + 1) == '(') {
					break;
				} else {
					city1.append(line.charAt(i));
				}
			}

			for (int k = 0; k < line.length()-1; k++) {
				if (line.charAt(k) == ')' && line.charAt(k + 1) == ',') {
					for (int j = k + 3; j < line.length()-1; j++) {
						if (line.charAt(j + 1) == '(') {
							break;
						} else {
							city2.append(line.charAt(j));
						}
					}

				}
			}

			cities.get(Search.rank(city1.toString().toUpperCase(), cities)).addToBag(Search.rank(city2.toString().toUpperCase(), cities));
		}
	}
}
