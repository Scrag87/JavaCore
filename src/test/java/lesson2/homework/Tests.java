package lesson2.homework;

import java.util.ArrayList;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class Tests {

    public ArrayUtils utils;

    @Before
    public void init() {
        utils = new ArrayUtils();
    }

    @Test(expected = ArraySizeException.class)
    public void testSize() throws ArraySizeException, ArrayDataException {
        Object[][] objects = new Object[3][50];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 50; j++) {
                objects[i][j] = 10;
            }
        }
        utils.arraySum(objects);
    }

    @Test(expected = ArrayDataException.class)
    public void testData() throws ArraySizeException, ArrayDataException {
        Object[][] objects = new Object[4][4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                objects[i][j] = 10;
            }
        }
        objects[3][3] = "String";
        objects[1][2] = new ArrayList<Integer>();
        utils.arraySum(objects);
    }

    @Test
    public void testSum() throws ArraySizeException, ArrayDataException {
        Object[][] objects = new Object[4][4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                objects[i][j] = 10;
            }
        }
        long result = utils.arraySum(objects);
        Assert.assertEquals(160, result);
    }

}
