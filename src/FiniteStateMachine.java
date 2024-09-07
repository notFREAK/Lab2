import java.lang.reflect.Method;

public class FiniteStateMachine implements StateMachine {
    private String currentState;

    public FiniteStateMachine(String initialState) {
        this.currentState = initialState;
    }

    @Override
    public void processEvent(String event) throws Exception {
        Class<?> clazz = this.getClass();
        Method[] methods = clazz.getDeclaredMethods();

        for (Method method : methods) {
            if (method.isAnnotationPresent(Transition.class)) {
                Transition transition = method.getAnnotation(Transition.class);

                if (transition.fromState().equals(currentState) && transition.event().equals(event)) {
                    method.invoke(this);
                    currentState = transition.toState();
                    System.out.println("Переход в состояние: " + currentState);
                    return;
                }
            }
        }

        throw new IllegalArgumentException("Неверный переход для события: " + event);
    }

    @Override
    public String getCurrentState() {
        return currentState;
    }
}