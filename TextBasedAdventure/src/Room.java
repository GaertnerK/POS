import java.io.*;

public class Room {
    int id;
    File description;
    boolean doorLocked;

    public Room(int id, File description) {
        this.id = id;
        this.description = description;
        this.doorLocked = true;
    }

    public int getId() {
        return id;
    }

    public File printDescription() throws FileNotFoundException {
        try (BufferedReader br = new BufferedReader(new FileReader(description))) {
            String line = br.readLine();
            System.out.println(line);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return description;
    }
}
