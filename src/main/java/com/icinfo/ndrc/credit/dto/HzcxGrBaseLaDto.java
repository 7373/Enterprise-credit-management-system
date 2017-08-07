/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.ndrc.credit.dto;

import com.icinfo.ndrc.credit.model.HzcxGrBaseLa;

/**
 * 描述: HZCX_GR_BASE_LA 对应的DTO类.<br>
 *
 * @author framework generator
 * @date 2017年06月02日
 */
public class HzcxGrBaseLaDto extends HzcxGrBaseLa {

	/**
	 * 
	 * Copyright© 2003-2017 浙江汇信科技有限公司, All Rights Reserved.
	 * 
	 * @author ranah
	 * @when 2017年6月9日下午2:40:13
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 控制加密变量 @ranah
	 */
	private String sfzhmJm;
	
	/**
	 * 性别显示
	 */
	private String sex;

	public String getSex() {
		
		if (super.getXb() != null)
			return super.getXb().equals("1") ? "男" : "女";
		else
			return null;
	}


	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getSfzhmJm() {
		/**
		 * 防止Sfzhm变量为空；
		 */
		if (super.getSfzhm() != null)
			return super.getSfzhm().substring(0, 10) + "********";
		else
			return null;
	}

	public void setSfzhmJm(String sfzhmJm) {
		this.sfzhmJm = sfzhmJm;
	}
}