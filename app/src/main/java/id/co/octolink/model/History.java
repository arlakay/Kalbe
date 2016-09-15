package id.co.octolink.model;

/**
 * Created by ERD on 14/09/2016.
 */
public class History {
    private String idtransaction;
    private String merchant_id;
    private String store_id;
    private String terminal_id;
    private String transaction_date;
    private String transaction_type;
    private String receipt_number;
    private String customer_id;
    private String card_number;
    private String product_id;
    private String quantity;
    private String discount;
    private String original_amount;
    private String total_amount;
    private String point_award;
    private String point_redeem;
    private String cashback_award;
    private String cashback_redeem;
    private String payment_method;
    private String device_sn;
    private String dongle_sn;
    private String bankcard_number;
    private String approval_code;
    private String merchant_name;
    private String store_name;

    public History(String idtransaction, String merchant_id, String store_id, String terminal_id, String transaction_date, String transaction_type, String receipt_number, String customer_id, String card_number, String product_id, String quantity, String discount, String original_amount, String total_amount, String point_award, String point_redeem, String cashback_award, String cashback_redeem, String payment_method, String device_sn, String dongle_sn, String bankcard_number, String approval_code, String merchant_name, String store_name) {
        this.idtransaction = idtransaction;
        this.merchant_id = merchant_id;
        this.store_id = store_id;
        this.terminal_id = terminal_id;
        this.transaction_date = transaction_date;
        this.transaction_type = transaction_type;
        this.receipt_number = receipt_number;
        this.customer_id = customer_id;
        this.card_number = card_number;
        this.product_id = product_id;
        this.quantity = quantity;
        this.discount = discount;
        this.original_amount = original_amount;
        this.total_amount = total_amount;
        this.point_award = point_award;
        this.point_redeem = point_redeem;
        this.cashback_award = cashback_award;
        this.cashback_redeem = cashback_redeem;
        this.payment_method = payment_method;
        this.device_sn = device_sn;
        this.dongle_sn = dongle_sn;
        this.bankcard_number = bankcard_number;
        this.approval_code = approval_code;
        this.merchant_name = merchant_name;
        this.store_name = store_name;
    }

    public String getIdtransaction() {
        return idtransaction;
    }

    public void setIdtransaction(String idtransaction) {
        this.idtransaction = idtransaction;
    }

    public String getMerchant_id() {
        return merchant_id;
    }

    public void setMerchant_id(String merchant_id) {
        this.merchant_id = merchant_id;
    }

    public String getStore_id() {
        return store_id;
    }

    public void setStore_id(String store_id) {
        this.store_id = store_id;
    }

    public String getTerminal_id() {
        return terminal_id;
    }

    public void setTerminal_id(String terminal_id) {
        this.terminal_id = terminal_id;
    }

    public String getTransaction_date() {
        return transaction_date;
    }

    public void setTransaction_date(String transaction_date) {
        this.transaction_date = transaction_date;
    }

    public String getTransaction_type() {
        return transaction_type;
    }

    public void setTransaction_type(String transaction_type) {
        this.transaction_type = transaction_type;
    }

    public String getReceipt_number() {
        return receipt_number;
    }

    public void setReceipt_number(String receipt_number) {
        this.receipt_number = receipt_number;
    }

    public String getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(String customer_id) {
        this.customer_id = customer_id;
    }

    public String getCard_number() {
        return card_number;
    }

    public void setCard_number(String card_number) {
        this.card_number = card_number;
    }

    public String getProduct_id() {
        return product_id;
    }

    public void setProduct_id(String product_id) {
        this.product_id = product_id;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public String getOriginal_amount() {
        return original_amount;
    }

    public void setOriginal_amount(String original_amount) {
        this.original_amount = original_amount;
    }

    public String getTotal_amount() {
        return total_amount;
    }

    public void setTotal_amount(String total_amount) {
        this.total_amount = total_amount;
    }

    public String getPoint_award() {
        return point_award;
    }

    public void setPoint_award(String point_award) {
        this.point_award = point_award;
    }

    public String getPoint_redeem() {
        return point_redeem;
    }

    public void setPoint_redeem(String point_redeem) {
        this.point_redeem = point_redeem;
    }

    public String getCashback_award() {
        return cashback_award;
    }

    public void setCashback_award(String cashback_award) {
        this.cashback_award = cashback_award;
    }

    public String getCashback_redeem() {
        return cashback_redeem;
    }

    public void setCashback_redeem(String cashback_redeem) {
        this.cashback_redeem = cashback_redeem;
    }

    public String getPayment_method() {
        return payment_method;
    }

    public void setPayment_method(String payment_method) {
        this.payment_method = payment_method;
    }

    public String getDevice_sn() {
        return device_sn;
    }

    public void setDevice_sn(String device_sn) {
        this.device_sn = device_sn;
    }

    public String getDongle_sn() {
        return dongle_sn;
    }

    public void setDongle_sn(String dongle_sn) {
        this.dongle_sn = dongle_sn;
    }

    public String getBankcard_number() {
        return bankcard_number;
    }

    public void setBankcard_number(String bankcard_number) {
        this.bankcard_number = bankcard_number;
    }

    public String getApproval_code() {
        return approval_code;
    }

    public void setApproval_code(String approval_code) {
        this.approval_code = approval_code;
    }

    public String getMerchant_name() {
        return merchant_name;
    }

    public void setMerchant_name(String merchant_name) {
        this.merchant_name = merchant_name;
    }

    public String getStore_name() {
        return store_name;
    }

    public void setStore_name(String store_name) {
        this.store_name = store_name;
    }

}
