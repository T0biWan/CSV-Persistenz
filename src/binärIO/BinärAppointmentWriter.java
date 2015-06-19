package binärIO;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import classes.Appointment;

public class BinärAppointmentWriter {
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
