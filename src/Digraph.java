
import java.util.ArrayList;

public class Digraph {

	private int V; // number of vertices
	private Bag<Integer>[] adj;

	public Digraph(ArrayList<City> cities) {
		V = 32; // number of cities in US
		adj = (Bag<Integer>[]) new Bag[V];

		for (int i = 0; i < V; i++) {
			City c = cities.get(i);
			adj[c.getCode()] = c.getBag();
		}
	}

	public int V() {
		return V;
	}

	public Iterable<Integer> adj(int v) {
		return adj[v];
	}

}
