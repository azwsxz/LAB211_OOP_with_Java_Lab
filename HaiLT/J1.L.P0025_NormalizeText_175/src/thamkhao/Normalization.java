package thamkhao;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author PHINC
 */
public class Normalization {

    public static void normalize(String inputFilePath, String outputFilePath) throws IOException {
        BufferedReader br = null;
        BufferedWriter bw = null;
        try {
            br = new BufferedReader(new FileReader(inputFilePath));
            bw = new BufferedWriter(new FileWriter(outputFilePath));
            String line;
            line = br.readLine();
            if (line != null) {
                if (!line.matches("[\\s\t]*")) {
                    line = normalize(line);
                    bw.write(line);
                }
            }
            while ((line = br.readLine()) != null) {
                if (!line.matches("[\\s\t]*")) {
                    line = normalize(line);
                    bw.newLine();
                    bw.append(line);
                }
            }
        } catch (IOException ioe) {
            throw ioe;
        } finally {
            if (br != null) {
                br.close();
            }
            if (bw != null) {
                bw.close();
            }
        }
    }

    public static String normalize(String content) {
        //no double space
        content = content.replaceAll("[\\s\t]{1,}", " ");
        //no space before punctuation
        content = content.replaceAll("[\\s]([.,!?:])", "$1");
        //One space after punctuation
        content = content.replaceAll("([.,?:!\"])([A-Za-z0-9'\"])", "$1 $2");
        //quotes
        content = content.replaceAll("([A-Za-z0-9])\"", "$1 \"");
        Matcher m = Pattern.compile("(\")([^\"]+)(\")").matcher(content);
        while (m.find()) {
            content = content.replace(m.group(), m.group(1) + m.group(2).trim() + m.group(3));
        }
        //remove first and last space
        content = content.replaceAll("^\\s", "").replaceAll("\\s$", "");
        //case
        content = content.toLowerCase();
        m = Pattern.compile("([.!?])\\s(\"?)([a-z])").matcher(content);
        while (m.find()) {
            content = content.replace(m.group(), m.group(1) + " " + m.group(2) + m.group(3).toUpperCase());
            m.reset(content);
        }
        content = content.substring(0, 1).toUpperCase() + content.substring(1);
        //last dot
        if (!".!?:".contains(content.substring(content.length()-1))) {
            content += ".";
        }
        return content;
    }

    public static void main(String[] args) {
        try {
            Normalization.normalize("src/A.txt", "src/B.txt");
            System.out.println("Normalize successfully. Open output file to see the result!");
        } catch (FileNotFoundException fnfe) {
            System.out.println("Find not found. Program has terminated!");
        } catch (IOException ioe) {
            System.out.println("Unexpected error happens. Program has terminated!");
        }
    }

}
