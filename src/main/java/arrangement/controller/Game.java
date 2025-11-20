package arrangement.controller;

import arrangement.controller.option.Option;
import arrangement.controller.option.OptionSelector;
import arrangement.model.GameState;

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
