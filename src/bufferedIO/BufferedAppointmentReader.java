package bufferedIO;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import classes.Appointment;
import exceptions.FormatException;
import exceptions.StringIsEmptyException;
import exceptions.WertebereichException;
import exceptions.ZeitenKollisionException;

public class BufferedAppointmentReader {
	
	//Aus filename wird der pfad generiert.
	//Es wird ein Stream erstellt der Analog zum BufferedWriter "zusammengesteckt" ist.
	//Der Inhalt der Textdatei (einzeilig) wird in einen String gelesen und mit dem Splitter, attributweise, in ein Array aufgeteilt.
	//Aus dem Array-indizes werden Appointment-Objekte erstellt, diese werden in einer Collection gespeichert.
	//Die Collection ist der Rückgabewert der Methode.
	public List<Appointment> readAppointment(String filename, String splitter) throws IOException, FormatException, WertebereichException, StringIsEmptyException, ZeitenKollisionException {
		String path = "output/" + filename + ".txt";
		List<Appointment> inputCollection = new ArrayList();
		BufferedReader input = new BufferedReader(new InputStreamReader(new FileInputStream (path)));
		String lesen = input.readLine();
		String [] attribute = lesen.split(splitter);
		int index = 0;
		for(int i = 0; i < attribute.length / 6; i++) {
			Appointment appointment = new Appointment();
			appointment.setDatum(attribute[index++]);
			appointment.setTitel(attribute[index++]);
			appointment.setStartzeit(attribute[index++]);
			appointment.setEndzeit(attribute[index++]);
			appointment.setKategorie(attribute[index++]);
			appointment.setNotiz(attribute[index++]);
			inputCollection.add(appointment);
		}
		input.close();
		return inputCollection;
	}

}
