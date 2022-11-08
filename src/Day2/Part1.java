package Day2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Part1 {
	public static void main(String[] args) {
		File file = new File(".\\src\\Day2\\data.txt");
		
		Scanner scan;
		try {
			scan = new Scanner(file);
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
			return;
		}
		
		List<Integer> inputData = new ArrayList<>();
		while (scan.hasNextInt()) {
			inputData.add(scan.nextInt());		// таблица записана в одну строку
		}
		
		scan.close();	
		
		System.out.println(findChecksum(inputData));
	}
	
	public static int findChecksum(List<Integer> inputData) {
		int checksum = 0;
		for (int i = 0; i < 16; i++) {   // 16 строк в таблице входных данных
			int max = Integer.MIN_VALUE;
			int min = Integer.MAX_VALUE;
			for (int j = 0; j < 16; j++) {		// 16 столбцов в таблице входных данных
				int index = 16 * i + j;			// вычисляет индекс элемента таблицы в строке
				int temp = inputData.get(index);
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
