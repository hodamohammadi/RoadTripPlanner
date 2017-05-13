
public class City implements Comparable<City> {

	private String name;
	private double latitude;
	private double longitude;
	private int code;
	private boolean mcdonald;
	private boolean burgerKing;
	private boolean wendys;
	private Bag<Integer> adj;

	public City(String name, double latitude, double longitude) {
		this.name = name;
		this.latitude = latitude;
		this.longitude = longitude;
		adj = new Bag<Integer>();
		this.mcdonald = false;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public boolean hasBurgerKing() {
		return burgerKing;
	}

	public void setBurgerKing(boolean bk) {
		this.burgerKing = bk;
	}

	public boolean hasMcdonald() {
		return mcdonald;
	}

	public void setMcdonald(boolean md) {
		this.mcdonald = md;
	}

	public boolean hasWendys() {
		return wendys;
	}

	public void setWendys(boolean wn) {
		this.wendys = wn;
	}

	public void addToBag(Integer city) {
		this.adj.add(city);
	}

	public Bag<Integer> getBag() {
		return adj;
	}



	private static boolean less(String u1, String u2) {
		if (u1.equals(null)) {
			return true;
		} else if (u2.equals(null)) {
			return false;
		}
		return u1.toUpperCase().compareTo(u2.toUpperCase()) < 0;
	}

	public int compareTo(City that) {
		if (less(this.getName(), that.getName()))
			return -1;
		if (less(that.getName(), this.getName()))
			return +1;
		return 0;
	}
}
