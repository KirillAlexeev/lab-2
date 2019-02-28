package ru.avalon.java.ocpjp.labs.actions;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Действие, которое перемещает файлы в пределах дискового пространства.
 */
public class FileMoveAction implements Action {

    /**
     * {@inheritDoc}
     */

    String fileName;
    String name;
    String content;
    File pathFrom;
    File pathTo;
    File file;

    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    public FileMoveAction() {

        System.out.println("Lets move file");
        try {
            while (true) {
                System.out.println("Please enter path from which you are going to move.");
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
                name = in.readLine();
                fileName = pathFrom + name;

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
                pathTo = new File(in.readLine() + "//"+ name);
                if (pathFrom.isDirectory()) {
                    break;
                }
                System.out.println("Wrong path!! Try again.");
            }
        } catch (IOException ex) {
            Logger.getLogger(FileCopyAction.class.getName()).log(Level.SEVERE, null, ex);
        }

        start();
    }

    @Override
    public void run() {
        try {
            Files.move(file.toPath(), pathTo.toPath(), REPLACE_EXISTING);
            close();
        } catch (IOException ex) {
            Logger.getLogger(FileCopyAction.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(FileMoveAction.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void close() throws Exception {
        in.close();
        throw new UnsupportedOperationException("Not implemented yet!");
    }

}
