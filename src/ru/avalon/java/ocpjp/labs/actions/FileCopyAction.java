package ru.avalon.java.ocpjp.labs.actions;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Действие, которое копирует файлы в пределах дискового пространства.
 */
public class FileCopyAction implements Action {

    /**
     * {@inheritDoc}
     */
    File pathFrom;
    File pathTo;
    File file;
    File copyFile;
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    String fileName;

    public FileCopyAction() {
        System.out.println("Lets copy some file");
        try {
            while (true) {
                System.out.println("Please enter path from which you are going to copy.");
                pathFrom = new File(in.readLine());
                if (pathFrom.isDirectory()) {
                    break;
                }
                System.out.println("Wrong path!! Try again.");
            }
        } catch (IOException ex) {
            Logger.getLogger(FileCopyAction.class.getName()).log(Level.SEVERE, null, ex);
        }

        while (true) {

            System.out.println("Please, enter file name: ");

            try {
                fileName = pathFrom + in.readLine();

                file = new File(fileName);
                if (file.exists()) {
                    break;
                }
            } catch (IOException ex) {
                System.out.println("Wrong name. Try again");
            }
            System.out.println("File doesnt exist!! Try again.");
        }

        try {
            while (true) {
                System.out.println("Please enter path where you are going to copy.");
                pathTo = new File(in.readLine());
                if (pathFrom.isDirectory()) {
                    break;
                }
                System.out.println("Wrong path!! Try again.");
            }
        } catch (IOException ex) {
            Logger.getLogger(FileCopyAction.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            while (true) {
                System.out.println("Please, name the copy.");
                System.out.println(pathTo);
                fileName = pathTo +"\\" + in.readLine();
                copyFile = new File(fileName);
                copyFile.createNewFile();
                System.out.println(fileName);
                if (copyFile.isFile()) {
                    break;
                }
                System.out.println("Wrongfile name!! Try again.");
            }
        } catch (IOException ex) {
            Logger.getLogger(FileCopyAction.class.getName()).log(Level.SEVERE, null, ex);
        }
        start();
    }

    @Override
    public void run() {
        try {
            Files.copy(file.toPath(), copyFile.toPath(), REPLACE_EXISTING);
        } catch (IOException ex) {
            Logger.getLogger(FileCopyAction.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void close() throws Exception {
        /*
         * TODO №3 Реализуйте метод close класса FileCopyAction
         */
        throw new UnsupportedOperationException("Not implemented yet!");
    }
}
