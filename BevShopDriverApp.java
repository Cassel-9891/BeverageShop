/*
 * Class: CMSC203 CRN: 30376
 * Instructor: Grigoriy Grinberg
 * Description: Driver app
 * Due: 05/01/2023
 * Platform/compiler: Windows/ Platform: x64/ Compiler: MSVC
 * I pledge that I have completed the programming 
   assignment independently. I have not copied the code 
   from a student or any source. I have not given my code 
   to any student.
 * Caterine Gabriela Asselborn
*/

import java.util.Scanner;

public class BevShopDriverApp 
{
    public static void main(String[] args) throws Exception 
    {
        // Set instance of BevShop
        BevShop shop = new BevShop();

        // Program introduction
        System.out.println("The current order in process can have at most 3 alcoholic beverages.");
        System.out.println("The minimum age to order alcohol drink is 21");
        System.out.println("Start please a new order: ");
        System.out.println("Your Total Order for nows 0.0");

        // Request of Data from Customer
        try (Scanner read = new Scanner(System.in)) 
        {
            boolean endProgram = false;

            startNewOrder(shop, read);

            do {
                int command = getNextCommand(read);

                switch (command)
                {
                    case 1: //  Order alcoholic beverage
                    {
                        processAlcohol(shop, read);
                        break;
                    }
                    case 2: //  Order smoothie
                    {
                        processSmoothie(shop, read);
                        break;
                    }
                    case 3: //  Order coffee
                    {
                        processCoffee(shop, read);
                        break;
                    }
                    case 4: //  End order
                    {
                        Order currentOrder = shop.getCurrentOrder();
                        System.out.println("Total drinks ordered: " + currentOrder.getTotalItems());
                        System.out.println("Total price: " + currentOrder.calcOrderTotal());                        
                        System.out.println("#------------------------------------#");

                        startNewOrder(shop, read);
                        break;
                    }
                    case 5: //  End day
                    {
                        System.out.println();
                        System.out.println("#------------Sales report----------------#");
                        System.out.println("Total orders sold: " + shop.totalNumOfMonthlyOrders());
                        System.out.println("Total sales: $" + shop.totalMonthlySale());                                             
                        System.out.println("#------------------------------------#");

                        endProgram = true;
                        break;
                    }

                }
            } while (!endProgram);
        }
    }

    private static void processCoffee(BevShop shop, Scanner read) {
        Size size = getSize(read);
        
        // Include extra shot                        
        boolean includeExtraShot = false;
        System.out.print("Would you like to add an extra shot for $" + Coffee.EXTRA_SHOT_PRICE + " more? (y/n): ");
        
        String extraShotResponse = read.nextLine();
        includeExtraShot = extraShotResponse.equalsIgnoreCase("y");
        
        // Include extra shot                        
        boolean includeSyrup = false;
        System.out.print("Would you like to add syrup for $" + Coffee.EXTRA_SYRUP_PRICE + " more? (y/n): ");
        
        String syrupResponse = read.nextLine();
        includeSyrup = syrupResponse.equalsIgnoreCase("y");

        shop.processCoffeeOrder("Coffee", size, includeExtraShot, includeSyrup);
    }

    private static void processAlcohol(BevShop shop, Scanner read) 
    {
        Customer currentCustomer = shop.getCurrentOrder().getCustomer();

        // Customer is too young to order alcohol
        if(!shop.isValidAge(currentCustomer.getAge()))
        {
            System.out.println("Your age is not appropriate for an alcoholic drink.");
            return;
        } 

        // Maximum number of alcoholic drinks reached
        if (!shop.isEligibleForMore()) 
        {
            System.out.println("You have reached the maximum number of alcohol drinks for this order.");
            return;                            
        }

        Size size = getSize(read);
        shop.processAlcoholOrder("Alcohol", size);
    }

    private static void processSmoothie(BevShop shop, Scanner read) {
        Size size = getSize(read);

        // Number of fruit
        System.out.print("How many fruits would you like to add (maximum of " +
            BevShopInterface.MAX_FRUIT + " fruits). Each fruit added costs an additional $" + Smoothie.PER_FRUIT_PRICE + ": ");
        
        int fruitCount = read.nextInt();
        read.nextLine();
        if(fruitCount < 0)
        {
            fruitCount = 0;
        }

        if(shop.isMaxFruit(fruitCount))
        {
            System.out.println("Number of fruits entered exceeds maximum. Defaulting to maximum fruits allowed.");
            fruitCount = BevShopInterface.MAX_FRUIT;
        }

        // Include protein                        
        boolean includeProtein = false;
        System.out.print("Would you like to add a scoop of protein for $" + Smoothie.PROTEIN_PRICE + " more? (y/n): ");
        
        String proteinResponse = read.nextLine();
        includeProtein = proteinResponse.equalsIgnoreCase("y");

        shop.processSmoothieOrder("Smoothie", size, fruitCount, includeProtein);
    }

    private static int getNextCommand(Scanner read)
    {
        System.out.println("What would you like to do next?");
        System.out.println("1. Order alcoholic beverage");
        System.out.println("2. Order smoothie");
        System.out.println("3. Order coffee");
        System.out.println("4. End order");
        System.out.println("5. End day");

        int response = read.nextInt();
        read.nextLine();

        return response;
    }

    private static void startNewOrder(BevShop shop, Scanner read) {
        System.out.print("Would you please enter your name: ");
        String customerName = read.nextLine();
   
        System.out.print("Would you please enter your age: ");
        int customerAge = read.nextInt();
        read.nextLine();
   
        // Check if customer is allowed to order alcohol drink
        if (shop.isValidAge(customerAge)) 
        {
            System.out.println("Your age is above 20 and you are eligible to order alcohol");
        }
   
        // Set order instance
        shop.startNewOrder(10, Day.WEDNESDAY, customerName, customerAge);
    }

    private static Size getSize(Scanner read)
    {
        System.out.println("What size would you like: ");
        System.out.println("1. Small");
        System.out.println("2. Medium");
        System.out.println("3. Large");

        int response = read.nextInt();
        read.nextLine();

        switch (response) 
        {
            case 2: // MEDIUM
            {
                return Size.MEDIUM;
            }
            case 3: // LARGE
            {
                return Size.LARGE;
            }        
            default: // Default to SMALL
            {
                return Size.SMALL;
            }
        }
    }
}
