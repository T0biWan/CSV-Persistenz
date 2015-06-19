package übungenZumSkript;
import java.util.ArrayList;
import java.util.List;

public class Lesen {
	
	public static void main(String[] args) {
		PokemonReader reader = new PokemonReader();
		List<Pokemon> inhalt = new ArrayList();
		
		inhalt = reader.ausDateiLesen("Pokémon", ":");
		
		for(Pokemon p : inhalt) {
			System.out.println(p.toString());
		}
	}
}
