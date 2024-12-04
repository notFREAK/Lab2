import java.lang.reflect.Method;

public class StateMachineService {
    private Object target;
    private String currentState;
    private boolean isRunning = true;

    public StateMachineService(Class<?> clazz, String initialState) throws Exception {
        this.target = clazz.getDeclaredConstructor().newInstance();
        this.currentState = initialState;
    }

    public void processChar(char c) throws Exception {
        if (!isRunning) {
            throw new IllegalStateException("Автомат остановлен из-за ошибки.");
        }
        Method getEventTypeMethod = target.getClass().getMethod("getEventType", char.class);
        String event = (String) getEventTypeMethod.invoke(target, c);

        Class<?> clazz = target.getClass();
        Method[] methods = clazz.getMethods();

        boolean transitionFound = false;

        for (Method method : methods) {
            if (method.isAnnotationPresent(Transition.class)) {
                Transition transition = method.getAnnotation(Transition.class);
                if (transition.fromState().equals(currentState) && transition.event().equals(event)) {

                    Method setCharMethod = clazz.getMethod("setCurrentChar", char.class);
                    setCharMethod.invoke(target, c);
                    method.setAccessible(true);
                    method.invoke(target);

                    Method targetMethod = clazz.getMethod(transition.methodName());
                    targetMethod.setAccessible(true);
                    targetMethod.invoke(target);
                    currentState = transition.toState();
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

    public String getCurrentState() {
        return currentState;
    }
}
