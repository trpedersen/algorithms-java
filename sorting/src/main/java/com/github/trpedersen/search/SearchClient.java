package com.github.trpedersen.search;

import edu.princeton.cs.introcs.StdOut;
import edu.princeton.cs.introcs.StdRandom;

/**
 * Created by timpe_000 on 7/07/2015.
 */
public class SearchClient {

    public static void main(String[] args) {
//        OrderedST<String, Integer> search = new BinarySearchTree<String, Integer>();
//
//        search.put("f", 1);
//        search.put("d", 2);
//        // search.put("c", 3);
//        search.put("g", 3);
//        search.put("a", 4);
//        search.put("b", 5);
//
////        search.deleteMin();
////        assert (search.get("a") == null);
////        assert (search.get("b").equals(2));
////        assert (search.get("c").equals(3));
////        search.deleteMax();
////        assert (search.get("d") == null);
//
//        assert (search.ceiling("c").equals("d"));
//        assert (search.floor("c").equals("b"));

        // assert(search.select(0).equals("a"));
        // assert(search.select(1).equals("b"));
        // assert(search.select(3).equals("f"));

//        String key = search.select(0);
//        key = search.select(1);
//        key = search.select(2);
//        key = search.select(3);
//        key = search.select(4);

//        int rank = search.rank("a");
//        rank = search.rank("b");
//        rank = search.rank("c");
//        rank = search.rank("d");
//        rank = search.rank("e");
//        rank = search.rank("z");

//        key = search.select(search.rank("z"));
//
//        search.keys().forEach(k ->
//                        StdOut.printf("%s: %d, ", k, search.get(k))
//        );

//        search.delete("c");
//        assert(search.ceiling("c")== null);
//        assert(search.floor("c").equals("b"));

//        assert(search.ceiling("b").equals("b"));
//        assert(search.floor("b").equals("b"));
//        search.delete("a");
//        search.delete("b");
//        assert(search.ceiling("b") == null);
//        assert(search.floor("b") == null);

//
//        search.keys().forEach(key ->
////                        StdOut.printf("%s: %d, ", key, search.get(key))
////        );
//        search.delete("b");
//        assert (search.get("b") == null);

//        search.keys().forEach(key ->
//                        StdOut.printf("%s: %d, ", key, search.get(key))
//        );

        OrderedST<Integer, Integer> searchInt; // = new SequentialST<Integer, Integer>();
////        //searchInt = new SequentialST<Integer, Integer>(); //
        searchInt = new BinarySearchTree<Integer, Integer>();
//        // VisualAccumulator accum = new VisualAccumulator(11000, 200);
        for (int i = 0; i < 1000000; i++) {
            //searchInt = new SequentialST<Integer, Integer>();
            // for( int j = 0; j < i; j++) {
            searchInt.put(StdRandom.uniform(1000000), i);
            //  accum.addDataValue(searchInt.compares());
            if (i % 10000 == 0) {
                // StdOut.printf("i: %d, i^2/2: %d, compares: %d\n", i, (i * i) / 2, searchInt.compares());
                StdOut.printf("i: %d, compares: %d\n", i, searchInt.compares());
            }
            searchInt.reset();

            //  }
        }
//
        int count = 0;
        for (int key : searchInt.keys()) {
            if (count % 1000 == 0) {
                StdOut.printf("%d: %d, ", key, searchInt.get(key));
            }
            count++;
        }
//
//        StdOut.println();
//
//        searchInt.keys(560, 602).forEach(key ->
//                        StdOut.printf("%d: %d, ", key, searchInt.get(key))
//        );
//
//        StdOut.println();

//        for(int i = 0; i < 1000; i++){
//            searchInt.delete(i);
//        }

//        while (!searchInt.isEmpty()) {
//            int i = StdRandom.uniform(1000);
//            searchInt.delete(i);
//            StdOut.printf("i: %d, size: %d\n", i, searchInt.size());
////            searchInt.keys().forEach( key ->
////                            StdOut.printf("%d ", key)
////            );
//            // StdOut.println();
//        }
//        StdOut.println();
//        searchInt.keys().forEach(key ->
//                        StdOut.printf("%d ", key)
//        );

    }
}
