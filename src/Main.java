public class Main {
    public static void main(String[] args) {
        try {
            StateMachineService stateMachineService = new StateMachineService(MyStateMachine.class, "START");
            String input = "var123 456";

            for (char c : input.toCharArray()) {
                String event = getEventType(c);
                stateMachineService.processEvent(event, c);
            }
            stateMachineService.processEvent("OTHER", ' ');

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String getEventType(char c) {
        if (Character.isLetter(c)) {
            return "LETTER";
        } else if (Character.isDigit(c)) {
            return "DIGIT";
        } else if (Character.isLetterOrDigit(c)) {
            return "LETTER_OR_DIGIT";
        } else {
            return "OTHER";
        }
    }
}
