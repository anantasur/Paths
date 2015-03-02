import java.util.Map;
import java.util.HashMap;

public class Paths{
	private Map<String, String> map = new HashMap<String, String>();
	
	public void insertPath(String start,String destination) {
		map.put(new String(start), new String(destination));
	}

	public boolean pathExists(String start,String destination) {
		return destination.equals(map.get(start));
	} 
}