import org.junit.*;

public class PaletTest extends junit.framework.TestCase {
	
	Palet palet;

	public PaletTest()
	{}

	@Test
	public void testWeight()
	{
		palet = new Palet(1, 1);
		assertEquals(10.34, palet.getWeight());

		palet = new Palet(10, 5);
		assertEquals(198.5, palet.getWeight());
	}

	@Test
	public void testHeight()
	{
		palet = new Palet(1, 1);
		assertEquals(23.0, palet.getHeight());

		palet = new Palet(10, 5);
		assertEquals(55.0, palet.getHeight());
	}
}
