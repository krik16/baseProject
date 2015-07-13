/**
 * @Copyright (C),上海容易网电子商务有限公司	
 * @Author: 柯军 
 * @datetime:2015年5月20日上午10:26:35
 * @Description: TODO
 *
 **/

package com.kiki.vo;

import java.io.Serializable;
import java.util.Map;

/**
 * @Author: 柯军
 * @Description: MQ消息提现申请参数对应实体
 * @datetime:2015年5月20日上午10:26:35
 * 
 **/

public class MQDrawParam implements Serializable {

	/**
     * 
     */
	private static final long serialVersionUID = -7647979818874548559L;

	private String userId;

	/**
	 * 提现金额
	 */
	private Double drawAmount;

	/**
	 * 提现流水号
	 */
	private String drawNo;

	/**
	 * 订单号
	 */
	private String orderNo;

	/**
	 * (支付账号类型，0：支付宝，1：银联)
	 */
	private Integer payType;

	private String payAccount;

	private String payName;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Double getDrawAmount() {
		return drawAmount;
	}

	public void setDrawAmount(Double drawAmount) {
		this.drawAmount = drawAmount;
	}

	public String getDrawNo() {
		return drawNo;
	}

	public void setDrawNo(String drawNo) {
		this.drawNo = drawNo;
	}

	public Integer getPayType() {
		return payType;
	}

	public void setPayType(Integer payType) {
		this.payType = payType;
	}

	public String getPayAccount() {
		return payAccount;
	}

	public void setPayAccount(String payAccount) {
		this.payAccount = payAccount;
	}

	public String getPayName() {
		return payName;
	}

	public void setPayName(String payName) {
		this.payName = payName;
	}

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public static MQDrawParam mapToEntity(Map<String, Object> map) {
		MQDrawParam mqDrawParam = new MQDrawParam();
		if (map != null) {
			if (map.get("userId") != null)
				mqDrawParam.setUserId(map.get("userId").toString());
			if (map.get("drawAmount") != null)
				mqDrawParam.setDrawAmount(Double.valueOf(map.get("drawAmount").toString()));
			if (map.get("drawNo") != null)
				mqDrawParam.setDrawNo(map.get("drawNo").toString());
			if (map.get("payType") != null)
				mqDrawParam.setPayType(Integer.valueOf(map.get("payType").toString()));
			if (map.get("payAccount") != null)
				mqDrawParam.setPayAccount(map.get("payAccount").toString());
			if (map.get("payName") != null)
				mqDrawParam.setPayName(map.get("payName").toString());
			if (map.get("orderNo") != null)
				mqDrawParam.setOrderNo(map.get("orderNo").toString());
		}
		return mqDrawParam;
	}
}
