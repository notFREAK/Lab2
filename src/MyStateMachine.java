public class MyStateMachine extends FiniteStateMachine {

    private StringBuilder token = new StringBuilder();

    @Override
    public void startIdentifier() {
        token.append(currentChar);
        System.out.println("Начало идентификатора: " + token);
    }

    @Override
    public void continueIdentifier() {
        token.append(currentChar);
        System.out.println("Продолжение идентификатора: " + token);
    }

    @Override
    public void startNumber() {
        token.append(currentChar);
        System.out.println("Начало числа: " + token);
    }

    @Override
    public void continueNumber() {
        token.append(currentChar);
        System.out.println("Продолжение числа: " + token);
    }

    @Override
    public void endToken() {
        System.out.println("Токен завершен: " + token);
        token.setLength(0);
    }

    private char currentChar;

    public void setCurrentChar(char c) {
        this.currentChar = c;
    }
}
