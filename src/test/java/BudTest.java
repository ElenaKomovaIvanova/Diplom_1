import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)

public class BudTest {
    Bun bun;
    private final String name;
    private final float price;

    public BudTest(String name, float price) {
        this.name = name;
        this.price = price;
    }


    @Before
    public void newBun() {
        bun = new Bun(name, price);
    }
    @Parameterized.Parameters(name = "Наименование и цена булочки. Тестовые данные: {0} {1}")
    public static Object[][] getBud() {
        return new Object[][]{
                {"Белая", 1},
                {"Ржаная", 5},
                {"Пшеничная", 100},
                {"Зерновая", 30},
        };
    }

    @Test
    public void testGetNameBun() {
        assertEquals(bun.getName(),name);
    }

    @Test
    public void testGetPriceBun() {
        assertEquals (bun.getPrice(),price, 0.0);
    }
}
