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
	
	public static void main(String[] args) {

		String source = new String(args[0]);
		String destination = new String(args[1]);

		Paths p = new Paths();
		p.insertPath("Bangalore","Singapore");
		p.insertPath("Singapore","Seoul");
		p.insertPath("Singapore","Dubai");
		p.insertPath("Seoul","Beijing");
		p.insertPath("Beijing","Tokyo");

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

