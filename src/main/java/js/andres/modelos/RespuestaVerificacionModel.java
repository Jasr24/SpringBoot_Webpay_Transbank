package js.andres.modelos;

import java.io.Serializable;

//Importante el serializable
public class RespuestaVerificacionModel implements Serializable{
    
    private static final long serialVersionUID = 1L;
	private String vci;
	private Integer amount;
	private String status;
	private String buy_order;
	private String session_id;
	private Object  card_detail;
	private String accounting_date;
	private String transaction_date;
	private String authorization_code;
	private String payment_type_code;
	private Integer response_code;
	private Integer installments_number;
	
	
	
	public RespuestaVerificacionModel() {
		super();
	}
	public RespuestaVerificacionModel(String vci, Integer amount, String status, String buy_order, String session_id,
			Object card_detail, String accounting_date, String transaction_date, String authorization_code,
			String payment_type_code, Integer response_code, Integer installments_number) {
		super();
		this.vci = vci;
		this.amount = amount;
		this.status = status;
		this.buy_order = buy_order;
		this.session_id = session_id;
		this.card_detail = card_detail;
		this.accounting_date = accounting_date;
		this.transaction_date = transaction_date;
		this.authorization_code = authorization_code;
		this.payment_type_code = payment_type_code;
		this.response_code = response_code;
		this.installments_number = installments_number;
	}
	public String getVci() {
		return vci;
	}
	public void setVci(String vci) {
		this.vci = vci;
	}
	public Integer getAmount() {
		return amount;
	}
	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getBuy_order() {
		return buy_order;
	}
	public void setBuy_order(String buy_order) {
		this.buy_order = buy_order;
	}
	public String getSession_id() {
		return session_id;
	}
	public void setSession_id(String session_id) {
		this.session_id = session_id;
	}
	public Object getCard_detail() {
		return card_detail;
	}
	public void setCard_detail(Object card_detail) {
		this.card_detail = card_detail;
	}
	public String getAccounting_date() {
		return accounting_date;
	}
	public void setAccounting_date(String accounting_date) {
		this.accounting_date = accounting_date;
	}
	public String getTransaction_date() {
		return transaction_date;
	}
	public void setTransaction_date(String transaction_date) {
		this.transaction_date = transaction_date;
	}
	public String getAuthorization_code() {
		return authorization_code;
	}
	public void setAuthorization_code(String authorization_code) {
		this.authorization_code = authorization_code;
	}
	public String getPayment_type_code() {
		return payment_type_code;
	}
	public void setPayment_type_code(String payment_type_code) {
		this.payment_type_code = payment_type_code;
	}
	public Integer getResponse_code() {
		return response_code;
	}
	public void setResponse_code(Integer response_code) {
		this.response_code = response_code;
	}
	public Integer getInstallments_number() {
		return installments_number;
	}
	public void setInstallments_number(Integer installments_number) {
		this.installments_number = installments_number;
	}
}
