package top.buukle.consumer.www.vo.wechatApi;

public class AccessToken implements java.io.Serializable {
    // 接口访问凭证
	private String accessToken;
	// 凭证有效期，单位：秒
	private int expiresIn;
 
	public AccessToken() {
 
	}
 
	public String getAccessToken() {
		return accessToken;
	}
 
	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}
 
	public int getExpiresIn() {
		return expiresIn;
	}
 
	public void setExpiresIn(int expiresIn) {
		this.expiresIn = expiresIn;
	}
}
