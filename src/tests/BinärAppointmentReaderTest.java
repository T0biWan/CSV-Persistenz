package tests;

import binärIO.BinärAppointmentReader;
import classes.Appointment;
import exceptions.FormatException;
import exceptions.StringIsEmptyException;
import exceptions.WertebereichException;
import exceptions.ZeitenKollisionException;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class BinärAppointmentReaderTest {

  // Diese Klasse wird getestet
  private BinärAppointmentReader binärReader = new BinärAppointmentReader();

  @Test
  public void testeBinärReader() throws FormatException, WertebereichException, ZeitenKollisionException, StringIsEmptyException, IOException {
    List<Appointment> expectedCollection = TestData.getTermin2(5);
    List<Appointment> collection = binärReader.readAppointment("BinärTermine", "::");

    assertEquals(expectedCollection, collection);
  }

}
