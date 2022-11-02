package js.andres.modelos;

import java.io.Serializable;

//Importante el serializable
public class RequestModel implements Serializable{
    
    private static final long serialVersionUID = 1L;
	private String buy_order;
	private String session_id;
	private Integer amount;
	private String return_url;
	
	
	
	public RequestModel() {
		super();
	}
	public RequestModel(String buy_order, String session_id, Integer amount, String return_url) {
		super();
		this.buy_order = buy_order;
		this.session_id = session_id;
		this.amount = amount;
		this.return_url = return_url;
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
	public Integer getAmount() {
		return amount;
	}
	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	public String getReturn_url() {
		return return_url;
	}
	public void setReturn_url(String return_url) {
		this.return_url = return_url;
	}
}
