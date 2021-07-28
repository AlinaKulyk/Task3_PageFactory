package model;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;



@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "rozetkaFilter")

    public class RozetkaFilter {

    private String productGroup;
    private String brand;
    private String sum;

    public String getProductGroup() { return productGroup; }

    public void setProductGroup(String productGroup) {
        this.productGroup = productGroup;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getSum() { return sum; }

    public void setSum(String sum) { this.sum = sum; }


    @Override
    public String toString() {
        return "RozetkaFilter{" +
                "productGroup='" + productGroup + '\'' +
                ", brand='" + brand + '\'' +
                ", sum='" + sum + '\'' +
                '}';
    }




}
