package binärIO;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import classes.Appointment;

public class BinärAppointmentWriter {
	
	//Pfad wird erstellt
	//Stream wird geöffnet
	//Hier ist wichtig zu wissen, wir können nicht jedes Attribut oder Objekt einzeln mit writeUTF schreiben.
	//Das macht Probleme, wir müssen dann beim Einlesen wissen wie viele Objekte wir geschrieben haben...
	//Also machen wir alles in einem einzigen Schreibbefehl.
	//Aus diesem Grund werden alle Attribute der Objekte formatiert und hintereinander gesetzt.
	//Dieser String wird dann geschrieben.
	//Der Stream wird geschlossen
	public void writeAppointment(List<Appointment> appointment, String dateiname, String splitter) throws IOException {
		String path = "output/" + dateiname + ".bin";
		DataOutputStream output = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(path)));
		String outputString = "";
		for(Appointment index : appointment) {
			outputString = outputString + formatierung(index, splitter);
			
		}
		output.writeUTF(outputString);
		output.flush();
		output.close();
	}
	
	public String formatierung(Appointment appointment, String splitter) {
		return appointment.getDatum() +splitter+ appointment.getTitel() +splitter+ appointment.getStartzeit() +splitter+ appointment.getEndzeit() +splitter+ appointment.getKategorie() +splitter+ appointment.getNotiz() +splitter;
	}

}
