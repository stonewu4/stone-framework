package com.stone.component.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.stone.component.enums.ReturnCodeEnum;
import lombok.Data;

import java.util.Date;

@Data
public class ResponseInfo<T> {
	/** 结果状态 ,具体状态码参见 ReturnCodeEnum.java */
	private int status;
	private String message;
	private T data;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
	private Date timestamp ;


	public ResponseInfo (){
		this.timestamp = new Date();
	}


	public static <T> ResponseInfo<T> success(T data) {
		ResponseInfo<T> resultData = new ResponseInfo<>();
		resultData.setStatus(ReturnCodeEnum.RC200.getCode());
		resultData.setMessage(ReturnCodeEnum.RC200.getMessage());
		resultData.setData(data);
		return resultData;
	}

	public static <T> ResponseInfo<T> fail(int code, String message) {
		ResponseInfo<T> resultData = new ResponseInfo<>();
		resultData.setStatus(code);
		resultData.setMessage(message);
		return resultData;
	}

	public static <T> ResponseInfo<T> fail() {
		ResponseInfo<T> resultData = new ResponseInfo<>();
		resultData.setStatus(ReturnCodeEnum.RC999.getCode());
		resultData.setMessage(ReturnCodeEnum.RC999.getMessage());
		return resultData;
	}

	public static <T> ResponseInfo<T> fail(ReturnCodeEnum codeEnum) {
		ResponseInfo<T> resultData = new ResponseInfo<>();
		resultData.setStatus(codeEnum.getCode());
		resultData.setMessage(codeEnum.getMessage());
		return resultData;
	}

}
