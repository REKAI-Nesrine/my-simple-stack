package maar.nrek.mysimplestack;

import java.util.ArrayList;
import java.util.List;

public class SimpleStack implements ISimpleStack {
    private List<Item> items;

    public SimpleStack() {
        this.items = new ArrayList<>();
    }

    @Override
    public boolean isEmpty() {
        return items.isEmpty();
    }

    @Override
    public int getSize() {
        return items.size();
    }

    @Override
    public void push(Item item) {
        items.add(item);
    }

    @Override
    public Item peek() throws EmptyStackException {
        if (isEmpty()) {
            throw new EmptyStackException("Stack is empty");
        }
        return items.get(items.size() - 1);
    }

    @Override
    public Item pop() throws EmptyStackException {
        if (isEmpty()) {
            throw new EmptyStackException("Stack is empty");
        }
        return items.remove(items.size() - 1);
    }
}