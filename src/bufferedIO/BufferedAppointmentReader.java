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

	public List<Appointment> readAppointment(String filename, String splitter) throws IOException, FormatException, WertebereichException, StringIsEmptyException, ZeitenKollisionException {
//		List<Appointment> input = new ArrayList();
//		List<String> readLines = Files.readAllLines(path);
//		for(String line : readLines) {
//			String [] attribute = line.split(splitter);
//			Appointment newAppointment = new Appointment();
//			newAppointment.setDatum(attribute[0]);
//			newAppointment.setTitel(attribute[1]);
//			newAppointment.setStartzeit(attribute[2]);
//			newAppointment.setEndzeit(attribute[3]);
//			newAppointment.setKategorie(attribute[4]);
//			newAppointment.setNotiz(attribute[5]);
//			input.add(newAppointment);
//		}
//		return input;
		
		
		
		
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
