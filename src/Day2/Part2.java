package Day2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Part2 {
	public static void main(String[] args) {
		File file = new File(".\\src\\Day2\\data.txt");
		
		Scanner scan;
		try {
			scan = new Scanner(file);
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
			return;
		}
		
		int [][] inputData = new int [16][16];
		while (scan.hasNextInt()) {
			for(int i = 0; i<inputData.length; i++) {
				for(int j = 0; j<inputData[i].length; j++) {
					inputData[i][j] = scan.nextInt();
				}
			}
		}
		
		scan.close();	
		
		System.out.println(findChecksum(inputData));
	}
	
	public static int findChecksum(int [][] inputData) {
		int resSum = 0;
		for (int i = 0; i < 16; i++) {
			int resultOneLine =0;
			List<Integer> oneLine = new ArrayList<>();
			for (int l = 0; l < 16; l++) {
				oneLine.add(inputData[i][l]);
			}
			Collections.sort(oneLine);				// sort - Sorts the specified list into ascending order, according to the natural ordering of its elements.
			Collections.reverse(oneLine);			// reverse - Reverses the order of the elements in the specified list.
			
			for (int j = 0; j < 16; j++) {
				for (int k = j+1; k < 16; k++) {
					if (oneLine.get(j) % oneLine.get(k) == 0) {
						resultOneLine += oneLine.get(j) / oneLine.get(k);
					}
				}

			}
			resSum += resultOneLine;
		}
		
		return resSum;
	}
}
