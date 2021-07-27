package com.stone.component.exception;

public class BusinessException extends RuntimeException {

	private static final long serialVersionUID = 8882366904034518521L;

	//异常CODE
	public static final int CODE_GLOCBAL_EXCEPTION = 12000; //系统异常
	public static final int CODE_UN_AUTHORIZATION = 10000;// 系统未授权
	public static final int CODE_NONEXISTENT_USER = 10001;// 不存在的用户
	public static final int CODE_INCORRECT_USER = 10002;// 用户名或密码错误
	public static final int CODE_DELETE_USER = 10017;// 用户已被删除
	public static final int CODE_DISTABLE_USER = 10016;// 用户已被禁用
	public static final int CODE_VALIDATE_USER = 10018;// 用户已过期
	public static final int CODE_ALREADY_LOGIN = 10019; // 用户已经登录
	public static final int CODE_ILLEGAL_SEAT = 10021; // 坐席类型不匹配
	public static final int CODE_ILLEGAL_PARAMS = 10003;// 不合法的参数
	public static final int CODE_ILLEGAL_IMAGE_SIZE = 10004;// 不合法的图片大小
	public static final int CODE_ILLEGAL_NOTMAPPING=10013;//违法上传未找到映射关系
	public static final int CODE_INSERT_ERROR = 10020;// 添加异常
	public static final int CODE_QUERY_ERROR = 10005;// 查询异常
	public static final int CODE_UPDATE_ERROR = 10006;// 更新记录异常
	public static final int CODE_DELETE_INEXISTENCE_ERROR = 10007;// 删除数据异常，记录不存在
	public static final int CODE_DELETE_INUSE_ERROR = 10008;// 删除数据异常，记录正在使用中
	public static final int CODE_REQUEST_DATA_INEXISTENCE = 10009;// 请求数据不存在或已被删除
	public static final int CODE_XML_PARSE_ERROR = 100010;// 解析XML或JSON数据异常
	public static final int CODE_REQUEST_IMAGE_INEXISTENCE = 100011;// 请求图片不存在或已被删除
	public static final int CODE_CRITERIA_DUPLICATE = 100012;// MAP与object不能同时存在
	public static final int CODE_REDIS_ERROR = 100013;// REDIS连接异常
	public static final int CODE_CACHE_ERROR = 100014;// 缓存对象不存在
	public static final int CODE_COLLETION_INDEX_ERROR = 100015;// list 下标越界
	public static final int CODE_USER_SESSION_ERROR = 100016;// 用户session不存在
	public static final int CODE_MISSING_SYSTENCONFIG_ERROR = 100017;// 缺少系统配置
	public static final int CODE_THREADS_FINISH_ERROR = 100018;// 线程未全部执行成功
	public static final int CODE_QUERY_OVERSIZE = 100019;// 查询数量超过100w
	public static final int CODE_RECORD_EXISTS = 100020;// 修改的记录已经存在
	public static final int CODE_SYNCHRONIZATION_FAILURE = 100021;// 大数据同步失败
	public static final int CODE_IMAGE_EXCEPTION = 100022;// 图片上传异常
	public static final int CODE_QUERY_EMPTY = 100023;// 查询结果为空
	public static final int CODE_ILLEGAL_OPERATION = 100024;// 导出操作不合法
	public static final int CODE_IMAGE_COMPRESSION_FAILURE = 100025;// 图片压缩失败
	public static final int CODE_DELETE_FILE_FAILURE = 100026;// 删除目录失败
	public static final int CODE_UPLOAD_FILE_FAILURE = 100027;// 上传ftp文件失败
	public static final int CODE_FTP_NO_LOGIN = 100028;// ftp登录失败
	public static final int CODE_MQ_SEND_MESSAGE = 100029;// MQ发送信息异常
	public static final int CODE_SAME_PLATENUMBER = 100044;// 不能添加相同白名单
	public static final int CODE_USER_LOGIN = 100045;//用户已经登录
	public static final int CODE_MAIL_SEND_MESSAGE = 100046;//发送邮件异常

	/** excel 错误码 start **/
	public static final int CODE_FILE_DOWN = 100042;//文件下载异常
	public static final int CODE_FILE_FORMAT = 100029;// 文件格式不正确
	public static final int CODE_PLATENUMBER_ERROR = 100030;// 不是精确车牌
	public static final int CODE_FILED_NOTNULL = 100031;// execl中字段不能为空
	public static final int CODE_FILE_COLUMN_NOTEQUALS = 100032;// execl中列值不相同
	public static final int CODE_FILE_OVER_SIZE = 100033;// execl文件超过5M
	public static final int CODE_FILE_RECORDS_EMPTY = 100034;// execl文件为空
	public static final int CODE_FILE_ORGNAME_MISMATCHES = 100035;// execl中布控范围没有匹配
	public static final int CODE_FILE_DATE_FORMAT_ERROR = 100036;// execl日期转化异常
	public static final int CODE_FILE_DATE_LESS_THAN_NOW = 100037;// execl布控时间小于开始布控时间
	public static final int CODE_FILE_DURATION_FORMATE_ERROR = 100038;// execl时长转化异常
	public static final int CODE_FILED_STARTTIME_NOTNULL = 100040;// 开始布控的时间不能为空
	public static final int CODE_FILE_DATE_ERROR = 100041;// 日期格式异常
	
	public static final int CODE_PLATENUMBER_FORMATE_ERROR = 100042;// 模糊车牌格式不正确
	public static final int CODE_PRECISEPLATENUMBER_FORMATE_ERROR = 100043;// 精确车牌格式不正确
	/** excel 错误码 end **/

	/*** 证书登录  start***/
	public static final int CODE_ClientTEXT_NOMATCH_SERVICE = 100501; //客户端和服务器段的随机码值不同
	public static final int CODE_AUTH_FAILD = 100502;//证书授权服务验证失败，提示信息为：用户不存在
	public static final int CODE_AUTH_FILE_NO_MATCH = 100503;//授权catoken为空 提示信息为：用户不存在
	public static final int CODE_AUTH_NONEXISTENT_USER = 100504;//证书登录用户不存在 提示信息为：用户不存在
	/*** 证书登录 end ***/
	
	/*** 导出  start***/
	public static final int CODE_NO_DATE = 100601; //导出的数据为空
	public static final int CODE_GENERATE_FILE_ERROR = 100602; //文件生成错误
	/*** 导出 end ***/
	
	/*** 流程部署状态  start***/
	public static final int BEFORE_THAN_AUDIT = 100701; //用户已经取出数据
	public static final int CACHE_NO_STATUS_EXIST = 100702; //和任务相对的状态， 缓冲字典数据不存在
	public static final int BEFORE_DEPLOY_CHECEK = 100703; //布控信息已经查看了
	public static final int CODE_SAME_DATE = 100704; //开始时间和结束时间相同了
	public static final int CODE_DATE_ERROR = 100705; //开始时间和结束时间相同了
	public static final int CODE_STARTTIME_MORETHAN_ENDTIME = 100706; //开始时间大于结束时间相同
	public static final int CODE_PHONE_SAME = 100707; //开始时间大于结束时间相同
	public static final int CODE_STATE_ERROR = 100708; //布控状态异常
	public static final int CODE_REPEAT_INFO = 100709; //布控记录重复
	public static final int CODE_SAME_INFO = 100710; //记录条目车牌号和车牌颜色重复
	/*** 流程部署状态 end ***/
	
	//权限模块
	public static final int HAS_USER_IN_ROLE = 100801; //角色下存在用户
	public static final int ROLENAME_REPEAT = 100802; //角色名称重复
	public static final int ADMINROLE = 100803; //管理员角色不能被删除
	public static final int ROLENAME_NULL = 100804; //角色名称重复
	public static final int ROLEPERMISSION_NULL = 100805; //角色名称重复
	
	/*** PCC识别  start***/
	public static final int CODE_PCC_RECOGNIZE_ERROR = 110001; //pcc识别服务异常
	public static final int CODE_PCC_RETURN_OVERTIME = 110006; //pcc返回的json为空
	public static final int CODE_PCC_RETURN_EMPTY_ERROR = 110007; //pcc返回的json为空
	public static final int CODE_REGION_ISNULL_ERROR = 110002; //用户必须框选一定的特征区域
	public static final int CODE_FEATURE_ISNULL_ERROR = 110003; //缓存中没有特征信息
	public static final int CODE_NOT_CAR_ERROR = 110004; //可能不是一辆车
	public static final int CODE_MATCH_SERVICE_ERROR = 110005; //大数据比对服务异常
	
	
	/*** CTI***/
	public static final int CODE_CTI_RETURN_OVERTIME = 120006; //CTI返回超时
	public static final int CODE_CTI_RETURN_EMPTY_ERROR = 120007; //CTI返回空
	public static final int CODE_CTI_RESULT_ERROR = 120002; //CTI返回结果错误，带错误码

	/** 阿里云-短信服务 **/
	public static final int CODE_SHORT_MSG_SEND_FAILED = 130001; //阿里云短信服务发送短信失败，带错误码
	public static final int CODE_SHORT_MSG_INIT_FAILED = 130002; //阿里云短信服务发送短信失败，带错误码
	
	/** 值班 **/
	public static final int CODE_DUTY_NOT_ON_DUTY = 140001; // 当前没有值班信息


	/*** PCC识别 end ***/
	
	
	private Integer code;

	private String message;
	
	private boolean customMsg = false;

	public BusinessException(Integer code) {
		super();
		this.code = code;
		if(!"200".equals(code))
			this.message="发生错误，调用失败";
			
	}
	
	public BusinessException(Integer code, String message) {
		super();
		this.code = code;
		this.message = message;
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
