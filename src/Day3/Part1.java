package Day3;

import java.util.HashMap;
import java.util.Map;

public class Part1 {
	public static void main(String[] args) {

		Map<String, Integer> map = new HashMap<>();
		Pointer ptr = new Pointer(0, 0);
		
		map.put(ptr.getCoordString(), 1);
		ptr.moveToRight();
		map.put(ptr.getCoordString(), 2);
		
		for (int i = 3; i <= 361527; i++) {
			newCoordinates(map, ptr);
			map.put(ptr.getCoordString(), i);
		}
		
		System.out.println(Math.abs(ptr.getX()) + Math.abs(ptr.getY()));
	}
	
	public static void newCoordinates(Map<String, Integer> map, Pointer ptr) {
		boolean leftBusy = map.containsKey(ptr.getX() + ";" + (ptr.getY() - 1));		// !=null
		boolean downBusy = map.containsKey((ptr.getX() + 1) + ";" + ptr.getY());
		boolean rightBusy = map.containsKey(ptr.getX() + ";" + (ptr.getY() + 1));
		boolean upBusy = map.containsKey((ptr.getX() - 1) + ";" + ptr.getY());
		
		if (leftBusy && !upBusy) {
			ptr.moveToUp();
		} else if (!leftBusy && downBusy) {
			ptr.moveToLeft();
		} else if (rightBusy && !downBusy) {
			ptr.moveToDown();
		} else if (upBusy && !rightBusy) {
			ptr.moveToRight();
		}
	}
}
