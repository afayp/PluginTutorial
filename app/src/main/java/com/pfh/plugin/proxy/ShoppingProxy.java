package com.pfh.plugin.proxy;

public class ShoppingProxy implements Shopping {

    Shopping base;

    public ShoppingProxy(Shopping base) {
        this.base = base;
    }

    @Override
    public String doShopping(long money) {
        String originalThings = base.doShopping(money);
        originalThings = "代理买的东西";
        return originalThings;
    }
}
