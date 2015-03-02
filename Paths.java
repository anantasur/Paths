import java.util.Map;
import java.util.HashMap;

public class Paths{
	private Map<String, String> routes = new HashMap<String, String>();
	
	public void insertPath(String start,String destination) {
		routes.put(new String(start), new String(destination));
	}

	public boolean isPresent(String place) {
		return routes.containsKey(place);
	}
	
	public boolean pathExists(String start,String destination) {
		return destination.equals(routes.get(start));
	}
	
	// public static void main(String[] args) {
		
	// }
}

