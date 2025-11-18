package arrangement;

import arrangement.controller.Game;
import arrangement.controller.option.OptionCreator;
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
        Output output = new Output();
        OptionCreator optionCreator = new OptionCreator(gameState, income, validator, missionItem);
        Game game = new Game(new OptionSelector(optionCreator, validator, output), gameState);

        game.play();
    }
}
