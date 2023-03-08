package calc;

import java.util.HashMap;
import java.util.Map;

public class Priority implements IPriority{
    private Map<Character, Integer> priority;

    public Priority() {
        priority = new HashMap<>();
        priority.put('+', 1);
        priority.put('-', 1);
        priority.put('*', 2);
        priority.put('/', 2);
        priority.put('^', 3);
        priority.put('(', 0);
    }


    @Override
    public Integer getPriority(Character key) {
        return this.priority.get(key);
    }

    @Override
    public void addPriority(Character key, Integer value) {
        this.priority.put(key, value);
    }

    @Override
    public void removePriority(Character key) {
        this.priority.remove(key);
    }

    @Override
    public boolean containsKey(Object key) {
        return this.priority.containsKey(key);
    }
}
