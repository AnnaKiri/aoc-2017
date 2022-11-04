package Day1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Part1 {
	public static void main(String[] args) {
		String path = ".\\src\\Day1\\data.txt";
		File file = new File(path);
		
		try {
			Scanner scan = new Scanner(file);
			List<Integer> captcha = new ArrayList<>();
			
			String str = scan.nextLine();						// у нас есть очень большая последовательность цифр, мы считали ее как строку и поместили в str
			for (int i = 0; i < str.length(); i++) {			// теперь проходимся по str по каждому ее символу с индексом i
																// что бы каждый отдельный символ в строке переделать в int, мы должны этот символ str переделать в char, потом из char в string, и из string в int
		//		char symbol = str.charAt(i);		 				мы не можем сразу из char сделать int, у Character ограниченные методы, поэтому лучше использовать Integer.parseInt
																//	Integer.parseInt(str) переведет всю строку целиком, а Integer.parseInt(str(i)) не работает
		//		String stringChar = String.valueOf(symbol);			поэтому идем по сложному пути через char
								
		//		int digit = Integer.parseInt(stringChar);

				int digit = Integer.parseInt(String.valueOf(str.charAt(i)));  // короткая запись трех строк выше без создания отдельных переменных

				captcha.add(digit);
			}
			
			scan.close();
			
			int sum = 0;
			for (int i = 0; i < captcha.size(); i++) {	
				int indexNext = i + 1;
				if (indexNext == captcha.size()) {
					indexNext = 0;
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
