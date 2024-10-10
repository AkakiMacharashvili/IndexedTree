package IndexedTree;

public class App {
    public static void main (String[] arr) {
        IndexedTree t = new IndexedTree<String>();
        String[] array = new String[] {"abc", "bcc", "cda"};

        for (String s: array) t.insert(0,s);
        var n = t.size();

        System.out.println(n);

        for(var s: t) System.out.println(s);


        for (int i=n-1; i>=0;i--) {
            System.out.println(t.get(i));
            t.remove(i);
        }

        System.out.println(t.size());
    }
}
