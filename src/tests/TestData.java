package tests;

import classes.Appointment;
import classes.ObservableContactDetails;

import java.util.ArrayList;
import java.util.List;

/**
 * Hilfsklasse zum Laden der Testdaten.
 */
public final class TestData {

  static final Appointment TERMIN1;
  static final Appointment TERMIN2;
  static final Appointment TERMIN3;

  static final ObservableContactDetails KONTAKT1;
  static final ObservableContactDetails KONTAKT2;
  static final ObservableContactDetails KONTAKT3;

  static {
    try {
      TERMIN1 = new Appointment();
      TERMIN2 = new Appointment("21/06/2015", "Uni", "10:00", "18:00", "Lernen", "Das ist ein Test");
      TERMIN3 = new Appointment("22/06/2015", "Mediendesign", "10:00", "11:30", "Vorlesung", "Wir lernen mega spannende Dinge");

      KONTAKT1 = new ObservableContactDetails();
      KONTAKT2 = new ObservableContactDetails("Inga", "Schwarze", "Tegeler Weg 107", "015253478533", "Inga.Schwarze@zalando.de");
      KONTAKT3 = new ObservableContactDetails("Robert", "Dziuba", "Müllerstraße 142", "0123456", "robertodziuba@gmail.com");
    } catch (Exception e) {
      throw new IllegalArgumentException(e.getMessage(), e);
    }
  }

  // Privater Standard-Konstruktor um neue Instanzen dieser Klasse zu vermeiden.
  private TestData() {
  }

  /**
   * Liefert die gültigen Termine 2 und 3 zurück.
   *
   * @return Die Liste der Termine.
   */
  public static List<Appointment> getValidAppointments() {
    List<Appointment> appointments = new ArrayList<>();
    appointments.add(TERMIN2);
    appointments.add(TERMIN3);
    return appointments;
  }

  public static List<Appointment> getTermin2(int count) {
    List<Appointment> appointments = new ArrayList<>();
    for (int i = 0; i < count; i++) {
      appointments.add(TERMIN2);
    }
    return appointments;
  }

  public static ObservableContactDetails[] getValidContacts() {
    return new ObservableContactDetails[]{KONTAKT2, KONTAKT3};
  }

}
