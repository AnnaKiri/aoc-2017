package Day2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Part12DArray {
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
		int checksum = 0;
		for (int i = 0; i < 16; i++) {   // 16 строк в таблице входных данных
			int max = Integer.MIN_VALUE;
			int min = Integer.MAX_VALUE;
			for (int j = 0; j < 16; j++) {		// 16 столбцов в таблице входных данных
				int temp = inputData[i][j];
				if (temp > max) {
					max = temp;
				}
				
				if (temp < min) { 
					min = temp;
				}
			}
			int difference = max - min;
			checksum += difference;
		}
		
		return checksum;
	}
}
