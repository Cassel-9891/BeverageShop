/*
 * Class: CMSC203 CRN: 30376
 * Instructor: Grigoriy Grinberg
 * Description: Alcohol Test class
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

public class AlcoholTestStudent 
{
    @Test
    public void testCalcPrice_weekday_small() 
    {
        // Arrange
        Size size = Size.SMALL;
        boolean isWeekend = false;
        Alcohol drink = new Alcohol("", size, isWeekend);
        double expectedPrice = 2;

        // Act 
        double result = drink.calcPrice();

        // Assert
        assertEquals(expectedPrice, result, 0.001);
    }
    
    @Test
    public void testCalcPrice_weekday_medium() 
    {
        // Arrange
        Size size = Size.MEDIUM;
        boolean isWeekend = false;
        Alcohol drink = new Alcohol("", size, isWeekend);
        double expectedPrice = 3;

        // Act 
        double result = drink.calcPrice();

        // Assert
        assertEquals(expectedPrice, result, 0.001);
    }

    @Test
    public void testCalcPrice_weekend_small() 
    {
        // Arrange
        Size size = Size.SMALL;
        boolean isWeekend = true;
        Alcohol drink = new Alcohol("", size, isWeekend);
        double expectedPrice = 2.6;

        // Act 
        double result = drink.calcPrice();

        // Assert
        assertEquals(expectedPrice, result, 0.001);
    }

    @Test
    public void testCalcPrice_weekend_medium() 
    {
        // Arrange
        Size size = Size.MEDIUM;
        boolean isWeekend = true;
        Alcohol drink = new Alcohol("", size, isWeekend);
        double expectedPrice = 3.6;

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
        boolean isWeekend = true;
        Alcohol drink = new Alcohol("", size, isWeekend);

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
        boolean isWeekend = true;
        Alcohol drink1 = new Alcohol("", size, isWeekend);
        Alcohol drink2 = new Alcohol("", size, isWeekend);

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
        boolean isWeekend = true;
        Alcohol drink1 = new Alcohol("", size, isWeekend);
        Alcohol drink2 = null;

        // Act 
        boolean result = drink1.equals(drink2);

        // Assert
        assertFalse(result);
    }

    @Test
    public void testEquals_different_fields_returns_false() 
    {
        // Arrange
        Alcohol drink1 = new Alcohol("", Size.MEDIUM, true);
        Alcohol drink2 = new Alcohol("", Size.SMALL, true);

        // Act 
        boolean result = drink1.equals(drink2);

        // Assert
        assertFalse(result);
    }

    @Test
    public void testToString() 
    {
        // Arrange
        Alcohol drink = new Alcohol("asdf", Size.MEDIUM, true);
        String expectedString = "Alcohol [isWeekend=true]\n" +
        "Beverage name: asdf\n" +
        "Beverage type: ALCOHOL\n" +
        "Beverage size: MEDIUM\n"  +
        "Price: 3.6\n";

        // Act 
        String result = drink.toString();

        // Assert
        assertEquals(expectedString, result);
    }
}
