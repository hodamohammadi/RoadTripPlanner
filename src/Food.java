
public class Food {

	private String restaurant;
	private String meal;
	private double price;
	private String comment;

	public Food(String restaurant, String meal, double price, String comment) {
		this.restaurant = restaurant;
		this.meal = meal;
		this.price = price;
		this.comment = comment;
	}

	public String getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(String restaurant) {
		this.restaurant = restaurant;
	}

	public String getMeal() {
		return meal;
	}

	public void setMeal(String meal) {
		this.meal = meal;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

}
