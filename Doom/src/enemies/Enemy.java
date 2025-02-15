package enemies;

import weapons.Weapon;

public sealed abstract class Enemy permits Dwarf, Wizard, Zombie {
    private int health;
    private int positionX;
    private int positionY;

    public Enemy(int health, int positionX, int positionY) {
        this.health = health;
        this.positionX = positionX;
        this.positionY = positionY;
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

    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    public int getPositionY() {
        return positionY;
    }

    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }

    public boolean moveLeft(char[][] map) {
        if (map[positionY][positionX-1] != '#') {
            this.positionX--;
            return true;
        }
        return false;
    }
    public boolean moveRight(char[][] map) {
        if (map[positionY][positionX+1] != '#') {
            this.positionX++;
            return true;
        }
        return false;
    }
    public boolean moveForward(char[][] map) {
        if (map[positionY-1][positionX] != '#') {
            this.positionY--;
            return true;
        }
        return false;
    }
    public boolean moveBack(char[][] map) {
        if (map[positionY+1][positionX] != '#') {
            this.positionY++;
            return true;
        }
        return false;
    }

    public abstract String getDetails();
    public abstract Weapon getWeapon();
}
