package übungenZumSkript;
import java.util.ArrayList;
import java.util.List;


public class Pokedex {
	//Attribute
	Pokemon pokemon;
	List<Pokemon> inhalt = new ArrayList();
	
	public Pokedex () {
		fillList();
	}
	
	public void fillList() {
		inhalt.add(new Pokemon("Bisasam", 1, "Pflanze", 10));
		inhalt.add(new Pokemon("Bisaknosp", 2, "Pflanze", 10));
		inhalt.add(new Pokemon("Bisaflor", 3, "Pflanze", 10));
		inhalt.add(new Pokemon("Glumanda", 4, "Feuer", 10));
		inhalt.add(new Pokemon("Glutexo", 5, "Feuer", 10));
		inhalt.add(new Pokemon("Glurak", 6, "Feuer", 10));
		inhalt.add(new Pokemon("Schiggy", 7, "Wasser", 10));
		inhalt.add(new Pokemon("Schillok",8, "Wasser", 10));
		inhalt.add(new Pokemon("Turtok", 9, "Wasser", 10));
	}
	
	public void ausgeben() {
		for(Pokemon p : inhalt) {
			System.out.println(p.toString());
		}
	}
}
