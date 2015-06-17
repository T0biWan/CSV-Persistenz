package klassen;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class CSVContactsWriter {
	final static Charset ENCODING = StandardCharsets.UTF_8;
	
	public static void writeEntityList(List<Contact> contacts, String filename, String splitter) throws IOException {
		
		Path path = Paths.get(filename);
		writeEntityList(contacts, path, splitter);
		
	}
	
	public static void writeEntityList(List<Contact> contacts, Path path, String splitter) throws IOException {
		
		List<String> lines = new ArrayList<>();
		for (Contact contact : contacts) {
			lines.add(contactAsCSVLine(contact, splitter));
		}
		Files.write(path,  lines,  ENCODING);
	}
	
	private static String contactAsCSVLine(Contact c, String splitter) {
		return c.name+splitter+c.firstName+splitter+c.email+splitter+c.phone;
	}

}
