package application;

import java.io.IOException;
import java.nio.file.NoSuchFileException;
import java.security.SecureRandom;
import java.util.Random;

import csvio.CSVContactsReader;
import csvio.CSVContactsWriter;
import classes.AddressBook;
import classes.ObservableContactDetails;
import exceptions.DetailsNotFoundException;
import exceptions.DuplicateKeyException;
import exceptions.InvalidContactException;
import exceptions.ParameterStringIsEmptyException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.TextFieldTableCell;

public class Control {
	
	/* alle unsere Variablen, die wir noch im Laufe des Programmes außerhalb der Methoden brauchen */
	/* stellt die Kontakte in einer ListView dar*/
	private ListView<ObservableContactDetails> 			listView 	= new ListView<>();
	/* stellt die Kontakte in einer TableView dar*/
	private TableView<ObservableContactDetails> 		tableView 	= new TableView<>();
	/* speichert unsere Kontakte für beide Views */
	private ObservableList<ObservableContactDetails> 	data 		= FXCollections.observableArrayList();
	/* in der ListView arbeiten wir noch mit Hilfe des AddressBook */
	private AddressBook 								aBook 		= new AddressBook();
	/* Da wir Fehler an mehreren Stellen haben können wird Error global initialisiert */
	private Label 										errorText;
	
	public Control(Button print, Button add, Label errorText) {
	
		/* und übergeben sie direkt an die observableArrayList */
		this.fuelleObservableData();
		
		/* ruft die toString- Methode von AddressBook auf */
		print.setOnMouseClicked(e -> System.out.println(aBook));
		
		/* soll einen neuen Kontakt kreieren */
		add.setOnMouseClicked(e-> this.addNewContact());
		
		this.errorText = errorText;
	}
	
	/*
	 * füllt alle Kontakte in die observableArrayList
	 * */
	
	/*
	 * GEÄNDERT: Diese Methode sucht nach unserer kontakte.csv und liest sie aus.
	 * Sollte keine Datei vorhanden sein oder die Datei leer, zeigen wir eine leere Liste! 
	 */
	
	private void fuelleObservableData() {
		
		ObservableContactDetails[] contactDetails = null;

		contactDetails = CSVContactsReader.readEntityList("kontakte.csv",":");

		// Wir schauen nach ob etwas zurüch gegeben wurde
		if(contactDetails != null && contactDetails.length > 0){
			for(ObservableContactDetails contact : contactDetails){
				try {
					aBook.addDetails(contact);
				} catch (DuplicateKeyException | InvalidContactException
						| ParameterStringIsEmptyException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			for(ObservableContactDetails contact : contactDetails){
				 data.add(contact);
			}
		}
		
	}

	/* Ein neuer Kontakt wird erstellt und mit Platzhaltern "-" gefüllt.
	 * Dieser wird an unser AddressBook übergeben und auch in unserer observableArrayList hinzugefügt. 
	 * Im AddressBook durchläuft er natürlich alle unsere Kontrollen
	 *  */
	private void addNewContact() {
		try {
			ObservableContactDetails neu = new ObservableContactDetails("-","-","-","-","-");
			aBook.addDetails(neu);
			data.add(neu);
			// wir speichern in der Datei
			try {
				CSVContactsWriter.writeEntityList(aBook.search(""), "kontakte.csv", ":");
			} catch (IOException | ParameterStringIsEmptyException | DetailsNotFoundException e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
				e.printStackTrace();
			}
		} catch (DuplicateKeyException | InvalidContactException
				| ParameterStringIsEmptyException e) {
			generateErrorModal(e.getMessage());
		}
	}
	

	/**TABLE VIEW */
	
	public TableView<ObservableContactDetails> erstelleKontaktTabelle() {

		/* damit wir die Tabelle editieren können*/
		tableView.setEditable(true);
		
		/* übergabe der observableArrayList */
		tableView.setItems(this.data);
		
		// Spalten erzeugen
		
		// 1. Wie soll die Spallte halten
		// Tabellenspalte hat zwei Typparameter: Typ der Struktur und Typ der Spalte
		TableColumn<ObservableContactDetails, String> vornameSpalte = new TableColumn<>("Vorname"); // Spaltenüberschrift
		// 2. Was soll in der Spalte/Zeile anzeigt werden
		// Callback-Methode ermittelt den anzuzeigenden Zellwert 
		// In ObservableContactDetails sind alle Attribute Properties und können direkt eingesetzt werden
		vornameSpalte.setCellValueFactory(e -> e.getValue().vornameProperty());
		// 3. Wie reagiert die  Spalte/Zeile beim Editieren
		// Zellenansicht muss im Edit-Modus definert werden - Callback-Methode liefert eine neue TableCell mit TextFieldTableCell
		vornameSpalte.setCellFactory(TextFieldTableCell.forTableColumn());
		
		// analog wie oben beschrieben
		TableColumn<ObservableContactDetails, String> nachnameSpalte = new TableColumn<>("Nachname");
		nachnameSpalte.setCellValueFactory(e -> e.getValue().nachnameProperty());
		nachnameSpalte.setCellFactory(TextFieldTableCell.forTableColumn());
		
		TableColumn<ObservableContactDetails, String> adresseSpalte = new TableColumn<>("Adresse");
		adresseSpalte.setCellValueFactory(e -> e.getValue().adresseProperty());
		adresseSpalte.setCellFactory(TextFieldTableCell.forTableColumn());
		
		TableColumn<ObservableContactDetails, String> telefonnummerSpalte = new TableColumn<>("Telefonnummer");
		telefonnummerSpalte.setCellValueFactory(e -> e.getValue().telefonnummerProperty());
		telefonnummerSpalte.setCellFactory(TextFieldTableCell.forTableColumn());
		
		TableColumn<ObservableContactDetails, String> mailSpalte = new TableColumn<>("E-Mail");
		mailSpalte.setCellValueFactory(e -> e.getValue().mailProperty());
		mailSpalte.setCellFactory(TextFieldTableCell.forTableColumn());
		
		//Spalten an Tabelle übergeben
		tableView.getColumns().addAll(vornameSpalte, nachnameSpalte, adresseSpalte, telefonnummerSpalte, mailSpalte);
		
		return tableView;
	}

	/** LIST VIEW*/
	
	public ListView<ObservableContactDetails> erstelleKontaktListe() {
				
		/* damit wir die Tabelle editieren können*/
		listView.setEditable(true);
		
		/* übergabe der observableArrayList */
		listView.setItems(data);
		
		/* Jetzt greifen wir in das Verhalten der ListView ein */
		listView.setCellFactory(c -> new ListCellFactory(aBook,listView, errorText));
	
		return listView;
	}

	/*
	 * Erstellt Random-Kontakte
	 */
	private void fuelleAddressBook() {
		
		for(int i = 0; i < 10; i++){
			ObservableContactDetails a = new ObservableContactDetails(
					csRandomAlphaNumericString(5), 
					csRandomAlphaNumericString(6),
					csRandomAlphaNumericString(9),
					csRandomAlphaNumericString(12),
					csRandomAlphaNumericString(25)
					);	
			try {
				aBook.addDetails(a);
			} catch (DuplicateKeyException | InvalidContactException
					| ParameterStringIsEmptyException e) {
				System.out.println(e.getMessage());
			}
		}
	}

	private static char[] VALID_CHARACTERS =
		    "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456879".toCharArray();

	// cs = cryptographically secure
	public static String csRandomAlphaNumericString(int numChars) {
	    SecureRandom srand = new SecureRandom();
	    Random rand = new Random();
	    char[] buff = new char[numChars];

	    for (int i = 0; i < numChars; ++i) {
	      // reseed rand once you've used up all available entropy bits
	      if ((i % 10) == 0) {
	          rand.setSeed(srand.nextLong()); // 64 bits of random!
	      }
	      buff[i] = VALID_CHARACTERS[rand.nextInt(VALID_CHARACTERS.length)];
	    }
	    return new String(buff);
	}
	
	/*alle Fehlermeldungen  werden nun an ein Label übergeben, welches in der View ist*/
	private void generateErrorModal(String message){
		this.errorText.setText(message);
	}

}