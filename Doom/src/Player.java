import weapons.*;

public class Player {
    private int health;
    private Weapon weapon;
    private int positionX;
    private int positionY;

    public Player() {
        this.health = 100;
        this.positionX = 0;
        this.positionY = 0;
        this.weapon = new Axe();
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getPositionX() {
        return positionX;
    }

    public int getPositionY() {
        return positionY;
    }

    public void setPosition(char[][] map) {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (map[i][j] == '@') {
                    this.positionX = j;
                    this.positionY = i;
                }
            }
        }
    }

    public boolean moveLeft(char[][] map) {
        if (map[positionY][positionX-1] != '#') {
            this.positionX--;
            return true;
        }else {
            System.out.println("Wall");
        }
        return false;
    }
    public boolean moveRight(char[][] map) {
        if (map[positionY][positionX+1] != '#') {
            this.positionX++;
            return true;
        }else {
            System.out.println("Wall");
        }
        return false;
    }
    public boolean moveForward(char[][] map) {
        if (map[positionY-1][positionX] != '#') {
            this.positionY--;
            return true;
        }else {
            System.out.println("Wall");
        }
        return false;
    }
    public boolean moveBack(char[][] map) {
        if (map[positionY+1][positionX] != '#') {
            this.positionY++;
            return true;
        }else {
            System.out.println("Wall");
        }
        return false;
    }
}
