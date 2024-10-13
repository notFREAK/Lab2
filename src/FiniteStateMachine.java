public abstract class FiniteStateMachine {

    @Transition(fromState = "State1", event = "Event1", toState = "State2", methodName = "handleEvent1")
    public void transition1() {
        // Переход State1 -> State2
    }

    @Transition(fromState = "State2", event = "Event2", toState = "State3", methodName = "handleEvent2")
    public void transition2() {
        // Переход State2 -> State3
    }

    @Transition(fromState = "State3", event = "Event3", toState = "State1", methodName = "handleEvent3")
    public void transition3() {
        // Переход State3 -> State1
    }

    public abstract void handleEvent1();
    public abstract void handleEvent2();
    public abstract void handleEvent3();
}
