package com.www.amaysim.strategy.chain;

import com.www.amaysim.entity.Cart;
import com.www.amaysim.entity.CartItem;
import com.www.amaysim.util.MathUtil;

/**
 * Created by wsl-paolo on 19/06/2017.
 */
public class CalculateRemainingItemChain extends AbstPricingChain implements PricingChain {

    public CalculateRemainingItemChain(PricingChain next) {
        super.next = next;
    }

    public void process(Cart cart) {

        Double total = cart.getTotal();

        for(CartItem i : cart.getCartItems()) {
            if(i.getUnprocessed() > 0) {
                total = total + (i.getUnprocessed() * i.getProduct().getPrice());
            }
        }

        cart.setTotal(MathUtil.round(total, 2));

        if(super.next != null) {
            super.next.process(cart);
        }

    }
}
