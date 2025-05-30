# Sandwich Shop Ordering System
## Overview
### This is a Java-based sandwich shop ordering application that allows customers to:

- #### Add drinks and chips to their order

- #### Review and checkout their order

- #### Save order receipts

- #### The application follows object-oriented principles with a clean architecture and separation of concerns.

## Key Features
- #### Order Management

- #### Create new orders with multiple items

- #### Calculate order total

- #### Complete or cancel orders

## Menu Items
- #### Sandwiches with customizable:

- #### Bread type (white, wheat, rye, etc.)

- #### Size (4", 8", 12")

- #### Toppings (regular and premium)

- #### Toasting option

- #### Drinks with size and flavor options

- #### Chips with different types

## User Interface
- #### Screen-based navigation system

- #### Intuitive menu selection

- #### Order summary display

- #### Technical Details
## Design Patterns
- #### Screen navigation using State pattern

- #### Polymorphic pricing for different item types

- #### Separation of concerns between UI and business logic

## Class Structure
- #### Application: Main controller

- #### Screens: Home, Order, AddItem, Checkout

- ####  Management: Order, OrderManager

- #### Menu Items: Sandwich, Drink, Chips implementing Sellable interface

- #### Components: Bread, Topping hierarchy

## How to Run
- #### Clone the repository

- #### Compile the Java files

- #### Run the Application class

## Future Enhancements
- #### Persistence for order history
- 
- #### Admin interface for menu management

- #### Payment system integration

- #### Enhanced UI with graphics


## Interesting Code
- #### High Reusability DRY Principle - Don't Repeat Yourself

- #### In a CLI application, you frequently need to present a list of choices. 

- #### The method uses a while(true) loop to ensure that the user is repeatedly prompted until they provide valid input or explicitly choose to cancel.

- #### Without this method, you would have to write the same block of code (looping through options, printing, reading input, validating) over and
  #### over again in different parts of your application.
![Screenshot 2025-05-29 221215.png](Screenshot/Screenshot%202025-05-29%20221215.png)


# CLI UI Screens

- ## Home Screens
![Screenshot 2025-05-29 213815.png](Screenshot/Screenshot%202025-05-29%20213815.png)

- ## Order Screens
![Screenshot 2025-05-29 213825.png](Screenshot/Screenshot%202025-05-29%20213825.png)

- ## Sandwich Screens
![Screenshot 2025-05-29 213833.png](Screenshot/Screenshot%202025-05-29%20213833.png)

- ## Meat Screens

![Screenshot 2025-05-29 213841.png](Screenshot/Screenshot%202025-05-29%20213841.png)


- ## Cheese Screens
![Screenshot 2025-05-29 213903.png](Screenshot/Screenshot%202025-05-29%20213903.png)


- ## Regular Topping Screens

![Screenshot 2025-05-29 213914.png](Screenshot/Screenshot%202025-05-29%20213914.png)

- ## Sauces Screens

![Screenshot 2025-05-29 213923.png](Screenshot/Screenshot%202025-05-29%20213923.png)


- ## Sides Screens

![Screenshot 2025-05-29 214107.png](Screenshot/Screenshot%202025-05-29%20214107.png)

- ## CheckOut Screens

![Screenshot 2025-05-29 214158.png](Screenshot/Screenshot%202025-05-29%20214158.png)


- ## Conformation Screens


![Screenshot 2025-05-29 214215.png](Screenshot/Screenshot%202025-05-29%20214215.png)


- ## Exit Screens

![Screenshot 2025-05-29 214235.png](Screenshot/Screenshot%202025-05-29%20214235.png)


## Author
#### Nesredin.A