package tests;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import bufferedIO.BufferedAppointmentReader;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import classes.Appointment;
import exceptions.FormatException;
import exceptions.StringIsEmptyException;
import exceptions.WertebereichException;
import exceptions.ZeitenKollisionException;
import bufferedIO.BufferedAppointmentWriter;

public class BufferedAppointmentWriterTest {

  private BufferedAppointmentReader bufferedReader = new BufferedAppointmentReader();

  // Diese Klasse wird getestet
	private BufferedAppointmentWriter bufferedWriter = new BufferedAppointmentWriter();

	@Test
	public void testeBufferedWriter() throws Exception {
    List<Appointment> expectedCollection = TestData.getValidAppointments();
    bufferedWriter.writeAppointment(expectedCollection, "BufferedAppointmentWriterTest", "::");
    List<Appointment> collection = bufferedReader.readAppointment("BufferedAppointmentWriterTest", "::");
		
		assertEquals(expectedCollection, collection);
	}

}
