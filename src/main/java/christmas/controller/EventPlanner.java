package christmas.controller;

import christmas.domain.logic.EventService;
import christmas.domain.model.EventResult;
import christmas.domain.type.Menu;
import christmas.view.InputView;
import christmas.view.OutputView;

import java.util.Map;

public class EventPlanner {
    private final InputView inputView;
    private final OutputView outputView;

    public EventPlanner(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        outputView.printIntro();

        int date = inputView.readDate();
        outputView.printCaution();
        Map<Menu, Integer> order = inputView.readOrder();

        EventService eventService = new EventService(date, order);
        EventResult eventResult = eventService.makeEventResult();

        outputView.printResult(eventResult);
    }
}
