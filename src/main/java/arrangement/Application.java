package arrangement;

import arrangement.controller.Game;
import arrangement.model.Validator;
import arrangement.view.Output;

public class Application {

    public static void main(String[] args) {
        Game game = new Game(new Output(), new Validator());
        game.play();
    }
}
