package classes;

import exceptions.ContactFormatException;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class ObservableContactDetails extends ContactDetails {
	
	private StringProperty	vorname = new SimpleStringProperty();
	private StringProperty  nachname = new SimpleStringProperty();
	private StringProperty  adresse = new SimpleStringProperty();
	private StringProperty  telefonnummer = new SimpleStringProperty();
	private StringProperty  mail = new SimpleStringProperty();

	// StandartKonstruktor
	public ObservableContactDetails(){
		this(null,null,null,null,null);
	}
	
	// StringArray Konstruktor
	public ObservableContactDetails(String[] arr) throws ContactFormatException{
		this(arr[0],arr[1],arr[2],arr[3],arr[4]);
		if(arr.length != 5){
			throw new ContactFormatException();
		}
	}
	
	public ObservableContactDetails(String vorname, String nachname, String adresse, String telefonnummer, String mail){
		super();
		this.setVorname(vorname);
		this.setNachname(nachname);
		this.setAdresse(adresse);
		this.setTelefonnummer(telefonnummer);
		this.setMail(mail);
	}
	
	// KopierKonstruktor
	public ObservableContactDetails(ObservableContactDetails observableContactDetails){
		this(   observableContactDetails.getVorname(),
				observableContactDetails.getNachname(),
				observableContactDetails.getAdresse(), 
				observableContactDetails.getTelefonnummer(),
				observableContactDetails.getMail()
				);
	}
	
	// GETTER UND SETTER
	
	public StringProperty vornameProperty(){ return vorname;}

	public String getVorname() {
		return vorname.get();
	}

	public void setVorname(String vorname) {
		this.vorname.set(vorname);
	}

	public StringProperty nachnameProperty(){ return nachname;}
	
	public String getNachname() {
		return nachname.get();
	}

	public void setNachname(String nachname) {
		this.nachname.set(nachname);
	}
	
	public StringProperty adresseProperty(){ return adresse;}

	public String getAdresse() {
		return adresse.get();
	}

	public void setAdresse(String adresse) {
		this.adresse.set(adresse);
	}
	
	public StringProperty telefonnummerProperty(){ return telefonnummer;}

	public String getTelefonnummer() {
		return telefonnummer.get();
	}

	public void setTelefonnummer(String telefonnummer) {
		this.telefonnummer.set(telefonnummer);
	}
	
	public StringProperty mailProperty(){ return mail;}

	public String getMail() {
		return mail.get();
	}

	public void setMail(String mail) {
		this.mail.set(mail);
	}
	
	public String toString(){
		
		StringBuilder s = new StringBuilder("[" + this.getVorname());
		   
		s.append(", " + this.getNachname());
		s.append(", " + this.getAdresse());  
		s.append(", " + this.getTelefonnummer());  
		s.append(", " + this.getMail());  
		s.append("]");
   
		return s.toString();
	}

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    ObservableContactDetails that = (ObservableContactDetails) o;

    if (adresse.get() != null ? !adresse.get().equals(that.adresse.get()) : that.adresse.get() != null) return false;
    if (mail.get() != null ? !mail.get().equals(that.mail.get()) : that.mail.get() != null) return false;
    if (nachname.get() != null ? !nachname.get().equals(that.nachname.get()) : that.nachname.get() != null) return false;
    if (telefonnummer.get() != null ? !telefonnummer.get().equals(that.telefonnummer.get()) : that.telefonnummer.get() != null) return false;
    if (vorname.get() != null ? !vorname.get().equals(that.vorname.get()) : that.vorname.get() != null) return false;

    return true;
  }

  @Override
  public int hashCode() {
    int result = vorname.get() != null ? vorname.get().hashCode() : 0;
    result = 31 * result + (nachname.get() != null ? nachname.get().hashCode() : 0);
    result = 31 * result + (adresse.get() != null ? adresse.get().hashCode() : 0);
    result = 31 * result + (telefonnummer.get() != null ? telefonnummer.get().hashCode() : 0);
    result = 31 * result + (mail.get() != null ? mail.get().hashCode() : 0);
    return result;
  }

  public static void main(String[] args) {
		ObservableContactDetails ocd = new ObservableContactDetails();
		ocd.setVorname("Robert");
		ocd.setNachname("Dziuba");
		ocd.setAdresse("Mueller str. 142");
		ocd.setTelefonnummer("12345678");
		ocd.setMail("test@test.de");
		
		System.out.println(ocd);
	}
}
