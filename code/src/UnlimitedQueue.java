public class UnlimitedQueue<T> implements Queue<T> {
    private Element _head = null;

    private class Element
    {
        public T Data;
        public Element NextElement = null;
        public Element(T data)
        {
            Data = data;
        }
    }

    public void Enqueue(T data)
    {
        var newElement = new Element(data);
        if (_head == null) _head = newElement;
        else
        {
            var lastElement = _head;
            while (lastElement.NextElement != null) lastElement = lastElement.NextElement;
            lastElement.NextElement = newElement;
        }
    }

    public T Dequeue()
    {
        var element = _head;
        _head = _head.NextElement;
        return element.Data;
    }
}
