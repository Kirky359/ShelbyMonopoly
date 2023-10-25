import java.util.List;
import java.util.Scanner;

import static java.lang.System.exit;

public class PlayerInput {
    public static String read() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
    public static int selectOptions(){
        return Integer.parseInt(read());
    }
}
