package Day1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Part2 {
	public static void main(String[] args) {
		String path = ".\\src\\Day1\\data.txt";
		File file = new File(path);
		
		try {
			Scanner scan = new Scanner(file);
			List<Integer> captcha = new ArrayList<>();
			
			String str = scan.nextLine();
			for (int i = 0; i < str.length(); i++) {
				int digit = Integer.parseInt(String.valueOf(str.charAt(i)));
				captcha.add(digit);
			}
			
			scan.close();
			
			int sum = 0;
			for (int i = 0; i < captcha.size(); i++) {	
				int indexNext = i + captcha.size() / 2;
				if (indexNext >= captcha.size()) {
					indexNext = indexNext - captcha.size();
				}
				if (captcha.get(i) == captcha.get(indexNext)) {
					sum += captcha.get(i);
				}
			}
			
			System.out.println(sum);
			
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		}	
	}
}
