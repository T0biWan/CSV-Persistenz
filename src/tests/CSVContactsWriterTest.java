package tests;

import static org.junit.Assert.*;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import classes.Appointment;
import classes.ObservableContactDetails;
import csvio.CSVAppointmentWriter;
import csvio.CSVContactsWriter;
import exceptions.FormatException;
import exceptions.StringIsEmptyException;
import exceptions.WertebereichException;
import exceptions.ZeitenKollisionException;

public class CSVContactsWriterTest {
	
	// Wie kann man kontakt1-3 in contacts speichern??? Habe es nicht richtig hinbekommen.
	// Klasse funktioniert nicht

	static ObservableContactDetails kontakt1, kontakt2, kontakt3;

	ObservableContactDetails[] contacts;
	
	CSVContactsWriter csvContactsWriter = new CSVContactsWriter();
	
	
	

	@BeforeClass
	public static void beforeClass() throws FormatException, WertebereichException, ZeitenKollisionException, StringIsEmptyException, IOException {
		
		kontakt1 = new ObservableContactDetails();
		kontakt2 = new ObservableContactDetails("Inga", "Schwarze", "Tegeler Weg 107", "015253478533", "Inga.Schwarze@zalando.de");
		kontakt2 = new ObservableContactDetails("Robert", "Dziuba", "Müllerstraße 142", "0123456", "robertodziuba@gmail.com");
		System.out.println(kontakt2);
		
		
		
		
	}

	
	@Test
	public void testeWriteContacts() throws IOException {
		
	
		
		csvContactsWriter.writeEntityList(contacts, "Lernen", "::");
		assertEquals(contacts, contacts);
		
	}
	
	

}


