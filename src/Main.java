public class Main {
    public static void main(String[] args) {
        try {
            StateMachineService stateMachineService = new StateMachineService(MyStateMachine.class, "State1");

            stateMachineService.processEvent("Event1");
            stateMachineService.processEvent("Event2");
            stateMachineService.processEvent("Event3");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
