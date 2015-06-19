package übungenZumSkript;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;



public class PokemonBinärReader {
	
	public Pokemon lesen(String dateiname) {
		String path = "output/" + dateiname + ".bin";
		Pokemon p = new Pokemon();
		try {
			DataInputStream input = new DataInputStream(new BufferedInputStream(new FileInputStream(path)));
			p.setName(input.readUTF());
			p.setNummer(input.readInt());
			p.setTyp(input.readUTF());
			p.setLevel(input.readInt());
			input.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return p;
	}

}
