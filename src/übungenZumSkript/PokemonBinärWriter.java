package übungenZumSkript;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import csv.Pokemon;

public class PokemonBinärWriter {
	public void schreiben(String dateiname, Pokemon p) {
		String path = "output/" + dateiname + ".bin";
		try {
			DataOutputStream out = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(path)));
			out.writeUTF(p.getName());
			out.writeInt(p.getNummer());
			out.writeUTF(p.getTyp());
			out.writeInt(p.getLevel());
			out.flush();
			out.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
