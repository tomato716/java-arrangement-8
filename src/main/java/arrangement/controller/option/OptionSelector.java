package arrangement.controller.option;

import arrangement.constants.Constants;
import arrangement.model.Validator;
import arrangement.view.Input;
import arrangement.view.Output;
import java.util.List;

public class OptionSelector {
    private final List<Option> selector;
    private final Validator validator;
    private final Output output;

    public OptionSelector(OptionCreator optionCreator, Validator validator, Output output) {
        selector = optionCreator.createOptions();
        this.validator = validator;
        this.output = output;
    }

    private Option select(int number) {
        return selector.get(number - Constants.ALIGN_INDEX);
    }

    public Option askOption() {
        while (true) {
            try {
                output.printStart();
                String input = Input.console();
                int optionNumber = validator.selectNumber(input);
                return select(optionNumber);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
