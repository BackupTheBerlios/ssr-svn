package de.berlios.ssr.old;

import java.util.*;

public class Author {
    private static String fileType;
    
    private static int len = 0;
    
    public Author(String name) {
        Author.fileType = name;
    }
    
    public ArrayList search(ArrayList target) throws Exception {
        ArrayList searchResult = new ArrayList();
        for (int j = 0; j < target.size(); j++) {
            String _file = (String) target.get(j).toString();
            if (CheckString(fileType, _file)) {
                searchResult.add(target.get(j));
            }
        }
        return searchResult;
    }
    
    private boolean CheckString(String query, String mark) {
        len = query.length();
        if (query.length() <= mark.length() && StringMatch(query, mark))
            return true;
        else
            return false;
    }
    
    private boolean StringMatch(String query, String mark) {
        if (mark.substring(0, len).equalsIgnoreCase(query))
            return true;
        else {
            if (mark.length() > len && StringMatch(query, mark.substring(1)))
                return true;
            else
                return false;
        }
    }
    
}
