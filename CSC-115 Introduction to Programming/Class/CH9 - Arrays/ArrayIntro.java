public class ArrayIntro {
    public static void main(String[] args) {
        int[] years = new int[5];
        years[0] = 2020;
        years[1] = 2001;
        years[2] = 1812;
        years[3] = 1942;
        years[4] = 2007;

        for (int i = 0; i < years.length; i++) {
            System.out.println(years[i]);
        }
    }  
}
