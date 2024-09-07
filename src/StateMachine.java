public interface StateMachine {
    void processEvent(String event) throws Exception;
    String getCurrentState();
}