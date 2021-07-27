package com.stone.component.exception;

import com.stone.component.enums.ReturnCodeEnum;

public class BusinessException extends RuntimeException {

	private static final long serialVersionUID = 8882366904034518521L;

	private Integer code;

	private String message;
	
	private boolean customMsg = false;

	public BusinessException(Integer code) {
		super();
		this.code = code;
		if(!"500".equals(code))
			this.message="发生错误，调用失败";
			
	}
	
	public BusinessException(Integer code, String message) {
		super();
		this.code = code;
		this.message = message;
	}

	public BusinessException(ReturnCodeEnum returnCodeEnum) {
		super();
		this.code = returnCodeEnum.getCode();
		this.message = returnCodeEnum.getMessage();
	}

	public BusinessException(Integer code, String message, Throwable cause) {
		super(cause);
		this.code = code;
		this.message = message;
	}
	
	public BusinessException(Integer code, String message, boolean customMsg) {
		super();
		this.code = code;
		this.message = message;
		this.customMsg = customMsg;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "code ..." + code;
	}

	public boolean isCustomMsg() {
		return customMsg;
	}
}
