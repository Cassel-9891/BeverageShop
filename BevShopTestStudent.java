/*
 * Class: CMSC203 CRN: 30376
 * Instructor: Grigoriy Grinberg
 * Description: BevShopTest class
 * Due: 05/01/2023
 * Platform/compiler: Windows/ Platform: x64/ Compiler: MSVC
 * I pledge that I have completed the programming 
   assignment independently. I have not copied the code 
   from a student or any source. I have not given my code 
   to any student.
 * Caterine Gabriela Asselborn
*/

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class BevShopTestStudent {
    @Test
    public void testFindOrder() 
    {
        // Arrange
        BevShop shop = new BevShop();
        shop.startNewOrder(9, Day.MONDAY, "Caty", 33);
        shop.startNewOrder(9, Day.MONDAY, "Caty", 33);
        Order order2 = shop.getCurrentOrder();
        shop.startNewOrder(9, Day.MONDAY, "Caty", 33);
        int expectedIndex = 1;

        // Act
        int result = shop.findOrder(order2.getOrderNo());
        
        // Assert
        assertEquals(expectedIndex, result);
    }

    @Test
    public void testGetCurrentOrder() 
    {
        // Arrange        
        BevShop shop = new BevShop();
        shop.startNewOrder(9, Day.MONDAY, "Caty", 33);

        // Act
        Order result = shop.getCurrentOrder();
        
        // Assert
        assertNotNull(result);
    }

    @Test
    public void testGetNumOfAlcoholDrink() 
    {
        // Arrange
        BevShop shop = new BevShop();
        shop.startNewOrder(9, Day.MONDAY, "Caty", 33);
        shop.processAlcoholOrder("alcohol", Size.LARGE);
        shop.processAlcoholOrder("alcohol", Size.SMALL);
        int expectedAlcoholDrinks = 2;

        // Act
        int result = shop.getNumOfAlcoholDrink();
        
        // Assert
        assertEquals(expectedAlcoholDrinks, result);
    }

    @Test
    public void testGetOrderAtIndex() 
    {
        // Arrange
        BevShop shop = new BevShop();
        shop.startNewOrder(9, Day.MONDAY, "Caty", 33);
        shop.startNewOrder(9, Day.MONDAY, "Caty", 33);
        Order order2 = shop.getCurrentOrder();
        shop.startNewOrder(9, Day.MONDAY, "Caty", 33);        

        // Act
        Order result = shop.getOrderAtIndex(1);
        
        // Assert
        assertSame(order2, result);
    }

    @Test
    public void testProcessAlcoholOrder() 
    {
        // Arrange
        BevShop shop = new BevShop();
        shop.startNewOrder(9, Day.MONDAY, "Caty", 33);    
        Size size = Size.LARGE;

        // Act
        shop.processAlcoholOrder("alcohol", size);    
        
        // Assert
        Beverage beverage = shop.getCurrentOrder().getBeverage(0);
        assertTrue(beverage instanceof Alcohol);
        Alcohol createdAlcohol = (Alcohol) beverage;
        assertEquals(createdAlcohol.getSize(), size);
    }

    @Test
    public void testProcessCoffeeOrder() 
    {
        // Arrange
        BevShop shop = new BevShop();
        shop.startNewOrder(9, Day.MONDAY, "Caty", 33);    
        Size size = Size.LARGE;        

        // Act
        shop.processCoffeeOrder("coffee", size, false, true);
        
        // Assert
        Beverage beverage = shop.getCurrentOrder().getBeverage(0);
        assertTrue(beverage instanceof Coffee);
        Coffee createdCoffee = (Coffee) beverage;
        assertEquals(createdCoffee.getSize(), size);
    }

    @Test
    public void testProcessSmoothieOrder() 
    {
        // Arrange
        BevShop shop = new BevShop();
        shop.startNewOrder(9, Day.MONDAY, "Caty", 33);    
        Size size = Size.LARGE;        

        // Act
        shop.processSmoothieOrder("smoothie", size, 3, true);
        
        // Assert
        Beverage beverage = shop.getCurrentOrder().getBeverage(0);
        assertTrue(beverage instanceof Smoothie);
        Smoothie createdSmoothie = (Smoothie) beverage;
        assertEquals(createdSmoothie.getSize(), size);
    }

    @Test
    public void testStartNewOrder() 
    {
        // Arrange
        BevShop shop = new BevShop();
        shop.startNewOrder(9, Day.MONDAY, "Caty", 33);
        shop.processAlcoholOrder("alcohol", Size.LARGE);
        shop.processAlcoholOrder("alcohol", Size.SMALL);

        // Act
        shop.startNewOrder(9, Day.MONDAY, "Caty", 33);
        
        // Assert
        assertEquals(2, shop.totalNumOfMonthlyOrders());
    }

    @Test
    public void testTotalMonthlySale() 
    {
        // Arrange
        BevShop shop = new BevShop();
        shop.startNewOrder(9, Day.MONDAY, "Caty", 33);
        shop.processAlcoholOrder("alcohol", Size.LARGE);
        shop.processAlcoholOrder("alcohol", Size.SMALL);

        shop.startNewOrder(9, Day.MONDAY, "Caty", 33);
        shop.processAlcoholOrder("alcohol", Size.LARGE);
        shop.processAlcoholOrder("alcohol", Size.SMALL);

        shop.startNewOrder(9, Day.MONDAY, "Caty", 33);
        shop.processAlcoholOrder("alcohol", Size.LARGE);
        shop.processAlcoholOrder("alcohol", Size.SMALL);
        double expectedSales = 18.0;

        // Act
        double result = shop.totalMonthlySale();
        
        // Assert
        assertEquals(expectedSales, result, 0.001);
    }

    @Test
    public void testTotalNumOfMonthlyOrders() 
    {

        // Arrange
        BevShop shop = new BevShop();
        shop.startNewOrder(9, Day.MONDAY, "Caty", 33);
        shop.processAlcoholOrder("alcohol", Size.LARGE);
        shop.processAlcoholOrder("alcohol", Size.SMALL);

        // Act
        shop.startNewOrder(9, Day.MONDAY, "Caty", 33);
        
        // Assert
        assertEquals(2, shop.totalNumOfMonthlyOrders());
    }

    @Test
    public void testTotalOrderPrice() 
    {
        // Arrange
        BevShop shop = new BevShop();
        shop.startNewOrder(9, Day.MONDAY, "Caty", 33);
        shop.processAlcoholOrder("alcohol", Size.LARGE);
        shop.processAlcoholOrder("alcohol", Size.SMALL);
        shop.processCoffeeOrder("coffee", Size.LARGE, false, true);
        shop.processCoffeeOrder("coffee", Size.LARGE, false, true);
        shop.processSmoothieOrder("smoothie", Size.SMALL, 3, true);
        shop.processSmoothieOrder("smoothie", Size.SMALL, 3, true);
        double expectedOrderPrice = 25.0;        

        // Act
        double result = shop.totalOrderPrice(shop.getCurrentOrder().getOrderNo());
        
        // Assert
        assertEquals(expectedOrderPrice, result, 0.001);
    }
}
