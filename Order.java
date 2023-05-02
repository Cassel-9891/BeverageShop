/*
 * Class: CMSC203 CRN: 30376
 * Instructor: Grigoriy Grinberg
 * Description: Order class
 * Due: 05/01/2023
 * Platform/compiler: Windows/ Platform: x64/ Compiler: MSVC
 * I pledge that I have completed the programming 
   assignment independently. I have not copied the code 
   from a student or any source. I have not given my code 
   to any student.
 * Caterine Gabriela Asselborn
*/

import java.util.ArrayList;
import java.util.Random;

public final class Order implements OrderInterface, Comparable<Order>
{
    private int orderNumber;
    private int orderTime;
    private Day orderDay;
    private Customer customer;
    private ArrayList<Beverage> beverages;

    private final int LOWER_BOUND = 10_000;
    private final int UPPER_BOUND = 90_000;

    public Order(int orderTime, Day orderDay, Customer customer)
    {
        // passed-in data
        this.orderTime = orderTime;
        this.orderDay = orderDay;
        this.customer = customer;

        // default
        orderNumber = generateOrder();
        beverages = new ArrayList<Beverage>();
    }

    public int generateOrder()
    {
        // Creates a random number object
        Random randomNumbers = new Random();

        // returns random number from a set range
        return randomNumbers.nextInt(LOWER_BOUND, UPPER_BOUND + 1);
    }

    @Override
    public int compareTo(Order otherOrder) 
    {
        // order numbers are the same, returns zero
        if(this.orderNumber == otherOrder.orderNumber)
        {
            return 0;
        }

        // if this order number is greater than other order number returns one
        if(this.orderNumber > otherOrder.orderNumber) 
        {
            return 1;
        }

        // if all else is false then this order is smaller than other order number
        return -1;
    }

    @Override
    public boolean isWeekend() 
    {
        return orderDay == Day.SATURDAY || orderDay == Day.SUNDAY;
    }

    // Add bevarge overloaded methods for coffee, alcohol, and smoothie respectively
    @Override
    public void addNewBeverage(String bevName, Size size, boolean extraShot, boolean extraSyrup) 
    {
        beverages.add(new Coffee(bevName, size, extraShot, extraSyrup));
    }

    @Override
    public void addNewBeverage(String bevName, Size size) 
    {
        beverages.add(new Alcohol(bevName, size, isWeekend()));
    }

    @Override
    public void addNewBeverage(String bevName, Size size, int numOfFruits, boolean addProtein) 
    {
        beverages.add(new Smoothie(bevName, size, numOfFruits, addProtein));
    }

    @Override
    public double calcOrderTotal() 
    {
        double orderTotal = 0;
        // for each beverage object in the beverages arraylist add price to total
        for (Beverage beverage : beverages) 
        {
            orderTotal += beverage.calcPrice();    
        }

        return orderTotal;
    }

    @Override
    public int findNumOfBeveType(Type type) 
    {
        int count = 0;
        for (Beverage beverage : beverages) 
        {
            if (beverage.getType() == type) 
            {
                count++;
            }
        }

        return count;
    }

    @Override
    public String toString() 
    {
        StringBuilder order = new StringBuilder("Order [orderNumber: " + orderNumber + 
            ", \n orderTime: " + orderTime + ", \n orderDay: " + orderDay + 
            ", \n customer: " + customer + "] \n");
         
        order.append("Beverages: \n");
        for (Beverage beverage : beverages) 
        {
            order.append(beverage).append("\n");
        }

        return order.toString();
    }

    // getters
    public Beverage getBeverage(int itemNo)
    {
        // looks into the arraylist "beverages" and finds the index
        return beverages.get(itemNo);
    }
    
    // returns deep copy of customer
    public Customer getCustomer() 
    {
        return new Customer(customer);
    }

    public Day getOrderDay() 
    {
        return orderDay;
    }

    public int getOrderNo() 
    {
        return orderNumber;
    }

    public int getOrderTime() 
    {
        return orderTime;
    }

    public int getTotalItems()
    {
        return beverages.size();
    }

    public ArrayList<Beverage> getBeverages() 
    {
        return new ArrayList<>(beverages);
    }

}
