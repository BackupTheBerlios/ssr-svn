package de.berlios.ssr.old;

import java.io.*;
import java.util.*;

public class Shuffler {
    static BufferedReader stdIn;

    static ArrayList allFiles = new ArrayList();

    static ArrayList toMp3 = new ArrayList();

    static ArrayList authMp3;

    static Author autore;

    static int tot = 0;

    static int tr_tot = 0;

    final static int MB = 1048576;

    static long maxSize = 254;

    static long maxByteSize;

    static long totSize = 0;

    static FileOutputStream fos = null;

    static FileInputStream fin = null;

    static boolean auth = false;

    public static void findAuth() throws Exception {
        if (!auth) {
            System.out.println("Quale filtro?");
            String filtro = stdIn.readLine();
            autore = new Author(filtro);
            authMp3 = autore.search(allFiles);
            for (int i = 0; i < authMp3.size(); i++) {
                File _file = (File) authMp3.get(i);
                System.out.println("\t"
                        + _file.getName().substring(0,
                                (_file.getName().length() - 4)));
            }
        }
    }

    public static void readInside(File file) {
        Filter mp3 = new Filter(".mp3", ".wma");
        File[] lista = file.listFiles();
        for (int i = 0; i < lista.length; i++) {
            File _temp = lista[i];
            if (_temp.isDirectory())
                readInside(_temp);
            else {
                if (mp3.accept(_temp)) {
                    allFiles.add(_temp);
                }
            }
        }
    }

    public static void makeList(ArrayList files) {
        toMp3.clear();
        tot = files.size();
        totSize = 0;
        tr_tot = 0;
        Random r = new Random();
        while (files.size() > 0 && totSize < maxByteSize) {
            int j = r.nextInt(files.size());
            File _file = (File) files.get(j);
            totSize += _file.length();
            if (totSize >= maxByteSize) {
                totSize -= _file.length();
                break;
            }
            toMp3.add(files.get(j));
            files.remove(j);
            tr_tot++;
        }
        for (int i = 0; i < toMp3.size(); i++) {
            File _file = (File) toMp3.get(i);
            System.out.println("\t"
                    + _file.getName().substring(0,
                            (_file.getName().length() - 4)));
        }
        System.out.println(tot + " Files totali");
        System.out.println(tr_tot + " Files trasferibili");
        System.out.println((totSize / MB) + " MB usati");
    }

    public static void copyList(ArrayList files) throws Exception {
        for (int i = 0; i < files.size(); i++) {
            File _file = (File) files.get(i);
            byte[] fileInBytes = new byte[(int) _file.length()];
            fin = new FileInputStream(_file.getAbsolutePath());
            fos = new FileOutputStream("/mnt/flash/" + _file.getName());
            System.out.print("Copia di " + _file.getName());
            fin.read(fileInBytes);
            fos.write(fileInBytes);
            System.out
                    .print("\r                                                                                \r");
        }
        System.out.println((totSize / MB) + " MegaByte copiati");
    }

    public static void main(String[] args) {
        maxByteSize = maxSize * MB;
        File baseDir = new File("/documenti/Musica/");
        File targetDir = new File("/mnt/flash/");
        stdIn = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Spazio disponibile " + targetDir.length());
        readInside(baseDir);
        while (true) {
            if (!auth)
                makeList(allFiles);
            else
                makeList(authMp3);
            while (true) {
                if (!auth)
                    System.out
                            .println("[F]iltro, [C]opia, [R]igenera o [E]sci");
                else
                    System.out
                            .println("*[F]iltro*, [C]opia, [R]igenera o [E]sci");
                try {
                    String cmd = stdIn.readLine();
                    if (cmd.length() != 0) {
                        if (cmd.charAt(0) == 'c' || cmd.charAt(0) == 'C') {
                            copyList(toMp3);
                            System.exit(1);
                        }
                        if (cmd.charAt(0) == 'f' || cmd.charAt(0) == 'F') {
                            findAuth();
                            auth = !auth;
                            break;
                        }
                        if (cmd.charAt(0) == 'e' || cmd.charAt(0) == 'E')
                            System.exit(1);
                        if (cmd.charAt(0) == 'r' || cmd.charAt(0) == 'R')
                            break;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
