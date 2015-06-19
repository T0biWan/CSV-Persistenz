package übungenZumSkript;
import csv.Pokemon;
import binär.BinReader;
import binär.BinWriter;
import binär.PokemonBinärReader;
import binär.PokemonBinärWriter;



public class Main {
	
	public static void main(String[] args) {
//		Writer w = new Writer();
//		MeinReader r = new MeinReader();
		BinWriter br = new BinWriter();
		BinReader bw = new BinReader();

//		w.schreib();
//		r.lesen();
		
//		br.schreib();
//		bw.lesen();
		
		PokemonBinärWriter pbw = new PokemonBinärWriter();
		PokemonBinärReader pbr = new PokemonBinärReader();
		Pokemon bisasam = new Pokemon("Bisasam", 1, "Pflanze", 10);
		pbw.schreiben("BinärPokémon", bisasam);
		System.out.println(pbr.lesen("BinärPokémon"));
	}

}
