package ru.avalon.java.ocpjp.labs;

import ru.avalon.java.ocpjp.labs.console.ConsoleUI;

import java.io.IOException;
import ru.avalon.java.ocpjp.labs.actions.FileCopyAction;
import ru.avalon.java.ocpjp.labs.actions.FileCreateAction;
import ru.avalon.java.ocpjp.labs.actions.FileMoveAction;
import ru.avalon.java.ocpjp.labs.actions.FileOpenAction;

/**
 * Лабораторная работа №2
 * <p>
 * Курс: "DEV-OCPJP. Подготовка к сдаче сертификационных экзаменов серии Oracle
 * Certified Professional Java Programmer"
 * <p>
 * Тема: "Потоки исполнения (Threads) и многозадачность"
 *
 * @author Daniel Alpatov <danial.alpatov@gmail.com>
 */
public class Main extends ConsoleUI<Commands> {

    /**
     * Точка входа в приложение.
     *
     * @param args
     */
    public static void main(String[] args) {
        new Main().run();
    }

    /**
     * Конструктор класса.
     * <p>
     * Инициализирует экземпляр базового типа с использоавнием перечисления
     * {@link Commands}.
     */
    Main() {
        super(Commands.class);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void onCommand(Commands command) throws IOException {

        switch (command) {
            case copy:
                FileCopyAction copy = new FileCopyAction();
                break;
            case move:
                FileMoveAction move = new FileMoveAction();
                break;
            case create:

                FileCreateAction create = new FileCreateAction();

                break;
            case open:
                FileOpenAction open = new FileOpenAction();
                break;
            case exit:
                close();
                break;
            /*
                 * TODO №9 Обработайте необработанные команды
             */
        }
    }

}
