DELI-cious: Custom Sandwich Shop CLI Application
Project Description
DELI-cious is a command-line interface (CLI) point-of-sale application designed for a custom sandwich shop. This application automates the order process, allowing customers to fully customize their sandwich orders, add drinks and chips, and generate a detailed receipt. The project emphasizes Object-Oriented Analysis and Design (OOP) principles, utilizing classes and interfaces to create a modular, maintainable, and extensible solution.

Key Features:

Customizable Sandwiches: Customers can choose sandwich size (4", 8", 12"), bread type (white, wheat, rye, wrap), and various toppings.

Topping Categories: Toppings are categorized as regular (included), premium meats, and premium cheeses, with options for "extra" premium toppings at an additional cost.

Sauces and Sides: Customers can add a variety of sauces and side items to their sandwiches.

Order Management: Ability to add multiple sandwiches, drinks (with size and flavor), and chips to a single order.

Real-time Order Details: Displays current order details and total cost.

Receipt Generation: Upon checkout, a detailed receipt is generated and saved to a receipts folder, named by the date and time of the order.

Intuitive CLI: Guides the user through the ordering process with clear prompts and options.

Application Screens
Below are conceptual representations of the application's main screens. In a real project, you would replace these placeholders with actual screenshots of your running CLI application.

1. Home Screen
   (Screenshot of Home Screen - e.g., "Welcome to DELI-cious!", "1) New Order", "0) Exit")

--- DELI-cious Home Screen ---
1) New Order
0) Exit
   Enter your choice:


2. Order Screen
   (Screenshot of Order Screen - e.g., current order summary, options to add items, checkout, cancel)

--- Order Screen ---
Current Order Items:
(No items added yet)
--------------------
1) Add Sandwich
2) Add Drink
3) Add Chips
4) Checkout
0) Cancel Order
   Enter your choice:


3. Add Sandwich Screen (Interactive Flow)
   (Series of screenshots showing prompts for size, bread, meats, cheeses, regular toppings, sauces, sides, and toasted option)

--- Add Sandwich ---
Select sandwich size:
1) 4"
2) 8"
3) 12"
0) Cancel
   Enter choice:


(... and subsequent prompts for bread, toppings, etc.)

4. Checkout Screen
   (Screenshot of Checkout Screen - e.g., final order details, total, confirm/cancel options)

--- Checkout ---
--- Current Order Details ---
Item 1:
4" Sandwich on white bread (5.50)
Regular Toppings (Included): lettuce, tomatoes
Premium Toppings:
- steak ($1.00)
- american ($0.75)
Toasted: Yes
Sandwich Total: $7.25

-----------------------------
Subtotal: $7.25
--------------------
1) Confirm Order (Generate Receipt)
0) Cancel Order (Return to Home)
   Enter your choice:


Interesting Piece of Code: The selectOption Helper Method
In a command-line application, repeatedly asking the user to choose from a list of numbered options is a very common task. To avoid duplicating this logic throughout the code and to ensure consistent input validation, a reusable helper method is invaluable. The selectOption method in AddSandwichScreen (and other screen classes) perfectly demonstrates this.

This method takes a prompt message, a List of options, and handles displaying them, reading user input, validating it, and allowing for cancellation.

// From src/main/java/com/delicous/view/AddSandwichScreen.java

/**
* Helper method to prompt user for selection from a list of options.
* @param scanner Scanner for input.
* @param prompt The message to display to the user.
* @param options The list of available options.
* @return The selected option string, or null if user cancels.
  */
  private String selectOption(Scanner scanner, String prompt, List<String> options) {
  while (true) { // Keep looping until valid input or cancellation
  System.out.println(prompt); // Display the main question/prompt
  for (int i = 0; i < options.size(); i++) {
  System.out.println((i + 1) + ") " + options.get(i)); // Display numbered options
  }
  System.out.println("0) Cancel"); // Option to cancel
  System.out.print("Enter choice: "); // Prompt for input

       try {
           int choice = Integer.parseInt(scanner.nextLine()); // Read input and convert to int
           if (choice == 0) {
               System.out.println("Operation cancelled.");
               return null; // Return null if user cancels
           }
           if (choice > 0 && choice <= options.size()) {
               return options.get(choice - 1); // Return the selected option (adjust for 0-based index)
           } else {
               System.out.println("Invalid choice. Please try again."); // Handle out-of-range numbers
           }
       } catch (NumberFormatException e) {
           System.out.println("Invalid input. Please enter a number."); // Handle non-numeric input
       }
  }
  }


Why this code is interesting:

Reusability: This single method is used across multiple screens and for various selection tasks (sandwich size, bread, drink flavor, etc.), preventing redundant code.

Robustness: It includes essential error handling (try-catch for NumberFormatException) and input validation (checking if the choice is within the valid range), making the application more resilient to incorrect user input.

User Experience: It provides a consistent and clear way for users to make choices, including an explicit "Cancel" option, which is crucial for navigating CLI applications.

Abstraction: It abstracts away the details of how options are presented and how input is read and validated, allowing the calling code to focus on the business logic of what is being selected.

Diagrams
Class Diagram
(Placeholder for an image of your Class Diagram export - e.g., a .png or .svg generated from a UML tool)

This diagram visually represents the classes, interfaces, and their relationships within the DELI-cious application, illustrating the object-oriented design.

For your reference, here is the PlantUML text used to generate the class diagram, which you can paste into a PlantUML renderer (like PlantUML Online Server):

@startuml
skinparam handwritten true
skinparam shadowing false

interface Screen {
+ display(): void
+ handleInput(Scanner): String
}

class Application {
- scanner: Scanner
- screens: Map<String, Screen>
- currentOrder: Order
- currentScreenName: String
+ run(): void
- initializeScreens(): void
+ main(String[]): void
}

class HomeScreen implements Screen
class OrderScreen implements Screen
class AddSandwichScreen implements Screen
class AddDrinkScreen implements Screen
class AddChipsScreen implements Screen
class CheckoutScreen implements Screen

Application "1" *-- "1" Order : manages
Application "1" *-- "many" Screen : knows about

OrderScreen "1" *-- "1" Order
AddSandwichScreen "1" *-- "1" Order
AddDrinkScreen "1" *-- "1" Order
AddChipsScreen "1" *-- "1" Order
CheckoutScreen "1" *-- "1" Order

interface Sellable {
+ getPrice(): double
+ getDetails(): String
}

class Order {
- items: List<Sellable>
+ addItem(Sellable): void
+ calculateTotal(): double
+ getDetails(): String
}

Order "1" *-- "0..*" Sellable : aggregates

class Sandwich implements Sellable {
- size: String
- bread: Bread
- toppings: List<Topping>
- toasted: boolean
+ addTopping(Topping): void
+ setToasted(boolean): void
+ getPrice(): double
+ getDetails(): String
}

class Drink implements Sellable {
- flavor: String
- size: String
+ getPrice(): double
+ getDetails(): String
}

class Chips implements Sellable {
- type: String
+ getPrice(): double
+ getDetails(): String
}

Sandwich "1" *-- "1" Bread
Sandwich "1" *-- "0..*" Topping : aggregates

class Bread {
- type: String
+ getPrice(String): double
}

abstract class Topping {
# name: String
# isExtra: boolean
+ getPrice(String): double
+ hasAdditionalCost(): boolean
+ setExtra(boolean): void
}

class RegularTopping extends Topping {
+ getPrice(String): double
+ hasAdditionalCost(): boolean
}

abstract class PremiumTopping extends Topping {
+ hasAdditionalCost(): boolean
}

class Meat extends PremiumTopping {
+ getPrice(String): double
}

class Cheese extends PremiumTopping {
+ getPrice(String): double
}

class PriceList {
- SANDWICH_BASE_PRICES: Map<String, Double>
- MEAT_PRICES: Map<String, Double>
- EXTRA_MEAT_PRICES: Map<String, Double>
- CHEESE_PRICES: Map<String, Double>
- REGULAR_TOPPINGS: List<String>
- SAUCE_TYPES: List<String>
- SIDE_TOPPINGS: List<String>
- DRINK_SIZES: List<String>
- DRINK_FLAVORS: List<String>
- CHIP_TYPES: List<String>
+ getSandwichBasePrice(String): double {static}
+ getMeatPrice(String): double {static}
+ getExtraMeatPrice(String): double {static}
+ getCheesePrice(String): double {static}
+ getExtraCheesePrice(String): double {static}
+ getDrinkPrice(String): double {static}
+ getChipsPrice(): double {static}
}

class Menu {
- SANDWICH_SIZES: List<String>
- BREAD_TYPES: List<String>
- MEAT_TYPES: List<String>
- CHEESE_TYPES: List<String>
- REGULAR_TOPPINGS: List<String>
- SAUCE_TYPES: List<String>
- SIDE_TOPPINGS: List<String>
- DRINK_SIZES: List<String>
- DRINK_FLAVORS: List<String>
- CHIP_TYPES: List<String>
+ getSandwichSizes(): List<String> {static}
+ getBreadTypes(): List<String> {static}
+ getMeatTypes(): List<String> {static}
+ getCheeseTypes(): List<String> {static}
+ getRegularToppings(): List<String> {static}
+ getSauceTypes(): List<String> {static}
+ getSideToppings(): List<String> {static}
+ getDrinkSizes(): List<String> {static}
+ getDrinkFlavors(): List<String> {static}
+ getChipTypes(): List<String> {static}
}

class ReceiptLogger {
- RECEIPTS_FOLDER: String {static}
- FILE_NAME_FORMATTER: DateTimeFormatter {static}
+ saveReceipt(Order): void {static}
}

PriceList .. Menu : uses
ReceiptLogger .. Order : uses

@enduml
