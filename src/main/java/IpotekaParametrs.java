public class IpotekaParametrs {
    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public String getFee() {
        return fee;
    }

    public void setFee(String fee) {
        this.fee = fee;
    }

    public String getTerm() {
        return term;
    }

    public IpotekaParametrs(String cost, String fee, String term) {
        this.cost = cost;
        this.fee = fee;
        this.term = term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    private String cost;
    private String fee;
    private String term;
}
