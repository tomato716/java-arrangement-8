package arrangement;

import arrangement.controller.Game;
import arrangement.model.GameState;
import arrangement.model.Income;
import arrangement.model.Validator;
import arrangement.controller.option.OptionSelector;
import arrangement.view.Output;

public class Application {

    public static void main(String[] args) {
        GameState gameState = new GameState();
        Income income = new Income();
        Game game = new Game(new Output(), new Validator(), new OptionSelector(gameState, income), gameState, income);
        game.play();
    }
}
