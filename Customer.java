/*
 * Class: CMSC203 CRN: 30376
 * Instructor: Grigoriy Grinberg
 * Description: Customer class
 * Due: 05/01/2023
 * Platform/compiler: Windows/ Platform: x64/ Compiler: MSVC
 * I pledge that I have completed the programming 
   assignment independently. I have not copied the code 
   from a student or any source. I have not given my code 
   to any student.
 * Caterine Gabriela Asselborn
*/

public final class Customer 
{
    private String name;
    private int age;

    public Customer(String name, int age) 
    {
        this.name = name;
        this.age = age;
    }

    public Customer(Customer otherCustomer) 
    {
        this.name = otherCustomer.name;
        this.age = otherCustomer.age;
    }

    // Getters and setters
    public String getName() 
    {
        return name;
    }

    public void setName(String name) 
    {
        this.name = name;
    }

    public int getAge() 
    {
        return age;
    }

    public void setAge(int age) 
    {
        this.age = age;
    }

    @Override
    public String toString() 
    {
        return "Customer [name: " + name + ", age: " + age + "]";
    }

    
}
