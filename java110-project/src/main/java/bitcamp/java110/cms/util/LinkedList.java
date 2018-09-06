package bitcamp.java110.cms.util;

public class LinkedList<T> {
    
    private Node<T> first;
    private Node<T> last;
    private int length;
    
    public LinkedList() {
        first = last = new Node<>();
    }
    
    public void add(T obj) {
        last.value = obj;
        Node<T> node = new Node<>();
        node.prev = last;
        last.next = node;
        last = node;
        length++;
        
    }
    
    
    public T get(int index) {
        if(index<0||index>=length) {
            return null;
        }
        
        Node<T> cursor = first;
        
        for(int count=0; count<index; count++) {
            cursor = cursor.next;// cursor에 cursor.next에 있는 값을 넣는다
            
        }
        return cursor.value;
    }
    
    public T remove(int index) {
        if(index<0||index>=length) {
            return null;
        }
        
        length--;
        
        Node<T> cursor = first;
        for (int count=0; count<index; count++) {
            cursor = cursor.next;
            
        }
        if(cursor == first) {
            first = first.next;
            first.prev = null;
            return cursor.value;
            // 항상 지운다음 값을 리턴
        }
        
        cursor.prev.next = cursor.next;
        cursor.next.prev = cursor.prev;
        return cursor.value;
    }
    
    public void insert(int index, T obj) {
        Node<T> node = new Node<>();
        node.value = obj;
        
        if(index<0||index>=length) {
            return;
        }
        
        length++;
        
        Node<T> cursor = first;
        for (int count=0; count<index; count++) {
            cursor = cursor.next;
            
        }
        // 이전 노드가 있어야만 이전 노드를 새 노드에 연결 할 수 있다
        if(cursor != first) {

            cursor.prev.next = node; // 이전 노드가 새 노드를 가르킨다
            node.prev = cursor.prev; // 새 노드는  이전 노드를 가르킨다
            
        }
        
        cursor.prev = node;// 현재노드는 새노드를 가르킨다
        node.next = cursor; // 새노드의 다음은 현재노드를 가르킨다
        
    }
    
    public int size() {
        return this.length;
    }
    
    class Node<T2>{
        T2 value;
        Node<T2> next;
        Node<T2> prev;
        
        public Node() {}
        
        public Node(T2 value, Node<T2> prev) {
            this.value = value;
            this.prev = prev;
        }
    }

}
