package maar.nrek.mysimplestack;

import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;

public class SimpleStackTest {

    private SimpleStack stack;

    @Before
    public void setUp() {
        stack = new SimpleStack();
    }

    @Test
    public void testIsEmptyOnNewStack() {
        // Given - setUp()

        // When
        boolean isEmpty = stack.isEmpty();

        // Then
        assertTrue(isEmpty);
    }

    @Test
    public void testIsEmptyAfterPush() {
        // Given
        Item item = new Item("Item1");

        // When
        stack.push(item);

        // Then
        assertFalse(stack.isEmpty());
    }

    @Test
    public void testGetSizeOnEmptyStack() {
        // Given - setUp()

        // When
        int size = stack.getSize();

        // Then
        assertEquals(0, size);
    }

    @Test
    public void testGetSizeAfterPush() {
        // Given
        stack.push(new Item("Item1"));
        stack.push(new Item("Item2"));

        // When
        int size = stack.getSize();

        // Then
        assertEquals(2, size);
    }

    @Test
    public void testPushAndPeek() throws EmptyStackException {
        // Given
        Item item = new Item("TestItem");

        // When
        stack.push(item);
        Item peeked = stack.peek();

        // Then
        assertEquals(item, peeked);
        assertEquals(1, stack.getSize()); // peek ne retire pas
    }

    @Test
    public void testPushAndPop() throws EmptyStackException {
        // Given
        Item item = new Item("TestItem");
        stack.push(item);

        // When
        Item popped = stack.pop();

        // Then
        assertEquals(item, popped);
        assertEquals(0, stack.getSize()); // pop retire
        assertTrue(stack.isEmpty());
    }

    @Test(expected = EmptyStackException.class)
    public void testPeekOnEmptyStack() throws EmptyStackException {
        // Given - empty stack

        // When
        stack.peek();

        // Then - should throw EmptyStackException
    }

    @Test(expected = EmptyStackException.class)
    public void testPopOnEmptyStack() throws EmptyStackException {
        // Given - empty stack

        // When
        stack.pop();

        // Then - should throw EmptyStackException
    }

    @Test
    public void testPushNull() {
        // Given

        // When
        stack.push(null);

        // Then
        assertEquals(1, stack.getSize());
        assertFalse(stack.isEmpty());
    }

    @Test
    public void testMultiplePushAndPop() throws EmptyStackException {
        // Given
        Item item1 = new Item("Item1");
        Item item2 = new Item("Item2");
        Item item3 = new Item("Item3");

        // When
        stack.push(item1);
        stack.push(item2);
        stack.push(item3);

        // Then - LIFO order
        assertEquals(item3, stack.pop());
        assertEquals(item2, stack.pop());
        assertEquals(item1, stack.pop());
        assertTrue(stack.isEmpty());
    }
}