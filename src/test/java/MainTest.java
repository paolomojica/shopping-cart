import com.www.amaysim.ShoppingCart;
import com.www.amaysim.ShoppingCartImpl;
import com.www.amaysim.entity.CartItem;
import com.www.amaysim.factory.ProductFactory;
import com.www.amaysim.strategy.DefaultPricingRulesStrategy;
import com.www.amaysim.strategy.PricingRulesStrategy;
import com.www.amaysim.util.MathUtil;

/**
 * Created by wsl-paolo on 19/06/2017.
 */
public class MainTest {

    /**
     Product Code    Product Name     Price
     ult_small       Unlimited 1GB    $24.90
     ult_medium      Unlimited 2GB    $29.90
     ult_large       Unlimited 5GB    $44.90
     1gb             1 GB Data-pack   $9.90

     Adding the promo code 'I<3AMAYSIM' will apply a 10% discount across the board.
     */
    public static void main(String... args) {
//        testCalculation();

        CartItem unli1gb = new CartItem(
                ProductFactory.getProduct("Unlimited 1GB"),
                1);

        CartItem unli2gb = new CartItem(
                ProductFactory.getProduct("Unlimited 2GB"),
                2);

        CartItem unli5gb = new CartItem(
                ProductFactory.getProduct("Unlimited 5GB"),
                4);

        PricingRulesStrategy strategy = new DefaultPricingRulesStrategy();

        ShoppingCart shoppingCart = new ShoppingCartImpl(strategy);
//        shoppingCart.add(item, "I<3AMAYSIM");
        shoppingCart.add(unli1gb);
        shoppingCart.add(unli2gb);

        System.out.println(shoppingCart.getItems());
        System.out.println(shoppingCart.getTotal());

    }

    private static void testCalculation() {

        int total = 19;
        int by3 = total / 3;
        double price =  24.90;


        System.out.println(by3);

        System.out.println("regular price: " + MathUtil.round(price * (by3 * 3), 2));
        System.out.println("promo price: " + MathUtil.round(by3 * (price * 2), 2));

    }

}
