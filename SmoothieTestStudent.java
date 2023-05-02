/*
 * Class: CMSC203 CRN: 30376
 * Instructor: Grigoriy Grinberg
 * Description: Smoothie Test class
 * Due: 05/01/2023
 * Platform/compiler: Windows/ Platform: x64/ Compiler: MSVC
 * I pledge that I have completed the programming 
   assignment independently. I have not copied the code 
   from a student or any source. I have not given my code 
   to any student.
 * Caterine Gabriela Asselborn
*/

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class SmoothieTestStudent 
{
  @Test
    public void testCalcPrice_small_no_extras() 
    {
        // Arrange
        Size size = Size.SMALL;
        int fruits = 0;
        boolean includeProtein = false;
        Smoothie drink = new Smoothie("", size, fruits, includeProtein);
        double expectedPrice = 2;

        // Act 
        double result = drink.calcPrice();

        // Assert
        assertEquals(expectedPrice, result, 0.001);
    }
    
    @Test
    public void testCalcPrice_medium_no_extras() 
    {
        // Arrange
        Size size = Size.MEDIUM;
        int fruits = 0;
        boolean includeProtein = false;
        Smoothie drink = new Smoothie("", size, fruits, includeProtein);
        double expectedPrice = 3;

        // Act 
        double result = drink.calcPrice();

        // Assert
        assertEquals(expectedPrice, result, 0.001);
    }
    
    @Test
    public void testCalcPrice_medium_1_extras() 
    {
        // Arrange
        Size size = Size.MEDIUM;
        int fruits = 3;
        boolean includeProtein = false;
        Smoothie drink = new Smoothie("", size, fruits, includeProtein);
        double expectedPrice = 4.5;

        // Act 
        double result = drink.calcPrice();

        // Assert
        assertEquals(expectedPrice, result, 0.001);
    }

    @Test
    public void testCalcPrice_medium_2_extras() 
    {
        // Arrange
        Size size = Size.MEDIUM;
        int fruits = 3;
        boolean includeProtein = true;
        Smoothie drink = new Smoothie("", size, fruits, includeProtein);
        double expectedPrice = 6;

        // Act 
        double result = drink.calcPrice();

        // Assert
        assertEquals(expectedPrice, result, 0.001);
    }

    @Test
    public void testEquals_same_drink_returns_true() 
    {
        // Arrange
        Size size = Size.MEDIUM;
        int fruits = 0;
        boolean includeProtein = false;
        Smoothie drink = new Smoothie("", size, fruits, includeProtein);

        // Act 
        boolean result = drink.equals(drink);

        // Assert
        assertTrue(result);
    }

    @Test
    public void testEquals_same_fields_returns_true() 
    {
        // Arrange
        Size size = Size.MEDIUM;
        int fruits = 0;
        boolean includeProtein = false;
        Smoothie drink1 = new Smoothie("", size, fruits, includeProtein);
        Smoothie drink2 = new Smoothie("", size, fruits, includeProtein);

        // Act 
        boolean result = drink1.equals(drink2);

        // Assert
        assertTrue(result);
    }

    @Test
    public void testEquals_null_returns_false() 
    {
        // Arrange
        Size size = Size.MEDIUM;
        int fruits = 0;
        boolean includeProtein = false;
        Smoothie drink1 = new Smoothie("", size, fruits, includeProtein);
        Smoothie drink2 = null;

        // Act 
        boolean result = drink1.equals(drink2);

        // Assert
        assertFalse(result);
    }

    @Test
    public void testEquals_different_fields_returns_false() 
    {
        // Arrange
        Smoothie drink1 = new Smoothie("", Size.MEDIUM, 0, true);
        Smoothie drink2 = new Smoothie("", Size.SMALL, 0, true);

        // Act 
        boolean result = drink1.equals(drink2);

        // Assert
        assertFalse(result);
    }

    @Test
    public void testToString() 
    {
        // Arrange
        Coffee drink = new Coffee("asdf", Size.MEDIUM, true, true);
        String expectedString = "Coffee [extraShot: true, extraSyrup: true]\n" +
        "Beverage name: asdf\n" +
        "Beverage type: COFFEE\n" +
        "Beverage size: MEDIUM\n"  +
        "Price: 4.0\n";

        // Act 
        String result = drink.toString();

        // Assert
        assertEquals(expectedString, result);
    }
}
