import enums.Gender;
import records.Address;
import records.Person;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PersonManager {
    private ArrayList<Person> persons = new ArrayList<Person>();
    private int lastId = 0;

    public ArrayList<Person> getPersons() {
        return persons;
    }

    public void setPersons(ArrayList<Person> persons) {
        this.persons = persons;
    }

    public void setLastId() {
        lastId = persons.size();
    }

    public void addPerson(String personData) {
        String[] data = personData.split("#");
        if (data.length != 15) {
            System.out.println("Invalid data format");
            return;
        }
        Gender gender;
        switch (data[4]) {
            case "m": gender = Gender.MALE; break;
            case "w": gender = Gender.FEMALE; break;
            case "d": gender = Gender.DIVERS; break;
            default:
                System.out.println("Invalid gender");
                return;
        }
        try {
            Person person = new Person(lastId+1, data[0], data[1], Integer.parseInt(data[2]), LocalDate.parse(data[3]), gender, Integer.parseInt(data[5]), new Address(Integer.parseInt(data[6]), data[7], data[8], data[9], data[10]), data[11], data[12], data[13], data[14]);
            persons.add(person);
            lastId++;
        }catch (Exception e) {
            System.out.println("Invalid person data");
        }
    }

    public void editPerson(int id, String personData) {
        String[] data = personData.split(";");
        if (data.length != 15) {
            System.out.println("Invalid data format");
            return;
        }
        Gender gender;
        switch (data[4]) {
            case "m": gender = Gender.MALE; break;
            case "f": gender = Gender.FEMALE; break;
            case "d": gender = Gender.DIVERS; break;
            default:
                System.out.println("Invalid gender");
                return;
        }
        try {
            Person person = new Person(id, data[0], data[1], Integer.parseInt(data[2]), LocalDate.parse(data[3]), gender, Integer.parseInt(data[5]), new Address(Integer.parseInt(data[6]), data[7], data[8], data[9], data[10]), data[11], data[12], data[13], data[14]);
            persons.remove(id-1);
            persons.add(person);
        }catch (Exception e) {
            System.out.println("Invalid person data");
        }
    }

    public void deletePerson(int id) {
        persons.stream().filter(p -> p.id() == id).findFirst().ifPresent(p -> persons.remove(p));
    }

    public List<Person> getPerson(String searchString) {
        return persons.stream().filter(person -> String.valueOf(person.id()).contains(searchString) || person.firstname().contains(searchString) || person.lastname().contains(searchString)
        || String.valueOf(person.birthday()).contains(searchString) || String.valueOf(person.gender()).contains(searchString) || person.address().city().contains(searchString)
        || person.address().state().contains(searchString) || person.address().zipCode().contains(searchString) || String.valueOf(person.address().streetNr()).contains(searchString)
        || person.email().contains(searchString) || person.telNumber().contains(searchString) || person.department().contains(searchString) || person.skills().contains(searchString)).toList();
    }

    public void printPersons() {
        System.out.println("ID, Vorname Nachname, Alter, Geburtstag, Geschlecht, Gehalt, Adresse, Email, Telefonnummer, Abteilung, Fähigkeiten");
        if (persons.isEmpty()) {
            System.out.println("No persons found");
        }else {
            for (Person person : persons) {
                System.out.println(person);
            }
        }
    }

    public int getGenders(Gender gender) {
        return persons.stream().filter(person -> person.gender() == gender).toList().size();
    }

    public double averageAge() {
        return persons.stream().mapToInt(Person::age).average().getAsDouble();
    }

    public int getSmallestSalary(){
        return persons.stream().mapToInt(Person::salary).min().getAsInt();
    }

    public int getLargestSalary(){
        return persons.stream().mapToInt(Person::salary).max().getAsInt();
    }

    public double getMiddleSalary(){
        return persons.stream().mapToInt(Person::salary).average().getAsDouble();
    }
}
