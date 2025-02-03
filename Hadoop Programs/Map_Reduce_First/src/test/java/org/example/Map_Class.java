package org.example;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;
import java.util.StringTokenizer;

public class Map_Class extends Mapper<Object, Text, Text, IntWritable> {

    private Text word = new Text();
    private final static IntWritable one = new IntWritable(1);

    public void map(Object key, Text value, Context context) throws IOException, InterruptedException {

        // Using StringTokenizer to split the input into words
//        StringTokenizer tokenizer = new StringTokenizer(value.toString());  // Split by whitespace (space, tab, newline)
//
//        while (tokenizer.hasMoreTokens()) {
//            String wordText = tokenizer.nextToken();  // Get each word
//            word.set(wordText);  // Set the word in the Text object
//            context.write(word, one);  // Write the word and its count (1) to the context
//        }

        // Alternatively, using split() to split the string by spaces

//        String[] words = value.toChar().split("\\s+");  // Split by whitespace (spaces, tabs, etc.)
//
//        for (String wordText : words) {
//            if (!wordText.isEmpty()) {  // Check if the word is not empty
//                word.set(wordText);  // Set the word in the Text object
//                context.write(word, one);  // Write the word and its count (1) to the context
//            }
//        }


        String line = value.toString();  // Convert the input line to a string

        // Iterate through each character in the line
        for (char c : line.toCharArray()) {
            // Convert the character to a String and set it to the 'word' Text object
            word.set(String.valueOf(c));

            // Write the character and the count (1) to the context
            context.write(word, one);
        }
    }
}
