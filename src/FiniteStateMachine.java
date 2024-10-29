public abstract class FiniteStateMachine {

    @Transition(fromState = "START", event = "LETTER", toState = "IDENTIFIER", methodName = "startIdentifier")
    public void transition1() { }

    @Transition(fromState = "START", event = "DIGIT", toState = "NUMBER", methodName = "startNumber")
    public void transition2() { }

    @Transition(fromState = "IDENTIFIER", event = "LETTER", toState = "IDENTIFIER", methodName = "continueIdentifier")
    public void transition3() { }

    @Transition(fromState = "IDENTIFIER", event = "DIGIT", toState = "IDENTIFIER", methodName = "continueIdentifier")
    public void transition4() { }

    @Transition(fromState = "IDENTIFIER", event = "SPACE", toState = "START", methodName = "endToken")
    public void transition5() { }

    @Transition(fromState = "NUMBER", event = "DIGIT", toState = "NUMBER", methodName = "continueNumber")
    public void transition6() { }

    @Transition(fromState = "NUMBER", event = "SPACE", toState = "START", methodName = "endToken")
    public void transition7() { }

    @Transition(fromState = "START", event = "NEWLINE", toState = "END", methodName = "endProcessing")
    public void transition8() { }

    @Transition(fromState = "IDENTIFIER", event = "NEWLINE", toState = "END", methodName = "endProcessing")
    public void transition9() { }

    @Transition(fromState = "NUMBER", event = "NEWLINE", toState = "END", methodName = "endProcessing")
    public void transition10() { }

    @Transition(fromState = "START", event = "OTHER", toState = "START", methodName = "ignoreOther")
    public void transition11() { }

    @Transition(fromState = "IDENTIFIER", event = "OTHER", toState = "START", methodName = "endToken")
    public void transition12() { }

    @Transition(fromState = "NUMBER", event = "OTHER", toState = "START", methodName = "endToken")
    public void transition13() { }

    public abstract void startIdentifier();
    public abstract void continueIdentifier();
    public abstract void startNumber();
    public abstract void continueNumber();
    public abstract void endToken();
    public abstract void endProcessing();
    public abstract void ignoreOther();
}
