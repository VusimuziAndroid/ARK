package android.apk;

/**
 * Created by Vusi Ngwenya on 7/20/2016.
 */
public class Customers {
    String customerNumber;
    String customerName;
    String idNumber;

    public Customers(String customerNumber,String customerName,String idNumber){
        this.customerNumber=customerNumber;
        this.customerName=customerName;
        this.idNumber=idNumber;
    }

    public String getCustomerNumber(){
        return this.customerNumber;
    }
    public String getCustomerName(){
        return this.customerName;
    }
    public String getIdNumber(){
        return this.idNumber;
    }
}
