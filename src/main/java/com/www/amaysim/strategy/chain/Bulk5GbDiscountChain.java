package com.www.amaysim.strategy.chain;

import com.www.amaysim.entity.Cart;
import com.www.amaysim.entity.CartItem;
import com.www.amaysim.util.MathUtil;

/**
 * Created by wsl-paolo on 19/06/2017.
 */
public class Bulk5GbDiscountChain extends AbstPricingChain implements PricingChain {

    public Bulk5GbDiscountChain(PricingChain next) {
        super.next = next;
    }

    public void process(Cart cart) {

        CartItem item = getItem(cart, "ult_large");

        if(item != null) {

            if(item.getQuantity() > 3) {

                Double total = cart.getTotal();
                Double discountedPrice = 39.90;

                total = total + item.getQuantity() * discountedPrice;
                item.setUnprocessed(0);

                cart.setTotal(MathUtil.round(total, 2));
                }

            }

        if(super.next != null) {
            super.next.process(cart);
        }
    }

}
