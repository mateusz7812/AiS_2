import java.util.ArrayList;

public class UnlimitedStack<T> implements Stack<T> {
    ArrayList<T> list = new ArrayList<T>();

    @Override
    public void Push(T data) {
        list.add(0, data);
    }

    @Override
    public T Pop() {
        return list.remove(0);
    }
}
