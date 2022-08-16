import org.junit.*;

public class BrickTest extends junit.framework.TestCase {
	Brick brick;

	public BrickTest(){}

	@Test
	public void testVolume()
	{
		brick = new Brick(1, 1, 1);
		assertEquals(1.0, brick.getVolume());

		brick = new Brick(8, 20, 12);
		assertEquals(1920.0, brick.getVolume());
	}

	@Test
	public void testWeight()
	{
		brick = new Brick(1, 1, 1);
		assertEquals(0.002, brick.getWeight());

		brick = new Brick(8, 20, 12);
		assertEquals(3.84, brick.getWeight());
	}

	@Test
	public void testSurfaceArea()
	{
		brick = new Brick(1, 1, 1);
		assertEquals(6.0, brick.getSurfaceArea());

		brick = new Brick(8, 20, 12);
		assertEquals(992.0, brick.getSurfaceArea());
	}
}
