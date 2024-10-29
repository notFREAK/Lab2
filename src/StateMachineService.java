import java.lang.reflect.Method;

public class StateMachineService {
    private Object target;
    private String currentState;
    private boolean isRunning = true;

    public StateMachineService(Class<?> clazz, String initialState) throws Exception {
        this.target = clazz.getDeclaredConstructor().newInstance();
        this.currentState = initialState;
    }

    public void processEvent(String event, char currentChar) throws Exception {
        if (!isRunning) {
            throw new IllegalStateException("Автомат остановлен из-за ошибки.");
        }

        Class<?> clazz = target.getClass();
        Method[] methods = clazz.getMethods();

        boolean transitionFound = false;

        for (Method method : methods) {
            if (method.isAnnotationPresent(Transition.class)) {
                Transition transition = method.getAnnotation(Transition.class);
                if (transition.fromState().equals(currentState) && transition.event().equals(event)) {
                    Method setCharMethod = clazz.getMethod("setCurrentChar", char.class);
                    setCharMethod.invoke(target, currentChar);

                    System.out.println("Текущее состояние: " + currentState + ", Событие: " + event);
                    Method targetMethod = clazz.getMethod(transition.methodName());
                    targetMethod.setAccessible(true);
                    targetMethod.invoke(target);
                    currentState = transition.toState();

                    System.out.println("Переход в состояние: " + currentState + "\n");
                    transitionFound = true;
                    break;
                }
            }
        }

        if (!transitionFound) {
            isRunning = false;
            throw new IllegalArgumentException("Некорректный переход для события: " + event + " в состоянии: " + currentState);
        }

        if (currentState.equals("END")) {
            isRunning = false;
            System.out.println("Автомат достиг конечного состояния.");
        }
    }
}
