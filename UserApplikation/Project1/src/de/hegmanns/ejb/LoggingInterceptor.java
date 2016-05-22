package de.hegmanns.ejb;

import java.lang.reflect.Parameter;

import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

public class LoggingInterceptor {
    
    @AroundInvoke
    public Object logge(InvocationContext invocationContext) throws Exception{
        long startzeit = System.currentTimeMillis();
        System.out.println("" + invocationContext.getParameters()[0]);
        Object result = invocationContext.proceed();
        String text = String.format("Call von %s dauerte %dms", invocationContext.getMethod().getDeclaringClass() + "." + invocationContext.getMethod().getName(), (System.currentTimeMillis() - startzeit));
        System.out.println(text);
        System.out.println("" + invocationContext.getMethod());
        System.out.println("Entries:");
        for (java.util.Map.Entry<String, Object> entry : invocationContext.getContextData().entrySet()){
            System.out.println("" + entry.getKey() + " : " + entry.getValue());
        }
        for (Parameter parameter : invocationContext.getMethod().getParameters()){
            System.out.println("" + parameter.getName() + ": " + parameter.toString());
            System.out.println("" + parameter);
            
        }
        
        
        return result;
    }
}
