public class LinkedListDeque<Astrid> {

//创建节点类
    public class IntNode{
        public Astrid item;
        public IntNode next;
        public IntNode prev;

        public IntNode(Astrid i, IntNode n, IntNode p){
            item = i;
            next = n;
            prev = p;
        }
    }
    public int size;
    public IntNode sentinel;

// 创建空链表
    public LinkedListDeque(){
        sentinel = new IntNode(null, null, null);
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
        size = 0;
    }



// 初始化一个非空的链表
    public LinkedListDeque(Astrid item){
        sentinel = new IntNode(null, null, null);
        sentinel.next = new IntNode(item, sentinel, sentinel);
        sentinel.prev = sentinel.next;
        size = 1;
    }
    public LinkedListDeque(LinkedListDeque<Astrid> other){
        sentinel = new IntNode(null, null, null);
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
        size = 0;
        for(int i=0; i<other.size();i++){
            addLast(other.get(i));
        }
    }
    public void addFirst(Astrid item){
        sentinel.next.prev = new IntNode(item, sentinel.next, sentinel);
        sentinel.next = sentinel.next.prev;
        size = size+1;
    }
    public void addLast(Astrid item){
        sentinel.prev.next = new IntNode(item, sentinel, sentinel.prev);
        sentinel.prev = sentinel.prev.next;
        size = size + 1;
    }
    public boolean isEmpty(){
        if (sentinel.next == sentinel){
            return true;
        }
        return false;
    }

    public int size(){
        return size;
    }

    //打印链表
    public void printDeque(){
        IntNode p = sentinel;
        while (p.next!=sentinel){
            System.out.print(p.next.item + " ");
            p = p.next;
        }
        System.out.println();
    }

    public void removeFirst(){
        sentinel.next.next.prev = sentinel;
        sentinel.next = sentinel.next.next;
        size = size-1;
    }

    public void removeLast(){
        sentinel.prev.prev.next = sentinel;
        sentinel.prev = sentinel.prev.prev;
        size = size-1;
    }

    public Astrid get(int index){
        if (index>(size-1)){
            return null;
        }
        IntNode p = sentinel;
        for(int i=0; i<=index; i++){
            p = p.next;
        }
        return p.item;
    }

    public Astrid getRecursiveHelp(IntNode a, int i){
        if (i == 0) {
            return a.next.item;
        }
        else{
            a = a.next;
            i = i-1;
        }
        return getRecursiveHelp(a, i);
    }

    public Astrid getRecursive(int index){
        if (index>(size-1)){
            return null  ;
        }
        IntNode p = sentinel;
        return getRecursiveHelp(p, index);

    }


    public static void main(String[]args){
        LinkedListDeque<Integer> t = new LinkedListDeque<>();
        t.addFirst(1);
        t.addFirst(2);
        t.addFirst(3);
        t.addFirst(4);
        t.addLast(100);
        System.out.println(t.isEmpty());
        t.printDeque();
        t.removeFirst();
        System.out.print(t.getRecursive(0));
    }
}
