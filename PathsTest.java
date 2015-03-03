import org.junit.Test;
import static org.junit.Assert.*;


public class PathsTest {
	
	@Test
	public void isCityPresent_checks_whether_city_is_prsent (){
		Paths paths = new Paths();
		assertFalse(paths.isPresent("Chennai"));
		assertTrue(paths.isPresent("Dubai"));
		assertTrue(paths.isPresent("Tokyo"));
		assertTrue(paths.isPresent("Singapore"));
		assertTrue(paths.isPresent("Beijing"));
	}

	@Test
	public void hasPath_returns_true_if_there_is_direct_flight_between_Bangalore_and_Singapore (){
		Paths paths = new Paths();
		assertTrue(paths.hasPath("Bangalore", "Singapore"));
		assertTrue(paths.hasPath("Singapore", "Bangalore"));
	}

	@Test
	public void hasPath_returns_true_if_there_is_direct_flight_between_Seoul_and_Beijing (){
		Paths paths = new Paths();
		assertTrue(paths.hasPath("Seoul", "Beijing"));
		assertTrue(paths.hasPath("Beijing", "Seoul"));
	}

	@Test
	public void hasPath_returns_true_if_there_is_direct_flight_between_Beijing_and_Tokyo (){
		Paths paths = new Paths();
		assertTrue(paths.hasPath("Beijing", "Tokyo"));
		assertTrue(paths.hasPath("Tokyo", "Beijing"));
	}
	
	@Test
	public void hasPath_returns_true_if_there_is_direct_flight_between_Singapore_and_Dubai (){
		Paths paths = new Paths();
		assertTrue(paths.hasPath("Singapore", "Dubai"));
		assertTrue(paths.hasPath("Dubai", "Singapore"));
	}

	@Test
	public void hasPath_returns_true_if_there_is_direct_flight_between_Singapore_and_Seoul (){
		Paths paths = new Paths();
		assertTrue(paths.hasPath("Singapore", "Seoul"));
		assertTrue(paths.hasPath("Seoul", "Singapore"));
	}

	@Test
	public void hasPath_returns_true_if_there_is_flight_between_Bangalore_and_Tokyo (){
		Paths paths = new Paths();
		assertTrue(paths.hasPath("Bangalore", "Tokyo"));
	}

	@Test
	public void hasPath_returns_true_if_there_is_flight_between_Tokyo_and_Bangalore (){
		Paths paths = new Paths();
		assertTrue(paths.hasPath("Tokyo", "Bangalore"));
	}

	@Test
	public void givePath_gives_full_path_between_two_places (){
		Paths paths = new Paths();
		assertEquals("Bangalore->Singapore", paths.getPath("Bangalore", "Singapore"));
		assertEquals("Bangalore->Singapore->Seoul->Beijing->Tokyo", paths.getPath("Bangalore", "Tokyo"));
	}
}