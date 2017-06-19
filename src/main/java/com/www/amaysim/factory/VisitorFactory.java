package com.www.amaysim.factory;

import com.www.amaysim.visitor.ShoppingPromoVisitor;
import com.www.amaysim.visitor.impl.IloveAmaysimPromoVisitor;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by wsl-paolo on 16/06/2017.
 */
public class VisitorFactory {

    private static Map<String, ShoppingPromoVisitor> visitors;

    //promo codes
    private static final String PROMOCODE_ILOVEAMAYSIM = "I<3AMAYSIM";


    public VisitorFactory() {
    }

    static {
        visitors = new HashMap<String, ShoppingPromoVisitor>();
        visitors.put(PROMOCODE_ILOVEAMAYSIM, new IloveAmaysimPromoVisitor());
    }

    public static ShoppingPromoVisitor getVisitor(String promoCode) {
        return visitors.get(promoCode);
    }

}
