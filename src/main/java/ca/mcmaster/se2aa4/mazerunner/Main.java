package ca.mcmaster.se2aa4.mazerunner;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.commons.cli.*;

public class Main {

    private static final Logger logger = LogManager.getLogger();
    private static final CommandLineParser parser = new DefaultParser();

    private Maze maze;
    private Traverser pathfinder;
    private MovementAlgorithm algorithm = new RightHandAlgorithm();
    private Options options;
    private String filepath;

    /**
     * Initialize main.
     */
    public Main(String args[]) {
        this.options = getOptions();
        this.filepath = getMazeFile(options, args);
        this.maze = new Maze(filepath);
        this.pathfinder = new Traverser(this.algorithm);
    }

    public void startMazeRunner() {
        logger.info("**** Computing path");
        Path path = pathfinder.getPath(this.maze);
        logger.info("Path found: " + path);

        System.out.println("Factorized path: " + path.getFactorized());
        System.out.println("Canonical path: " + path.getCanonical());
        logger.info("** End of MazeRunner");
    }

    public static Options getOptions() {
        Options options = new Options();
        Option customMap = Option.builder("i")
            .argName("Custom Map")
            .hasArg(true)
            .required(true)
            .desc("set custom map file").build();
        options.addOption(customMap);
        return options;
    }

    public String getMazeFile(Options options, String[] args) {
        CommandLine cmd;
        CommandLineParser parser = new DefaultParser();
        try {
            cmd = parser.parse(options,args);
            if (cmd.hasOption("i")) {
                logger.info("-i flag recieved");
                return cmd.getOptionValue("i");
            }
        } catch (ParseException e) {
            logger.error("Error. Map file not provided.");
        }
        return null;
    }

    public static void main(String[] args) {
        Main mazerunner = new Main(args);
        mazerunner.startMazeRunner();
    }
}