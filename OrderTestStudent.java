/*
 * Class: CMSC203 CRN: 30376
 * Instructor: Grigoriy Grinberg
 * Description: Order Test class
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

import java.util.Random;

import org.junit.Test;

public class OrderTestStudent 
{
    @Test
    public void testAddNewBeverage_adds_alcohol_to_order() 
    {
        // Arrange
        Size size = Size.MEDIUM;
        Order order = new Order(9, Day.MONDAY, new Customer("Caty", 33));

        // Act
        order.addNewBeverage("Alcohol", size);

        // Assert
        Beverage addedBeverage = order.getBeverage(0);
        assertTrue(addedBeverage instanceof Alcohol);
        assertEquals(addedBeverage.getSize(), size);
    }

    @Test
    public void testAddNewBeverage2_adds_coffee_to_order() 
    {
        // Arrange
        Size size = Size.MEDIUM;        
        boolean extraShot = true;
        boolean extraSyrup = true;
        Order order = new Order(9, Day.MONDAY, new Customer("Caty", 33));

        // Act
        order.addNewBeverage("Coffee", size, extraShot, extraSyrup);

        // Assert
        Beverage addedBeverage = order.getBeverage(0);
        assertTrue(addedBeverage instanceof Coffee);
        assertEquals(addedBeverage.getSize(), size);

        Coffee coffeeResult = (Coffee) addedBeverage;
        assertEquals(coffeeResult.getExtraShot(), extraShot);
        assertEquals(coffeeResult.getExtraSyrup(), extraSyrup);
    }

    @Test
    public void testAddNewBeverage3_adds_smoothie_to_order() 
    {
        // Arrange
        Size size = Size.MEDIUM;        
        int fruit = new Random().nextInt(0, 6);
        boolean includeProtein = true;
        Order order = new Order(9, Day.MONDAY, new Customer("Caty", 33));

        // Act
        order.addNewBeverage("Smoothie", size, fruit, includeProtein);

        // Assert
        Beverage addedBeverage = order.getBeverage(0);
        assertTrue(addedBeverage instanceof Smoothie);
        assertEquals(addedBeverage.getSize(), size);

        Smoothie smoothieResult = (Smoothie) addedBeverage;
        assertEquals(smoothieResult.getNumOfFruits(), fruit);
        assertEquals(smoothieResult.getAddProtein(), includeProtein);

    }

    @Test
    public void testCalcOrderTotal() 
    {        
        // Arrange
        Size size = Size.MEDIUM;        
        int fruit = 3;
        boolean includeProtein = true;
        boolean extraShot = true;
        boolean extraSyrup = true;
        Order order = new Order(9, Day.MONDAY, new Customer("Caty", 33));
        order.addNewBeverage("Alcohol", size);
        order.addNewBeverage("Coffee", size, extraShot, extraSyrup);
        order.addNewBeverage("Smoothie", size, fruit, includeProtein);
        double expectedTotal = 13.0;

        // Act
        double result = order.calcOrderTotal();

        // Assert
        assertEquals(expectedTotal, result, 0.001);
    }

    @Test
    public void testCompareTo_equal() 
    {
        // Arrange
        Order order = new Order(9, Day.MONDAY, new Customer("Caty", 33));
        int expectedResult = 0;

        // Act
        int result = order.compareTo(order);

        // Assert
        assertEquals(expectedResult, result);
    }

    @Test
    public void testCompareTo_not_equal() 
    {
        // Arrange
        Order order1 = new Order(9, Day.MONDAY, new Customer("Caty", 33));
        Order order2 = new Order(9, Day.MONDAY, new Customer("Caty", 33));
        int expectedResult = 0;
        if(order1.getOrderNo() > order2.getOrderNo())
        {
            expectedResult = 1;
        }
        else 
        {
            expectedResult = -1;
        }

        // Act
        int result = order1.compareTo(order2);

        // Assert
        assertEquals(expectedResult, result);
    }

    @Test
    public void testFindNumOfBeveType() 
    {        
        Size size = Size.MEDIUM;    

        Random random = new Random();
        int alcoholDrinksToAdd = random.nextInt(0, 5);
        int cofffeeDrinksToAdd = random.nextInt(0, 10);
        int smoothieDrinksToAdd = random.nextInt(0, 10);

        Order order = new Order(9, Day.MONDAY, new Customer("Caty", 33));

        for (int i = 0; i < alcoholDrinksToAdd; i++) 
        {
            order.addNewBeverage("Alcohol", size);            
        }
        for (int i = 0; i < smoothieDrinksToAdd; i++) 
        {
            order.addNewBeverage("Smoothie", size, 3, true);            
        }
        for (int i = 0; i < cofffeeDrinksToAdd; i++) 
        {
            order.addNewBeverage("Coffee", size, true, true);     
        }     

        // Act
        int result = order.findNumOfBeveType(Type.COFFEE);

        // Assert
        assertEquals(cofffeeDrinksToAdd, result);
    }

    @Test
    public void testGetBeverage() 
    {
        // Arrange
        Size size = Size.MEDIUM;        
        int fruit = 3;
        boolean includeProtein = true;
        boolean extraShot = true;
        boolean extraSyrup = true;
        Order order = new Order(9, Day.MONDAY, new Customer("Caty", 33));
        order.addNewBeverage("Alcohol", size);
        order.addNewBeverage("Coffee", size, extraShot, extraSyrup);
        order.addNewBeverage("Smoothie", size, fruit, includeProtein);

        // Act
        Beverage result = order.getBeverage(1);

        // Assert
        assertTrue(result instanceof Coffee);
    }

    @Test
    public void testIsWeekend_weekday_false() 
    {
        // Arrange
        Order order = new Order(9, Day.MONDAY, new Customer("Caty", 33));

        // Act
        boolean result = order.isWeekend();

        // Assert
        assertFalse(result);
    }

    @Test
    public void testIsWeekend_weekend_true() 
    {
        // Arrange
        Order order = new Order(9, Day.SUNDAY, new Customer("Caty", 33));

        // Act
        boolean result = order.isWeekend();

        // Assert
        assertTrue(result);
    }

    @Test
    public void testToString() 
    {
        // Arrange
        Size size = Size.MEDIUM;        
        int fruit = 3;
        boolean includeProtein = true;
        boolean extraShot = true;
        boolean extraSyrup = true;
        Order order = new Order(9, Day.MONDAY, new Customer("Caty", 33));
        order.addNewBeverage("Alcohol", size);
        order.addNewBeverage("Coffee", size, extraShot, extraSyrup);
        order.addNewBeverage("Smoothie", size, fruit, includeProtein);
        String expected = "Order [orderNumber: " + order.getOrderNo() +", \n" + 
        " orderTime: 9, \n" +
        " orderDay: MONDAY, \n" +
        " customer: Customer [name: Caty, age: 33]] \n" +
        "Beverages: \n" +
        "Alcohol [isWeekend=false]\n" +
        "Beverage name: Alcohol\n" +
        "Beverage type: ALCOHOL\n" +
        "Beverage size: MEDIUM\n" +
        "Price: 3.0\n" +
        "\n" +
        "Coffee [extraShot: true, extraSyrup: true]\n" +
        "Beverage name: Coffee\n" +
        "Beverage type: COFFEE\n" +
        "Beverage size: MEDIUM\n" +
        "Price: 4.0\n" +
        "\n" +
        "Smoothie [Number of fruits: 3, Protein: true]\n" +
        "Beverage name: Smoothie\n" +
        "Beverage type: SMOOTHIE\n" +
        "Beverage size: MEDIUM\n" +
        "Price: 6.0\n\n";

        // Act
        String result = order.toString();

        // Assert
        assertEquals(expected, result);
    }
}
