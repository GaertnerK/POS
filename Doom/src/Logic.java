import enemies.Enemy;
import weapons.Axe;
import weapons.Hand;
import weapons.Sword;
import weapons.Wand;

import java.util.Random;
import java.util.Scanner;

public class Logic {
    private boolean playerAlive;
    private boolean levelComplete;
    private char lastChar;

    public Logic() {
        playerAlive = true;
        levelComplete = false;
        lastChar = ' ';
    }

    public boolean isPlayerAlive() {
        return playerAlive;
    }

    public boolean isLevelComplete() {
        return levelComplete;
    }

    public char getLastChar() {
        return lastChar;
    }

    public void move(Player player, Field field, String input) {
        switch (input) {
            case "left", "a" -> {
                if(player.moveLeft(field.getMap())){
                    lastChar = field.getMap()[player.getPositionY()][player.getPositionX()];
                    field.getMap()[player.getPositionY()][player.getPositionX()+1] = ' ';
                    field.getMap()[player.getPositionY()][player.getPositionX()] = '@';
                }
            }
            case "right", "d" -> {
                if(player.moveRight(field.getMap())){
                    lastChar = field.getMap()[player.getPositionY()][player.getPositionX()];
                    field.getMap()[player.getPositionY()][player.getPositionX()-1] = ' ';
                    field.getMap()[player.getPositionY()][player.getPositionX()] = '@';
                }
            }
            case "forward", "w" -> {
                if(player.moveForward(field.getMap())){
                    lastChar = field.getMap()[player.getPositionY()][player.getPositionX()];
                    field.getMap()[player.getPositionY()+1][player.getPositionX()] = ' ';
                    field.getMap()[player.getPositionY()][player.getPositionX()] = '@';
                }
            }
            case "backward", "s" -> {
                if(player.moveBack(field.getMap())){
                    lastChar = field.getMap()[player.getPositionY()][player.getPositionX()];
                    field.getMap()[player.getPositionY()-1][player.getPositionX()] = ' ';
                    field.getMap()[player.getPositionY()][player.getPositionX()] = '@';
                }
            }
        }
        if (checkWin(player, field)) {
            levelComplete = true;
            return;
        }
        checkFight(player, field);
        for (Enemy e : field.getEnemies()) {
            Random random = new Random();
            int x = random.nextInt(4)+1;
            switch (x){
                case 1 -> {
                    if (field.getMap()[e.getPositionY()][e.getPositionX()-1] == 'S') {
                        break;
                    }
                    if(e.moveLeft(field.getMap())){
                        field.getMap()[e.getPositionY()][e.getPositionX()+1] = ' ';
                        field.getMap()[e.getPositionY()][e.getPositionX()] = 'X';
                    }
                }
                case 2 -> {
                    if (field.getMap()[e.getPositionY()][e.getPositionX()+1] == 'S') {
                        break;
                    }
                    if(e.moveRight(field.getMap())){
                        field.getMap()[e.getPositionY()][e.getPositionX()-1] = ' ';
                        field.getMap()[e.getPositionY()][e.getPositionX()] = 'X';
                    }
                }
                case 3 -> {
                    if (field.getMap()[e.getPositionY()-1][e.getPositionX()] == 'S') {
                        break;
                    }
                    if(e.moveForward(field.getMap())){
                        field.getMap()[e.getPositionY()+1][e.getPositionX()] = ' ';
                        field.getMap()[e.getPositionY()][e.getPositionX()] = 'X';
                    }
                }
                case 4 -> {
                    if (field.getMap()[e.getPositionY()+1][e.getPositionX()] == 'S') {
                        break;
                    }
                    if(e.moveBack(field.getMap())){
                        field.getMap()[e.getPositionY()-1][e.getPositionX()] = ' ';
                        field.getMap()[e.getPositionY()][e.getPositionX()] = 'X';
                    }
                }
            }
        }
        checkFight(player, field);
        field.printMap();
    }

    public void checkFight(Player player, Field field) {
        for (Enemy e : field.getEnemies()) {
            if (field.getMap()[e.getPositionY()+1][e.getPositionX()] == '@') {
                fight(player, field, e);
                break;
            }else if(field.getMap()[e.getPositionY()-1][e.getPositionX()] == '@') {
                fight(player, field, e);
                break;
            }else if (field.getMap()[e.getPositionY()][e.getPositionX()+1] == '@') {
                fight(player, field, e);
                break;
            }else if (field.getMap()[e.getPositionY()][e.getPositionX()-1] == '@') {
                fight(player, field, e);
                break;
            }else if (field.getMap()[e.getPositionY()+1][e.getPositionX()+1] == '@') {
                fight(player, field, e);
                break;
            }else if (field.getMap()[e.getPositionY()-1][e.getPositionX()-1] == '@') {
                fight(player, field, e);
                break;
            }else if (field.getMap()[e.getPositionY()][e.getPositionX()] == '@'){
                fight(player, field, e);
                break;
            }
        }
    }

    public void fight(Player player, Field field, Enemy e) {
        field.printMap();
        Random random = new Random();
        System.out.println(e.getDetails());
        System.out.println("Ihre Waffe: " + player.getWeapon().getDetails());
        double axeAttackSpeedPlayer = 0;
        double axeAttackSpeedEnemy = 0;
        while (player.getHealth() != 0 && e.getHealth() != 0) {
            System.out.println();
            System.out.println("Ihr Leben: " + player.getHealth() + "\nGegner Leben: " + e.getHealth());
            System.out.println("Zahl zwischen 1-3 eingeben");
            System.out.println("Ihr Angriff:");
            Scanner scanner = new Scanner(System.in);
            double attackSpeed = 0;
            do {
                attackSpeed += 0.5;
                axeAttackSpeedPlayer += 0.5;
                if ((player.getWeapon() instanceof Sword && attackSpeed == 1) || player.getWeapon() instanceof Wand || player.getWeapon() instanceof Hand || axeAttackSpeedPlayer == 2) {
                    int input = 0;
                    try {
                        input = scanner.nextInt();
                    } catch (Exception exception) {
                        System.out.println("Ungültige Eingabe");
                    }
                    int rand = random.nextInt(3) + 1;
                    if (rand == input) {
                        System.out.println("Treffer");
                        e.setHealth(e.getHealth() - player.getWeapon().getDamage());
                    } else {
                        System.out.println("Kein Treffer");
                    }
                    if (e.getHealth() <= 0) {
                        field.getMap()[e.getPositionY()][e.getPositionX()] = ' ';
                        field.getEnemies().remove(e);
                        System.out.println("Waffe des Gegners behalten?: " + e.getWeapon().getName() + " J/N");
                        String inputS = scanner.next();
                        switch (inputS) {
                            case "J", "j" -> {
                                player.setWeapon(e.getWeapon());
                                System.out.println("Waffe wurde mitgenommen!");
                            }
                            default -> System.out.println("Waffe wurde nicht mitgenommen");
                        }
                        return;
                    }
                }
            }while (attackSpeed != 1);
            System.out.println();
            attackSpeed = 0;
            if (axeAttackSpeedPlayer >= 2){
                axeAttackSpeedPlayer = 0;
            }
            System.out.println("Gegner greift an:");
            do {
                attackSpeed += 0.5;
                axeAttackSpeedEnemy += 0.5;
                if ((e.getWeapon() instanceof Sword && attackSpeed == 1) || e.getWeapon() instanceof Wand || e.getWeapon() instanceof Hand || axeAttackSpeedEnemy == 2) {
                        int rand = random.nextInt(3) + 1;
                        int enemyAttack = random.nextInt(10) + 1;
                        if (rand == enemyAttack) {
                            System.out.println("Gegner hat getroffen");
                            player.setHealth(player.getHealth() - e.getWeapon().getDamage());
                        } else {
                            System.out.println("Gegner hat nicht getroffen");
                        }
                        if (player.getHealth() <= 0) {
                            playerAlive = false;
                            return;
                        }
                }
            }while (attackSpeed != 1);
            if (axeAttackSpeedEnemy >= 2){
                axeAttackSpeedEnemy = 0;
            }
        }
    }

    public boolean checkWin(Player player, Field field) {
        if (lastChar == 'S') {
            levelComplete = true;
            return true;
        }
        return false;
    }
}
