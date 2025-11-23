package Week6;

public class PlayerTest {
    public static void main(String[] arg)
    {
        Player p1 = new Player("Bob", "BobGaming0", 12);
        Player p2 = new Player("Bob", "BobGaming0", 12, 5, 40);

        System.out.println(p1.toString());
        System.out.println(p2.toString());

        p1.incrementGames(20);
        p1.incrementWins(49);

        p2.incrementWins(10);

        System.out.println(p1.toString());
        System.out.println(p2.toString());
    }
}
