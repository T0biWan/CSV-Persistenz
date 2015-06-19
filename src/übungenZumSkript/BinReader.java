package übungenZumSkript;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class BinReader {
	public void lesen() {
		try {
			DataInputStream input = new DataInputStream(new BufferedInputStream(new FileInputStream("output/data.bin")));
			int inInt = input.readInt();
			double inDouble = input.readDouble();
			String inString = input.readUTF();
			input.close();
			
			System.out.println(inInt + "\n"+inDouble+"\n"+inString);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
