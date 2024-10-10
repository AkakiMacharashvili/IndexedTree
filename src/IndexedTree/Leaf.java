package IndexedTree;

public class Leaf<T> implements Node{
    private T value;

    public void setValue(T value) {
        this.value = value;
    }

    @Override
    public int size() {
        return 1;
    }

    @Override
    public Object get(int i) {
        if(i == 0){
            return value;
        }else{
            throw new IndexOutOfBoundsException("wrong index ");
        }
    }

    @Override
    public void update(int i, Object x) {
        if(i == 0){
            this.value = value;
        }else{
            throw new IndexOutOfBoundsException("wrong index ");
        }
    }

    @Override
    public Node insert(int i, Object x) {
        //implement code after implementing class Inner
        Inner<T> inner = new Inner<>();
        inner.setLsize(1);
        inner.setRsize(1);

        Leaf<T> leaf1 = new Leaf<>();
        Leaf<T> leaf2 = new Leaf<>();
        leaf1.setValue(this.value);
        leaf2.setValue((T) x);

        if(i <= 0){
            inner.setLeft(leaf2);
            inner.setRight(leaf1);
        }else{
            inner.setLeft(leaf1);
            inner.setRight(leaf2);
        }

        return inner;
    }

    @Override
    public Node remove(int i) {
        if(i == 0){
            return null;
        }else{
            throw new IndexOutOfBoundsException("wrong index ");
        }
    }
}
