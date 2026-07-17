// Creation Date: July 15, 2026. at 8:58 PM
// Last Modified: July 16, 2026. at  7:56 PM

import java.io.*;

public class Diary {
    //=======VARIABLES=======//
    private String FileName;

    //=======CONSTRUCTOR=======// NOTE: IN ORDER TO USE THIS FILES WE NEED A CONSTRUCTOR TO CREATE INSTANCES FROM OTHER FILES
    public Diary(String FilePath) {
        this.FileName = FilePath;
    }

    //==========GETTERS==========\\ NOTE: TO ACCESS THE PRIVATE VARIABLES AND USE IT TO OTHER FILES
    public void readAllEntries() {
        try (BufferedReader br = new BufferedReader(new FileReader(FileName))) {
            String line;
            while ((line = br.readLine()) != null) { //... br.readLine reads every single line, til the line has no more strings. when it reaches to that line with no strings, it returns a null.
                System.out.println(line);
            }
            br.close();

        } catch (FileNotFoundException e) {
            System.out.println("File can't be found!");
            System.out.println("Message: "+e.getMessage());
        } catch (IOException e) {
            System.out.println("File Error: "+e.getMessage());
            System.out.println("Cause: "+e.getCause());
        }
    }
    public boolean fileExists() {
        File f = new File(FileName);
        if (f.exists()) {
            System.out.println(f.getName()+" exists!");
            return true;
        }
        System.out.println(f.getName()+" does not exists!");
        return false;
    }

    //==========SETTERS==========\\ NOTE: CHANGES THE VARIABLES ON THIS FILE
    public void clearDiary() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FileName))) {
            bw.write("");
            bw.close();
            System.out.println("THE DIARY HAS BEEN CLEARED!");
        } catch (FileNotFoundException e) {
            System.out.println("File can't be found!");
            System.out.println("Message: "+e.getMessage());
        } catch (IOException e) {
            System.out.println("File Error: "+e.getMessage());
            System.out.println("Cause: "+e.getCause());
        }
    }

    //===========METHODS===========\\ NOTE: THIS ARE THE SPECIFIC PROCESS IN ORDER TO MEET THE DESIRED RESULTS
    public void addEntry(String entry) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FileName, true))) { // THE OBJECT HAS TO BE CONSTRUCTED INSIDE A TRY PARAMETERS
            bw.write("===== Entry =====");
            bw.newLine();
            bw.write(entry);
            bw.newLine();
            bw.write("=================\n\n");
            bw.close();
        } catch(FileNotFoundException e) {
            System.out.println("File can't be found!");
            System.out.println("Message: "+e.getMessage());
        } catch (IOException e) {
            System.out.println("File Error: "+e.getMessage());
            System.out.println("Cause: "+e.getCause());
        }
    }


    // ================================================== OTHER CLASSES ================================================== \\
}
