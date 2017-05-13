import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class parserMenu {
	public static Food meal;
	public static ArrayList<Food>[] meals;
	public static ArrayList<Food> md;
	public static ArrayList<Food> bk;
	public static ArrayList<Food> wn;

	public static ArrayList<Food>[] Parse(String file) throws FileNotFoundException {

		Scanner input = new Scanner(new File(file));
		md = new ArrayList<Food>();
		bk = new ArrayList<Food>();
		wn = new ArrayList<Food>();
		input.nextLine();

		while (input.hasNext()) {
			String line = input.nextLine();
			String[] items = line.split(",");

			if (items[0].charAt(0) == ('M'))
				md.add(new Food(items[0], items[1], Double.parseDouble(items[2].substring(1)), items[3]));

			else if (items[0].charAt(0) == ('B'))
				bk.add(new Food(items[0], items[1], Double.parseDouble(items[2].substring(1)), items[3]));

			else if (items[0].charAt(0) == ('W'))
				wn.add(new Food(items[0], items[1], Double.parseDouble(items[2].substring(1)), items[3]));

		}

		meals = new ArrayList[] { md, bk, wn };
		return meals;
	}
}
