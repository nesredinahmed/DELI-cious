import com.delicious.model.Order;
import com.delicious.utilities.AnsiColors; // Import AnsiColors
import com.delicious.screens.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * The main application class for DELI-cious CLI.
 * Manages screen navigation and the current order state.
 */
public class Application {
    private Scanner scanner;
    private Map<String, Screen> screens;
    private Order currentOrder;
    private String currentScreenName;

    public Application() {
        this.scanner = new Scanner(System.in);
        this.screens = new HashMap<>();
        this.currentOrder = new Order(); // Initialize a new order for the session
        initializeScreens();
        this.currentScreenName = "home"; // Start at the home screen
    }

    /**
     * Initializes all application screens and maps them by name.
     */
    private void initializeScreens() {
        screens.put("home", new HomeScreen());
        screens.put("order", new OrderScreen(currentOrder)); // Pass currentOrder to OrderScreen
        screens.put("add_sandwich", new AddSandwichScreen(currentOrder));
        screens.put("add_drink", new AddDrinkScreen(currentOrder));
        screens.put("add_chips", new AddChipsScreen(currentOrder));
        screens.put("checkout", new CheckoutScreen(currentOrder));
    }

    /**
     * The main application loop. Displays the current screen and handles user input.
     */
    public void run() {
        System.out.println(AnsiColors.BOLD + AnsiColors.CYAN + "\n========================================" + AnsiColors.RESET);
        System.out.println(AnsiColors.BOLD + AnsiColors.CYAN + "  Welcome to DELI-cious! Order Fresh! " + AnsiColors.RESET);
        System.out.println(AnsiColors.BOLD + AnsiColors.CYAN + "========================================\n" + AnsiColors.RESET);

        while (true) {
            Screen currentScreen = screens.get(currentScreenName);
            if (currentScreen == null) {
                System.err.println(AnsiColors.RED + "Error: Screen not found: " + currentScreenName + AnsiColors.RESET);
                currentScreenName = "home"; // Fallback to home
                continue;
            }

            currentScreen.display();
            String nextScreenCommand = currentScreen.handleInput(scanner);

            // Handle special commands
            if ("exit".equals(nextScreenCommand)) {
                System.out.println(AnsiColors.BOLD + AnsiColors.CYAN + "\n=========================================" + AnsiColors.RESET);
                System.out.println(AnsiColors.BOLD + AnsiColors.CYAN + "  Thank you for using DELI-cious! Goodbye! " + AnsiColors.RESET);
                System.out.println(AnsiColors.BOLD + AnsiColors.CYAN + "=========================================\n" + AnsiColors.RESET);
                System.out.println( AnsiColors.YELLOW + "                                                           _\n" +
                        "                                                          //\n" +
                        "                                                         //\n" +
                        "                                         _______________//__\n" +
                        "                                       .(______________//___).\n" +
                        "                                       |              /      |\n" +
                        "                                       |. . . . . . . / . . .|\n" +
                        "                                       \\ . . . . . ./. . . . /\n" +
                        "                                        |           / ___   |\n" +
                        "                    _.---._             |::......./../...\\.:|\n" +
                        "                _.-~       ~-._         |::::/::\\::/:\\::::::|\n" +
                        "            _.-~               ~-._     |::::\\::/::::::X:/::|\n" +
                        "        _.-~                       ~---.;:::::::/::\\::/:::::|\n" +
                        "    _.-~                                 ~\\::::::n::::::::::|\n" +
                        " .-~                                    _.;::/::::a::::::::/\n" +
                        " :-._                               _.-~ ./::::::::d:::::::|\n" +
                        " `-._~-._                   _..__.-~ _.-~|::/::::::::::::::|\n" +
                        "  /  ~-._~-._              / .__..--~----.YWWWWWWWWWWWWWWWP'\n" +
                        " \\_____(_;-._\\.        _.-~_/       ~).. . \\\n" +
                        "    /(_____  \\`--...--~_.-~______..-+_______)\n" +
                        "  .(_________/`--...--~/    _/           /\\\n" +
                        " /-._     \\_     (___./_..-~__.....__..-~./\n" +
                        " `-._~-._   ~\\--------~  .-~_..__.-~ _.-~\n" +
                        "     ~-._~-._ ~---------'  / .__..--~\n" +
                        "         ~-._\\.        _.-~_/\n" +
                        "             \\`--...--~_.-~\n" +
                        "              `--...--~" + AnsiColors.RESET);
                System.out.println(AnsiColors.BOLD + AnsiColors.CYAN + " ____  _____ _____ _      ___     ___ _   _  ____ _   _  ____  _   _  ____ \n" +
                        " |  _ \\| ____|_   _| |    / \\ \\   / / | | | |/ ___| | | |/ ___|| | | |/ ___|\n" +
                        " | | | |  _|   | | | |   / _ \\ \\ / /| | | | |   | |_| | |     | |_| |\\___ \\\n" +
                        " | |_| | |___  | | | |__| ___ \\ V / | |_| | |___|  _  | |___  |  _  | ___) |\n" +
                        " |____/|_____| |_| |____/_/   \\_/   \\___/ \\____|_| |_| \\____| |_| |_|____/ \n" +
                        "\n" +
                        " ----------------------------------------------------------------------------\n" +
                        " |                                                                          |\n" +
                        " |         \uD83E\uDD6A              DELI-cious CLI POS - ORDER FRESH! \uD83E\uDD64            |\n" +
                        " |                                                                          |\n" +
                        " ----------------------------------------------------------------------------\n" + AnsiColors.RESET);


                break; // Exit the loop and terminate application
            } else if ("cancel_order".equals(nextScreenCommand)) {
                // For OrderScreen's cancel, just reset the order and go home
                this.currentOrder = new Order(); // Create a new empty order
                // Re-initialize screens that depend on currentOrder
                screens.put("order", new OrderScreen(currentOrder));
                screens.put("add_sandwich", new AddSandwichScreen(currentOrder));
                screens.put("add_drink", new AddDrinkScreen(currentOrder));
                screens.put("add_chips", new AddChipsScreen(currentOrder));
                screens.put("checkout", new CheckoutScreen(currentOrder));
                currentScreenName = "home";
            } else if ("new_order_and_home".equals(nextScreenCommand) || "cancel_order_and_home".equals(nextScreenCommand)) {
                // For CheckoutScreen's confirm/cancel, reset order and go home
                this.currentOrder = new Order(); // Create a new empty order
                // Re-initialize screens that depend on currentOrder
                screens.put("order", new OrderScreen(currentOrder));
                screens.put("add_sandwich", new AddSandwichScreen(currentOrder));
                screens.put("add_drink", new AddDrinkScreen(currentOrder));
                screens.put("add_chips", new AddChipsScreen(currentOrder));
                screens.put("checkout", new CheckoutScreen(currentOrder));
                currentScreenName = "home";
            } else {
                // Navigate to the next screen
                currentScreenName = nextScreenCommand;
            }
        }
        scanner.close(); // Close the scanner when the application exits
    }

    public static void main(String[] args) {
        Application app = new Application();
        app.run();
    }
}