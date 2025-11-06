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
        output.printStart();
        String input = Input.console();
        validator.selectNumber(input);

    }
}
