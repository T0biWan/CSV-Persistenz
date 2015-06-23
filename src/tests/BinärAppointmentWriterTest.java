package tests;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import binärIO.BinärAppointmentReader;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import classes.Appointment;
import exceptions.FormatException;
import exceptions.StringIsEmptyException;
import exceptions.WertebereichException;
import exceptions.ZeitenKollisionException;
import binärIO.BinärAppointmentWriter;

public class BinärAppointmentWriterTest {

  private BinärAppointmentReader binärReader = new BinärAppointmentReader();

  // Diese Klasse wird getestet
  private BinärAppointmentWriter binärWriter = new BinärAppointmentWriter();
	
	@Test
	public void testeBinärWriter() throws Exception {
    List<Appointment> expectedCollection = TestData.getValidAppointments();
		binärWriter.writeAppointment(expectedCollection, "BinärAppointmentWriterTest", "::");

    List<Appointment> collection = binärReader.readAppointment("BinärAppointmentWriterTest", "::");
		assertEquals(expectedCollection, collection);
	}

}
