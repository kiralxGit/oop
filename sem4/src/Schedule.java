import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Schedule<T extends Tasks> implements Iterator<Task> {
    private List<T> tasksList;

    public Schedule(){
        tasksList = new ArrayList<>();
    }
    public boolean addNewTask(T task){
        return this.tasksList.add(task);
    }
    public boolean removeTask(T task){
        return this.tasksList.remove(task);
    }
    public T getTask(int i){
        return this.tasksList.get(i);
    }
    public List<T> getTasksList() {
        return this.tasksList;
    }
    public int getSize(){
        return this.tasksList.size();
    }

    @Override
    public String toString() {
        if (this.getSize() == 0){
            return "Нет дел!";
        }
        return "" + tasksList;
    }

    private int index;
    @Override
    public boolean hasNext() {
        return index < this.getSize();
    }

    @Override
    public Task next() {
        return (Task) this.tasksList.get(index++);
    }

}
