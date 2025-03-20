package org.howard.edu.lsp.assignment5;

class Driver {
    public static void main(String[] args) {
        IntegerSet set1 = new IntegerSet();
        System.out.println("Is set1 empty? " + set1.isEmpty());

        set1.add(1);
        set1.add(2);
        set1.add(3);
        System.out.println("Value of Set1: " + set1.toString());
        System.out.println("Length of Set1: " + set1.length());
        System.out.println("Smallest in Set1: " + set1.smallest());
        System.out.println("Largest in Set1: " + set1.largest());

        IntegerSet set2 = new IntegerSet();
        set2.add(3);
        set2.add(4);
        set2.add(5);
        System.out.println("Value of Set2: " + set2.toString());

        System.out.println("Set1 contains 2? " + set1.contains(2));
        System.out.println("Set2 contains 1? " + set2.contains(1));

        System.out.println("Union of Set1 and Set2:");
        set1.union(set2);
        System.out.println("Result: " + set1.toString());

        set1.clear();
        System.out.println("After clearing, is set1 empty? " + set1.isEmpty());
    }
}