public class AList<Astrid> {
    private Astrid[] items;
    private int size;

    public AList(){
        items = (Astrid[]) new Object[100];
        size = 0;
    }

    /** Resize the underlying array */
    private void resize(int capacity){
        Astrid[] a = (Astrid[]) new Object[capacity];
        System.arraycopy(items, 0, a, 0, size);
        items = a;
    }

    public void addLast(Astrid x){

        if (size == items.length){
            resize(size*2);
        }
        items[size] = x;
        size = size+1;
    }

    public Astrid getLast(){
        return items[size-1];
    }

    public Astrid get(int i){
        return items[i];
    }

    public int size(){
        return size;
    }

    public Astrid removeLast(){
        Astrid x = getLast();
        items[size-1] = null;
        size = size-1;
        return x;
    }













}
