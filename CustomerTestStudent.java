/*
 * Class: CMSC203 CRN: 30376
 * Instructor: Grigoriy Grinberg
 * Description: Customer Test class
 * Due: 05/01/2023
 * Platform/compiler: Windows/ Platform: x64/ Compiler: MSVC
 * I pledge that I have completed the programming 
   assignment independently. I have not copied the code 
   from a student or any source. I have not given my code 
   to any student.
 * Caterine Gabriela Asselborn
*/

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;

import org.junit.Test;

public class CustomerTestStudent {
    @Test
    public void testToString() 
    {
        // Arrange
        String name = "Caty";
        int age = 33;
        Customer original = new Customer(name, age);
        String expected = "Customer [name: Caty, age: 33]";

        // Act
        String result = original.toString();

        // Assert
        assertEquals(expected, result);
    }

    @Test
    public void testCopyConstructor()
    {
        // Arrange
        String name = "Caty";
        int age = 33;
        Customer original = new Customer(name, age);

        // Act
        Customer copy = new Customer(original);

        // Assert
        assertEquals(original.getName(), copy.getName());
        assertEquals(original.getAge(), copy.getAge());

        // Check if they refer to different objects
        assertNotSame(original, copy);
    }
}
