package übungenZumSkript;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;


public class Schreiben {

	public static void main(String[] args) {
		//Attribute
		Pokedex pokedex = new Pokedex();
		PokemonWriter writer = new PokemonWriter();

		
		try {
			writer.inDateiSchreiben("Pokémon", pokedex.inhalt);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
