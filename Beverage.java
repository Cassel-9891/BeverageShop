/*
 * Class: CMSC203 CRN: 30376
 * Instructor: Grigoriy Grinberg
 * Description: Beverage class
 * Due: 05/01/2023
 * Platform/compiler: Windows/ Platform: x64/ Compiler: MSVC
 * I pledge that I have completed the programming 
   assignment independently. I have not copied the code 
   from a student or any source. I have not given my code 
   to any student.
 * Caterine Gabriela Asselborn
*/

public abstract class Beverage 
{
    private String bevName;
    private Type type;
    private Size size;
    
    protected static final double BASE_PRICE = 2.0;
    protected static final double SIZE_UP_PRICE = 1.0;

    // constructor
    public Beverage(String beverageName, Type beverageType, Size beverageSize)
    {
        this.bevName = beverageName;
        this.type = beverageType;
        this.size = beverageSize;
    }

    public abstract double calcPrice();

    protected double getSizePrice()
    {
        // Default price will always start at base price
        double sizePrice = BASE_PRICE;

        // Price according to size
        if(this.getSize() == Size.MEDIUM)
        {
            sizePrice += SIZE_UP_PRICE;
        }

        if(this.getSize() == Size.LARGE)
        {
            sizePrice += SIZE_UP_PRICE * 2;
        }

        return sizePrice;
    }

    @Override
    public String toString()
    {
        return "Beverage name: " + bevName + "\n" +
            "Beverage type: " + type + "\n" +
            "Beverage size: " + size + "\n" +
            "Price: " + calcPrice() + "\n";
    }

    // Overriding equals() to compare two Beverage objects
    // reference: https://www.geeksforgeeks.org/overriding-equals-method-in-java/
    @Override
    public boolean equals(Object object)
    {
        // If the object is compared with itself then return true 
        if (object == this) 
        {
            return true;
        }
 
        // checks if object is null
        if(object == null)
        {
            return false;
        }

        // Check if object is an instance of Beverage or not
        if (!(object instanceof Beverage)) 
        {
            return false;
        }
         
        // typecast object to Beverage so that we can compare data members
        Beverage otherBeverage = (Beverage) object;
         
        return this.bevName.equals(otherBeverage.bevName) 
            && this.type == otherBeverage.type && this.size == otherBeverage.size;
    }

    // Getter and setters
    public String getBevName() 
    {
        return bevName;
    }

    public void setBevName(String beverageName) 
    {
        this.bevName = beverageName;
    }

    public Type getType() 
    {
        return type;
    }

    public void setType(Type beverageType) 
    {
        this.type = beverageType;
    }

    public Size getSize() 
    {
        return size;
    }

    public void setSize(Size beverageSize) 
    {
        this.size = beverageSize;
    }

}
