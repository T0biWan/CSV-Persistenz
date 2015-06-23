package tests;

import classes.ObservableContactDetails;
import csvio.CSVContactsReader;
import csvio.CSVContactsWriter;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class CSVContactsWriterTest {
	
	// Wie kann man kontakt1-3 in contacts speichern??? Habe es nicht richtig hinbekommen.
	// Klasse funktioniert nicht
	
	private CSVContactsWriter csvContactsWriter = new CSVContactsWriter();
	
	@Test
	public void testeWriteContacts() throws IOException {
    ObservableContactDetails[] expectedContacts = TestData.getValidContacts();

    csvContactsWriter.writeEntityList(expectedContacts, "CSVContactsWriterTest", "::");
    ObservableContactDetails[] contacts = CSVContactsReader.readEntityList("CSVContactsWriterTest", "::");
    assertEquals(expectedContacts, contacts);
	}

}


