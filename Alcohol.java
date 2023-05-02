/*
 * Class: CMSC203 CRN: 30376
 * Instructor: Grigoriy Grinberg
 * Description: Alcohol class
 * Due: 05/01/2023
 * Platform/compiler: Windows/ Platform: x64/ Compiler: MSVC
 * I pledge that I have completed the programming 
   assignment independently. I have not copied the code 
   from a student or any source. I have not given my code 
   to any student.
 * Caterine Gabriela Asselborn
*/

public final class Alcohol extends Beverage
{
    private boolean isWeekend;
    private final double WEEKEND_MARKUP = 0.60;

    public Alcohol(String bevName, Size size, boolean isWeekend) 
    {
        super(bevName, Type.ALCOHOL, size);

        this.isWeekend = isWeekend;
    }

    @Override
    public String toString() 
    {
        return "Alcohol [isWeekend=" + isWeekend + "]\n" +
            super.toString();
    }

    @Override
    public double calcPrice() 
    {
        // price according to size
		double totalPrice = getSizePrice();

        //Price according to whether it is served on the weekend
        if (isWeekend) 
        {
            totalPrice += WEEKEND_MARKUP;    
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

        // typecast object to Alcohol so that we can compare data members
        Alcohol otherAlcohol = (Alcohol)object;

        return this.isWeekend == otherAlcohol.isWeekend;
    }

    // getter
    public boolean isWeekend() 
    {
        return isWeekend;
    }

}
