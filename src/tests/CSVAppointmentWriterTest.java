package tests;

import classes.Appointment;
import csvio.CSVAppointmentReader;
import csvio.CSVAppointmentWriter;
import org.junit.Test;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import static org.junit.Assert.assertEquals;

/*
 * Diese Test-Klasse testet, ob das Schreiben funktioniert.
 */

public class CSVAppointmentWriterTest {

  private CSVAppointmentReader csvAppointmentReader = new CSVAppointmentReader();

  private CSVAppointmentWriter csvAppointmentWriter = new CSVAppointmentWriter();

  // temporärer Pfad
  private Path basePath = Paths.get(System.getProperty("java.io.tmpdir"));

  @Test
  public void testeWriteAppointmentEinzelnerTermin() throws Exception {
    csvAppointmentWriter.writeAppointment(TestData.TERMIN2, "writeAppointmentEinzelnerTerminTest", "::");
    List<Appointment> appointments = csvAppointmentReader.readAppointment("writeAppointmentEinzelnerTerminTest", "::");
    assertEquals(TestData.TERMIN2, appointments.get(0));
  }


  @Test
  public void testeWriteAppointmentTerminCollection() throws Exception {
    List<Appointment> expectedCollection = TestData.getValidAppointments();

    
    csvAppointmentWriter.writeAppointment(expectedCollection, "WriteAppointmentTerminCollectionTest", "::");
    List<Appointment> appointments = csvAppointmentReader.readAppointment("WriteAppointmentTerminCollectionTest", "::");
    assertEquals(expectedCollection, appointments);
  }

  @Test
  public void testeWriteAppointmentPath() throws Exception {
    Path filePath = basePath.resolve("Vorlesung.csv");
    csvAppointmentWriter.writeAppointment(TestData.TERMIN3, filePath, "::");
    List<Appointment> appointments = csvAppointmentReader.readAppointment(filePath, "::");
    assertEquals(TestData.TERMIN3, appointments.get(0));
  }

  @Test
  public void testeWriteAppointmentPathCollection() throws Exception {
    List<Appointment> expectedCollection = TestData.getValidAppointments();
    Path filePath = basePath.resolve("Uni.csv");
    csvAppointmentWriter.writeAppointment(expectedCollection, filePath, "::");
    List<Appointment> appointments = csvAppointmentReader.readAppointment(filePath, "::");
    assertEquals(expectedCollection, appointments);
  }


}
