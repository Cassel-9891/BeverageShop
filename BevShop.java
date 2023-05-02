/*
 * Class: CMSC203 CRN: 30376
 * Instructor: Grigoriy Grinberg
 * Description: BevShop class
 * Due: 05/01/2023
 * Platform/compiler: Windows/ Platform: x64/ Compiler: MSVC
 * I pledge that I have completed the programming 
   assignment independently. I have not copied the code 
   from a student or any source. I have not given my code 
   to any student.
 * Caterine Gabriela Asselborn
*/

import java.util.ArrayList;

public class BevShop implements BevShopInterface
{
    private ArrayList<Order> orders;
    private int alcoholDrinks;

    //constructor
    public BevShop() 
    {
        orders = new ArrayList<Order>();
    }

    @Override
    public int findOrder(int orderNo) 
    {
        for(int index = 0; index < orders.size(); index++) 
        {
            if (orders.get(index).getOrderNo() == orderNo ) 
            {
                return index;
            }
        }

        // indicates order was not found
        return -1;
    }

    @Override
    public Order getCurrentOrder() 
    {
        int lastOrder =  orders.size() -1;

        return orders.get(lastOrder);
    }

    @Override
    public int getMaxNumOfFruits() 
    {
        return MAX_FRUIT;
    }

    @Override
    public int getMaxOrderForAlcohol() 
    {
        return MAX_ORDER_FOR_ALCOHOL;
    }

    @Override
    public int getMinAgeForAlcohol() 
    {
        return MIN_AGE_FOR_ALCOHOL;
    }

    @Override
    public int getNumOfAlcoholDrink() 
    {
        alcoholDrinks = getCurrentOrder().findNumOfBeveType(Type.ALCOHOL);
        return alcoholDrinks;
    }

    @Override
    public Order getOrderAtIndex(int index) 
    {
        return orders.get(index);
    }

    @Override
    public boolean isEligibleForMore() 
    {
        return getNumOfAlcoholDrink() < getMaxOrderForAlcohol();
        
    }

    @Override
    public boolean isMaxFruit(int numOfFruits) 
    {
        return numOfFruits > getMaxNumOfFruits();
    }

    @Override
    public boolean isValidAge(int age) 
    {
        return age >= getMinAgeForAlcohol();
    }

    @Override
    public boolean isValidTime(int time) 
    {
        return time >= MIN_TIME && time <= MAX_TIME;
    }
    
    @Override
    public void processAlcoholOrder(String bevName, Size size) 
    {
        getCurrentOrder().addNewBeverage(bevName, size);
        alcoholDrinks++;
    }
    
    @Override
    public void processCoffeeOrder(String bevName, Size size, boolean extraShot, boolean extraSyrup) 
    {
        getCurrentOrder().addNewBeverage(bevName, size, extraShot, extraSyrup);
    }

    @Override
    public void processSmoothieOrder(String bevName, Size size, int numOfFruits, boolean addProtein) 
    {
        getCurrentOrder().addNewBeverage(bevName, size, numOfFruits, addProtein);
    }

    @Override
    public void sortOrders() 
    {
        int length = orders.size();
 
        // One by one move boundary of unsorted subarray
        for (int index = 0; index < length - 1; index++)
        {
            // Find the minimum element in unsorted array
            int minIndex = index;
            for (int j = index + 1; j < length; j++)
            {
                if (orders.get(j).getOrderNo() < orders.get(minIndex).getOrderNo())
                {
                    minIndex = j;
                }
            }
 
            // Swap the found minimum element with the first element
            Order temp = orders.get(minIndex);
            orders.set(minIndex, orders.get(index));
            orders.set(index, temp);
        }
    }

    @Override
    public void startNewOrder(int time, Day day, String customerName, int customerAge) 
    {
        // create new order object and pass in given data, including creating a new Customer
        Order order = new Order(time, day, new Customer(customerName, customerAge));

        orders.add(order);
    }

    @Override
    public double totalMonthlySale() 
    {
        double total = 0;
        for (Order order : orders) 
        {
            total += order.calcOrderTotal();
        }

        return total;
    }

    @Override
    public int totalNumOfMonthlyOrders() 
    {
        return orders.size();
    }

    @Override
    public double totalOrderPrice(int orderNo) 
    {
        int index = findOrder(orderNo);
        return orders.get(index).calcOrderTotal();
    }

    @Override
    public String toString() 
    {
        StringBuilder orderList = new StringBuilder();
        for (Order order : orders) 
        {
            orderList.append(order).append("\n");  
        }
        
        orderList.append("Total monthly sale: $").append(totalMonthlySale());

        return orderList.toString();
    }
    
    
    
   
    
    
    
    
    
    
   
   

}
