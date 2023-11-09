import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static java.lang.String.valueOf;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static praktikum.IngredientType.*;
@RunWith(Parameterized.class)
public class InsredientTest {
    private IngredientType type;
    private String name;
    private float price;
    Ingredient ingredient;

    public InsredientTest(IngredientType type, String name, float price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }

    @Before
    public void newIngredient() {
        ingredient = new Ingredient(type,name, price);
    }

    @Parameterized.Parameters(name = "Модель ингридиента: Тип, Наименование, Цена: {0} {1} {3}")
    public static Object[][] getIngredient() {
        return new Object[][]{
                {SAUCE, "Белая", 1},
                {FILLING, "Ржаная", 5},
                {SAUCE, "Пшеничная", 100},
                {FILLING, "Зерновая", 30},
        };
    }

    @Test
    public void testGetTypeIngredient() {
        assertTrue (ingredient.getType() == type);
    }

    @Test
    public void testGetNameIngredient() {
        assertEquals(ingredient.getName(),name);
    }

    @Test
    public void testGetPriceIngredient() {
        assertEquals (ingredient.getPrice(),price, 0.0);
    }
}
