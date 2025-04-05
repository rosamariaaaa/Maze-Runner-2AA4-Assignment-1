package ca.mcmaster.se2aa4.mazerunner;

public interface MovementCommand {

    public void execute(Coordinates coords, Compass direction);

    public Path getPath();
   
}