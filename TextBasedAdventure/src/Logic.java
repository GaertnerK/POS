import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Logic {
    private Room[] rooms;
    private int currentRoom;

    public Logic() {
        rooms = new Room[4];
        currentRoom = 1;
    }

    public void loadRooms() {
        for (int i = 0; i < rooms.length; i++) {
            String filename = "room" + i+1 + ".txt";
            rooms[i] = new Room(i, new File(filename));
        }
    }

    public void handleInput(String input) throws FileNotFoundException {
        rooms[currentRoom].printDescription();
        if (currentRoom == 1) {
            if (input.equals("1")) {
                if ()
            }
        }
    }
}
