public interface Buffer {
    //producers call this method
    public abstract void insert(Object item);

    //consumers call this method
    public abstract Object remove();
}
