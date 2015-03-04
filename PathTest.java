import org.junit.Test;
import static org.junit.Assert.*;


public class PathTest {
	
	@Test
	public void isCityPresent_checks_whether_city_is_prsent (){
		Path path = new Path();
		assertFalse(path.isPresent("Chennai"));
		assertTrue(path.isPresent("Dubai"));
		assertTrue(path.isPresent("Tokyo"));
		assertTrue(path.isPresent("Singapore"));
		assertTrue(path.isPresent("Beijing"));
	}

	@Test
	public void hasPath_returns_true_if_there_is_direct_flight_between_Bangalore_and_Singapore (){
		Path path = new Path();
		assertTrue(path.hasPath("Bangalore", "Singapore"));
		assertTrue(path.hasPath("Singapore", "Bangalore"));
	}

	@Test
	public void hasPath_returns_true_if_there_is_direct_flight_between_Seoul_and_Beijing (){
		Path path = new Path();
		assertTrue(path.hasPath("Seoul", "Beijing"));
		assertTrue(path.hasPath("Beijing", "Seoul"));
	}

	@Test
	public void hasPath_returns_true_if_there_is_direct_flight_between_Beijing_and_Tokyo (){
		Path path = new Path();
		assertTrue(path.hasPath("Beijing", "Tokyo"));
		assertTrue(path.hasPath("Tokyo", "Beijing"));
	}
	
	@Test
	public void hasPath_returns_true_if_there_is_direct_flight_between_Singapore_and_Dubai (){
		Path path = new Path();
		assertTrue(path.hasPath("Singapore", "Dubai"));
		assertTrue(path.hasPath("Dubai", "Singapore"));
	}

	@Test
	public void hasPath_returns_true_if_there_is_direct_flight_between_Singapore_and_Seoul (){
		Path path = new Path();
		assertTrue(path.hasPath("Singapore", "Seoul"));
		assertTrue(path.hasPath("Seoul", "Singapore"));
	}

	@Test
	public void hasPath_returns_true_if_there_is_flight_between_Bangalore_and_Tokyo (){
		Path path = new Path();
		assertTrue(path.hasPath("Bangalore", "Tokyo"));
	}

	@Test
	public void hasPath_returns_true_if_there_is_flight_between_Tokyo_and_Bangalore (){
		Path path = new Path();
		assertTrue(path.hasPath("Tokyo", "Bangalore"));
	}

	@Test
	public void givePath_gives_full_path_between_two_places (){
		Path path = new Path();
		assertEquals("Bangalore->Singapore", path.printPath("Bangalore", "Singapore"));
		assertEquals("Bangalore->Singapore->Seoul->Beijing->Tokyo", path.printPath("Bangalore", "Tokyo"));
	}
}