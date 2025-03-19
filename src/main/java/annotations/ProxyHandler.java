package annotations;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.*;


public class ProxyHandler implements InvocationHandler {
    private final Object obj;
    private final Map<Key, Object> cacheMap = new HashMap<>();
    private final Map<Field, Object> stateMap = new HashMap<>();

    public ProxyHandler(Object obj) {
        this.obj = obj;
    }

    private void check(){
        Field[] fields = obj.getClass().getFields();



    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Method proxyMethod = obj.getClass().getMethod(method.getName(), method.getParameterTypes());

        if (!proxyMethod.isAnnotationPresent(Cache.class)) {
            return proxyMethod.invoke(this.obj, args);
        }

        Key key = new Key(proxyMethod, args);
        if (!cacheMap.containsKey(key)) {
            Object result = proxyMethod.invoke(this.obj, args);
            cacheMap.put(key, result);
            return result;
        }
        System.out.print("cached ");
        return cacheMap.get(key);
    }

    private record Key(Method method, Object[] args) {
            private Key(Method method, Object[] args) {
                this.method = method;
                if (args != null) {
                    this.args = Arrays.copyOf(args, args.length);
                } else this.args = new Object[0];
            }

            @Override
            public boolean equals(Object object) {
                if (this == object) return true;
                if (object == null || getClass() != object.getClass()) return false;
                Key key = (Key) object;
                return Objects.equals(method, key.method) && Objects.deepEquals(args, key.args);
            }

            @Override
            public int hashCode() {
                return Objects.hash(method, Arrays.hashCode(args));
            }
        }
}