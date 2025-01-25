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
    private int height;
    private int width;
    private static final Logger logger = LogManager.getLogger();

    public Maze (String filepath) {
        this.filepath = filepath;
        this.height = getHeight();
        this.width = getWidth();
    }

    /**
     * Return the height of the maze
     */
    public int getHeight() {
        try {
            int count = 0;
            BufferedReader reader = new BufferedReader(new FileReader(this.filepath));
            String line;
                
            while ((line = reader.readLine()) != null) {
                count++;
            }

            return count;
        } catch (Exception e) {
            logger.error("/!\\ An error has occured /!\\");
        }
        return -1;
    }

    /**
     * Return the width of the maze
     */
    public int getWidth() {
        // Read the first line of the maze. Return the length.
        try {
            BufferedReader reader = new BufferedReader(new FileReader(this.filepath));
            String line = reader.readLine();
            return line.length();
        } catch (Exception e) {
            logger.error("/!\\ An error has occured /!\\");
        }
        return -1;
    }

    /**
     * Read the maze from the file path.
     */
    private void enumerateMaze(String filepath) {
        try {
            logger.info("**** Reading the maze from file " + this.filepath);
            BufferedReader reader = new BufferedReader(new FileReader(this.filepath));
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
