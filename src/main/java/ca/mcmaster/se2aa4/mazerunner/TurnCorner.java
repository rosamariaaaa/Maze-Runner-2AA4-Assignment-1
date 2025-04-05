package ca.mcmaster.se2aa4.mazerunner;

/**
 * Turn corner Command
 */
public class TurnCorner implements MovementCommand {

    public static final Path path = new Path("FRF");

    /**
     * Execute the moveForward Command
     */
    @Override
    public void execute(Coordinates coords, Compass compass) {
        Direction direction = compass.getDirection();

        Coordinates forward = direction.getForward(coords);
        Coordinates corner = direction.getRightTurn().getForward(forward);
        coords.set(corner.getX(), corner.getY());
        compass.turnRight();
    }

    @Override
    public Path getPath() {
        return path;
    }

}