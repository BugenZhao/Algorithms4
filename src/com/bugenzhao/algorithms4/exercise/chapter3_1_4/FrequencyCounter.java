package com.bugenzhao.algorithms4.exercise.chapter3_1_4;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;

public class FrequencyCounter {
    public static void main(String[] args) {
        System.out.print("minLen: ");
        int minLen = StdIn.readInt(); // 8
        In fin = new In("data/tale.txt");
        // BST<String, Integer> st = new BST<>();
        // BinarySearchST<String, Integer> st = new BinarySearchST<>();
        SeparateChainingHashST<String, Integer> st = new SeparateChainingHashST<>();
        String word;
        while (!fin.isEmpty()) {
            word = fin.readString();
            if (word.length() < minLen) continue;
            Integer count = st.get(word);
            if (count == null)
                st.put(word, 1);
            else
                st.put(word, count + 1);
        }

        String max = " ";
        st.put(max, 0);
        for (String w :
                st.keys()) {
            if (st.get(w) > st.get(max))
                max = w;
        }
        System.out.println(max + " " + st.get(max)); // business 122

//        System.out.println(st.rank("business"));
//        System.out.println(st.select(571));
    }
}
