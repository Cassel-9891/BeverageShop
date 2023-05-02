/*
 * Class: CMSC203 CRN: 30376
 * Instructor: Grigoriy Grinberg
 * Description: Smoothie class
 * Due: 05/01/2023
 * Platform/compiler: Windows/ Platform: x64/ Compiler: MSVC
 * I pledge that I have completed the programming 
   assignment independently. I have not copied the code 
   from a student or any source. I have not given my code 
   to any student.
 * Caterine Gabriela Asselborn
*/

public final class Smoothie extends Beverage
{
    private int numOfFruits;
    private boolean addProtein;

    public static final double PER_FRUIT_PRICE = 0.50;
    public static final double PROTEIN_PRICE = 1.50;


    // constructor
    public Smoothie(String bevName, Size size, int numOfFruits, boolean addProtein)
    {
        super(bevName, Type.SMOOTHIE, size);

        this.numOfFruits = numOfFruits;
        this.addProtein = addProtein;
    }

	@Override
    public String toString() 
    {
        return "Smoothie [Number of fruits: " + numOfFruits + ", Protein: " + addProtein + "]\n" +
            super.toString();
    }

    @Override
    public boolean equals(Object object)
    {
        if(!super.equals(object))
        {
            return false;
        }

        // typecast object to Smoothie so that we can compare data members
        Smoothie otherSmoothie = (Smoothie)object;

        return this.numOfFruits == otherSmoothie.numOfFruits 
            && this.addProtein == otherSmoothie.addProtein;
    }

    @Override
	public double calcPrice() 
    {
        // price according to size
		double totalPrice = getSizePrice();

        //Price according to extras
        totalPrice += numOfFruits * PER_FRUIT_PRICE;

        if (addProtein) 
        {
            totalPrice += PROTEIN_PRICE;
        }

        return totalPrice;
	}
    
    // Getters
    public int getNumOfFruits() 
    {
        return numOfFruits;
    }

    public boolean getAddProtein() 
    {
        return addProtein;
    }
}
