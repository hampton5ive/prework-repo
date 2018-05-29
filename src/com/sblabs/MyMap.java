package com.sblabs;

public class MyMap<K,V> {

    int size;
    int capacity;

    Node[] arr;

    public static void main(String[] args) {
        MyMap<String, Integer> nameToNum = new MyMap<String, Integer>(4);
        nameToNum.put("Alex", 1);
        nameToNum.put("Alan", 2);
        nameToNum.put("Jamie", 0);
        nameToNum.put("Grayson", 3);
        nameToNum.put("Ari", 3);

        System.out.println(nameToNum);
        System.out.println("size=" + nameToNum.size());

        System.out.println("Jamie has number " + nameToNum.get("Jamie"));
        System.out.println("Ari has number " + nameToNum.get("Ari"));
        System.out.println("Grayson has number " + nameToNum.get("Grayson"));

        System.out.println("Removing Grayson");
        nameToNum.remove("Grayson");
        System.out.println("Removing Jamie");
        nameToNum.remove("Jamie");
        System.out.println("Removing Alan");
        nameToNum.remove("Alan");
        System.out.println("Removing Alex");
        nameToNum.remove("Alex");
        System.out.println("Removing Wack");
        nameToNum.remove("Wack");
        System.out.println("Adding Alan with 20");
        nameToNum.put("Alan", 20);
        System.out.println(nameToNum);
        System.out.println("Removing Ari");
        nameToNum.remove("Ari");
        System.out.println("Removing Alan");
        nameToNum.remove("Alan");
        System.out.println(nameToNum);
        System.out.println(nameToNum.isEmpty());
    }

    class Node<I> {
        Entry entry;
        Node next;

        Node(Entry entry, Node next) {
            this.entry = entry;
            this.next = next;
        }
    }

    // to access K, V this class can't be static
    class Entry {
        K key;
        V value;

        Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    MyMap(int capacity) {
        this.capacity = capacity;
        arr = new Node[capacity];

    }

    Node getList(K key) {
        int index = Math.abs(key.hashCode()) % capacity;
        Node bucket = arr[index];
        return bucket;
    }

    void put(K key, V val) {
        int index = Math.abs(key.hashCode()) % capacity;
        Node bucket = getList(key);
        // if no list exist at that bucket, start one
        if (bucket == null) {
            Entry entry = new Entry(key, val);
            arr[index] = new Node(entry, null);
            // INCREMENT SIZE HERE TOO!
            size++;
        }
        // iterate the list to find where
        else {
            Node current = bucket;
            while (current != null) {
                // same bucket and looking at same key too, just replace value
                if (current.entry.key.equals(key)) {
                    current.entry.value = val;
                } else {
                    // collision
                    // append it to list
                    if (current.next == null) {
                        Entry entry = new Entry(key, val);
                        current.next = new Node(entry, null);
                        size++;
                    }
                }
                current = current.next;
            }
        }
    }

    Object get(K key) {
        Node bucket = getList(key);
        if (bucket == null) {
            return null;
        }
        Node current = bucket;
        while(current != null) {
            if (current.entry.key.equals(key)) {
                return current.entry.value;
            }
            current = current.next;
        }
        return null;
    }

    void remove(K key) {
        Node bucket = getList(key);
        if (bucket == null) {
            return;
        }

        Node prev = null;
        Node curr = bucket;
        while(curr != null) {
            if (curr.entry.key.equals(key)) {
                size--;
                // if the entry you're removing is the HEAD
                if (curr == bucket) {
                    bucket = curr.next;
                    arr[key.hashCode() % capacity] = bucket;
                } else {
                    prev.next = curr.next;
                }
                break;
            }
            prev = curr;
            curr = curr.next;
        }
    }

    int size() {
        return size;
    }

    boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        String str = "";
        for (int i=0; i < arr.length; i++) {
            Node curr = arr[i];
            if (curr == null) {
                continue;
            }
            while(curr != null) {
                str+=curr.entry.key + ": " + curr.entry.value;
                if (curr.next != null) {
                    str+=", ";
                } else {
                    str+="\n";
                }
                curr = curr.next;
            }
        }
        return str;
    }
}