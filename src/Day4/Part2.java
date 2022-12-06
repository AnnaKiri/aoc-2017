package Day4;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

public class Part2 {
	public static void main(String[] args) throws IOException {
		String path = ".\\src\\Day4\\data.txt";
		final String[] arr = Files.readString(Path.of(path)).lines().toArray(String[]::new);
		
		
		int counter = 0;
		for (String string : arr) {
			String[] passphrases = (string.split(" "));
			Set<String> set = new TreeSet<>();
			
			for (String str : passphrases) {
				char[] array = str.toCharArray();
				Arrays.sort(array);
				String line = String.valueOf(array);
				set.add(line);
			}
			
			if (set.size() == passphrases.length) {
				counter++;
			}
		}
		
		System.out.println(counter);
		
	}
}