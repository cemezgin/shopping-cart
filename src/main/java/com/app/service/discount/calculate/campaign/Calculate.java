package com.app.service.discount.calculate.campaign;


import com.app.service.cart.ShoppingCart;

public class Calculate {
    private ICalculateByType typeStrategy;

    public Calculate(ICalculateByType typeStrategy) {
        this.typeStrategy = typeStrategy;
    }

    public void setShoppingCart(ShoppingCart cart)
    {
        this.typeStrategy.setShoppingCart(cart);
    }
}
