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
        logger.info("Instantiating Maze");
        this.filepath = filepath;
        this.height = getHeight();
        this.width = getWidth();
        this.maze = enumerateMaze();
    }

    public char getSpace(int x, int y) {
        return maze[x][y];
    }

    public int getStart() {
        for (int i = 0; i < width; i++) {
            if (maze[i][0] == 'p') {
                return i;
            }
        }
        return -1;
    }

    public int getFinish() {
        return width-1;
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
    private char[][] enumerateMaze() {
        char[][] mazeArray = new char[width][height];

        try {
            logger.info("**** Reading the maze from file " + this.filepath);
            BufferedReader reader = new BufferedReader(new FileReader(this.filepath));
            String line;
            
            int row = 0;
            while ((line = reader.readLine()) != null) {
                for (int col = 0; col < line.length(); col++) {
                    if (line.charAt(col) == '#') {
                        logger.info("WALL ");
                        mazeArray[row][col] = 'w';
                    } else if (line.charAt(col) == ' ') {
                        logger.info("PASS ");
                        mazeArray[row][col] = 'p';
                    }
                }
                row++;
                logger.info(System.lineSeparator());
            }
        } catch(Exception e) {
            logger.error("/!\\ An error has occured /!\\");
        }
        return mazeArray;
    }
}
