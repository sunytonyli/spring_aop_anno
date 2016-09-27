package com.tony.aop.po;

import java.io.Serializable;

/**
 * @author songyu.li@yeepay.com
 * @createDatetime 2016年4月18日 下午8:03:32
 */

public class PdsOrder implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 339783047276344958L;

	private String PTDealerID;
	private String OutOrderNo;
	private String TradeDate;
	private String Sign;
	public String getPTDealerID() {
		return PTDealerID;
	}
	public void setPTDealerID(String pTDealerID) {
		PTDealerID = pTDealerID;
	}
	public String getOutOrderNo() {
		return OutOrderNo;
	}
	public void setOutOrderNo(String outOrderNo) {
		OutOrderNo = outOrderNo;
	}
	public String getTradeDate() {
		return TradeDate;
	}
	public void setTradeDate(String tradeDate) {
		TradeDate = tradeDate;
	}
	public String getSign() {
		return Sign;
	}
	public void setSign(String sign) {
		Sign = sign;
	}
}
