package arrangement.controller;

import arrangement.model.GameState;
import arrangement.model.Income;
import arrangement.model.Validator;
import arrangement.controller.option.OptionSelector;
import arrangement.controller.option.Option;
import arrangement.view.Input;
import arrangement.view.Output;

public class Game {

    private final OptionSelector optionSelector;
    private final GameState gameState;

    public Game(OptionSelector optionSelector, GameState gameState) {
        this.optionSelector = optionSelector;
        this.gameState = gameState;
    }

    public void play() {
        while (gameState.getState()) {
            Option option = optionSelector.askOption();
            option.play();
        }
    }



}
