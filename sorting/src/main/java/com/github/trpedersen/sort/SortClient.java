package com.github.trpedersen.sort;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.github.trpedersen.util.Stopwatch;
import edu.princeton.cs.introcs.StdOut;
import org.apache.lucene.analysis.standard.StandardTokenizer;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by timpe_000 on 28/06/2015.
 */
public class SortClient {

    @Parameter(names = "-a", description = "algorithm: insertion, selection, merge, quick, shell, heap")
    private List<String> algorithms = new ArrayList<String>();

    @Parameter(names = "-p", description = "print sorted array to stdout")
    private boolean print = false;

    @Parameter(names = "-i", description = "treat input as integers")
    private boolean asInt = false;

    @Parameter(names = "-s", description = "shuffle input before sorting")
    private boolean shuffle = false;

    @Parameter(names = "-f", description = "read from inputFile")
    private String inputFile;

    @Parameter(names = "-o", description = "write to output file")
    private String outputFile;

    @Parameter(names = "--help", help = true)
    private boolean help;

    InputStream inputStream = null;


    private Comparable[] getData(int initialSize) throws IOException {
        Comparable[] a = new Comparable[0];

        if (inputFile != null) {
            inputStream = new FileInputStream(inputFile);
        } else {
            inputStream = System.in;
        }
        List<Comparable> list = new ArrayList<Comparable>();

        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        StreamTokenizer tokenizer = new StreamTokenizer(reader);
        while(tokenizer.nextToken() != StreamTokenizer.TT_EOF){
            if(asInt && tokenizer.ttype == StreamTokenizer.TT_NUMBER){
                list.add((int)tokenizer.nval);
            } else {
                list.add(tokenizer.sval);
            }
        }

        a = list.toArray(a);
        return a;
    }

    private Comparable[] getData2(int initialSize) throws IOException {

        Comparable[] a = new Comparable[0];
        String token;
        Writer fw = null;
        BufferedWriter writer = null;

        if (inputFile != null) {
            inputStream = new FileInputStream(inputFile);
        } else {
            inputStream = System.in;
        }

        if(outputFile != null){
            fw = new FileWriter(outputFile);
            writer = new BufferedWriter(fw);
        }
        List<Comparable> list = new ArrayList<Comparable>();

        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        StandardTokenizer tokenizer = new StandardTokenizer();
        tokenizer.setReader(reader);
        tokenizer.reset();

        while(tokenizer.incrementToken()){
            token = ((CharTermAttribute)tokenizer.getAttribute(CharTermAttribute.class)).toString();
            if(writer != null){
                writer.write(token);
                writer.write("\n");
            }
            list.add(token);
        }
        tokenizer.end();
        tokenizer.close();

        a = list.toArray(a);
        return a;
    }

    public void run()  {

        if(algorithms.size() == 0){
            StdOut.println("Must specify at least one algorithm");
            return;
        }

        try {


            Comparable a[] = null;
            StdOut.printf("loading data...");
            Stopwatch sw = new Stopwatch();
            a = getData(1000000);
            double elapsed = sw.elapsedTime();
            StdOut.printf("done, items: %d, time: %f\n", a.length, elapsed);


//
//        Stopwatch sw = new Stopwatch();
//        s.sort(a);
//        double elapsed = sw.elapsedTime();
//        assert s.isSorted(a);
//        if (s.print) s.dump(a, size);
//        s.showStats(a, size);
//        StdOut.printf("elapsed: %f\n", elapsed);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
        }

    }

    public SortClient() {
    }



    public static void main(String[] args) throws IOException {

        SortClient client = new SortClient();
        new JCommander(client, args);
        client.run();

    }
}