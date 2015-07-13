package com.kiki.core.bean;

/**
 * 统一返回对象
 * 
 * @author baodk
 */
public class ResponseResult implements java.io.Serializable {
  private static final String SUCCESS = "200";

  /**
	 * 
	 */
  private static final long serialVersionUID = 1L;

  /** 是否成功 */
  private boolean success = true;

  /** 返回对象类型数据 */
  private Object info;

  /** 信息编码 */
  private String code;

  /** 提升信息 */
  private String message;

  /**
   * Creates a new instance of ResponseResult.
   * 
   */

  public ResponseResult() {

    this.success = true;
    this.code = SUCCESS;
  }

  public boolean isSuccess() {
    return success;
  }

  public void setSuccess(boolean success) {
    this.success = success;
  }

  public Object getInfo() {
    return info;
  }

  public void setInfo(Object info) {
    this.info = info;
  }

  public String getCode() {
    return code;
  }


  public void setCode(String code) {
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
    return "ResponseResult [success=" + success + ", info=" + info + ", code=" + code
        + ", message=" + message + "]";
  }

}
