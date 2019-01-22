package by.zapolski.io;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.regex.Pattern;

public class DirList {
    public static void main(String[] args) {

        String str = ".*\\.java";

        File path = new File("c:\\Users\\d\\IdeaProjects\\TIJ4-code\\examples\\arrays\\");

        String[] list;

        list = path.list(new FilenameFilter() {
            private Pattern pattern = Pattern.compile(str);

            @Override
            public boolean accept(File dir, String name) {
                return pattern.matcher(name).matches();
            }
        });
        Arrays.sort(list,String.CASE_INSENSITIVE_ORDER);
        for (String dirItem:list)
            System.out.println(dirItem);
    }
}