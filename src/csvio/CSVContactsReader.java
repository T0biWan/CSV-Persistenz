package csvio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import classes.ContactDetails;
import classes.ObservableContactDetails;
import exceptions.ContactFormatException;

public class CSVContactsReader {
	
	/* Helferklasse, die uns ermöglicht, filename als String zu übergeben - ruft dann die untere readEntityList() aus */
	public static ObservableContactDetails[] readEntityList(String dateiname, String splitter){
		Path source = Paths.get(dateiname);
		return readEntityList(source, splitter);
	}
	
	/*
	 * wie beim Writer nur andersrum lesen wir unsere Datei ein 
	 * und kreieren uns aus den eingelesenen Strings wieder ein Objekt. 
	 * */
	public static ObservableContactDetails[] readEntityList(Path source, String splitter){
		List<ObservableContactDetails> target = new ArrayList<>();
		try {
			List<String> lines = Files.readAllLines(source);
			for (String line : lines){
				
				try {
					target.add(new ObservableContactDetails(line.split(splitter)));
				} catch (ContactFormatException e) {
					// TODO Auto-generated catch block
					System.out.println(e.getMessage());
					e.printStackTrace();
				}
			}
		} catch (IOException ex) { ex.printStackTrace(System.err);
			target.addAll(null); //null addition to target to indicate problem
		}
		
		return target.toArray(new ObservableContactDetails[target.size()]);
	}

}
