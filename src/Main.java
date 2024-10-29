public class Main {
    public static void main(String[] args) {
        try {
            StateMachineService stateMachineService = new StateMachineService(MyStateMachine.class, "START");
            String input = "var123 456\t789\n";

            for (char c : input.toCharArray()) {
                try {
                    stateMachineService.processChar(c);
                } catch (IllegalArgumentException e) {
                    System.err.println(e.getMessage());
                    break;
                }
            }



        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
