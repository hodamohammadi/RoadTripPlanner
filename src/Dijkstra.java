public class Dijkstra {

	private static DirectedEdge[] edgeTo;
	private static double[] distTo;
	private IndexMinPQ<Double> pq;
	private static int s;

	public Dijkstra(EdgeWeightedDigraph G, int s) {
		edgeTo = new DirectedEdge[G.V()];
		distTo = new double[G.V()];
		pq = new IndexMinPQ<Double>(G.V());

		for (int v = 0; v < G.V(); v++)
			distTo[v] = Double.POSITIVE_INFINITY;
		distTo[s] = 0.0;
		pq.insert(s, 0.0);

		while (!pq.isEmpty())
			relax(G, pq.delMin());
	}

	private void relax(EdgeWeightedDigraph G, int v) {
		for (DirectedEdge e : G.adj(v)) {
			int w = e.to();
			if (distTo[w] > distTo[v] + e.weight()) {
				distTo[w] = distTo[v] + e.weight();
				edgeTo[w] = e;
				if (pq.contains(w))
					pq.changeKey(w, distTo[w]);
				else
					pq.insert(w, distTo[w]);
			}
		}
	}

	public static DirectedEdge[] getEdgeTo() {
		return edgeTo;
	}

	public static double getDistTo(int v) {
		return distTo[v];
	}

	public Iterable<Integer> pathTo(int v) {
		Stack<Integer> path = new Stack<Integer>();

		while (v != s) {
			path.push(v);
			DirectedEdge w = edgeTo[v];
			v = w.from();
		}

		if (v == s)
			path.push(v);

		return path;
	}

}
