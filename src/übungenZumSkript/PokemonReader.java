package übungenZumSkript;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class PokemonReader {
	
	public List<Pokemon> ausDateiLesen (String dateiname, String splitter) {
		List<Pokemon> inhalt = new ArrayList();
		String pfad = "output/" + dateiname + ".csv";
		Path path = Paths.get(pfad);
		
		try {
			List<String> lines = Files.readAllLines(path);
			for(String line : lines) {
				String [] attribute = line.split(":");
				inhalt.add(new Pokemon(attribute [0], Integer.parseInt(attribute [1]), attribute [2], Integer.parseInt(attribute [3])));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return inhalt;
	}
}

