package tests;

import classes.ObservableContactDetails;
import csvio.CSVContactsWriter;
import exceptions.FormatException;
import exceptions.StringIsEmptyException;
import exceptions.WertebereichException;
import exceptions.ZeitenKollisionException;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class IOExceptionTest {
	
	// Dieser Test funktioniert nicht, da ich keinen Plan habe, wann eine IOException fliegt.
	// Ich habe geschaut, ob das evt über die Schließung von Kanälen erfolgt, 
	// aber die Reader und Writer kennen die Methode close gar nicht.. KP wo mein Fehler liegt.
	
  // Eine IOException kann erzeugt werden, wenn z.B. ein Verzecinis existiert, das so heißt, wie eigentlich der Dateiname...

  private CSVContactsWriter csvContactsWriter = new CSVContactsWriter();

  private Path basePath = Paths.get(System.getProperty("java.io.tmpdir"));

	@Test (expected = IOException.class)
	public void testeIOException() throws IOException, FormatException, WertebereichException, StringIsEmptyException, ZeitenKollisionException {
    File baseDir = basePath.toFile();
    File testDir = new File(baseDir, "test");
    testDir.mkdirs();

    Path filePath = basePath.resolve("test");
    ObservableContactDetails[] expectedContacts = TestData.getValidContacts();
    csvContactsWriter.writeEntityList(expectedContacts, filePath, "::");
	}

}
