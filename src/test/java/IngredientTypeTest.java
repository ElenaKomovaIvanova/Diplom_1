import org.junit.Assert;
import org.junit.Test;
import praktikum.IngredientType;

import java.lang.reflect.Array;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class IngredientTypeTest {
    @Test
    public void testGerIngredientType () {
        String IngredientTypeAr =  Arrays.toString(IngredientType.values());
        Assert.assertTrue(IngredientTypeAr.equals("[SAUCE, FILLING]"));

    }
}
