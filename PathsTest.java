import org.junit.Test;
import java.util.*;
import static org.junit.Assert.*;
import java.util.Map;
import java.util.HashMap;

public class PathsTest {	

	@Test
	public void there_is_no_path_between_Bangalore_Singapore(){
		Paths p = new Paths();
		p.insertPath("Bangalore","Singapore");
		assertTrue(p.pathExists("Bangalore","Singapore"));
	}

	@Test
	public void there_is_path_between_singapore_Seol(){
		Paths p = new Paths();
		assertTrue(!p.pathExists("Singapore","Seoul"));
	}

	@Test
	public void there_is_a_source_known_as_Bangalore(){
		Paths p = new Paths();
		p.insertPath("Bangalore","Singapore");
		assertTrue(p.isPresent("Bangalore"));
	}

	@Test
	public void there_is_a_source_known_as_Chennai(){
		Paths p = new Paths();
		p.insertPath("Bangalore","Singapore");
		assertTrue(!p.isPresent("Chennai"));
	}
}