package übungenZumSkript;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class PokemonWriter {
	public String CSVFormatierung(Pokemon p, String splitter) {
		return p.getName() +splitter+ p.getNummer() + splitter+ p.getTyp() +splitter+ p.getLevel();
	}
	
	public void inDateiSchreiben(String dateiname, List<Pokemon> list) throws IOException {
		String pfad = "output/" + dateiname + ".csv";
		Path path = Paths.get(pfad);
		List<String> zeilen = new ArrayList();
		
		for(Pokemon p : list) {
			zeilen.add(CSVFormatierung(p, ":"));
		}
		
		Files.write(path,  zeilen);
	}
}
