public class Paths {

	public static void main(String[] args) {
		String source = args[0];
		String destination = args[1];
		Path path = new Path();
		if(!path.isPresent(source)){
			System.out.println("No city named '"+source+"' in database");
			return;
		}
		if(!path.isPresent(destination)){
			System.out.println("No city named '"+destination+"' in database");
			return;
		}
		else
			System.out.println(path.printPath(source,destination));
	}
}