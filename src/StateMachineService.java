import java.lang.reflect.Method;

public class StateMachineService {
    private Object target;
    private String currentState;

    public StateMachineService(Class<?> clazz, String initialState) throws Exception {
        this.target = clazz.getDeclaredConstructor().newInstance();
        this.currentState = initialState;
    }

    public void processEvent(String event) throws Exception {
        Class<?> clazz = target.getClass();
        Method[] methods = clazz.getMethods();

        for (Method method : methods) {
            if (method.isAnnotationPresent(Transition.class)) {
                Transition transition = method.getAnnotation(Transition.class);
                if (transition.fromState().equals(currentState) && transition.event().equals(event)) {
                    System.out.println("Текущее состояние: " + currentState);
                    Method targetMethod = clazz.getMethod(transition.methodName());
                    targetMethod.setAccessible(true);
                    targetMethod.invoke(target);
                    currentState = transition.toState();
                    System.out.println("Переход в состояние: " + currentState + "\n");
                    return;
                }
            }
        }

        throw new IllegalArgumentException("Неверный переход для события: " + event);
    }
}