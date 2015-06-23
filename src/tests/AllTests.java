package tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ BinärAppointmentReaderTest.class,
		BinärAppointmentWriterTest.class, BufferedAppointmentReaderTest.class,
		BufferedAppointmentWriterTest.class, CSVAppointmentReaderTest.class,
		CSVAppointmentWriterTest.class, CSVContactsReaderTest.class,
		CSVContactsWriterTest.class, IOExceptionTest.class })
public class AllTests {

}
