package org.reflection.runner.advanced.programs;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

// 1. Define an interface
interface MyService {
    void doSomething();
    String getData(String param);
}

// 2. Create a concrete implementation of that interface
class MyServiceImpl implements MyService {
    @Override
    public void doSomething() {
        System.out.println("MyServiceImpl: Doing something important.");
    }

    @Override
    public String getData(String param) {
        System.out.println("MyServiceImpl: Getting data for param: " + param);
        return "Data for " + param;
    }
}

// 3. Implement an InvocationHandler to define the proxy's behavior
class MyServiceInvocationHandler implements InvocationHandler {
    private final Object target; // The actual object to which the proxy delegates calls

    public MyServiceInvocationHandler(Object target) {
        this.target = target;
    }

    /**
     * This method is invoked when a method is called on the proxy instance.
     *
     * @param proxy The proxy instance that the method was invoked on.
     * @param method The Method instance corresponding to the interface method invoked on the proxy instance.
     * @param args An array of objects containing the values of the arguments passed in the method invocation on the proxy instance.
     * @return The value to return from the method invocation on the proxy instance.
     * @throws Throwable The exception to throw from the method invocation on the proxy instance.
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // You can add pre-processing logic here
        System.out.println("\n--- Proxy Intercepted Call ---");
        System.out.println("Method invoked: " + method.getName());
        System.out.print("Arguments: ");
        if (args != null) {
            for (Object arg : args) {
                System.out.print(arg + " ");
            }
        } else {
            System.out.print("None");
        }
        System.out.println();

        // Invoke the actual method on the target object
        Object result = method.invoke(target, args);

        // You can add post-processing logic here
        System.out.println("Method returned: " + result);
        System.out.println("--- End Proxy Intercepted Call ---");

        return result;
    }
}

public class ProxyExample {
    public static void main(String[] args) {
        // Create an instance of the concrete implementation
        MyService realService = new MyServiceImpl();

        // Create an InvocationHandler with the real service as the target
        InvocationHandler handler = new MyServiceInvocationHandler(realService);

        // 4. Use Proxy.newProxyInstance() to create a dynamic proxy
        // Parameters:
        //   - ClassLoader: The class loader to define the proxy class.
        //   - interfaces: An array of interfaces that the proxy class should implement.
        //   - InvocationHandler: The invocation handler to dispatch method invocations to.
        MyService proxyService = (MyService) Proxy.newProxyInstance(
                MyService.class.getClassLoader(), // Class loader
                new Class<?>[]{MyService.class},  // Interfaces to implement
                handler                           // Invocation handler
        );

        // 5. Show how the proxy intercepts method calls
        System.out.println("Calling doSomething() through the proxy:");
        proxyService.doSomething();

        System.out.println("\nCalling getData() through the proxy:");
        String data = proxyService.getData("exampleParam");
        System.out.println("Received data from proxy: " + data);
    }
}
