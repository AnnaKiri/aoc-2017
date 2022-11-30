package Day3;

import java.util.HashMap;
import java.util.Map;

public class Part2 {
	public static void main(String[] args) {

		Map<String, Integer> map = new HashMap<>();
		Pointer ptr = new Pointer(0, 0);
		
		map.put(ptr.getCoordString(), 1);
		ptr.moveToRight();
		map.put(ptr.getCoordString(), 1);
		
		while (true) {
			newCoordinates(map, ptr);
			map.put(ptr.getCoordString(), findNewValue(map, ptr));
			
			if (map.get(ptr.getCoordString()) > 361527) {
				System.out.println(map.get(ptr.getCoordString()));
				break;
			}
		}
		
	}
	
	public static void newCoordinates(Map<String, Integer> map, Pointer ptr) {
		boolean leftBusy = map.containsKey(ptr.getX() + ";" + (ptr.getY() - 1));
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
	
	public static int findNewValue(Map<String, Integer> map, Pointer ptr) {
		int value = 0;
		for (int i = -1; i <= 1; i++) {
			for (int j = -1; j <= 1; j++) {
				if (i == ptr.getX() && j == ptr.getY()) {
					continue;
				}
				
				int newX = ptr.getX() + i;
				int newY = ptr.getY() + j;
				
				value += map.containsKey(newX + ";" + newY) ? map.get(newX + ";" + newY) : 0; 
				
//				if (map.containsKey((ptr.getX() + i) + ";" + (ptr.getY() + j))) {
//					value += map.get((ptr.getX() + i) + ";" + (ptr.getY() + j));
//				}
			}
		}
		return value;
	}
	
}

