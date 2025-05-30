package com.delicious.screens;

import java.util.Scanner;

/**
 * Interface for all application screens.
 */
public interface Screen {
    /**
     * Displays the content of the screen to the user.
     */
    void display();

    /**
     * Handles user input for the screen and determines the next action or screen.
     * @param scanner The Scanner object for reading user input.
     * @return A string representing the next screen to navigate to, or a command (e.g., "exit", "back").
     */
    String handleInput(Scanner scanner);
}