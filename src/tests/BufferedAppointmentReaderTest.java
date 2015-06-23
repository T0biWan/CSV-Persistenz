package tests;

import bufferedIO.BufferedAppointmentReader;
import classes.Appointment;
import exceptions.FormatException;
import exceptions.StringIsEmptyException;
import exceptions.WertebereichException;
import exceptions.ZeitenKollisionException;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class BufferedAppointmentReaderTest {
	
	private BufferedAppointmentReader bufferedReader = new BufferedAppointmentReader();
	
	@Test
	public void testeBufferedReader() throws IOException, FormatException, WertebereichException, StringIsEmptyException, ZeitenKollisionException {
    List<Appointment> expectedCollection = TestData.getTermin2(5);
    List<Appointment> collection = bufferedReader.readAppointment("BufferedTermine", "::");

		assertEquals(expectedCollection, collection);
	}

}
