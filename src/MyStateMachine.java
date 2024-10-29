public class MyStateMachine extends FiniteStateMachine {

    private StringBuilder token = new StringBuilder();
    private char currentChar;

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

    @Override
    public void endProcessing() {
        System.out.println("Обработка завершена.");
    }

    @Override
    public void ignoreOther() {
        System.out.println("Игнорирование символа.");
    }

    public void setCurrentChar(char c) {
        this.currentChar = c;
    }

    public String getEventType(char c) {
        if (c == '\n') {
            return "NEWLINE";
        }  else if (Character.isLetter(c)) {
            return "LETTER";
        } else if (Character.isDigit(c)) {
            return "DIGIT";
        } else if (Character.isWhitespace(c)) {
            return "SPACE";
        } else {
            return "OTHER";
        }
    }
}
