import enemies.Dwarf;
import enemies.Enemy;
import enemies.Wizard;
import enemies.Zombie;

import java.util.ArrayList;
import java.util.Random;

public class Field {
    private char[][] map;
    private ArrayList<Enemy> enemies;

    public Field(int level) {
        enemies = new ArrayList<>();
        this.map = loadLevel(level);
    }

    public char[][] getMap() {
        return map;
    }

    public void setMap(char[][] map) {
        this.map = map;
    }

    public ArrayList<Enemy> getEnemies() {
        return enemies;
    }

    public char[][] loadLevel(int level) {
        String mapString = "";
        mapString = switch (level) {
            case 1 -> """
                    ##############################
                    #     #   #  ###   ###       #
                    #     #   #  ###   ###   S   #
                    #     #   #  ###   ###       #
                    #  #  #######  X  ######## X #
                    #  #     #          #        #
                    ####   #  ###########  X     #
                    #       #  X                 #
                    #  ###########  X            #
                    #   X  ######  ##########    #
                    #                            #
                    #  ##########  #  #X #   #   #
                    #      #   #   #  #   #  #   #
                    #      #   #   #  #   #  #   #
                    #      #   #   #  #   #  #   #
                    # @    #   #   #  #   #  #   #
                    ##############################
                    """;
            case 2 -> """
                    ########################################
                    # @    #   #  #######  X    ####       #
                    #      #   #                           #
                    #  X   ######  #########  #######      #
                    #      #           X        #   S      #
                    ####   #   ######  ###         #       #
                    #      #        #   #          #       #
                    #  ###########  #   #####  X   #       #
                    #      X        #       #      #       #
                    #  #####  #######  #######  ####       #
                    #      #      #    X                   #
                    ########################################
                    
                    """;
            case 3 -> """
                    ########################################
                    #   X      #####   X      #####   S    #
                    #  ###                   #             #
                    #  ###    #####    ###   #####    X    #
                    #   #       #                     #    #
                    #######   ###    #######    ###   ######
                    #   @      #       X         #         #
                    #  #####   #####   #####   #####   ### #
                    #  #   #   #   #   #   #   #   #   #   #
                    #  #   #   #   #   #   #   #   #   #   #
                    ########################################
                    
                    """;
            case 4 -> """
                    ########################################
                    # @      #    ###               X      #
                    #   ###  #    ###     #   #######      #
                    #   ###  #         X  #   #            #
                    #   ###  #####        #####   S        #
                    #           #     ####    #            #
                    ####   #    #########  #######         #
                    #   X  #               #    X          #
                    #   ########   X   ###########         #
                    #       #      ##                      #
                    #       #######     #########          #
                    ########################################
                    
                    """;
            case 5 -> """
                    ########################################
                    # @    ###      #    ###     X         #
                    #      #   ###### X      #####         #
                    #      #           ###      #          #
                    #  #####   ######    ####   #########  #
                    #  #####        #    #      #     S    #
                    #          ######    ####   ########   #
                    #    X               #   #  X          #
                    #############   #####  #####  #####    #
                    #     X                                #
                    #  #######   ########  ##########      #
                    ########################################
                    
                    """;
            default -> mapString;
        };
        String[] parts = mapString.split("\n");
        map = new char[parts.length][parts.length];
        for (int i = 0; i < parts.length; i++) {
            map[i] = parts[i].toCharArray();
        }
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (map[i][j] == 'X') {
                    Random random = new Random();
                    int rand = random.nextInt(2)+1;
                    switch (rand) {
                        case 1 -> enemies.add(new Zombie(100, j, i));
                        case 2 -> {
                            rand = random.nextInt(2)+1;
                            switch (rand) {
                                case 1 -> enemies.add(new Wizard(80, j, i));
                                case 2 -> enemies.add(new Dwarf(50, j, i));
                            }
                        }
                    }
                }
            }
        }
        return map;
    }

    public void printMap() {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
    }
}
