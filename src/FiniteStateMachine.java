public abstract class FiniteStateMachine {

    @Transition(fromState = "START", event = "LETTER", toState = "IDENTIFIER", methodName = "startIdentifier")
    public void transition1() { }

    @Transition(fromState = "START", event = "DIGIT", toState = "NUMBER", methodName = "startNumber")
    public void transition2() { }

    @Transition(fromState = "IDENTIFIER", event = "LETTER_OR_DIGIT", toState = "IDENTIFIER", methodName = "continueIdentifier")
    public void transition3() { }

    @Transition(fromState = "NUMBER", event = "DIGIT", toState = "NUMBER", methodName = "continueNumber")
    public void transition4() { }

    @Transition(fromState = "IDENTIFIER", event = "OTHER", toState = "END", methodName = "endToken")
    public void transition5() { }

    @Transition(fromState = "NUMBER", event = "OTHER", toState = "END", methodName = "endToken")
    public void transition6() { }

    public abstract void startIdentifier();
    public abstract void continueIdentifier();
    public abstract void startNumber();
    public abstract void continueNumber();
    public abstract void endToken();
}
