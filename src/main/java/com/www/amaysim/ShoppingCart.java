package com.www.amaysim;

import com.www.amaysim.entity.Cart;
import com.www.amaysim.entity.CartItem;
import com.www.amaysim.visitor.ShoppingPromoVisitor;

import java.util.List;

/**
 * Created by wsl-paolo on 16/06/2017.
 */
public interface ShoppingCart {

    void add(CartItem item);
    void add(CartItem item, String promoCode);
    Double getTotal();
    List<CartItem> getItems();

}
