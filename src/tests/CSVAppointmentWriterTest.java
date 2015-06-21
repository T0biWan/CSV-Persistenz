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

import csvio.CSVAppointmentWriter;
import classes.Appointment;
import exceptions.FormatException;
import exceptions.StringIsEmptyException;
import exceptions.WertebereichException;
import exceptions.ZeitenKollisionException;

/*
 * Diese Test-Klasse testet, ob das Schreiben funktioniert.
 */

public class CSVAppointmentWriterTest {
	
	static Appointment termin1, termin2, termin3;
	
	CSVAppointmentWriter csvAppointmentWriter = new CSVAppointmentWriter();
	
	
	

	@BeforeClass
	public static void beforeClass() throws FormatException, WertebereichException, ZeitenKollisionException, StringIsEmptyException, IOException {
		
		termin1 = new Appointment();
		termin2 = new Appointment("21/06/2015", "Uni", "10:00", "18:00", "Lernen", "Das ist ein Test");
		termin3 = new Appointment("22/06/2015", "Mediendesign", "10:00", "11:30", "Vorlesung", "Wir lernen mega spannende Dinge");
		System.out.println(termin3);
		
		
	}

	@Test
	public void testeWriteAppointmentEinzelnerTermin() throws IOException {
		
		
		csvAppointmentWriter.writeAppointment(termin2, "Lernen", "::");
		assertEquals(termin2, termin2);
		
	}
	
	
	@Test
	public void testeWriteAppointmentTerminCollection() throws IOException {
		
		List<Appointment> collection = new ArrayList();
			for(int i = 0; i < 5; i++) {
			collection.add(termin2);
			}
		
			// Wieso an dieser Stelle kein try/catch, im Buffered aber schon?
		csvAppointmentWriter.writeAppointment(collection, "Lernen", "::");
		assertEquals(collection, collection);
		System.out.println(collection);
	}
	
	
	@Test
	public void testeWriteAppointmentPath() throws IOException {
		
		Path path = Paths.get("output/" + "Vorlesung" + ".csv");
		csvAppointmentWriter.writeAppointment(termin3, path, "::");
		
		assertEquals(termin3, termin3);
		
	}
	
	
	
	@Test
	public void testeWriteAppointmentPathCollection() throws IOException {
		
		List<Appointment> collection = new ArrayList();
		for(int i = 0; i < 5; i++) {
			collection.add(termin2);
		}
		Path path = Paths.get("output/" + "Uni" + ".csv");
		csvAppointmentWriter.writeAppointment(collection, path, "::");
		assertEquals(collection, collection);
		
	}
		
	

}
