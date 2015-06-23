package tests;

import static org.junit.Assert.*;

import classes.ObservableContactDetails;
import csvio.CSVContactsReader;
import org.junit.Before;
import org.junit.Test;

public class CSVContactsReaderTest {

	@Test
	public void testReadContacts() {
    ObservableContactDetails[] expectedContacts = TestData.getValidContacts();
    ObservableContactDetails[] contacts = CSVContactsReader.readEntityList("output/CSVContacts.csv", "::");
    assertEquals(expectedContacts, contacts);
	}

}
