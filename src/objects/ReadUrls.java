package objects;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ReadUrls {

public static Map<String, String> readUrls() {
		
		Map<String, String> urls = new HashMap<>();
		File myObject = new File("src\\urls.txt");
		Scanner myReader;
		
		try {
			myReader = new Scanner(myObject);
			while (myReader.hasNextLine()) {
				String data = myReader.nextLine();
				String values[] = data.split("`");
				System.out.println(values[0] + " " + values[1]);
				urls.put(values[0], values[1]);
			}
			myReader.close();
		} catch (FileNotFoundException e) {
			System.out.println("Error");
			e.printStackTrace();
		}

		return urls;

	}
}
