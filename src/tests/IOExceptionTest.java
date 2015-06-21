package tests;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import bufferedIO.BufferedAppointmentReader;
import bufferedIO.BufferedAppointmentWriter;
import csvio.CSVAppointmentReader;
import csvio.CSVAppointmentWriter;
import classes.Appointment;
import exceptions.FormatException;
import exceptions.StringIsEmptyException;
import exceptions.WertebereichException;
import exceptions.ZeitenKollisionException;

public class IOExceptionTest {
	
	// Dieser Test funktioniert nicht, da ich keinen Plan habe, wann eine IOException fliegt.
	// Ich habe geschaut, ob das evt über die Schließung von Kanälen erfolgt, 
	// aber die Reader und Writer kennen die Methode close gar nicht.. KP wo mein Fehler liegt.
	
	
	static Appointment termin1;
	
//	CSVAppointmentWriter csvAppointmentWriter = new CSVAppointmentWriter();
//	CSVAppointmentReader csvAppointmentReader = new CSVAppointmentReader();
	BufferedAppointmentWriter bufferedWriter = new BufferedAppointmentWriter();
//	BufferedAppointmentReader bufferedReader = new BufferedAppointmentReader();
	
	@BeforeClass
	public static void beforeClass() throws FormatException, WertebereichException, ZeitenKollisionException, StringIsEmptyException, IOException {
		
		termin1 = new Appointment("21/06/2015", "Uni", "10:00", "18:00", "Lernen", "Das ist ein Test");
		
	}


	@Test (expected = IOException.class)
	
	
	public void testeIOException() throws IOException, FormatException, WertebereichException, StringIsEmptyException, ZeitenKollisionException {
		
		List<Appointment> collection = new ArrayList();
			for(int i = 0; i < 5; i++) {
				collection.add(termin1);
			}
		
		bufferedWriter.writeAppointment(collection, "BufferedTermineCollection", "::");
	}

}
