package vanar.projects.BNMSource;

public class Currency {

    private String currencyName;
    private float value;


    public Currency(String currencyName, float value) {
        this.currencyName = currencyName;
        this.value = value;
    }


    public String getCurrencyName() {
        return currencyName;

    }
    
    public void setCurrencyName(String currencyName) {
        this.currencyName = currencyName;
    }


    public float getValue() {
        return value;
    }


    public void setValue(float value) {
        this.value = value;
    }


    @Override
    public String toString() {
        return "Currency [name=" + currencyName + ", value=" + value + "]";
    }

    

    

    
    
}
