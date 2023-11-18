import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    @Mock
    Ingredient ingredient;
    @Mock
    Ingredient ingredient1;
    @Mock
    Bun bun;
    @Test
    public void testAddIngredient () {
        Burger burger = new Burger();
        burger.addIngredient(ingredient);
        Assert.assertTrue(burger.ingredients.size() == 1);
    }

    @Test
    public void testRemoveIngredient () {
        Burger burger = new Burger();
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient1);
        burger.removeIngredient(1);
        Assert.assertTrue(burger.ingredients.size() == 1);
    }

    @Test
    public void testMoveIngredient () {
        Burger burger = new Burger();
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient1);
        burger.moveIngredient(0,1);
        Assert.assertTrue(burger.ingredients.get(1).equals(ingredient));

    }

    @Test
    public void testGetPrice() {
        Burger burger = new Burger();
        burger.addIngredient(ingredient);
        burger.setBuns(bun);
        Mockito.when(bun.getPrice()).thenReturn(100F);
        Mockito.when(ingredient.getPrice()).thenReturn(250F);
        Assert.assertTrue(burger.getPrice() == 450F);

    }

    @Test
    public void testGetReceipt() {
        Burger burger = new Burger();
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient1);
        burger.setBuns(bun);
        Mockito.when(bun.getName()).thenReturn("Пышная булочка");
        Mockito.when(ingredient.getName()).thenReturn("Бекон");
        Mockito.when(bun.getPrice()).thenReturn(100F);
        Mockito.when(ingredient.getPrice()).thenReturn(250F);
        Mockito.when(ingredient1.getPrice()).thenReturn(10F);
        Mockito.when(ingredient.getType()).thenReturn(FILLING);
        Mockito.when(ingredient1.getType()).thenReturn(SAUCE);
        Mockito.when(ingredient1.getName()).thenReturn("Яйцо");
        String textReceipt = burger.getReceipt();
        String expTextReceipt = "(==== Пышная булочка ====)\n" +
                "= filling Бекон =\n" +
                "= sauce Яйцо =\n" +
                "(==== Пышная булочка ====)\n" +
                "\n" +
                "Price: 460,000000";
        Assert.assertTrue(textReceipt.equals(expTextReceipt));
        //System.out.println(burger.getReceipt());
    }
}
