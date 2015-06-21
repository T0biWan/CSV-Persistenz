package bufferedIO;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import classes.Appointment;

public class BufferedAppointmentWriter {
	
	//Pfad wird erzeugt
	//Stream geöffnet
	//Die übergebene Collection wird durchiteriert
	//Jeder Index wird formatiert und per Stream in den Speicher geschrieben
	//Flush schreibt dann aus dem Speicher in die Textdatei.
	//Dann wird der Stream geschlossen.
	public void writeAppointment(List<Appointment> appointment, String filename, String splitter) throws IOException {
		String path = "output/" + filename + ".txt";
		BufferedWriter output = new BufferedWriter(new OutputStreamWriter( new FileOutputStream(path)));
		for (Appointment index : appointment) {
			output.write(formatAppointmentToCSV(index, splitter));
		}
		output.flush();
		output.close();
	}

	//Formatierung
	//Am Ende eines Objektes kommt ebenfalls das Trennzeichen zum Einsatz, da wir nun Zeilenweise schreiben ermöglicht das uns die Objekte zu unterscheiden.
	private String formatAppointmentToCSV(Appointment appointment, String splitter) {
		return appointment.getDatum()+ splitter
				+ appointment.getTitel() + splitter
				+ appointment.getStartzeit() + splitter
				+ appointment.getEndzeit() + splitter
				+ appointment.getKategorie() + splitter
				+ appointment.getNotiz() + splitter;
	}
}
