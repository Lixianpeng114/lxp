package lxp.util;

public enum ResultCode {
	/** SUCCESS */
	SUCCESS(200,"SUCCESS"),
	/** 账号以被删除 */
	ACCOUNT_IS_DELETE(301,"账号以被删除"),
	/** 系统异常  */
	SERVER_ERROR(500,"系统异常"),
	/** 数据添加失败 */
	INSERT_ERROR(501,"数据添加失败"),
	/** 数据更新失败 */
	DATA_UPDATE_ERROR(502,"数据更新失败"),
	/** 数据删除失败 */
	DATA_DELETE_ERROR(503,"数据删除失败"),
	/** 没有权限 */
	NOT_PERMISSION(504,"没有权限"),
	/** 未知错误 */
	UNKNOWN_ERROR(512,"未知错误"),
	/** 普通错误 */
	BAD_REQUEST(400,"普通错误"),
	/** 不能修改 */
	UPDATE_NOT(401,"不能修改自己的数据"),
	/** 未找到资源 */
	NOT_FOUND(404,"未找到资源"),
	/** 角色已被停用 */
	ROLE_NOT_USE(402,"角色已被停用!"),
	/** 账号不存在 */
	ACCOUNT_NO_EXIT(405,"账号不存在"),
	/** 没有输入手机号 */
	MOBILE_NO_INPUT(406,"没有输入手机号"),
	/** 账号已存在 */
	ACCOUNT_Y_EXIST(407,"账号已存在"),
	/** 您还未登录 */
	ACCOUNT_NOT_LOGIN(408,"您还未登录"),
	/** 账号或密码错误 **/
	ACCOUNT_OR_PWD_ERROR(409,"账号或密码错误"),
	/** 参数丢失 */
	PARAM_LOSS(410,"参数丢失"),
	/** 签名错误 */
	SIGN_ERROR(411,"签名错误"),
	/** 该账号未注册 */
	ACCOUNT_NOT_REG(413,"该账号未注册"),
	/** 验证码错误 */
	VERIFICATION_ERROR(414,"验证码错误"),
	/** 数据不存在 */
	DATA_NOT_EXIST(415,"数据不存在"),
	/** 数据重复 */
	DATA_DUPLICATED(416,"数据重复"),
	/** 没有验证码 */
	CODE_NOT_EXTIST(417,"没有验证码"),
	/** 验证码错误 */
	CODE_ERROR(418,"验证码错误"),
	/** 订单未支付 */
	ORDER_NOT_PAY(419,"订单未支付"),
	/** 订单已失败 */
	ORDER_FAIL(420,"订单已失败"),
	/**订单已支付或者已完成 */
	ORDER_SUCCESS(421,"订单已支付或者已完成"),
	/** 未操作时间过长您以退出登录 */
	LOGIN_TIME_OUT(422,"未操作时间过长您以退出登录"),
	/** 登录失败 */
	LOGIN_FALL(522,"登录失败"),
	/** 注册失败 */
	REG_FALL(523,"注册失败"),
	/** 状态码错误 */
	ORDER_STATUS_ERROR(423,"订单状态码,错误"),
	/** 身份证号错误 */
	ID_CARD_ERROR(424,"身份证号错误"),
	/** 短信验证码发送失败 */
	SMS_CODE_SEND_ERROR(425,"短信验证码发送失败"),
	/** 车辆颜色类别重复 */
	COLOR_TITLE_DUPLICATED(426,"车辆颜色类别重复"),
	/** 旧密码不一致 */
	OLD_PWD_ERROE(427,"旧密码错误"),
	/** 新密码与确认密码不一致 */
	PWD_REPWD_ERROR(428,"新密码与确认密码不一致"),
	/** 无法更新自己的权限 */
	UPDATE_NOT_YOU_ROLE(429,"无法更新自己的权限"),
	/** 超过购买限制  */
	GT_BUY_LIMIT(430,"超过购买限制"),
	/** 不能重复发起退款 */
	REFUND_NOT_TWO(431,"不能重复发起退款"),
	/** 订单已支付不能取消 */
	ORDER_PAY_Y(480,"订单已支付,不能取消"),
	/** 改订单目前不能发起售后 */
	ORDER_NOT_AFTER(481,"该订单目前不能发起售后"),
	/** 改订单目前不能确认收货 */
	ORDER_NOT_CONFRIM(482,"该订单目前不能确认收货"),
	/** 没有找到相对应的VSN */
	VSN_NOT_FIND(485,"没有找到相对应的VSN"),
	/** 没有找到相对应的VIN */
	VIN_NOT_FIND(486,"没有找到相对应的VIN"),
	/** 改vsn已使用  */
	VSN_IS_USED(483,"该VSN已被使用"),
	/** 该vin已使用 */
	VIN_IS_USED(484,"该VIN已被使用"),
	/** 有部分订单匹配失败 */
	MATCH_ERROR(487,"有部分订单匹配失败"),
	/*** 上传Excel 为空*/
	EXCEL_NULL(488,"上传Excel 为空"),
	/** 不能重复发起退款 */
	REFUND_NOT(489,"不能重复发起退款"),
	/** 创建预支付订单失败 */
	CREATE_PAYMENT_ERROR(490,"创建预支付订单失败"),
	/** 不能超出商品应付总金额 */
	NOT_BEYOND_PRICE(491,"不能超出商品应付总金额"),
	/** 支付信息不匹配  */
	PAYMENT_ERROE(492,"支付信息不匹配"),
	/** 验证签名失败 */
	VERIFY_SIGN_ERROR(493,"验证签名失败"),
	/** 创建预退款订单失败 */
	CREATE_REFUND_ERROR(494,"创建预退款订单失败"),
	/** 没有支付成功 */
	PAYMENT_FAIL(495,"没有支付成功"),
	/** 没有支付成功 */
	File_NOT(496,"上传失败！上传文件格式错误！"),
	/** 该支付信息存在没有完成的退款 */
	EXIST_REFUND(497,"该支付信息存在没有完成的退款"),
	/** 该支付信息已完成退款,不能重新发起退款 */
	REFUND_SUCCESS(498,"该支付信息已完成退款,不能重新发起退款"),
	/** 订单已支付不能取消 */
	PAYMENT_Y(499,"本支付单业务完成无法再次申请二维码信息"),
	/** 退款失败  */
	REFUND_FAIL(520,"退款失败"),
	/** 本合同已经确认  */
	CONTRACT_CONFIRM_FAIL(521,"本合同已经确认"),
	/**导入开票信息成功*/
	UPLOAD_INVOICE_SUCCESS(60001, "导入成功"),
	/**导入开票信息 获取文件失败*/
	UPLOAD_INVOICE_NULLFILE(60002, "参数错误,获取文件失败"),
	/**失败 异常*/
	EXCEPTION(60002, "失败,异常"),
	/**失败 异常*/
	INTERFACE_FAIL(60003, "失败,接口调用失败"),
	/**合同信息未完善*/
	HETONG_NOT(522, "合同信息未完善"),
	/** 不能确认合同!订单状态没有通过 */
	CONTRACT_NOT_STATUS_FAIL(523, "不能确认合同!订单状态没有通过"),
	/** 本订单不能发起退款 */
	ORDER_NOT_REFUND(524,"本订单不能发起退款"),
	/** 合同已确认,不能解绑VSN */
	UNBAIND_VSN_ERROR(525,"合同已确认,不能解绑VSN"),
	/** 合同已确认,不能解绑VIN */
	UNBAIND_VIN_ERROR(525,"合同已确认,不能解绑VIN"),
	/** 合同已确认,不能解绑VIN */
	UNZIP_INVOICE_NULLFILE(526,"解压异常"),
	/** 未完成的功能 */
	UNFINISHED_FUNCTIONS(527,"未完成的功能"),
	/** Order_no 为空*/
	ORDERNO_NULL(528,"orderNo 为空"),
	/**	导入失败,该日期不存在对账数据 */
	DATA_NULL(529,"导入失败,该日期不存在对账数据"),
	/** 导入失败*/
	POS_NULL(530,"billPoss为空"),
	/** 操作失败 */
	OPERATING_NULL(531,"操作失败"),
	/**未确认分期表*/
	INSTALMENT_APPLY_NOT(532,"未确认分期"),
	/**以保存,请勿重复提交*/
	NOT_SUBMIT(532,"以保存,请勿重复提交"),
	/** 分期申请没有通过 */
	APPLY_NOT_STATUS(533,"分期申请没有通过!"),
	/** 分期申请不存在 */
	APPLY_NOT_EXIST(534,"分期申请不存在!"),
	/** 分期申请不存在 */
	PAY_REPEAT(535,"付款条件重复!"),
	/** 上传的文件格式错误 */
	UPLOAD_FILE_FORMAT_ERROR(536,"上传的文件格式错误");
	
	
	private int code;
	private String msg;
	
	private ResultCode(int code,String msg){
		this.code = code;
		this.msg = msg;
	}
	
	public int getCode(){
		return this.code;
	}
	
	public String getMsg(){
		return this.msg;
	}
}
