public class MyStateMachine extends FiniteStateMachine {

    public MyStateMachine() {
        super("State1");
    }

    @Transition(fromState = "State1", event = "Event1", toState = "State2")
    public void handleEvent1() {
        System.out.println("Обработка Event1");
    }

    @Transition(fromState = "State2", event = "Event2", toState = "State3")
    public void handleEvent2() {
        System.out.println("Обработка Event2");
    }

    @Transition(fromState = "State3", event = "Event3", toState = "State1")
    public void handleEvent3() {
        System.out.println("Обработка Event3");
    }
}