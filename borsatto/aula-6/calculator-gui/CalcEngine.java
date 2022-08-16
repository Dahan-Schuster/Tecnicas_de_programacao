/**
 * The main part of the calculator doing the calculations.
 * 
 * @author  David J. Barnes and Michael Kolling
 * @version 0.1 (incomplete)
 */
public class CalcEngine
{
    private int displayValue;
	private int leftOperand;
	private char previousOperator;

    /**
     * Create a CalcEngine.
     */
    public CalcEngine()
    {
		displayValue = 0;
		leftOperand = 0;
		previousOperator = ' ';
    }

    /**
     * @return The value that should currently be displayed
     * on the calculator display.
     */
    public int getDisplayValue()
    {
        return displayValue;
    }

    /**
     * A number button was pressed.
     * Either start a new operand, or incorporate this number as
     * the least significant digit of an existing one.
     * @param number The number pressed on the calculator.
     */
    public void numberPressed(int number)
    {
		displayValue = displayValue * 10 + number;
    }

    /**
     * The 'plus' button was pressed. 
     */
    public void plus()
    {
		applyPreviousOperator();
		previousOperator = '+';
		displayValue = 0;
    }

    /**
     * The 'minus' button was pressed.
     */
    public void minus()
    {
		applyPreviousOperator();
		previousOperator = '-';
		displayValue = 0;
    }

    /**
     * The '=' button was pressed.
     */
    public void equals()
    {
		applyPreviousOperator();
		displayValue = leftOperand;
		previousOperator = ' ';
		leftOperand = 0;
    }

    /**
     * The 'C' (clear) button was pressed.
     */
    public void clear()
    {
		displayValue = 0;
    }

    /**
     * @return The title of this calculation engine.
     */
    public String getTitle()
    {
        return "Simple Calculator";
    }

    /**
     * @return The author of this engine. This string is displayed as it is,
     * so it should say something like "Written by H. Simpson".
     */
    public String getAuthor()
    {
        return "Dahan Schuster";
    }

    /**
     * @return The version number of this engine. This string is displayed as 
     * it is, so it should say something like "Version 1.1".
     */
    public String getVersion()
    {
        return "1.0.0";
    }

	/**
	 * Check if a operator was already pressed before,
	 * without pressing the equals button.
	 * Would be something like '1+1+1' or '10+5-5'
	 * 
	 * In that case, the intermediate value is calculated,
	 * updating the left operand
	 */
	private void applyPreviousOperator()
	{
		if (previousOperator == '+') {
			leftOperand += displayValue;
		} else if (previousOperator == '-') {
			leftOperand -= displayValue;
		} else {
			leftOperand = displayValue;
		}
	}
}
