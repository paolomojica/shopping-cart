package com.www.amaysim.strategy.chain;

import com.www.amaysim.entity.Cart;
import com.www.amaysim.entity.CartItem;

import java.util.List;

/**
 * Created by wsl-paolo on 16/06/2017.
 */
public class EmptyCartChain extends AbstPricingChain implements PricingChain {

    public EmptyCartChain(PricingChain next) {
        super.next = next;
    }

    public void process(Cart cart) {

        if(cart.getTotal() == null) {
            cart.setTotal(0.0);
        }

        if(cart.getCartItems().size() > 0 ) {
            super.next.process(cart);
        }
    }

}

