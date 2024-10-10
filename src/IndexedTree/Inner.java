package IndexedTree;

public class Inner<T> implements Node{
    public void setLeft(Node<T> left) {
        this.left = left;
    }

    public void setRight(Node<T> right) {
        this.right = right;
    }

    public void setLsize(int lsize) {
        this.lsize = lsize;
    }

    public void setRsize(int rsize) {
        this.rsize = rsize;
    }

    private Node<T> left;
    private Node<T> right;
    private int lsize;
    private int rsize;

    @Override
    public int size() {
        return lsize + rsize;
    }

    @Override
    public Object get(int i) {
        if(i < lsize) return left.get(i);
        else return right.get(i - lsize);
    }

    @Override
    public void update(int i, Object x) {
        if(i < lsize){
            left.update(i, (T) x);
        }else{
            right.update(i - lsize, (T) x);
        }
    }

    @Override
    public Node insert(int i, Object x) {
        if(i < 0) i = 0;
        if(i > lsize + rsize) i = lsize + rsize;

        if(i < lsize){
            left = left.insert(i,(T) x);
            lsize++;
        }else{
            right = right.insert(i - lsize, (T) x);
            rsize++;
        }
        return this;
    }

    @Override
    public Node remove(int i) {
        if(i < 0 || i > lsize + rsize) throw new IndexOutOfBoundsException("wrong...");
        else{
            if(i < lsize){
                left = left.remove(i);
                lsize--;
            }else{
                right = right.remove(i - lsize);
                rsize--;
            }
            return this;
        }
    }
}
