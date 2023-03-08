package calc;

public interface IPriority {

    Integer getPriority(Character key);

    void addPriority(Character key, Integer value);

    void removePriority(Character key);

    boolean containsKey(Object key);
}
