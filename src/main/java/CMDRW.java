import java.io.File;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;
import java.util.regex.Pattern;

public class CMDRW extends Thread {
    List<Money> money;
    public CMDRW(List<Money> money){
        this.money = money;
    }
    public void run(){
        Scanner s = new Scanner(System.in);
        CMDReader(s);
    }
    public void CMDReader(Scanner s){
        System.out.println("是否从文件读取？(Y/N)[N]");
        String str = s.nextLine();
        if("quit".equals(str)){
            System.exit(0);
        }
        if (str.length() == 0 || "N".equals(str)){
            CMDOperate(s, str);
        }
        else if("Y".equals(str)){
            System.out.println("请输入文本文件完整路径(例：D:\1.txt)");
            str = s.nextLine();
            File f = new File(str);
            if(f.exists() && !f.isDirectory()){
                money = new FileOperate().GetMoneyFromFile(money, str);
                CMDOperate(s, str);
            }
            else {
                System.out.println("文本文件不存在");
                CMDReader(s);
            }
        }
        else {
            System.out.println("输入信息有误");
            s.close();
            CMDReader(s);
        }
    }

    public void CMDOperate(Scanner s, String str){
        System.out.println("请输入账务信息(例：USD 100)");
        str = s.nextLine();
        if("quit".equals(str)){
            System.exit(0);
        }
        String[] ss = str.split("\\s+");
        if(ss.length >= 2) {
            Money m = new Money();
            if (ss[0].length() == 3) {
                m.setCurrency(ss[0].toUpperCase());
            } else {
                System.out.println("Currency invalid:" + ss[0]);
                CMDOperate(s, str);
            }
            if (Pattern.compile("[-0-9]+").matcher(ss[1]).matches()) {
                m.setNum(Integer.parseInt(ss[1]));
            } else {
                System.out.println("Currency invalid:" + ss[1]);
                CMDOperate(s, str);
            }
            if (m.getCurrency() != null && m.getNum() != Integer.MIN_VALUE) {
                money.add(m);
                CMDOperate(s, str);
            }
            else {
                CMDOperate(s, str);
            }
        }
        else {
            System.out.println("string invalid");
            CMDOperate(s, str);
        }
    }
}
