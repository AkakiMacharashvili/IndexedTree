package IndexedTree;

import java.util.Iterator;

public class IndexedTree<T> implements Iterable<T>{
    private Node<T> tree;


    public int size() {
        return tree.size();
    }


    public Object get(int i) {
        return tree.get(i);
    }


    public void update(int i, Object x) {
        tree.update(i, (T) x);
    }


    public Node insert(int i, Object x) {
        if(tree == null){
            Leaf<T> leaf = new Leaf<T>();
            leaf.setValue((T) x);
            tree = leaf;
            return tree;
        }

        tree = tree.insert(i, (T) x);
        return tree;
    }


    public Node remove(int i) {
        return tree.remove(i);
    }


    @Override
    public Iterator<T> iterator() {
        return new MyIterator();
    }

    private class MyIterator implements Iterator<T> {
        private int currentIndex = 0;

        @Override
        public boolean hasNext() {
            return currentIndex < tree.size();
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new IndexOutOfBoundsException();
            }
            return tree.get(currentIndex++);
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException("remove");
        }
    }
}
