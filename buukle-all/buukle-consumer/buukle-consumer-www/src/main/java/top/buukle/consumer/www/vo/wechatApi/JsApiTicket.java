package top.buukle.consumer.www.vo.wechatApi;

public class JsApiTicket implements java.io.Serializable {

    private String ticket;
	// 凭证有效期，单位：秒
	private int expiresIn;
 
	public JsApiTicket() {
 
	}
 
	public String getTicket() {
		return ticket;
	}
 
	public void setTicket(String ticket) {
		this.ticket = ticket;
	}
 
	public int getExpiresIn() {
		return expiresIn;
	}
 
	public void setExpiresIn(int expiresIn) {
		this.expiresIn = expiresIn;
	}
 
}
