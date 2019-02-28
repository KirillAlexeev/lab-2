/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.avalon.java.ocpjp.labs.actions;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Кирилл
 */
public class FileCreateAction implements Action {

    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    File path;
    File file;

    String fileName;
    String content;

    public FileCreateAction() {

        System.out.println("Lets create some file");
        while (true) {
            path = new File(createPath());
            if (path.isDirectory()) {
                break;
            }
            System.out.println("Wrong path!! Try again.");
        }

        while (true) {

            System.out.println("Please, enter file name: ");

            try {
                fileName = path + in.readLine();

                file = new File(fileName);
                if (file.createNewFile()) {
                    break;
                }
            } catch (IOException ex) {
                System.out.println("Wrong name. Try again");
            }

        }
        System.out.println("Please, enter the text: ");
        try {
            content = in.readLine();
            start();

        } catch (IOException ex) {
            Logger.getLogger(FileCreateAction.class.getName()).log(Level.SEVERE, null, ex);
        } 

    }

    @Override
    public void run() {
        try (FileWriter fw = new FileWriter(file)) {

            fw.write(content);
            fw.flush();
            close();
        } catch (IOException ex) {
            Logger.getLogger(FileCreateAction.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(FileCreateAction.class.getName()).log(Level.SEVERE, null, ex);
        }

                
    }

    private String createPath() {
        System.out.println("Please, enter file path: ");
        try {
            return in.readLine();
        } catch (IOException ex) {
            return ex.getLocalizedMessage();
        }
    }

    @Override
    public void close() throws Exception {
        in.close();
        
    }

}
