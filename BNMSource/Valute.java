package vanar.projects.BNMSource;

public class Valute {

    private Integer id;
    private Integer numCode;
    private String charCode;
    private Byte nominal;
    private Currency money;

    

    public Valute(Integer id, Integer numCode, String charCode, Byte nominal, Currency money) {
        this.id = id;
        this.numCode = numCode;
        this.charCode = charCode;
        this.nominal = nominal;
        this.money = money;
    }

    public Integer getNumCode() {
        return numCode;
    }

    public void setNumCode(Integer numCode) {
        this.numCode = numCode;
    }

    public String getCharCode() {
        return charCode;
    }

    public void setCharCode(String charCode) {
        this.charCode = charCode;
    }

    public Byte getNominal() {
        return nominal;
    }

    public void setNominal(Byte nominal) {
        this.nominal = nominal;
    }

    public Currency getMoney() {
        return money;
    }

    public void setMoney(Currency money) {
        this.money = money;
    }

    

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Valute [numCode=" + numCode + ", charCode=" + charCode + ", nominal=" + nominal + ", money=" + money
                + "]\n";
    }

    

    

   
    

    


   


    



}
