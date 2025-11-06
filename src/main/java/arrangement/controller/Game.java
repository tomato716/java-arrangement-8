package arrangement.controller;

import arrangement.model.Validator;
import arrangement.model.meat.OptionSelector;
import arrangement.model.option.Option;
import arrangement.view.Input;
import arrangement.view.Output;

public class Game {

    private final Output output;
    private final Validator validator;
    private final OptionSelector optionSelector;

    public Game(Output output, Validator validator, OptionSelector optionSelector) {
        this.output = output;
        this.validator = validator;
        this.optionSelector = optionSelector;
    }

    public void play() {
        int optionNumber = askOption();
        Option option = optionSelector.select(optionNumber);
        option.play();

    }


    private int askOption() {
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
