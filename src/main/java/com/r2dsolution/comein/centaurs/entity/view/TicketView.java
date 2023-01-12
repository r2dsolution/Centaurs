package com.r2dsolution.comein.centaurs.entity.view;

import java.math.BigDecimal;
import java.util.Date;

public interface TicketView {

	BigDecimal getAdultRate();

	String getCancelable();

	Integer getCancelBefore();

	BigDecimal getChildRate();

	Long getCompanyId();

	String getCompanyName();

	String getCompanyAddress();

	String getCountry();

	String getDetail();

	Date getEndDate();

	Long getFirstTicketId();

	Long getInventoryId();

	String getProvince();

	Date getStartDate();

	String getTicketCode();

	Long getTicketCount();

	String getTicketStatus();

	Long getTotal();

	Date getTourDate();

	String getTourDesc();

	Long getTourId();

	String getTourName();

	String getTourStatus();

}
