package übungenZumSkript;
import java.io.FileOutputStream;
import java.io.FilterWriter;
import java.io.IOException;
import java.io.Writer;


public class AwesomeFilter extends FilterWriter{
	protected AwesomeFilter(Writer fileOutputStream) {
		super(fileOutputStream);
	}

	@Override
	public void write(String string) throws IOException {
		write("#"+string);
	}
}
