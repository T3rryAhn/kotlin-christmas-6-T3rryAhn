package christmas;

import christmas.controller.EventPlanner;
import christmas.domain.logic.EventService;
import christmas.domain.model.EventResult;
import christmas.domain.type.Menu;
import christmas.view.InputView;
import christmas.view.OutputView;

import java.util.Map;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        EventPlanner eventPlanner = new EventPlanner(inputView, outputView);

        eventPlanner.run();
    }
}
