/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.avalon.java.ocpjp.labs.actions;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Кирилл
 */
public class FileOpenAction implements Action {

    private File file;
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    BufferedReader bf;
    FileReader fr;
    StringBuffer sb = new StringBuffer();

    public FileOpenAction() {
        System.out.println("Lets open file");
        while (true) {

            System.out.println("Please, enter full file name: ");

            try {

                file = new File(in.readLine());
                if (file.exists()) {
                    break;
                }
            } catch (IOException ex) {
                System.out.println("Wrong name. Try again");
            }

        }
        start();
    }

    @Override
    public void run() {
        try {
            String tmp;
            fr =  new FileReader(file);
            bf = new BufferedReader(fr);
            while ((tmp = bf.readLine()) != null) {
                sb = sb.append(tmp).append("\n");
            }
            System.out.println(sb.toString());
            close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FileOpenAction.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FileOpenAction.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(FileOpenAction.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void close() throws Exception {
        bf.close();
        fr.close();
        
    }

}
