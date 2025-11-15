package arrangement.controller;

import arrangement.model.GameState;
import arrangement.model.Income;
import arrangement.model.Validator;
import arrangement.controller.option.OptionSelector;
import arrangement.controller.option.Option;
import arrangement.view.Input;
import arrangement.view.Output;

public class Game {

    private final Output output;
    private final Validator validator;
    private final OptionSelector optionSelector;
    private final GameState gameState;
    private final Income income;

    public Game(Output output,
                OptionSelector optionSelector,
                GameState gameState) {
        this.output = output;
        this.validator = validator;
        this.optionSelector = optionSelector;
        this.gameState = gameState;
    }

    public void play() {
        while (gameState.getState()) {
            Option option = askOption();
            option.play();
        }
    }


    private Option askOption() {
        while (true) {
            try {
                output.printStart();
                String input = Input.console();
                int optionNumber = validator.selectNumber(input);
                return optionSelector.select(optionNumber);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
