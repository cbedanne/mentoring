import java.awt.Color;
import java.util.Arrays;
import java.util.stream.Stream;
public class FeuTricoloreStream {
    private Color[] tab = {Color.green, Color.orange, Color.red};
    public void brille() {
        Stream<Color> feuTricolore
                = Stream.iterate(0, n-> n+1).map(curseur -> tab[curseur%3]);
        feuTricolore.limit(7).forEach(System.out::println);
    }
    public static void main(String[] a)
    {
        FeuTricoloreStream fs = new FeuTricoloreStream();
        System.out.println("------ brille --------");
        fs.brille();
    }
}
