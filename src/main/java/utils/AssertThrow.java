package utils;

public class AssertThrow {
    public static void assertTrue(boolean condition, Class<? extends Throwable> exception, String message) {
        if (!condition) {
            try {
                throw exception.getDeclaredConstructor(String.class).newInstance(message);
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
        }
    }

}
