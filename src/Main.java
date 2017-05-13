
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

public class Main {

	static ArrayList<City> cities1;
	static ArrayList<Food>[] foods;
	static ArrayList<Location> mdLocations;
	static ArrayList<Location> bkLocations;
	static ArrayList<Location> wnLocations;

	public static int size(Iterable<?> citylist) {
		final int size;
		if (citylist instanceof Collection) {
			size = ((Collection<?>) citylist).size();
		} else {
			int counter = 0;
			for (Object c : citylist) {
				counter++;
			}
			size = counter;
		}
		return size;
	}

	public static void main(String[] args) throws IOException {

		cities1 = parserCities.Parse("2XB3_A3_DataSets/USCities.csv");
		City[] citieslist = cities1.toArray(new City[cities1.size()]);
		Quick.sort(citieslist);
		ArrayList<City> cities = new ArrayList<City>(Arrays.asList(citieslist));

		int code = 0;
		for (City c : cities) {
			c.setCode(code);
			code++;
		}

		parserConnected.Parse("2XB3_A3_DataSets/connectedCities.txt", cities);

		Digraph DG = new Digraph(cities);

		File file = new File("a3_out.txt");
		file.createNewFile();
		FileWriter writer = new FileWriter(file);

		BreadthFirstSearch BFP = new BreadthFirstSearch(DG, 3);
		DirectFirstSearch DFP = new DirectFirstSearch(DG, 3);
		
		
		
		writer.write("BFS: ");
		StringBuilder cList = new StringBuilder();
		for (int city : BFP.pathTo(17)) {
				cList.append(", " + cities.get(city).getName());
		}
		String cList2 = cList.substring(2);
		writer.write(cList2);
		
		
		writer.write("\nDFS: ");
		cList = new StringBuilder();
		for (int city : DFP.pathTo(17)) {
			cList.append(", " + cities.get(city).getName());
		}

		
		cList2 = cList.substring(2);
		writer.write(cList2);
		
		writer.flush();
		writer.close();

		foods = parserMenu.Parse("2XB3_A3_DataSets/menu.csv");

		mdLocations = parserRes.Parse("2XB3_A3_DataSets/mcdonalds.csv");
		bkLocations = parserRes.Parse("2XB3_A3_DataSets/burgerking.csv");
		wnLocations = parserRes.Parse("2XB3_A3_DataSets/wendys.csv");
	}
}
