package de.berlios.ssr.old;

import java.io.*;

public class Filter {
    private static String fileType;
    
    private static String fileType2;
    
    public Filter(String type, String type2) {
        this.fileType = type;
        this.fileType2 = type2;
    }
    
    public boolean accept(File pathname) {
        String name = pathname.toString();
        if (name.substring(name.length() - 4).equalsIgnoreCase(fileType)
                || name.substring(name.length() - 4)
                .equalsIgnoreCase(fileType2))
            return true;
        else
            return false;
    }
}
