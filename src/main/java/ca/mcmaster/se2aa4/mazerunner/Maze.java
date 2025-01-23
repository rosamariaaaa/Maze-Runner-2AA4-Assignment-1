package ca.mcmaster.se2aa4.mazerunner;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.commons.cli.*;

public class Maze {

    private String filepath;
    private char[][] maze;
    private int length;
    private int width;
    private static final Logger logger = LogManager.getLogger();

    public Maze () {
        
    }

    public int getLength() {
        return 0;
    }

    public int getWidth() {
        return 0;
    }

    /**
     * Read the maze from the file path.
     */
    private void enumerateMaze(String filepath) {
        try {
            logger.info("**** Reading the maze from file " + filepath);
            BufferedReader reader = new BufferedReader(new FileReader(filepath));
            String line;
            
            while ((line = reader.readLine()) != null) {
                for (int idx = 0; idx < line.length(); idx++) {
                    if (line.charAt(idx) == '#') {
                        logger.trace("WALL ");
                    } else if (line.charAt(idx) == ' ') {
                        logger.trace("PASS ");
                    }
                }
                logger.info(System.lineSeparator());
            }
        } catch(Exception e) {
            logger.error("/!\\ An error has occured /!\\");
        }

    }

}
