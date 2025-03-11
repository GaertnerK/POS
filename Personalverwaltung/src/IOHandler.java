import enums.Gender;
import records.Address;
import records.Person;

import java.io.*;
import java.nio.file.Files;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class IOHandler {
    public static final String FILENAME = "data.txt";
    public ArrayList<Person> readFile() throws IOException {
        List<Person> personArrayList = Files.lines(new File(FILENAME).toPath())
                .map(s -> s.split("#"))
                .map(s -> new Person(
                       Integer.parseInt(s[0]),
                       s[1],
                       s[2],
                       Integer.parseInt(s[3]),
                       LocalDate.parse(s[4]),
                       Gender.valueOf(s[5]),
                       Integer.parseInt(s[6]),
                       new Address(Integer.parseInt(s[7]), s[8], s[9], s[10],s[11]),
                       s[12],
                       s[13],
                       s[14],
                       s[15]
               )).toList();
        for (Person person : personArrayList) {
            System.out.println(person);
        }
        return new ArrayList(personArrayList);
    }

    public void writeFile(List<Person> persons) throws FileNotFoundException {
        try (FileWriter writer = new FileWriter(new File(FILENAME))) {
            for (Person person : persons) {
                writer.write(person.id() + "#" + person.firstname() + "#" + person.lastname() + "#" + person.age() + "#"
                        + person.birthday() + "#" + person.gender() + "#" + person.salary() + "#" + person.address().streetNr()
                        + "#" + person.address().street() + "#" + person.address().zipCode() + "#" + person.address().city() + "#" 
                        + person.address().state() + "#" + person.email() + "#" + person.telNumber() + "#" + person.department() + "#" + person.skills() + "\n");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
