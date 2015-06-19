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

public class CSVAppointmentReader {

	public List<Appointment> readAppointment(String filename, String splitter) throws IOException, FormatException, WertebereichException, StringIsEmptyException, ZeitenKollisionException {
		Path path = Paths.get("output/" + filename + ".csv");
		return readAppointment(path, splitter);
	}
	
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
