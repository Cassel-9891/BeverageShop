/*
 * Class: CMSC203 CRN: 30376
 * Instructor: Grigoriy Grinberg
 * Description: Coffee class
 * Due: 05/01/2023
 * Platform/compiler: Windows/ Platform: x64/ Compiler: MSVC
 * I pledge that I have completed the programming 
   assignment independently. I have not copied the code 
   from a student or any source. I have not given my code 
   to any student.
 * Caterine Gabriela Asselborn
*/

public final class Coffee extends Beverage
{
    private boolean extraShot;
    private boolean extraSyrup;
    
    public static final double EXTRA_SHOT_PRICE = 0.50;
    public static final double EXTRA_SYRUP_PRICE = 0.50;

    //contructor
    public Coffee(String bevName, Size size, boolean extraShot, boolean extraSyrup)
    {
        super(bevName, Type.COFFEE, size);

        this.extraShot = extraShot;
        this.extraSyrup = extraSyrup;
    }

    @Override
    public String toString() 
    {
        // name, size, extrashot, extra syrup, price
        return "Coffee [extraShot: " + extraShot + ", extraSyrup: " + extraSyrup + "]\n" +
            super.toString();
    }

    @Override
    public double calcPrice()
    {
        // price according to size
        double totalPrice = getSizePrice();

        // Price according to extras
        if(extraShot)
        {
            totalPrice += EXTRA_SHOT_PRICE;
        }

        if(extraSyrup)
        {
            totalPrice += EXTRA_SYRUP_PRICE;
        }

        return totalPrice;
    }

    @Override
    public boolean equals(Object object)
    {
        if(!super.equals(object))
        {
            return false;
        }

        // typecast object to Coffee so that we can compare data members
        Coffee otherCoffee = (Coffee)object;

        return this.extraShot == otherCoffee.extraShot 
            && this.extraSyrup == otherCoffee.extraSyrup;

    }

    // getters
    public boolean getExtraShot() 
    {
        return extraShot;
    }

    public boolean getExtraSyrup() 
    {
        return extraSyrup;
    }

}
