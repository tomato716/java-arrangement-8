package arrangement;

import arrangement.controller.Game;
import arrangement.model.GameState;
import arrangement.model.Income;
import arrangement.model.MissionItem;
import arrangement.model.RandomMissionItem;
import arrangement.model.Validator;
import arrangement.controller.option.OptionSelector;
import arrangement.view.Output;

public class Application {

    public static void main(String[] args) {
        GameState gameState = new GameState();
        Income income = new Income();
        Validator validator = new Validator();
        MissionItem missionItem = new RandomMissionItem();
        Game game = new Game(new Output(), validator, new OptionSelector(gameState, income, validator, missionItem),
                gameState,
                income);
        game.play();
    }
}
