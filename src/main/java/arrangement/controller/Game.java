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

    public Game(Output output, Validator validator, OptionSelector optionSelector, GameState gameState, Income income) {
        this.output = output;
        this.validator = validator;
        this.optionSelector = optionSelector;
        this.gameState = gameState;
        this.income = income;
    }

    public void play() {
        while (gameState.getState()) {
            Option option = askOption();
            option.play();
        }
        System.out.println("--- 일과 종료 ---");
        System.out.println("최종 수입: " + income.getIncome() + "원");
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
