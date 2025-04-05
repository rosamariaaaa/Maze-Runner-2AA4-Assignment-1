package ca.mcmaster.se2aa4.mazerunner;

public class MoveForward implements MovementCommand {

    public static final Path path = new Path("F");

    @Override
    public void execute(Coordinates coords, Compass compass) {
        Direction direction = compass.getDirection();
        Coordinates forward = direction.getForward(coords);
        coords.set(forward.getX(), forward.getY());
    }

    @Override
    public Path getPath() {
        return path;
    }

}