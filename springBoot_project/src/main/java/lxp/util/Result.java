package lxp.util;

public class Result {

	private int code = 200;
	private String msg = "OK";		
	private Object data;
	
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}

	public Result(){
		this.data = "SUCCESS";
	}	
	
	public Result(Object data){
		this.data = data;
	}
	
	public Result(int code, String msg){
		this.code = code;
		this.msg = msg;
	}
	
	public Result(ResultCode resultCode){
		this.code = resultCode.getCode();
		this.msg = resultCode.getMsg();
	}
	
	public Result(ResultCode resultCode,Object data){
		this.code = resultCode.getCode();
		this.msg = resultCode.getMsg();
		this.data = data;
	}
}


