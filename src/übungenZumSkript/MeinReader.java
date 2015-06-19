package übungenZumSkript;


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class MeinReader {
	public void lesen() {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream ("output/myoutput.txt")));
			br.readLine();
			br.close();
			System.out.println(br.readLine());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
