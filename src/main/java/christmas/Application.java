package christmas;

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

        int date = inputView.readDate();
        Map<Menu, Integer> order = inputView.readOrder();

        EventService eventService = new EventService(date, order);
        EventResult eventResult = eventService.makeEventResult();
        outputView.printResult(eventResult);
    }
}
