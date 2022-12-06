package Day4;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashSet;
import java.util.Set;

public class Part1 {
	public static void main(String[] args) throws IOException {
		String path = ".\\src\\Day4\\data.txt";
		final String[] arr = Files.readString(Path.of(path)).lines().toArray(String[]::new);
		
		
		int counter = 0;
		for (String string : arr) {
			String[] passphrases = (string.split(" "));
			Set<String> set = new HashSet<>();
			for (String str : passphrases) {
				set.add(str);
			}
			if (set.size() == passphrases.length) {
				counter++;
			}
		}
		
		System.out.println(counter);
		
	}
}
