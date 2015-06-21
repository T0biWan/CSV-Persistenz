package tests;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import binärIO.BinärAppointmentReader;
import bufferedIO.BufferedAppointmentReader;
import classes.Appointment;
import exceptions.FormatException;
import exceptions.StringIsEmptyException;
import exceptions.WertebereichException;
import exceptions.ZeitenKollisionException;

public class BinärAppointmentReaderTest {
	
	
static Appointment termin1, termin2, termin3;
	
	BinärAppointmentReader binärReader = new BinärAppointmentReader();
	
	@BeforeClass
	public static void beforeClass() throws IOException, FormatException, WertebereichException, ZeitenKollisionException, StringIsEmptyException {
		
		termin1 = new Appointment();
		termin2 = new Appointment("21/06/2015", "Uni", "10:00", "18:00", "Lernen", "Das ist ein Test");
		termin3 = new Appointment("22/06/2015", "Mediendesign", "10:00", "11:30", "Vorlesung", "Wir lernen mega spannende Dinge");
		System.out.println(termin3);
		
	}

	@Test
	public void testeBinärReader() throws FormatException, WertebereichException, ZeitenKollisionException, StringIsEmptyException, IOException {
		
		
		Appointment termin2 = new Appointment("21/06/2015", "Uni", "10:00", "18:00", "Lernen", "Das ist ein Test");
		
		List<Appointment> collection = new ArrayList();
		for(int i = 0; i < 5; i++) {
			collection.add(termin2);
		}
		
		collection = binärReader.readAppointment("BinärTermine", "::");
		assertEquals(collection, collection);
	}

}
