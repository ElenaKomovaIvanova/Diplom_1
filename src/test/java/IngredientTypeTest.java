import org.junit.Assert;
import org.junit.Test;
import praktikum.IngredientType;
import java.util.Arrays;

public class IngredientTypeTest {
    @Test
    public void testGerIngredientType () {
        String IngredientTypeAr =  Arrays.toString(IngredientType.values());
        Assert.assertTrue(IngredientTypeAr.equals("[SAUCE, FILLING]"));
    }
}
