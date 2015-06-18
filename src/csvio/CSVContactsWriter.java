package csvio;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import classes.ObservableContactDetails;

public class CSVContactsWriter {
	final static Charset ENCODING = StandardCharsets.UTF_8;
	
	/* Helferklasse, die uns ermöglicht, filename als String zu übergeben - ruft dann die untere writeEntityList() aus */
	public static void writeEntityList(ObservableContactDetails[] contacts, String filename, String splitter) throws IOException {
		Path path = Paths.get(filename);
		writeEntityList(contacts, path, splitter);
	}
	
	/*
	 * writeEntityList bekommt als Parameter ein Array von ObservableContactDetails Objekten, 
	 * den Pfad wo gespeichert werden soll, und unseren Splitter.
	 * Dieses Array wird durchlaufen und pro ObservableContactDetails (also ein einzelner Kontakt) 
	 * an die Methode contactAsCSVLine übergeben. contactAsCSVLine gibt uns dann ein String mit unseren splitter zurück
	 * und wird in unsere Liste eingetragen.
	 * Dann wird diese Liste an Files.write übergeben. 
	 * write übernimmt dann das zeilenweise Schreiben in die Datei (path).
	 * Jeder Kontakt ist eine Zeile.
	 * */
	public static void writeEntityList(ObservableContactDetails[] contacts, Path path, String splitter) throws IOException {
		
		List<String> lines = new ArrayList<>();
		for (ObservableContactDetails contact : contacts) {
			lines.add(contactAsCSVLine(contact, splitter));
		}
		Files.write(path,  lines,  ENCODING);
	}
	
	/*
	 * contactAsCSVLine bekommt ein einzelnes ObservableContactDetails und liest dieses dank unserer genialen getters aus
	 * (Vorname,Nachname,Adresse,Telefonnummer,Mail). Diese werden mit unserem splitter als eine Stringzeile zurückgegeben. 
	 * WICHTIG: wir speichern keine Objekte sondern nur Zeilen von Strings.
	 * */
	private static String contactAsCSVLine(ObservableContactDetails c, String splitter) {
		return c.getVorname()+splitter+c.getNachname()+splitter+c.getAdresse()+splitter+c.getTelefonnummer()+splitter+c.getMail();
	}

}
