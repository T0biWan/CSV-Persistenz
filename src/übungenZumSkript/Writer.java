package übungenZumSkript;
import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;


public class Writer {
	public void schreib(){
		try {
			BufferedWriter outBuf = new BufferedWriter(new OutputStreamWriter( new FileOutputStream("output/myoutput.txt")));
			
//			FileOutputStream outFl = new FileOutputStream("output/myoutput1.txt");
//			OutputStreamWriter outWr = new OutputStreamWriter(outFl);
//			BufferedWriter outBuf = new BufferedWriter(outWr);
			outBuf.write("test1");
			outBuf.write("test2");
			outBuf.write("test3");
			outBuf.flush();
			outBuf.close();
			
			
			PrintWriter writer = new PrintWriter (new FileOutputStream("output/myoutput2.txt"));
			writer.write("test1");
			writer.write("test2");
			writer.flush();
			writer.close();
			
//			DataOutputStream out = new DataOutputStream(new BufferedOutputStream(new FileOutputStream("output/myoutput3bin.txt")));
//			out.writeUTF("t");

			//Mit meinen Filter
			PrintWriter writer2 = new PrintWriter (new AwesomeFilter(new OutputStreamWriter(new FileOutputStream("output/myoutput3.txt"))));
			writer2.write("t");
			writer2.flush();
			writer2.close();
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println();
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println();
		}
	}

}
