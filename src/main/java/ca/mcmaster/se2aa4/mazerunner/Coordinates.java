package ca.mcmaster.se2aa4.mazerunner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Coordinates {

    int x;
    int y;

    public Coordinates(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean isEqualTo(Coordinates coordinates) {
        return this.x == coordinates.getX() && this.y == coordinates.getY();
    }

    public void stepUp() {
        y--;
    }

    public void stepDown() {
        y++;
    }

    public void stepLeft() {
        x--;
    }

    public void stepRight() {
        x++;
    }

}