package csvio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import classes.Appointment;
import classes.ObservableContactDetails;
import exceptions.ContactFormatException;
import exceptions.FormatException;
import exceptions.StringIsEmptyException;
import exceptions.WertebereichException;
import exceptions.ZeitenKollisionException;

/*
 * Reader Klasse: Nimmt Textdatei, liest Inhalt und erstellt daraus ein Objekt.
 */
public class CSVAppointmentReader {
	
	//Helferklasse, die aus String-Dateinamen einen Pfad bastelt.
	//Dann wird die zweite Methode aufgerufen die einen Pfad verlangt.
	public List<Appointment> readAppointment(String filename, String splitter) throws IOException, FormatException, WertebereichException, StringIsEmptyException, ZeitenKollisionException {
		Path path = Paths.get("output/" + filename + ".csv");
		return readAppointment(path, splitter);
	}
	
	//In eine Collection, die Strings entgegennimmt, wird der gesamte inhalt der Datei eingelesen.
	//Diese Collection wird mit einer erweiterten for-Schleife durchiteriert.
	//Jeder Index entspricht, durch die CSV-schreibweise, den Attributen eines Objektes.
	//Daher wird aus jedem Index ein Appointment erstellt. Dieses Objekt wird einer zweiten Colelction übergeben, die letztendlich der Rückgabewert der Methode ist.
	public List<Appointment> readAppointment(Path path, String splitter) throws IOException, FormatException, WertebereichException, StringIsEmptyException, ZeitenKollisionException {
		List<Appointment> input = new ArrayList();
		List<String> readLines = Files.readAllLines(path);
		for(String line : readLines) {
			String [] attribute = line.split(splitter);
			Appointment newAppointment = new Appointment();
			newAppointment.setDatum(attribute[0]);
			newAppointment.setTitel(attribute[1]);
			newAppointment.setStartzeit(attribute[2]);
			newAppointment.setEndzeit(attribute[3]);
			newAppointment.setKategorie(attribute[4]);
			newAppointment.setNotiz(attribute[5]);
			input.add(newAppointment);
		}
		return input;
	}

}
