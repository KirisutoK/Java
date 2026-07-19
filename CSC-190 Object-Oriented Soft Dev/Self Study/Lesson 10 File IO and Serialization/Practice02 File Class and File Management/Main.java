// Creation Date: July 17, 2026. at 9:47 PM
// Last Modified: July 19, 2026. at 10:59 AM

public class Main {
    // =========================== CLASS VARIABLES =========================== \\

    // =========================== MAIN =========================== \\
    public static void main(String[] args) {
        //======= CREATING OBJECTS =======//
        FileManager FManager = new FileManager("C:\\Users\\kiris\\OneDrive - Finger Lakes Community College\\Documents\\FLCC\\Coding\\Java\\CSC-190 Object-Oriented Soft Dev\\Self Study\\Lesson 10 File IO and Serialization\\Practice02 File Class and File Management\\FileSandBox");

        //======= METHODS =======//
        // FManager.createFile("Test.txt");
        // FManager.deleteFile("Test");
        // FManager.listFiles();
        // FManager.renameFile("Test", "Test.txt");


        //======= CLAUDE =======//
        // [CREATING FILES]
        FManager.createFile("Test01");
        FManager.createFile("Test02");
        FManager.createFile("Test03");

        // [CREATING A DUPLICATE]
        FManager.createFile("Test01");

//        // [CREATING A DIRECTORY] <=========== THIS MY OWN PERSONAL CODE
//        FManager.createDirectory("TestDirectory01");
//        FManager.renameDirectory("TestDirectory01", "TestDirectory02");
//
//        // [CHANGING DIRECTORY]
//        FManager.changeDirectory("C:\\Users\\kiris\\OneDrive - Finger Lakes Community College\\Documents\\FLCC\\Coding\\Java\\CSC-190 Object-Oriented Soft Dev\\Self Study\\Lesson 10 File IO and Serialization\\Practice02 File Class and File Management");

        // [LIST ALL FILES IN THE DIRECTORY]
        FManager.listFiles();

        // [GET INFO IN ONE SPECIFIC FILE]
        FManager.getFileInfo("Test01");

        // [RENAME ONE FILE]
        FManager.renameFile("Test01", "Test04");

        // [LIST ALL FILES IN THE DIRECTORY]
        FManager.listFiles();

        // [DELETE A FILE]
        FManager.deleteFile("Test04");

        // [LIST ALL FILES IN THE DIRECTORY]
        FManager.listFiles();

    }

    // =========================== OTHER METHODS =========================== \\
}
