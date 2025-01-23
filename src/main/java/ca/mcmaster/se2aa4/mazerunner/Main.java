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
    private Path path;

    private static String filepath;

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

    public static void parseCommandLine(Options options, String[] args) {
        CommandLine cmd;
        CommandLineParser parser = new DefaultParser();
        try {
            cmd = parser.parse(options,args);
            if (cmd.hasOption("i")) {
                logger.info("-i flag recieved");
                filepath = cmd.getOptionValue("i");
            }
        } catch (ParseException e) {
            logger.error(e.getMessage());
        }
    }

    public static void main(String[] args) {
        Options options = getOptions();
        parseCommandLine(options, args);

        logger.info("** Starting Maze Runner");

        logger.info("**** Computing path");
        logger.error("PATH NOT COMPUTED");
        logger.info("** End of MazeRunner");
    }
}
