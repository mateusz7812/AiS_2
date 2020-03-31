public class UnlimitedStack<T> implements Stack<T> {
    private Element Head = null;

    private class Element
    {
        public T Data;
        public Element NextElement = null;
        public Element(T data)
        {
            Data = data;
        }
    }

    public void Push(T data)
    {
        if (Head == null)
        {
            Head = new Element(data);
        }
        else
        {
            var newElement = new Element(data);
            newElement.NextElement = Head;
            Head = newElement;
        }
    }

    public T Pop()
    {
        if (Head == null) return null;
        var saved = Head;
        Head = Head.NextElement;
        return saved.Data;
    }
}
