package com.pfh.plugin.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Java动态代理介绍：https://www.jianshu.com/p/6f6bb2f0ece9
 *
 * Java 实现动态代理的缺点：因为 Java 的单继承特性（每个代理类都继承了 Proxy 类），只能针对接口创建代理类，不能针对类创建代理类。
 * 如果是类可以手动写代理
 */
public class ProxyExample {

    public static void main(String[] args) {
        // 正常购物
        ShoppingImpl selfShopping = new ShoppingImpl();
        System.out.println(selfShopping.doShopping(100));


        // 代理购物
        ShoppingProxy proxyShopping = new ShoppingProxy(new Shopping() {
            @Override
            public String doShopping(long money) {
                return "代理买的东西";
            }
        });
        System.out.println(proxyShopping.doShopping(100));



        // Java动态代理购物
        Shopping javaProxyShopping = (Shopping) Proxy.newProxyInstance(Shopping.class.getClassLoader(), Shopping.class.getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
                if (method.getName().equals("doShopping")) {
                    return "Java动态代理买的东西";
                }
                return method.invoke(o, objects);
            }
        });
        System.out.println(javaProxyShopping.doShopping(100));

    }

    public static class ShoppingImpl implements Shopping {
        @Override
        public String doShopping(long money) {
            return "自己买东西";
        }
    }
}
