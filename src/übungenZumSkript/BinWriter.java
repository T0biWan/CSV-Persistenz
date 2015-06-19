package übungenZumSkript;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class BinWriter {
	public void schreib() {
		try {
			DataOutputStream out = new DataOutputStream(new BufferedOutputStream(new FileOutputStream("output/data.bin")));
			out.writeInt(666);
			out.writeDouble(6.9);
			out.writeUTF("The Number of the Beast!");
			out.flush();
			out.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


}
