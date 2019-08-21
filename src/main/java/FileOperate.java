import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Vector;
import java.util.regex.Pattern;

public class FileOperate {
    public List<Money> GetMoneyFromFile(List<Money> money, String path){
        try {
            BufferedReader is = new BufferedReader(new InputStreamReader(new FileInputStream(path)));
            String str = null;
            while ((str = is.readLine()) != null){
                String[] ss = str.split("\\s+");
                if(ss.length >= 2) {
                    Money m = new Money();
                    if (ss[0].length() == 3) {
                        m.setCurrency(ss[0].toUpperCase());
                    } else {
                        System.out.println("Currency invalid:" + ss[0]);
                    }
                    if (Pattern.compile("[-0-9]+").matcher(ss[1]).matches()) {
                        m.setNum(Integer.parseInt(ss[1]));
                    } else {
                        System.out.println("Currency invalid:" + ss[1]);
                    }
                    if (m.getCurrency() != null && m.getNum() != Integer.MIN_VALUE) {
                        money.add(m);
                    }
                }
                else {
                    System.out.println("string invalid");
                }
            }
        }
        catch (Exception e){}
        return money;
    }
}
