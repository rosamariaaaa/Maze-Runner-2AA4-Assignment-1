package ca.mcmaster.se2aa4.mazerunner;

/**
 * Turn left command
 */
public class TurnLeft implements MovementCommand {

    public static final Path path = new Path("L");

    @Override
    public void execute(Coordinates coords, Compass compass) {
        compass.turnLeft();
    }

    @Override
    public Path getPath() {
        return path;
    }

}