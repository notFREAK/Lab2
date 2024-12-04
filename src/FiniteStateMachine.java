public abstract class FiniteStateMachine {

    @Transition(fromState = "START", event = "LETTER", toState = "IDENTIFIER", methodName = "startIdentifier")
    public void transition1() {
        System.out.println("Выполняется Transition1: START -> IDENTIFIER при событии LETTER");
    }

    @Transition(fromState = "START", event = "DIGIT", toState = "NUMBER", methodName = "startNumber")
    public void transition2() {
        System.out.println("Выполняется Transition2: START -> NUMBER при событии DIGIT");
    }

    @Transition(fromState = "IDENTIFIER", event = "LETTER", toState = "IDENTIFIER", methodName = "continueIdentifier")
    public void transition3() {
        System.out.println("Выполняется Transition3: IDENTIFIER -> IDENTIFIER при событии LETTER");
    }

    @Transition(fromState = "IDENTIFIER", event = "DIGIT", toState = "IDENTIFIER", methodName = "continueIdentifier")
    public void transition4() {
        System.out.println("Выполняется Transition4: IDENTIFIER -> IDENTIFIER при событии DIGIT");
    }

    @Transition(fromState = "IDENTIFIER", event = "SPACE", toState = "START", methodName = "endToken")
    public void transition5() {
        System.out.println("Выполняется Transition5: IDENTIFIER -> START при событии SPACE");
    }

    @Transition(fromState = "NUMBER", event = "DIGIT", toState = "NUMBER", methodName = "continueNumber")
    public void transition6() {
        System.out.println("Выполняется Transition6: NUMBER -> NUMBER при событии DIGIT");
    }

    @Transition(fromState = "NUMBER", event = "SPACE", toState = "START", methodName = "endToken")
    public void transition7() {
        System.out.println("Выполняется Transition7: NUMBER -> START при событии SPACE");
    }

    @Transition(fromState = "START", event = "NEWLINE", toState = "END", methodName = "endProcessing")
    public void transition8() {
        System.out.println("Выполняется Transition8: START -> END при событии NEWLINE");
    }

    @Transition(fromState = "IDENTIFIER", event = "NEWLINE", toState = "END", methodName = "endProcessing")
    public void transition9() {
        System.out.println("Выполняется Transition9: IDENTIFIER -> END при событии NEWLINE");
    }

    @Transition(fromState = "NUMBER", event = "NEWLINE", toState = "END", methodName = "endProcessing")
    public void transition10() {
        System.out.println("Выполняется Transition10: NUMBER -> END при событии NEWLINE");
    }

    @Transition(fromState = "START", event = "OTHER", toState = "START", methodName = "ignoreOther")
    public void transition11() {
        System.out.println("Выполняется Transition11: START -> START при событии OTHER");
    }

    @Transition(fromState = "IDENTIFIER", event = "OTHER", toState = "START", methodName = "endToken")
    public void transition12() {
        System.out.println("Выполняется Transition12: IDENTIFIER -> START при событии OTHER");
    }

    @Transition(fromState = "NUMBER", event = "OTHER", toState = "START", methodName = "endToken")
    public void transition13() {
        System.out.println("Выполняется Transition13: NUMBER -> START при событии OTHER");
    }

    // Абстрактные методы, которые должны быть реализованы в подклассе
    public abstract void startIdentifier();
    public abstract void continueIdentifier();
    public abstract void startNumber();
    public abstract void continueNumber();
    public abstract void endToken();
    public abstract void endProcessing();
    public abstract void ignoreOther();
}
