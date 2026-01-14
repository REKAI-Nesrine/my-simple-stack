package maar.nrek.mysimplestack;

import org.junit.Test;
import static org.junit.Assert.*;

public class ItemTest {

    @Test
    public void testItemCreation() {
        // Given
        String name = "TestItem";

        // When
        Item item = new Item(name);

        // Then
        assertEquals(name, item.getName());
    }

    @Test
    public void testGetName() {
        // Given
        Item item = new Item("Item1");

        // When
        String name = item.getName();

        // Then
        assertEquals("Item1", name);
    }

    @Test
    public void testSetName() {
        // Given
        Item item = new Item("OldName");

        // When
        item.setName("NewName");

        // Then
        assertEquals("NewName", item.getName());
    }

    @Test
    public void testToString() {
        // Given
        Item item = new Item("TestItem");

        // When
        String result = item.toString();

        // Then
        assertTrue(result.contains("TestItem"));
    }
}