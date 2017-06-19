package com.www.amaysim.visitor.impl;

import com.www.amaysim.util.MathUtil;
import com.www.amaysim.visitor.ShoppingPromoVisitor;
import com.www.amaysim.entity.Cart;

/**
 * Adding the promo code 'I<3AMAYSIM' will apply a 10% discount across the board.
 */
public class IloveAmaysimPromoVisitor implements ShoppingPromoVisitor<Cart> {

    public void visit(Cart cart) {

        Double total = cart.getTotal();
        Double discountedPrice = total - (total * .10);
        cart.setTotal(MathUtil.round(discountedPrice, 2));

    }

}

