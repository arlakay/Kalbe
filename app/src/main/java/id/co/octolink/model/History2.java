package id.co.octolink.model;

import java.util.HashSet;

/**
 * Created by FirdaRinoa on 8/22/16.
 */
public class History2 {
    public String getNamemerchant_history2() {
        return namemerchant_history2;
    }

    public void setNamemerchant_history2(String namemerchant_history2) {
        this.namemerchant_history2 = namemerchant_history2;
    }

    public String getAddressmerchant_history2() {
        return addressmerchant_history2;
    }

    public void setAddressmerchant_history2(String addressmerchant_history2) {
        this.addressmerchant_history2 = addressmerchant_history2;
    }

    public String getDatemerchant_history2() {
        return datemerchant_history2;
    }

    public void setDatemerchant_history2(String datemerchant_history2) {
        this.datemerchant_history2 = datemerchant_history2;
    }

    public String namemerchant_history2;
    public String addressmerchant_history2;
    public String datemerchant_history2;

    public History2(){

    }
    public History2(String namemerchant_history2,String addressmerchant_history2, String datemerchant_history2){
        this.namemerchant_history2 = namemerchant_history2;
        this.addressmerchant_history2 = addressmerchant_history2;
        this.datemerchant_history2 = datemerchant_history2;
    }

}
