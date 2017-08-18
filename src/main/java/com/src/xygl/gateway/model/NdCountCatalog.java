package com.icinfo.ndrc.gateway.model;

import java.util.Date;

import javax.persistence.Column;

import com.fasterxml.jackson.annotation.JsonFormat;

public class NdCountCatalog {
	
	@Column(name="CountCreditDynamic")
	private Integer countCreditDynamic;
	
	@Column(name ="TimeCreditDynamic")
	@JsonFormat(pattern ="yyyy-MM-dd",timezone = "GMT+8")
	private Date timeCreditDynamic;
	
	@Column(name="CountPolicy")
	private Integer countPolicy;
	
	@Column(name = "TimePolicy")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date timePolicy;
	
	@Column(name="CountCreditRule")
	private Integer countCreditRule;
	
	@Column(name = "TimeCreditRule")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date timeCreditRule;
	
	@Column(name="CountVideo")
	private Integer countVideo;
	
	@Column(name = "TimeVideo")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date timeVideo;
	
	@Column(name="CountSevenDouble")
	private Integer countSevenDouble;
	
	@Column(name = "TimeSevenDouble")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date timeSevenDouble;
	
	@Column(name="CountRedList")
	private Integer countRedList;
	
	@Column(name = "TimeRedList")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date timeRedList;
	
	@Column(name="CountBlackList")
	private Integer countBlackList;
	
	@Column(name = "TimeBlackList")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date timeBlackList;

	public Integer getCountCreditDynamic() {
		return countCreditDynamic;
	}

	public void setCountCreditDynamic(Integer countCreditDynamic) {
		this.countCreditDynamic = countCreditDynamic;
	}

	public Integer getCountPolicy() {
		return countPolicy;
	}

	public void setCountPolicy(Integer countPolicy) {
		this.countPolicy = countPolicy;
	}

	public Integer getCountCreditRule() {
		return countCreditRule;
	}

	public void setCountCreditRule(Integer countCreditRule) {
		this.countCreditRule = countCreditRule;
	}

	public Integer getCountVideo() {
		return countVideo;
	}

	public void setCountVideo(Integer countVideo) {
		this.countVideo = countVideo;
	}

	public Integer getCountSevenDouble() {
		return countSevenDouble;
	}

	public void setCountSevenDouble(Integer countSevenDouble) {
		this.countSevenDouble = countSevenDouble;
	}

	public Integer getCountRedList() {
		return countRedList;
	}

	public void setCountRedList(Integer countRedList) {
		this.countRedList = countRedList;
	}

	public Integer getCountBlackList() {
		return countBlackList;
	}

	public void setCountBlackList(Integer countBlackList) {
		this.countBlackList = countBlackList;
	}

	public Date getTimeCreditDynamic() {
		return timeCreditDynamic;
	}

	public void setTimeCreditDynamic(Date timeCreditDynamic) {
		this.timeCreditDynamic = timeCreditDynamic;
	}

	public Date getTimePolicy() {
		return timePolicy;
	}

	public void setTimePolicy(Date timePolicy) {
		this.timePolicy = timePolicy;
	}

	public Date getTimeCreditRule() {
		return timeCreditRule;
	}

	public void setTimeCreditRule(Date timeCreditRule) {
		this.timeCreditRule = timeCreditRule;
	}

	public Date getTimeVideo() {
		return timeVideo;
	}

	public void setTimeVideo(Date timeVideo) {
		this.timeVideo = timeVideo;
	}

	public Date getTimeSevenDouble() {
		return timeSevenDouble;
	}

	public void setTimeSevenDouble(Date timeSevenDouble) {
		this.timeSevenDouble = timeSevenDouble;
	}

	public Date getTimeRedList() {
		return timeRedList;
	}

	public void setTimeRedList(Date timeRedList) {
		this.timeRedList = timeRedList;
	}

	public Date getTimeBlackList() {
		return timeBlackList;
	}

	public void setTimeBlackList(Date timeBlackList) {
		this.timeBlackList = timeBlackList;
	}
	
	
}
