package model.enums;

import lombok.Setter;

import java.math.BigDecimal;

public enum TaxiType {
    STANDART(new BigDecimal(60000),new BigDecimal(60000)),
    COMFORT(new BigDecimal(60000),new BigDecimal(60000)),
    BUSINESS(new BigDecimal(60000),new BigDecimal(60000));

    private BigDecimal pricePerKM;

    private BigDecimal priceForLanding;

    TaxiType(BigDecimal pricePerKM, BigDecimal priceForLanding) {
        this.pricePerKM = pricePerKM;
        this.priceForLanding = priceForLanding;
    }

    public BigDecimal getPricePerKM() {
        return pricePerKM;
    }

    public void setPricePerKM(BigDecimal pricePerKM) {
        this.pricePerKM = pricePerKM;
    }

    public BigDecimal getPriceForLanding() {
        return priceForLanding;
    }

    public void setPriceForLanding(BigDecimal priceForLanding) {
        this.priceForLanding = priceForLanding;
    }

    @Override
    public String toString() {
        return "TaxiType{" +
                "pricePerKM=" + pricePerKM +
                ", priceForLanding=" + priceForLanding +
                '}';
    }
}
