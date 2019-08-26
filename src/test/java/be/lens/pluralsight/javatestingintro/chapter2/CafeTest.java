package be.lens.pluralsight.javatestingintro.chapter2;

import org.junit.Assert;
import org.junit.Test;

public class CafeTest {
    @Test
    public void canBrewEspresso(){
        Cafe cafe = new Cafe();
        cafe.restockBeans(7);
        Coffee coffee = cafe.brew(CoffeeType.Espresso);

        // it is an espresso
        // it has no milk
        // enough coffee in it
        Assert.assertEquals(CoffeeType.Espresso,coffee.getType());
        Assert.assertEquals(0,coffee.getMilk());
        Assert.assertEquals(7,coffee.getBeans());
    }
}
