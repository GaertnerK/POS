import enums.Gender;
import records.Address;
import records.Person;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static Scanner scanner = new Scanner(System.in);

    public static final int ADD_PERSON = 1;
    public static final int EDIT_PERSON = 2;
    public static final int DELETE_PERSON = 3;
    public static final int FIND_PERSON = 4;
    public static final int FIND_ALL_PERSON = 5;
    public static final int ANALYSE = 6;

    public static void main(String[] args) throws FileNotFoundException {
        PersonManager pm = new PersonManager();
        IOHandler handler = new IOHandler();
        try {
            pm.setPersons(handler.readFile());
            pm.setLastId();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("File not found");
        }
        while (true) {
            showMenu();
            int input = Integer.parseInt(scanner.nextLine());
            switch (input) {
                case ADD_PERSON:
                    pm.addPerson(getData());
                    break;
                case EDIT_PERSON:
                    System.out.println("ID der Person die Sie bearbeiten möchten eingeben: ");
                    input = Integer.parseInt(scanner.nextLine());
                    pm.editPerson(input, getData());
                    break;
                case DELETE_PERSON:
                    System.out.println("ID der Person die Sie löschen möchten eingeben:");
                    input = Integer.parseInt(scanner.nextLine());
                    pm.deletePerson(input);
                    break;
                case FIND_PERSON:
                    System.out.println("Was suchen Sie?");
                    String searchString = scanner.nextLine();
                    List<Person> personList = pm.getPerson(searchString);
                    for (Person person : personList) {
                        System.out.println(person);
                    }
                    break;
                case FIND_ALL_PERSON: pm.printPersons(); break;
                case ANALYSE:
                    System.out.println("""
                            1. Gender filtern
                            2. Durchschnittsalter
                            3. Gehalt
                            """);
                    try {
                        input = Integer.parseInt(scanner.nextLine());
                        switch (input) {
                            case 1 -> {
                                System.out.println("Nach welchem Gender soll gefiltert werden?(m/w/d)");
                                String gender = scanner.nextLine();
                                if (gender.equals("m")) {
                                    System.out.println(pm.getGenders(Gender.MALE));
                                }else if (gender.equals("w")) {
                                    System.out.println(pm.getGenders(Gender.FEMALE));
                                }else {
                                    System.out.println(pm.getGenders(Gender.DIVERS));
                                }
                            }
                            case 2 -> {
                                if (pm.getPersons().isEmpty()) {
                                    System.out.println("Keine Persons vorhanden ");
                                }else {
                                    System.out.println("Durchschnittsalter: " + pm.averageAge());
                                }
                            }
                            case 3 -> {
                                if (pm.getPersons().isEmpty()) {
                                    System.out.println("Keine Personen vorhanden");
                                }else {
                                    System.out.println("kleinste Gehalt: " + pm.getSmallestSalary() + "; größtes Gehalt: " + pm.getLargestSalary()
                                            + "; Durchschnittsgehalt: " + pm.getMiddleSalary());
                                }
                            }
                        }
                    }catch (Exception e) {
                        System.out.println("Invalid input");
                    }
                    break;
                default: return;
            }
            handler.writeFile(pm.getPersons());
        }
    }

    public static void showMenu(){
        System.out.print("""
                -----------------------------------
                Personenverwaltung
                1. Neue Person hinzufügen
                2. Person bearbeiten
                3. Person löschen
                4. Person suchen
                5. Liste aller Personen anzeigen
                6. Analysefunktion
                7. Beenden
                -----------------------------------
                Eingabe> """);
    }

    private static String getData() {
        String data = "";
        System.out.println("Vorname der Person: ");
        data += scanner.nextLine() + "#";
        System.out.println("Nachname der Person: ");
        data += scanner.nextLine() + "#";
        System.out.println("Alter der Person: ");
        data += scanner.nextLine() + "#";
        System.out.println("Geburtsdatum(YYYY-MM-DD) der Person: ");
        data += scanner.nextLine() + "#";
        System.out.println("Geschlecht der Person (m/w/d): ");
        data += scanner.nextLine() + "#";
        System.out.println("Gehalt der Person: ");
        data += scanner.nextLine() + "#";
        System.out.println("Hausnummer der Person: ");
        data += scanner.nextLine() + "#";
        System.out.println("Wohnstraße der Person: ");
        data += scanner.nextLine() + "#";
        System.out.println("Postleitzahl der Person: ");
        data += scanner.nextLine() + "#";
        System.out.println("Stadt der Person: ");
        data += scanner.nextLine() + "#";
        System.out.println("Land der Person: ");
        data += scanner.nextLine() + "#";
        System.out.println("E-Mail der Person: ");
        data += scanner.nextLine() + "#";
        System.out.println("Telefonnummer der Person: ");
        data += scanner.nextLine() + "#";
        System.out.println("Abteilung der Person: ");
        data += scanner.nextLine() + "#";
        System.out.println("Skills der Person: ");
        data += scanner.nextLine();
        return data;
    }
}