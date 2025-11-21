package arrangement;

import arrangement.controller.Game;
import arrangement.controller.option.OptionCreator;
import arrangement.controller.option.OptionSelector;
import arrangement.model.GameState;
import arrangement.model.Income;
import arrangement.model.MissionItemRule;
import arrangement.model.RandomMissionItem;
import arrangement.model.Validator;
import arrangement.view.Input;
import arrangement.view.Output;

public class Application {

    public static void main(String[] args) {
        GameState gameState = new GameState();
        Income income = new Income();
        Validator validator = new Validator();
        MissionItemRule missionItem = new RandomMissionItem();
        Output output = new Output();
        OptionCreator optionCreator = new OptionCreator(gameState, income, validator, missionItem, output);
        OptionSelector optionSelector = new OptionSelector(optionCreator, validator, output);
        Game game = new Game(optionSelector, gameState);

        game.play();
        Input.finish();
    }
}
