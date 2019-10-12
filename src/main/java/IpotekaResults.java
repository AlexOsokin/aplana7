public class IpotekaResults {
    public IpotekaResults(String credit, String paymant, String income, String rate) {
        this.credit = credit;
        this.paymant = paymant;
        this.income = income;
        this.rate = rate;
    }

    public String getCredit() {
        return credit;
    }

    public void setCredit(String credit) {
        this.credit = credit;
    }

    public String getPaymant() {
        return paymant;
    }

    public void setPaymant(String paymant) {
        this.paymant = paymant;
    }

    public String getIncome() {
        return income;
    }

    public void setIncome(String income) {
        this.income = income;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    private String credit;
    private String paymant;
    private String income;
    private String rate;
}
