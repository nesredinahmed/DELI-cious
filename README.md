+-------------------+       1
|    Application    |<------+
+-------------------+       |
| - screens: List<Screen>   |
| - currentOrder: Order     |
+-------------------+       |
| + run(): void     |       |
| + navigateTo(Screen): void|
+-------------------+       |
           |                |
           | knows about    |
           V                |
+-------------------+       |
|     <<interface>> |       |
|      Screen       |       |
+-------------------+       |
| + display(): void |       |
| + handleInput(): void |
+-------------------+       |
           /\               |
          /  \              |
         /____\             |
           |                |
           | implements     |
           |                |
+-------------------+       |
|     HomeScreen    |       |
+-------------------+       |
| - orderManager: OrderManager |
+-------------------+       |
| + display(): void |       |
| + handleInput(): void |   |
+-------------------+       |
                            |
+-------------------+       |
|     OrderScreen   |       |
+-------------------+       |
| - currentOrder: Order     |
+-------------------+       |
| + display(): void |       |
| + handleInput(): void |   |
+-------------------+       |
                            |
+-------------------+       |
| AddSandwichScreen |       |
+-------------------+       |
| - currentOrder: Order     |
+-------------------+       |
| + display(): void |       |
| + handleInput(): void |   |
+-------------------+       |
                            |
+-------------------+       |
|  AddDrinkScreen   |       |
+-------------------+       |
| - currentOrder: Order     |
+-------------------+       |
| + display(): void |       |
| + handleInput(): void |   |
+-------------------+       |
                            |
+-------------------+       |
|  AddChipsScreen   |       |
+-------------------+       |
| - currentOrder: Order     |
+-------------------+       |
| + display(): void |       |
| + handleInput(): void |   |
+-------------------+       |
                            |
+-------------------+       |
|   CheckoutScreen  |       |
+-------------------+       |
| - currentOrder: Order     |
+-------------------+       |
| + display(): void |       |
| + handleInput(): void |   |
+-------------------+       |
                            |
+-------------------+       |
|   OrderManager    |-------+ 1
+-------------------+       |   owns
| - currentOrder: Order (optional, or pass order around) |
+-------------------+       |
| + createNewOrder(): Order |
| + cancelOrder(Order): void|
| + completeOrder(Order): void |
+-------------------+       |
           |                |
           | manages        |
           V                |
+-------------------+ 1..*
|       Order       |<-----------------+
+-------------------+                  |
| - sandwiches: List<Sandwich> |      |
| - drinks: List<Drink>     |         |
| - chips: List<Chips>       |         |
+-------------------+         1         |
| + addItem(Sellable): void |           |
| + calculateTotal(): double|           |
| + getDetails(): String    |           |
+-------------------+                   |
           /\                           |
          /  \                          |
         /____\                         |
           |                            |
           | aggregates                 |
           |                            |
+-------------------+                   |
|   <<interface>>   |                   |
|     Sellable      |                   |
+-------------------+                   |
| + getPrice(): double |                |
| + getDetails(): String |              |
+-------------------+                   |
           /\                           |
          /  \                          |
         /____\                         |
           |                            |
           | implements                 |
           |                            |
+-------------------+      +-------------------+      +-------------------+
|     Sandwich      |      |       Drink       |      |       Chips       |
+-------------------+      +-------------------+      +-------------------+
| - size: String    |      | - size: String    |      | - type: String    |
| - bread: Bread    |      | - flavor: String  |      +-------------------+
| - toppings: List<Topping> |      +-------------------+      | + getPrice(): double |
| - toasted: boolean|      | + getPrice(): double |      | + getDetails(): String |
+-------------------+      | + getDetails(): String |      +-------------------+
| + addBread(Bread): void |      +-------------------+
| + addTopping(Topping): void |
| + setToasted(boolean): void |
| + getPrice(): double |
| + getDetails(): String |
+-------------------+
           |
           | aggregates
           V
+-------------------+
|       Bread       |
+-------------------+
| - type: String    |
+-------------------+
| + getPrice(size): double |
+-------------------+
           /\
          /  \
         /____\
           |
           | aggregates
           |
+-------------------+
|     <<abstract>>  |
|       Topping     |
+-------------------+
| - name: String    |
+-------------------+
| + getPrice(size): double |
| + isExtraCost(): boolean |
+-------------------+
           /\
          /  \
         /____\
           |
           | extends
           |
+-------------------+          +-------------------+
|   RegularTopping  |          |   PremiumTopping  |
+-------------------+          +-------------------+
|                    |          |                    |
+-------------------+          +-------------------+
| + getPrice(size): double (returns 0) |          | + getPrice(size): double |
| + isExtraCost(): boolean (returns false) |          | + isExtraCost(): boolean (returns true) |
+-------------------+          +-------------------+
                                         /\
                                        /  \
                                       /____\
                                         |
                                         | extends
                                         |
+-------------------+          +-------------------+
|        Meat       |          |       Cheese      |
+-------------------+          +-------------------+
|                    |          |                    |
+-------------------+          +-------------------+
| + getPrice(size): double |          | + getPrice(size): double |
+-------------------+          +-------------------+

+-------------------+
|    ReceiptLogger  |
+-------------------+
| - receiptsFolder: String |
+-------------------+
| + saveReceipt(Order): void |
