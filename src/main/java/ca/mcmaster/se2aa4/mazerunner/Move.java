package ca.mcmaster.se2aa4.mazerunner;

public enum Move {
    FORWARD ('F'), 
    LEFT ('L'), 
    RIGHT ('R');

    private final char character;

    Move (char character) {
        this.character = character;
    }

    public char getChar() {
        return character;
    }
}