import enemies.Dwarf;
import enemies.Enemy;
import enemies.Wizard;
import enemies.Zombie;
import weapons.Axe;
import weapons.Hand;
import weapons.Sword;
import weapons.Wand;

import java.util.Scanner;
import java.util.spi.AbstractResourceBundleProvider;

public class Main {
    public static void main(String[] args) {
        int level = 1;
        Field field = new Field(level);
        Player player = new Player();
        Logic logic = new Logic();
        printInfo();
        field.printMap();
        while (logic.isPlayerAlive()) {
            player.setPosition(field.getMap());
            String menu = """
                    left → gehe eine Zelle nach links
                    right → gehe nach Zelle nach rechts
                    forward → gehe nach Zelle nach vor
                    backward → gehe nach Zelle nach hinten
                    info → Infos anzeigen
                    end → beenden
                    """;
            System.out.println(menu);
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();
            switch (input) {
                case "info": printInfo(); break;
                case "end": return;
                default: logic.move(player, field, input); break;
            }
            if (logic.isLevelComplete()) {
                System.out.println("Level complete");
                if (level == 5) {
                    break;
                }
                level++;
                logic = new Logic();
                field = new Field(level);
                player.setHealth(100);
                System.out.println("Level: " + level);
                field.printMap();
            }
        }
        if (logic.isLevelComplete()) {
            System.out.println("Gewonnen");
        }else {
            System.out.println("Verloren");
        }
    }

    public static void printInfo(){
        Wizard w = new Wizard(100, 2, 3);
        Dwarf d = new Dwarf(100, 2, 3);
        Zombie z = new Zombie(100, 2, 3);
        Axe a = new Axe();
        Hand h = new Hand();
        Sword s = new Sword();
        Wand wand = new Wand();
        System.out.println("""
                Ziel: Schatz(S) erreichen
                @ - Player
                S - Schatz
                X - Gegner
                Gegner:""" + "\n    " + w.getDetails() + "\n    " + d.getDetails() + "\n    " + z.getDetails() + "\n" +
                """
                Waffen:""" + "\n    " + a.getDetails() + "\n    " + h.getDetails() + "\n    " + s.getDetails() + "\n    " + wand.getDetails() + "\n");
    }
}