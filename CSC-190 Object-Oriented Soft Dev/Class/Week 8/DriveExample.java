// Creation Date: March 17, 2026. at 10:42 AM
// Last Modified: March 17, 2026. at 10:57 AM

import java.util.ArrayList;
import java.util.Arrays;

public class DriveExample {
    public static void main(String[] args) {
        ArrayList<String> files = new ArrayList<>(Arrays.asList("introduction.pdf", "intro.doc", "pic1.jpg", "hello.pdf"));
        System.out.println(files);

        ArrayList<String> pdfFiles = new ArrayList<>();

        for (int i=0; i < files.size(); i++) {
            if (files.get(i).contains(".pdf")) {
                System.out.println(files.get(i));
                pdfFiles.add(files.get(i));
                files.remove(i);
                i--;
            }
        }

        System.out.println("pdf files remaining: "+pdfFiles);
        System.out.println("Non-pdf files remaining: "+files);
    }
}
