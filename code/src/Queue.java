public interface Queue<T> {
    void Enqueue(T data);
    T Dequeue();
}
