package simple_hash;

import tree.Tree;

public class HashTable {

    private Tree[] buckets;

    public HashTable() {
        this.buckets = new Tree[3];
        for (int i = 0; i < this.buckets.length; i++) {
            this.buckets[i] = new Tree();
        }
    }

    private int hashFunction(int key) {
        return key % this.buckets.length;
    }

    public void put(int key, String value) {
        int bucketIndex = hashFunction(key);
        this.buckets[bucketIndex].insert(key, value);
    }

    public String get(int key) {
        int bucketIndex = hashFunction(key);
        return (String) this.buckets[bucketIndex].get(key);
    }

    @Override
    public String toString() {
        StringBuilder out = new StringBuilder("{\n");
        for (Tree bucket : this.buckets) {
            out.append("\t").append(bucket.toString()).append("\n");
        }
        return out + "}";
    }

    public static void main(String[] args) {

        HashTable ht = new HashTable();
        System.out.println(ht.toString());
        ht.put(20, "a");
        System.out.println(ht.toString());
        ht.put(5, "b");
        System.out.println(ht.toString());
        ht.put(40, "c");
        System.out.println(ht.toString());
        ht.put(0, "d");
        System.out.println(ht.toString());
        ht.put(10, "e");
        System.out.println(ht.toString());
        ht.put(30, "f");
        System.out.println(ht.toString());
        ht.put(50, "g");
        System.out.println(ht.toString());


    }
}