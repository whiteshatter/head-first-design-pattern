package com.mint.disignpattern.jdk;

import java.lang.reflect.Proxy;

public class OwnerProxyUtil {
    public static PersonBean getOwnerProxy(PersonBean person) {
        return (PersonBean) Proxy.newProxyInstance(
                person.getClass().getClassLoader(),
                person.getClass().getInterfaces(),
                new OwnerInvocationHandler(person)
        );
    }
}
