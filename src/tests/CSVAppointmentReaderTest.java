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

	private CSVAppointmentReader csvAppointmentReader = new CSVAppointmentReader();
	
	
	@Test
	public void testeReader() throws IOException, FormatException, WertebereichException, StringIsEmptyException, ZeitenKollisionException {
    List<Appointment> expectedCollection = TestData.getTermin2(1);
    List<Appointment> collection = csvAppointmentReader.readAppointment("Lernen", "::");
		
		assertEquals(expectedCollection, collection);
	}

}
