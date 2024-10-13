public class MyStateMachine extends FiniteStateMachine {

    @Override
    public void handleEvent1() {
        System.out.println("Производный класс: Обработка Event1");
    }

    @Override
    public void handleEvent2() {
        System.out.println("Производный класс: Обработка Event2");
    }

    @Override
    public void handleEvent3() {
        System.out.println("Производный класс: Обработка Event3");
    }
}
