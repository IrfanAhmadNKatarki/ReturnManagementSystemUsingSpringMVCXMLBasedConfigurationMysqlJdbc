package com.rms.model;

public class CustomUserOrderWrapper {
	private Order order;
    private CustomUser customUser;

    public CustomUserOrderWrapper(Order order, CustomUser customUser) {
        this.order = order;
        this.customUser = customUser;
    }

    public Order getOrder() {
        return order;
    }

    public CustomUser getCustomUser() {
        return customUser;
    }
}