import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class PerPrint implements Runnable {
    List<Money> money;
    public PerPrint(List<Money> money) {
        this.money = money;
    }

    @Override
    public void run() {
        print();
    }

    public void print(){
        try {
            Thread.sleep(60000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Map<String, Integer> res = money.stream().collect(Collectors.groupingBy(Money::getCurrency, Collectors.summingInt(Money::getNum)));
        res.forEach((k,v)->{if(v != 0) System.out.println(k + " " + v.toString());});
    }
}
