public class Money {
    public Money(){
        this.currency = null;
        this.num = Integer.MIN_VALUE;
    }
    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    private String currency;
    private int num;
}
