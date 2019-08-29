package be.lens.pluralsight.javatestingintro.chapter2;

import org.junit.Assert;
import org.junit.Test;

import static be.lens.pluralsight.javatestingintro.chapter2.CoffeeType.Espresso;
import static be.lens.pluralsight.javatestingintro.chapter2.CoffeeType.Latte;

public class CafeTest {

    public static final int ESPRESSO_BEANS = Espresso.getRequiredBeans();
    public static final int NO_MILK = 0;
    public static final int NO_BEANS = 0;

    @Test
    public void canBrewEspresso(){
        // given
        Cafe cafe = cafeWithBeans();
        // when
        Coffee coffee = cafe.brew(Espresso);
        // then
        Assert.assertEquals("Wrong coffee type", Espresso,coffee.getType());
        Assert.assertEquals("Wrong amount of milk", NO_MILK,coffee.getMilk());
        Assert.assertEquals("Wrong number of beans", ESPRESSO_BEANS,coffee.getBeans());
        //Assert.assertEquals("Wrong number of beans",7,coffee.getBeans());
    }

    @Test
    public void canBrewLate(){
        Cafe cafe = cafeWithBeans();
        cafe.restockMilk(Latte.getRequiredMilk());

        Coffee coffee = cafe.brew(Latte);

        Assert.assertEquals("Wrong coffee type",Latte,coffee.getType());
    }

    @Test(expected = IllegalArgumentException.class)
    public void mustRestockMilk(){
        Cafe cafe = new Cafe();

        cafe.restockMilk(NO_MILK);
    }

    @Test(expected = IllegalArgumentException.class)
    public void mustRestockBeans(){
        Cafe cafe = new Cafe();

        cafe.restockBeans(NO_BEANS);
    }

    @Test
    public void brewingEspressoConsumesBeans(){
        // given
        Cafe cafe = cafeWithBeans();
        // when
        Coffee coffee = cafe.brew(Espresso);
        // then
        Assert.assertEquals("# Beans not zero", NO_BEANS,cafe.getBeansInStock());
    }

    @Test(expected = IllegalStateException.class)
    public void lattesRequiresMilk(){
        // given
        Cafe cafe = cafeWithBeans();
        // when
        Coffee coffee = cafe.brew(CoffeeType.Latte);
    }

    private Cafe cafeWithBeans() {
        Cafe cafe = new Cafe();
        cafe.restockBeans(ESPRESSO_BEANS);
        return cafe;
    }
}
