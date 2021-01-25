package duke;

import java.util.Scanner;

/**
 * Main implementation for the Duke chat-bot.
 * @author Soon Keat Neo
 * @version CS2103T AY20/21 Sem 1 iP v0.1
 */

public class Duke {
    /** Allows for easy change of the bot name in future. **/
    final protected static String BOT_NAME = "DukeNukem";
    private Ui ui;
    private static TaskList tasks;
    private static Storage storage;
    public Duke(String filePath) {
        ui = new Ui();
        storage = new Storage(filePath).load();
        try {
            tasks = new TaskList(storage);
        } catch (DukeException e) {
            Ui.printMessage(e.getMessage());
            tasks = new TaskList();
        }
    }

    public void run() {
        listenInput();
        quit();
    }

    public static void main(String[] args) {
        new Duke("data/data.txt").run();
    }

    /**
     * Listens to the user's input, and passes it to the input handler.
     */
    public static void listenInput() {
        Scanner scannerObject = new Scanner(System.in);
        boolean stillListening = true;
        while (stillListening) {
            Ui.printSeparators();
            String inputString = scannerObject.nextLine().trim();;
            Ui.printSeparators();
            try {
                Parser.parse(inputString, tasks, storage);
            } catch (InvalidCommandException | InvalidInputException | InvalidTaskException e) {
                Ui.printMessage(e.getMessage());
            }
        }
    }

    /**
     * Quits the program and provides provisions for clean-up.
     */
    public static void quit() {
        Ui.printMessage("Hope you had an enjoyable experience! Good-bye~");
        System.exit(0);
    }
}
