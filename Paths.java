import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

public class Paths{
	static Map<String,List<String>> routes = new HashMap<String,List<String>>();
	static {
		List<String> bangalore = new ArrayList<String>();
		bangalore.add("Singapore");
		List<String> singapore = new ArrayList<String>();
		singapore.add("Seoul");
		singapore.add("Dubai");
		List<String> seoul = new ArrayList<String>();
		seoul.add("Beijing");
		List<String> beijing = new ArrayList<String>();
		beijing.add("Tokyo");

		routes.put("Bangalore",bangalore);
		routes.put("Singapore",singapore);
		routes.put("Seoul",seoul);
		routes.put("Beijing",beijing);
	}
	
	public boolean isPresent(String place) {
		return routes.containsKey(place);
	}
	
	public boolean pathExists(String source,String destination) {
		return routes.get(source).contains(destination);
	}
	
	public static void main(String[] args) {

		String source = new String(args[0]);
		String destination = new String(args[1]);

		Paths p = new Paths();
		if(!p.isPresent(source)){
			System.out.println("No city named \""+source+"\" in database");
			return;
		}
		if(p.pathExists(source, destination)){
			System.out.println("True");
		}else{
			System.out.println("No city named \""+destination+"\" in database");
		}
	}
}

