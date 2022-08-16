public class Main {
	public static void main(String[] args) {
		// ClockDisplay clockDisplayFull = new ClockDisplay(Format.FULL);
		// ClockDisplay clockDisplayHalf = new ClockDisplay(Format.HALF);

		ClockDisplayLazy clockDisplayFull = new ClockDisplayLazy(Format.FULL);
		ClockDisplayLazy clockDisplayHalf = new ClockDisplayLazy(Format.HALF);

		// clockDisplayFull.setTime(23, 0);
		// clockDisplayHalf.setTime(11, 0, Period.PM);

		System.out.println(clockDisplayFull.getTime());
		System.out.println(clockDisplayHalf.getTime());

		try {
			int limit = (60 * 24);
			// limit = 0;
			for (int i = 0; i < limit; i++) {
				System.out.print("\033[H\033[2J");
				System.out.flush();

				System.out.println(clockDisplayFull.getTime());
				clockDisplayFull.timeTick();

				System.out.println(clockDisplayHalf.getTime());
				clockDisplayHalf.timeTick();
				
				Thread.sleep(10); 
			}
		} catch (Exception e) {
			System.out.println("Thread.sleep error");
		}
	}
}
