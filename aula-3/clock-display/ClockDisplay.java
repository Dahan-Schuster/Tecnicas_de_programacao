/**
 * The ClockDisplay class implements a digital clock display for a
 * European-style 24 hour clock. The clock shows hours and minutes. The
 * range of the clock is 00:00 (midnight) to 23:59 (one minute before
 * midnight).
 * 
 * The clock display receives "ticks" (via the timeTick method) every minute
 * and reacts by incrementing the display. This is done in the usual clock
 * fashion: the hour increments when the minutes roll over to zero.
 * 
 * @author Michael Kolling and David J. Barnes
 * @version 2008.03.30
 */
public class ClockDisplay {
	private Format format;
	private Period period;
	private NumberDisplay hours;
	private NumberDisplay minutes;
	private String displayString; // simulates the actual display

	/**
	 * Constructor for ClockDisplay objects. This constructor
	 * creates a new clock set at 00:00.
	 */
	public ClockDisplay(Format hourFormat) {
		period = Period.AM;
		format = hourFormat;
		hours = new NumberDisplay(format.rollOverLimit);
		minutes = new NumberDisplay(60);
		updateDisplay();
	}

	/**
	 * Constructor for ClockDisplay objects. This constructor
	 * creates a new clock set at the time specified by the
	 * parameters.
	 */
	public ClockDisplay(Format hourFormat, int hour, int minute, Period period) {
		format = hourFormat;
		hours = new NumberDisplay(format.rollOverLimit);
		minutes = new NumberDisplay(60);
		this.period = period;
		setTime(hour, minute);
	}

	/**
	 * This method should get called once every minute - it makes
	 * the clock display go one minute forward.
	 */
	public void timeTick() {
		minutes.increment();
		if (minutes.getValue() == 0) { // it just rolled over!
			hours.increment();

			// half period clocks must have a special treatment
			if (format == Format.HALF) {
				if (this.isNoon()) {
					period = Period.PM; // set the period to afternoon

				} else if (period == Period.PM) {
					if (hours.getValue() == 12) {
						hours.setValue(0);
						period = Period.AM;
					} else if (hours.getValue() == 0) {
						hours.setValue(1);
					}
				}
			}
		}
		updateDisplay();
	}

	public boolean isNoon() {
		if (format == Format.FULL)
			return hours.getValue() == 12;
			
		return period == Period.AM && hours.getValue() == 12;
	}

	/**
	 * Set the time of the display to the specified hour and
	 * minute.
	 */
	public void setTime(int hour, int minute) {

		hours.setValue(hour);
		minutes.setValue(minute);
		updateDisplay();
	}

	/**
	 * Set the time of the display to the specified hour,
	 * minute and period of the day.
	 */
	public void setTime(int hour, int minute, Period period) {
		hours.setValue(hour);
		minutes.setValue(minute);
		this.period = period;
		updateDisplay();
	}

	/**
	 * Return the current time of this display in the format HH:MM.
	 */
	public String getTime() {
		return displayString;
	}

	/**
	 * Update the internal string that represents the display.
	 */
	private void updateDisplay() {
		displayString = hours.getDisplayValue() + ":" +
				minutes.getDisplayValue();

		if (format == Format.HALF)
			displayString += " " + period.label;
	}
}
