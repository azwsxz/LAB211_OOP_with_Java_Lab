
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author datdqse05327
 */
public class HandleFile {

    public int checkIntChoice(int min, int max, String message) {
        Scanner sc = new Scanner(System.in);
        int number;
        String check;
        while (true) {
            try {
                System.out.print(message);
                check = sc.nextLine().trim();
                if (check.isEmpty()) {
                    System.out.println("You input nothing!");
                    continue;
                }
                number = Integer.parseInt(check);
                if (number < min || number > max) {
                    System.out.printf("Number must be in range [%d-%d]!\n", min, max);
                    continue;
                }
                return number;
            } catch (NumberFormatException e) {
                System.out.println("Number not contain charater!");
            }
        }
    }

    public int checkInputInt(String mess) {
        Scanner sc = new Scanner(System.in);
        int number;
        String check;
        while (true) {
            try {
                System.out.print(mess);
                check = sc.nextLine().trim();
                if (check.isEmpty()) {
                    System.out.println("You input nothing! Please enter input again!");
                    continue;
                }
                number = Integer.parseInt(check);
                return number;
            } catch (NumberFormatException e) {
                System.out.println("Number not contain charater! Enter input again!");
            }
        }
    }

    public void checkPath() {
        Scanner sc = new Scanner(System.in);
        String path = "";
        System.out.println("----- Check Path -----");
        System.out.print("Enter path: ");
        path = sc.nextLine();
        File fp = new File(path);
        if (fp.exists() && fp.isFile()) {
            System.out.println("Path to file");
        } else if (fp.exists() && fp.isDirectory()) {
            System.out.println("Path to Directory");
        } else {
            System.out.println("Path doesn't exist");
        }
    }

    public void listFileJava() {
        Scanner sc = new Scanner(System.in);
        System.out.println("----- Get file name with type java -----");
        System.out.print("Enter path: ");
        String path = sc.nextLine().trim();
        File fp = new File(path);
        ArrayList<String> listFile = new ArrayList<>();
        if (fp.exists() && fp.isDirectory()) {
            File[] files = fp.listFiles(new FileFilter() {
                @Override
                public boolean accept(File pathname) {
                    if (!pathname.isFile()) {
                        return false;
                    }
                    if (pathname.getAbsolutePath().endsWith(".java")) {
                        return true;
                    }
                    return false;
                }
            });
            for (int i = 0; i < files.length; i++) {
                listFile.add(files[i].getName());
            }
        } else {
            System.out.println("Path doesn't exist");
            return;
        }
        System.out.println("Result " + listFile.size() + " file!");
//        for (int i = 0; i < listFile.size(); i++) {
//            System.out.println(listFile.get(i));
//        }
    }

    public void fileSizeLargerInputSize() {
        Scanner sc = new Scanner(System.in);
        System.out.println("----- Get file with size greater than input -----");
        int size = checkInputInt("Enter Size (Integer): ");
        System.out.print("Enter path: ");
        String path = sc.nextLine();
        File fp = new File(path);
        if (fp.exists() && fp.isDirectory()) {
            File[] files = fp.listFiles();
            for (int i = 0; i < files.length; i++) {
                if (files[i].isFile() && files[i].length() > size) {
                    System.out.println(files[i].getName());
                }
            }
        } else {
            System.out.println("Path doesn't exist!");
            return;
        }
    }

    public void addContentFile() {
        Scanner sc = new Scanner(System.in);
        System.out.println("----- Write more content to file -----");
        System.out.print("Enter content: ");
        String content = sc.nextLine().trim();
        while (true) {
            System.out.print("Enter path: ");
            String path = sc.nextLine().trim();
            File fp = new File(path);
            if (fp.exists() && fp.isFile()) {
                try {
                    FileWriter fw = new FileWriter(fp, true);
                    BufferedWriter bw = new BufferedWriter(fw);
                    bw.append(content);
                    bw.close();
                    System.out.println("Write done");
                } catch (IOException ex) {
                    System.out.println(ex.getMessage());
                }
                break;
            } else {
            };
        }
    }

    public void countWords() throws FileNotFoundException, IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("----- Read file an count characters -----");
        System.out.print("Enter path: ");
        String path = sc.nextLine().trim();
        File fp = new File(path);
        if (fp.exists() && fp.isFile()) {
            FileReader fr = new FileReader(fp);
            BufferedReader br = new BufferedReader(fr);
            String line = br.readLine();
            int count = 0;
            while (line != null) {
                if (line.length() == 0) {
                    line = br.readLine();
                    continue;
                }
                String goodLine = line.replaceAll("[^a-zA-Z0-9\\s*]", "");
                System.out.println(goodLine);
                String[] wordsLine = goodLine.split("\\s+");
                if (wordsLine.length == 0) {
                    line = br.readLine();
                    continue;
                }
                count += wordsLine.length;
                line = br.readLine();
            }
            System.out.println("Total: " + count);
            fr.close();
            br.close();
        } else {
            System.out.println("File doesn't exist!");
        }
    }
}
