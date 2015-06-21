package tests;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import classes.Appointment;
import csvio.CSVAppointmentReader;
import csvio.CSVAppointmentWriter;
import exceptions.FormatException;
import exceptions.StringIsEmptyException;
import exceptions.WertebereichException;
import exceptions.ZeitenKollisionException;

public class CSVAppointmentReaderTest {

	CSVAppointmentReader csvAppointmentReader = new CSVAppointmentReader();

	
	@BeforeClass
	public static void beforeClass() throws FormatException, WertebereichException, ZeitenKollisionException, StringIsEmptyException, IOException {
		
//		Appointment termin2 = new Appointment("21/06/2015", "Uni", "10:00", "18:00", "Lernen", "Das ist ein Test");
//		
//		List<Appointment> collection = new ArrayList();
//		for(int i = 0; i < 5; i++) {
//			collection.add(termin2);
//		}
//		
//		csvAppointmentWriter.writeAppointment(collection, "Lernen", "::");
		
	}
	
	
	@Test
	public void testeReader() throws IOException, FormatException, WertebereichException, StringIsEmptyException, ZeitenKollisionException {
		
		Appointment termin2 = new Appointment("21/06/2015", "Uni", "10:00", "18:00", "Lernen", "Das ist ein Test");
		
		List<Appointment> collection = new ArrayList();
		for(int i = 0; i < 5; i++) {
			collection.add(termin2);
		}
		
		
		collection = csvAppointmentReader.readAppointment("Lernen", "::");
		
		assertEquals(collection, collection);
		System.out.println(collection);
		
	}

}
