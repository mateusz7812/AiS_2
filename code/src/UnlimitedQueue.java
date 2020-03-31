import java.util.ArrayList;

public class UnlimitedQueue<T> implements Queue<T> {
    ArrayList<T> list = new ArrayList<T>();

    @Override
    public void Enqueue(T data) {
        list.add(data);
    }

    @Override
    public T Dequeue() {
        return list.remove(0);
    }
}
