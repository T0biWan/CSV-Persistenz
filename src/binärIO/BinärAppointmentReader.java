package binärIO;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import classes.Appointment;
import exceptions.FormatException;
import exceptions.StringIsEmptyException;
import exceptions.WertebereichException;
import exceptions.ZeitenKollisionException;

public class BinärAppointmentReader {
	
	//Path wird generiert.
	//Aus der Textdatei werden die Daten als fortlaufender einzeiliger String eingelesen.
	//Mit der Methode split() wird der String aufgeteilt in Attribute.
	//Diese werden indexweise in einem Array gespeichert.
	//Da wir wissen wie viele Attribute ein Objekt hat, gehen wir es index für index durch und erstellen Objekte aus den Attributen.
	//Die Objekte werden einer Collection hinzugefügt die, nach dem schließen des Streams, zurückgegeben wird.
	public List<Appointment> readAppointment(String dateiname, String splitter) throws IOException, FormatException, WertebereichException, StringIsEmptyException, ZeitenKollisionException {
		String path = "output/" + dateiname + ".bin";
		List<Appointment> inputCollection = new ArrayList();
		DataInputStream input = new DataInputStream(new BufferedInputStream(new FileInputStream(path)));
		String inputString = input.readUTF();
		String[] attribute = inputString.split(splitter);
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
