package arrangement.controller;

import arrangement.model.Validator;
import arrangement.view.Input;
import arrangement.view.Output;

public class Game {

    private final Output output;
    private final Validator validator;

    public Game(Output output, Validator validator) {
        this.output = output;
        this.validator = validator;
    }

    public void play() {
        int choiceNumber = startChoice();
        System.out.println(choiceNumber);


    }

    private int startChoice() {
        while (true) {
            try {
                output.printStart();
                String input = Input.console();
                return validator.selectNumber(input);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

    }
}
