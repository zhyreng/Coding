import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args){
        List<Money> money = new Vector<Money>();
        Thread t1 = new Thread(new CMDRW(money));
        t1.start();
        Thread t2 = new Thread(new PerPrint(money));
        t2.start();
    }
}
