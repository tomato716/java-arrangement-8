package arrangement.view;

import java.util.Scanner;

public class Input {
    private static Scanner scanner;

    public static String console() {
        return inputInit().nextLine();

    }

    private static Scanner inputInit() {
        if (scanner == null) {
            scanner = new Scanner(System.in);
        }

        return scanner;
    }

    public static void finish() {
        if (scanner != null) {
            scanner.close();
            scanner = null;
        }
    }
}
