package ca.mcmaster.se2aa4.mazerunner;

/**
 * Implementation of the Command Design Pattern
 * Encapsulates movement commands.
 */
public interface MovementCommand {

    public void execute(Coordinates coords, Compass direction);

    public Path getPath();
   
}