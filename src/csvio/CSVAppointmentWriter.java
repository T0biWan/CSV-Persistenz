package csvio;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import classes.Appointment;

public class CSVAppointmentWriter {
	// Attribut
	final static Charset ENCODING = StandardCharsets.UTF_8;
	
	//Helferklasse, die aus String-Dateinamen einen Pfad bastelt
	//Dann wird die zweite Methode (Methodenüberladung) aufgerufen die einen Pfad verlangt
	public void writeAppointment(List<Appointment> appointment, String filename, String splitter) throws IOException {
		Path path = Paths.get("output/" + filename + ".csv");
		writeAppointment(appointment, path, splitter);
	}
	
	//Collection von Appointments wird entgegengenommen und durchiteriert.
	//Jeder Index entspricht einem Temrin, dieser wird in's richtige Format gebracht und einer zweiten Collection übergeben.
	//Anschließend wird letztere Collection in die Datei geschrieben.
	public void writeAppointment(List<Appointment> appointment, Path path, String splitter) throws IOException {
		List<String> lines = new ArrayList<>();
		for (Appointment index : appointment) {
			lines.add(formatAppointmentToCSV(index, splitter));
		}
		Files.write(path, lines, ENCODING);
	}

	//CSV-Formatierung:
	//aus einem gegebenem Objekt werden alle Attribute ausgelesen und von Trennzeichen getrennt, in einem String zusammengefasst.
	private String formatAppointmentToCSV(Appointment appointment, String splitter) {
		return appointment.getDatum()+ splitter
				+ appointment.getTitel() + splitter
				+ appointment.getStartzeit() + splitter
				+ appointment.getEndzeit() + splitter
				+ appointment.getKategorie() + splitter
				+ appointment.getNotiz();
	}
	
	//Helferklasse, die aus String-Dateinamen einen Pfad bastelt
	//Dann wird die zweite Methode aufgerufen die einen Pfad verlangt
	public void writeAppointment(Appointment appointment, String filename, String splitter) throws IOException {
		Path path = Paths.get("output/" + filename + ".csv");
		writeAppointment(appointment, path, splitter);
	}
	
	//Einzelnes Appointment wird geschrieben
	public void writeAppointment(Appointment appointment, Path path, String splitter) throws IOException {
		List<String> lines = new ArrayList<>();
		lines.add(formatAppointmentToCSV(appointment, splitter));
		Files.write(path, lines, ENCODING);
	}
}
