package com.alkemann.advent.common;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FileSolver {

    protected Scanner scanner;

    protected boolean readFile(String filename) {
        try {
            File f = new File(filename);
            scanner = new Scanner(f);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FileSolver.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }
}
