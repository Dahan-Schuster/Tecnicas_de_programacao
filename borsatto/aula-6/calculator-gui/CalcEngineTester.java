import org.junit.*;
import junit.framework.TestCase;

/**
 * Test the CalcEngine class using JUnit.
 * 
 * @author Dahan Schuster
 * @version 2022.04.30
 */
public class CalcEngineTester extends TestCase {
	// The engine to be tested.
	private CalcEngine engine;

	/**
	 * Constructor for objects of class CalcEngineTester
	 */
	public CalcEngineTester() {
	}

	/**
	 * Set up a new CalcEngine before each test
	 */
	@Before
	public void setUp() {
		engine = new CalcEngine();
	}

	/**
	 * Test the plus operation of the engine.
	 */
	@Test
	public void testPlus() {
		engine.numberPressed(3);
		assertEquals(3, engine.getDisplayValue());

		engine.plus();
		assertEquals(0, engine.getDisplayValue());

		engine.numberPressed(4);
		assertEquals(4, engine.getDisplayValue());

		engine.equals();
		assertEquals(7, engine.getDisplayValue());
	}

	/**
	 * Test the minus operation of the engine.
	 */
	@Test
	public void testMinus() {
		engine.numberPressed(9);
		assertEquals(9, engine.getDisplayValue());

		engine.minus();
		assertEquals(0, engine.getDisplayValue());

		engine.numberPressed(4);
		assertEquals(4, engine.getDisplayValue());

		engine.equals();
		assertEquals(5, engine.getDisplayValue());
	}

	/**
	 * Test if the value displayed after pressing
	 * more than one number is correct
	 */
	@Test
	public void testDisplayMultidigitValue() {
		engine.numberPressed(1);
		assertEquals(1, engine.getDisplayValue());

		engine.numberPressed(2);
		assertEquals(12, engine.getDisplayValue());

		engine.numberPressed(3);
		assertEquals(123, engine.getDisplayValue());
	}

	/**
	 * Test if the display is cleared after pressing 'C'
	 */
	@Test
	public void testClear() {
		engine.numberPressed(1);
		engine.numberPressed(0);
		assertEquals(10, engine.getDisplayValue());

		engine.clear();
		assertEquals(0, engine.getDisplayValue());
	}

	/**
	 * Test apply previous operator if the plus or minus
	 * button are pressed more than one time before the
	 * equals button.
	 */
	@Test
	public void testApplyPreviousOperator() {
		engine.numberPressed(1);
		engine.numberPressed(0);
		assertEquals(10, engine.getDisplayValue());

		engine.plus();
		assertEquals(0, engine.getDisplayValue());

		engine.numberPressed(5);
		assertEquals(5, engine.getDisplayValue());

		engine.minus();
		assertEquals(0, engine.getDisplayValue());

		engine.numberPressed(5);
		assertEquals(5, engine.getDisplayValue());

		engine.equals();
		assertEquals(10, engine.getDisplayValue());
	}
}
