package edu.kh.test;

public class IPInfo {

	private String ip;
	private String user;
	
	
	
	public IPInfo() {
		
	}



	public IPInfo(String ip, String user) {
		super();
		this.ip = ip;
		this.user = user;
	}



	public String getIp() {
		return ip;
	}



	public void setIp(String ip) {
		this.ip = ip;
	}



	public String getUser() {
		return user;
	}



	public void setUser(String user) {
		this.user = user;
	}



	@Override
	public String toString() {
		return "IPInfo [ip=" + ip + ", user=" + user + "]";
	}
	
	
	
	
}

