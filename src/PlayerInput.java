import java.util.List;
import java.util.Scanner;

import static java.lang.System.exit;

public class PlayerInput {
    public static String read() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
    public static Object selectOptions(){
        System.out.println("Enter 1 to buy property\n Enter 2 to end your turn ");
        return Integer.parseInt(read());
    }
}
