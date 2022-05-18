public class Videogame extends Item {
	private String genre;
	private String platform;
	private int launchYear;

	public Videogame(String theTitle, int time, String theGenre, String thePlatform, int year) {
		super(theTitle, time);
		genre = theGenre;
		platform = thePlatform;
		launchYear = year;
	}

	public String getGenre() {
		return genre;
	}

	public String getPlatform() {
		return platform;
	}

	public int getLaunchYear() {
		return launchYear;
	}

	@Override
	public void print() {
		super.print();
		System.out.println("Genre: " + genre);
		System.out.println("Platform: " + platform);
		System.out.println("Launch year: " + String.valueOf(launchYear));
	}
}
