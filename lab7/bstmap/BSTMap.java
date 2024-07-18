package bstmap;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class BSTMap<K extends Comparable<K>,V> implements Map61B<K,V>{

    private class BSTNode{
        private K key;
        private V value;
        private BSTNode left;
        private BSTNode right;
        BSTNode(K key, V value){
            this.key = key;
            this.value = value;
        }
    }

    private BSTNode root;
    private int size;

    public BSTMap(){
        root = null;
        size = 0;
    }
    @Override
    public void clear() {
        root = null;
        size = 0;
    }

    @Override
    public boolean containsKey(K key) {
        return containsKey(root, key);
    }

    private boolean containsKey(BSTNode node, K key){
        if(node == null){
            return false;
        }
        if(node.key.equals(key)){
            return true;
        }
        int cmp = key.compareTo(node.key);
        if(cmp < 0){
            return containsKey(node.left, key);
        }else if (cmp > 0){
            return containsKey(node.right, key);
        }else {
            return true;
        }
    }

    @Override
    public V get(K key) {
        return get(root, key);
    }

    private V get(BSTNode node, K key){
        if(node == null){
            return null;
        }
        if(node.key.equals(key)){
            return node.value;
        }
        int cmp = key.compareTo(node.key);
        if(cmp < 0){
            return get(node.left, key);
        }else if (cmp > 0){
            return get(node.right, key);
        }else {
            return node.value;
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void put(K key, V value) {
        root = put(root, key, value);
    }

    private BSTNode put(BSTNode node, K key, V value){
        if(node == null){
            size++;
            return new BSTNode(key, value);
        }
        int cmp = key.compareTo(node.key);
        if(cmp < 0){
            node.left = put(node.left, key, value);
        }else if(cmp > 0){
            node.right = put(node.right, key, value);
        }else {
            node.value = value;
        }
        return node;
    }

    @Override
    public Set<K> keySet() {
        Set<K> keys = new TreeSet<>();
        addKeys(root, keys);
        return keys;
    }

    private void addKeys(BSTNode node, Set<K> keySet){
        if(node == null){
            return;
        }
        addKeys(node.left, keySet);
        keySet.add(node.key);
        addKeys(node.right, keySet);
    }

    @Override
    public V remove(K key) {
        V value = get(key);
        if(value != null){
            root = remove(root, key);
            size--;
        }
        return value;
    }
    private BSTNode remove(BSTNode node, K key){
        if(node == null){
            return null;
        }
        int cmp = key.compareTo(node.key);
        if(cmp < 0){
            node.left = remove(node.left, key);
        }else if(cmp > 0){
            node.right = remove(node.right, key);
        }else {
            if(node.left == null){
                return node.right;
            }
            if(node.right == null){
                return node.left;
            }
            BSTNode temp = node;
            node = min(temp.right);
            node.right = removeMin(temp.right);
            node.left = temp.left;
        }
        return node;
    }

    private BSTNode min(BSTNode node){
        if(node.left == null){
            return node;
        }
        return min(node.left);
    }

    private BSTNode removeMin(BSTNode node){
        if(node.left == null){
            return node.right;
        }
        node.left = removeMin(node.left);
        return node;
    }

    @Override
    public V remove(K key, V value) {
        V val = get(key);
        if(val != null && val.equals(value)){
            root = remove(root, key);
            size--;
        }
        return val;
    }

    @Override
    public Iterator<K> iterator() {
        return new BSTMapIterator();
    }

    private class BSTMapIterator implements Iterator<K>{
        private Set<K> keys;
        private Iterator<K> iterator;
        BSTMapIterator(){
            keys = keySet();
            iterator = keys.iterator();
        }
        @Override
        public boolean hasNext() {
            return iterator.hasNext();
        }

        @Override
        public K next() {
            return iterator.next();
        }
    }

    public void printInOrder(){
        printInOrder(root);
    }

    private void printInOrder(BSTNode node){
        if(node == null){
            return;
        }
        printInOrder(node.left);
        System.out.println(node.key + " " + node.value);
        printInOrder(node.right);
    }
}
