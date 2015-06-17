package klassen;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import exceptions.ContactFormatException;

public class CSVContactsReader {
	
	public static List<Contact> readEntityList(String dateiname, String splitter){
		Path source = Paths.get(dateiname);
		return readEntityList(source, splitter);
	}
	
	public static List<Contact> readEntityList(Path source, String splitter){
		List<Contact> target = new ArrayList<>();
		try {
			List<String> lines = Files.readAllLines(source);
			for (String line : lines){
				try{
					target.add(new Contact(line.split(splitter)));
				} catch (ContactFormatException ex) {ex.printStackTrace(System.err);
					target.add(new Contact()); // empty contact to indicate problem
				}
				
			}
		} catch (IOException ex) { ex.printStackTrace(System.err);
			target.addAll(null); //null addition to target to indicate problem
		}
		return target;
	}

}
