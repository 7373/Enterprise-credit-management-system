/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.ndrc.credit.controller;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.icinfo.framework.core.web.BaseController;
import com.icinfo.ndrc.credit.model.NdDept;
import com.icinfo.ndrc.credit.model.NdUploadHandle;
import com.icinfo.ndrc.credit.service.IBatchService;
import com.icinfo.ndrc.credit.service.INdDeptService;
import com.icinfo.ndrc.credit.service.INdTempService;
import com.icinfo.ndrc.credit.service.INdUploadHandleService;
import com.icinfo.ndrc.credit.service.ITempAccidentSuperviseInfoService;
import com.icinfo.ndrc.credit.service.ITempAdminForceInfoService;
import com.icinfo.ndrc.credit.service.ITempAdminPermitService;
import com.icinfo.ndrc.credit.service.ITempAdminPunishService;
import com.icinfo.ndrc.credit.service.ITempBusinessLicenceInfoService;
import com.icinfo.ndrc.credit.service.ITempCommendRewardInfoService;
import com.icinfo.ndrc.credit.service.ITempConstructPersonnelCertificateInfoService;
import com.icinfo.ndrc.credit.service.ITempCreditLevelResultService;
import com.icinfo.ndrc.credit.service.ITempDriveLicenceInfoService;
import com.icinfo.ndrc.credit.service.ITempEnvirClassEvaluateInfoService;
import com.icinfo.ndrc.credit.service.ITempEnvirEffectCheckInfoService;
import com.icinfo.ndrc.credit.service.ITempFinanceGuaranteeCompanyService;
import com.icinfo.ndrc.credit.service.ITempFireAccidentInfoService;
import com.icinfo.ndrc.credit.service.ITempFireControlLicenceInfoService;
import com.icinfo.ndrc.credit.service.ITempGaAdminForceInfoService;
import com.icinfo.ndrc.credit.service.ITempHealthLicenceInfoService;
import com.icinfo.ndrc.credit.service.ITempHealthQualiInfoService;
import com.icinfo.ndrc.credit.service.ITempHealthYearcheckInfoService;
import com.icinfo.ndrc.credit.service.ITempHelpBaseInfoService;
import com.icinfo.ndrc.credit.service.ITempHotelSpecialtyApproveInfoService;
import com.icinfo.ndrc.credit.service.ITempJudicialBaseInfoService;
import com.icinfo.ndrc.credit.service.ITempJudicialUnitInfoService;
import com.icinfo.ndrc.credit.service.ITempLawFirmAssessInfoService;
import com.icinfo.ndrc.credit.service.ITempLowLivingHomeInfoService;
import com.icinfo.ndrc.credit.service.ITempLowLivingPeopleInfoService;
import com.icinfo.ndrc.credit.service.ITempMajorFireInfoService;
import com.icinfo.ndrc.credit.service.ITempManyQyBaseInfoService;
import com.icinfo.ndrc.credit.service.ITempMarriageInfoService;
import com.icinfo.ndrc.credit.service.ITempMaterialAcceptanceUnqualifyInfoService;
import com.icinfo.ndrc.credit.service.ITempOfficeBaseInfoService;
import com.icinfo.ndrc.credit.service.ITempOfficeUnitBaseInfoService;
import com.icinfo.ndrc.credit.service.ITempOfficialSealApproveInfoService;
import com.icinfo.ndrc.credit.service.ITempPeopleQualiInfoService;
import com.icinfo.ndrc.credit.service.ITempPrintActivityInfoService;
import com.icinfo.ndrc.credit.service.ITempProduceSafeAccidentService;
import com.icinfo.ndrc.credit.service.ITempProjectApproveService;
import com.icinfo.ndrc.credit.service.ITempPublicSchoolInfoService;
import com.icinfo.ndrc.credit.service.ITempPublicSchoolTeacherInfoService;
import com.icinfo.ndrc.credit.service.ITempQyHeadInfoService;
import com.icinfo.ndrc.credit.service.ITempQyServeyQualiInfoService;
import com.icinfo.ndrc.credit.service.ITempRedBlackListService;
import com.icinfo.ndrc.credit.service.ITempRepairLicenceInfoService;
import com.icinfo.ndrc.credit.service.ITempReviewAcceptanceInfoService;
import com.icinfo.ndrc.credit.service.ITempRewardInfoService;
import com.icinfo.ndrc.credit.service.ITempSafeProduceLincenceService;
import com.icinfo.ndrc.credit.service.ITempSecurityApproveInfoService;
import com.icinfo.ndrc.credit.service.ITempSeedManagePermitService;
import com.icinfo.ndrc.credit.service.ITempSociaOrganCheckInfoService;
import com.icinfo.ndrc.credit.service.ITempSociaOrganClassInfoService;
import com.icinfo.ndrc.credit.service.ITempSociaOrganInfoService;
import com.icinfo.ndrc.credit.service.ITempSuperviseInspectDeceptionInfoService;
import com.icinfo.ndrc.credit.service.ITempTaxCreditLevelService;
import com.icinfo.ndrc.credit.service.ITempTaxOweService;
import com.icinfo.ndrc.credit.service.ITempTraditionalArtInditifyInfoService;
import com.icinfo.ndrc.credit.service.ITempViolateSportInfoService;
import com.icinfo.ndrc.credit.service.IUploadService;
import com.icinfo.ndrc.support.Constants;
import com.icinfo.ndrc.system.model.SysUser;
import com.icinfo.ndrc.util.UUIDUtils;

/**
 * 描述:
 *
 * 
 */
@Controller
@RequestMapping("/credit/upload")
public class UploadController extends BaseController {

	public final static String[] SHEETNAME = { 
			"0_安全生产许可证", "1_生产安全事故信息", "2_重大事故隐患挂牌督办信息", "3_查封、扣押等行政强制信息","4_表彰奖励信息",
			"5_黑名单", "6_红名单", "7_林木种子生产经营许可",
			"17_所属管理的公办学校信息", "18_所属公办学校的教师信息", "19_纳税信用等级评定信息", "20_企业（个体工商户）欠税信息", "21_测绘企业资质信息", "22_评估机构基本情况",
			"23_企业负责人信息", "24_建筑施工三类人员证书信息", "25_行政许可", "26_行政处罚", "27_项目核准信息", "28_融资性担保公司的设立与变更信息",
			"29_县属国有企业及城区工业项目固定资产投资节能审查及节能验收信息", "30_传统工艺美术品种、技艺、精品、大师认定信息", "31_使用新型墙体材料验收不合格信息","32_设立保安培训机构审批信息","33_旅馆业特种行业许可证信息","34_公章刻制业特种行业许可证信息",
			"35_消防安全许可信息（建设工程消防设计审核、建设工程消防验收）","36_重大火灾隐患信息","37_火灾事故信息","38_行政强制信息 ","39_违反体育道德、弄虚作假、徇私舞弊的处理信息","40_民办非、中介机构等弄虚作假的监督检查","41_个人从事其他印刷品印刷经营活动信息","42_设立从事包装装潢印刷品和其他印刷品印刷经营活动的企业信息","43_奖励信息",
			"100_客运经营许可信息","101_货运经营许可信息", "102_出租车经营许可信息", "103_场站经营许可信息", "104_驾培经营许可信息", "105_维修经营许可信息",
			"106_交通企业信用等级考核结果信息（客、货运、场站）", "107_交通企业信用等级考核结果信息（出租车）", "108_交通企业信用等级考核结果信息（驾培学校）",
			"109_交通企业信用等级考核结果信息（维修企业）", "110_交通企业信用等级考核结果信息（租赁企业）", "111_道路运输从业人员资格信息及信用评价结果（出租车人员）",
			"112_道路运输从业人员资格信息及信用评价结果（客、货运从业人员）", "113_道路运输从业人员资格信息（维修）", "50_环境影响评价文件审批信息", "51_环境等级评定信息",
			"52_机关、事业人员基本信息", "53_机关、事业单位信息", "54_婚姻信息", "55_低保家庭信息" ,"56_低保人员信息","57_救助基本信息","58_社会组织信息",
			"59_社会组织等级评估信息","60_社会组织年检信息","61_基层法律服务所信息","62_律师事务所信息","63_公证机构基本信息","64_律师基本信息","65_基层法律服务工作者基本信息",
			"66_公证员基本信息","67_律师事务所年度考核信息",
			
			"200_县级注册的医疗卫生机构设置执业许可","201_县级注册的医疗机构年检","202_县级注册的母婴保健专项技术服务许可",
			"203_县级注册的医护人员执业注册信息","204_县级注册的母婴保健专项技术服务人员资格信息"
			
			
			
	};
	@Autowired
	private ITempAccidentSuperviseInfoService tempAccidentSuperviseInfoService;
	@Autowired
	private ITempRedBlackListService tempRedBlackListService;
	@Autowired
	private INdTempService ndTempService;
	@Autowired
	ITempSafeProduceLincenceService tempSafeProduceLincenceService;
	@Autowired
	ITempSeedManagePermitService tempSeedManagePermitService;
	@Autowired
	INdDeptService ndDeptService;
	@Autowired
	IUploadService uploadService;
	@Autowired
	private ITempPublicSchoolInfoService tempPublicSchoolInfoService;
	@Autowired
	private ITempTaxCreditLevelService tempTaxCreditLevelService;
	@Autowired
	private ITempPublicSchoolTeacherInfoService tempPublicSchoolTeacherInfoService;
	@Autowired
	ITempProduceSafeAccidentService tempProduceSafeAccidentService;
	@Autowired
	ITempAdminForceInfoService tempAdminForceInfoService;
	@Autowired
	ITempBusinessLicenceInfoService tempBusinessLicenceInfoService;
	@Autowired
	private ITempTaxOweService tempTaxOweService;
	@Autowired
	private ITempQyServeyQualiInfoService tempQyServeyQualiInfoService;
	@Autowired
	private ITempManyQyBaseInfoService tempManyQyBaseInfoService;
	@Autowired
	private ITempDriveLicenceInfoService tempDriveLicenceInfoService;
	@Autowired
	private ITempQyHeadInfoService tempQyHeadInfoService;
	@Autowired
	private ITempEnvirEffectCheckInfoService tempEnvirEffectCheckInfoService;
	@Autowired
	private ITempConstructPersonnelCertificateInfoService tempConstructPersonnelCertificateInfoService;
	@Autowired
	private ITempAdminPermitService tempAdminPermitService;
	@Autowired
	private ITempAdminPunishService tempAdminPunishService;
	@Autowired
	private ITempRepairLicenceInfoService tempRepairLicenceInfoService;
	@Autowired
	private ITempEnvirClassEvaluateInfoService tempEnvirClassEvaluateInfoService;
	@Autowired
	private ITempOfficeBaseInfoService tempOfficeBaseInfoService;
	@Autowired
	private ITempOfficeUnitBaseInfoService tempOfficeUnitBaseInfoService;
	@Autowired
	private ITempMarriageInfoService tempMarriageInfoService;
	@Autowired
	private ITempProjectApproveService tempProjectApproveService;
	@Autowired
	private ITempFinanceGuaranteeCompanyService tempFinanceGuaranteeCompanyService;
	@Autowired
	private ITempReviewAcceptanceInfoService tempReviewAcceptanceInfoService;
	@Autowired
	private ITempTraditionalArtInditifyInfoService tempTraditionalArtInditifyInfoService;
	@Autowired
	private ITempMaterialAcceptanceUnqualifyInfoService tempMaterialAcceptanceUnqualifyInfoService;
	@Autowired
	private ITempLowLivingHomeInfoService tempLowLivingHomeInfoService;
	@Autowired
	private ITempLowLivingPeopleInfoService tempLowLivingPeopleInfoService;
	@Autowired
	private ITempHelpBaseInfoService tempHelpBaseInfoService;
	@Autowired
	private ITempSociaOrganInfoService tempSociaOrganInfoService;
	
	@Autowired
	private ITempCreditLevelResultService tempCreditLevelResultService;
	@Autowired
	private ITempPeopleQualiInfoService tempPeopleQualiInfoService;
	@Autowired
	private ITempSecurityApproveInfoService tempSecurityApproveInfoService;
	@Autowired
	private ITempHotelSpecialtyApproveInfoService tempHotelSpecialtyApproveInfoService;
	@Autowired
	private ITempOfficialSealApproveInfoService tempOfficialSealApproveInfoService;
	@Autowired
	private ITempHealthLicenceInfoService tempHealthLicenceInfoService;
	@Autowired
	private ITempFireControlLicenceInfoService tempFireControlLicenceInfoService;
	@Autowired
	private ITempMajorFireInfoService tempMajorFireInfoService;
	@Autowired
	private ITempHealthYearcheckInfoService tempHealthYearcheckInfoService;
	@Autowired
	private ITempHealthQualiInfoService tempHealthQualiInfoService;
	@Autowired
	private ITempFireAccidentInfoService tempFireAccidentInfoService;
	@Autowired
	private ITempGaAdminForceInfoService tempGaAdminForceInfoService;
	@Autowired
	ITempSociaOrganClassInfoService tempSociaOrganClassInfoService;
	@Autowired
	ITempCommendRewardInfoService tempCommendRewardInfoService;
	@Autowired
	ITempSociaOrganCheckInfoService tempSociaOrganCheckInfoService;
	@Autowired
	ITempJudicialUnitInfoService tempJudicialUnitInfoService;
	@Autowired
	private ITempViolateSportInfoService tempViolateSportInfoService;
	@Autowired
	private ITempSuperviseInspectDeceptionInfoService tempSuperviseInspectDeceptionInfoService;
	@Autowired
	private ITempPrintActivityInfoService tempPrintActivityInfoService;
	@Autowired
	private ITempRewardInfoService tempRewardInfoService;
	@Autowired
	INdUploadHandleService ndUploadHandleService;
	@Autowired
	ITempJudicialBaseInfoService tempJudicialBaseInfoService;
	@Autowired
	ITempLawFirmAssessInfoService tempLawFirmAssessInfoService;
	
	
	/**
	 * 进入数据导入页面
	 * 
	 * @author zjj
	 * @throws Exception
	 */
	@RequestMapping(value = "/views")
	public ModelAndView views(HttpSession session) throws Exception {
		SysUser user = (SysUser) session.getAttribute(Constants.SESSION_SYS_USER);
		ModelAndView mv = new ModelAndView("credit/system/upload_list");
		mv.addObject("user", user);

		NdDept ndDept = ndDeptService.findByDepCode(user.getDept());
		mv.addObject("deptFileName", uploadService.doGetFileName(ndDept.getDepName()));
		return mv;
	}

	@RequestMapping(value = "/uploadFile", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String upload(@RequestParam(value = "btnFile") MultipartFile files, String fileName, HttpServletRequest req)
			throws Exception {
		SysUser sysUser = (SysUser) req.getSession().getAttribute(Constants.SESSION_SYS_USER);
		String depCode = sysUser.getDept();

		InputStream is = files.getInputStream();
		POIFSFileSystem fs = new POIFSFileSystem(is);
		HSSFWorkbook workbook = new HSSFWorkbook(fs);
		HSSFSheet sheet = null;

		Map<String, Integer> sheetNamesMap = new HashMap<String, Integer>();
		for (int i = 0; i < SHEETNAME.length; i++) {
			sheetNamesMap.put(SHEETNAME[i], i);
		}
		int count = validSheetCount(SHEETNAME, workbook);
		if (count == 0)
			return "error" + ",没有可用的sheet";

		String msg = "";
		String bacthNO = UUIDUtils.randomUUID();
		List<IBatchService> IBatchServiceList = new ArrayList<IBatchService>();
		for (int i = 0; i < workbook.getNumberOfSheets(); i++) {
			sheet = workbook.getSheetAt(i);
			String sheetName = sheet.getSheetName();
			for (String name : SHEETNAME) {
				if (name.endsWith("_" + sheetName)) {
					switch (Integer.parseInt((name.split("_")[0]))) {
					case 0:
						msg = tempSafeProduceLincenceService.record(depCode, sheet, bacthNO);// 安全生产许可证
						IBatchServiceList.add(tempSafeProduceLincenceService);
						break;
					 case 1:
						msg =tempProduceSafeAccidentService.record(depCode,sheet,bacthNO);//生产安全事故信息
					 	IBatchServiceList.add(tempProduceSafeAccidentService);
					 	break;
					case 2:
						msg = tempAccidentSuperviseInfoService.record(depCode, sheet, bacthNO);// 重大事故隐患挂牌督办信息
						IBatchServiceList.add(tempAccidentSuperviseInfoService);
						break;
					case 3: 
						msg = tempAdminForceInfoService.record(depCode,sheet,bacthNO);
						IBatchServiceList.add(tempAdminForceInfoService);
						break;
					case 4:
						msg = tempCommendRewardInfoService.record(depCode,sheet,bacthNO);
						IBatchServiceList.add(tempCommendRewardInfoService);
						break;
					case 5:
						msg = tempRedBlackListService.record(depCode, sheet, bacthNO, "b");// 黑名单
						IBatchServiceList.add(tempRedBlackListService);
						break;
					case 6:
						msg = tempRedBlackListService.record(depCode, sheet, bacthNO, "r");// 红名单
						IBatchServiceList.add(tempRedBlackListService);
						break;
					case 7:
						msg = tempSeedManagePermitService.record(depCode, sheet, bacthNO);// 林木种子生产经营种类许可
						IBatchServiceList.add(tempSeedManagePermitService);
						break;
					case 17:
						msg = tempPublicSchoolInfoService.record(depCode, sheet, bacthNO);
						IBatchServiceList.add(tempPublicSchoolInfoService);
						break;
					case 18:
						msg = tempPublicSchoolTeacherInfoService.record(depCode, sheet, bacthNO);
						IBatchServiceList.add(tempPublicSchoolTeacherInfoService);
						break;
					case 19:
						msg = tempTaxCreditLevelService.record(depCode, sheet, bacthNO);
						IBatchServiceList.add(tempTaxCreditLevelService);
						break;
					case 20:
						msg = tempTaxOweService.record(depCode, sheet, bacthNO);
						IBatchServiceList.add(tempTaxOweService);
						break;
					case 21:
						msg = tempQyServeyQualiInfoService.record(depCode, sheet, bacthNO);
						IBatchServiceList.add(tempQyServeyQualiInfoService);
						break;
					case 22:
						msg = tempManyQyBaseInfoService.record(depCode, sheet, bacthNO);
						IBatchServiceList.add(tempManyQyBaseInfoService);
						break;
					case 23:
						msg = tempQyHeadInfoService.record(depCode, sheet, bacthNO);
						IBatchServiceList.add(tempQyHeadInfoService);
						break;

					case 100:// 经营许可信息
					case 101:// 经营许可信息
					case 102:// 经营许可信息
					case 103:// 经营许可信息
						msg = tempBusinessLicenceInfoService.record(depCode, sheet, bacthNO);
						IBatchServiceList.add(tempBusinessLicenceInfoService);
						break;
					case 104: // 驾培经营许可信息
						msg = tempDriveLicenceInfoService.record(depCode, sheet, bacthNO);
						IBatchServiceList.add(tempDriveLicenceInfoService);
						break;
					case 105: // 维修经营许可信息

						msg = tempRepairLicenceInfoService.record(depCode, sheet, bacthNO);
						IBatchServiceList.add(tempRepairLicenceInfoService);
						break;
					case 106: // 考核结果
					case 107: // 考核结果
					case 108: // 考核结果
					case 109: // 考核结果
					case 110: // 考核结果
						msg = tempCreditLevelResultService.record(depCode, sheet, bacthNO);
						IBatchServiceList.add(tempCreditLevelResultService);
						break;
					case 111:
					case 112:
					case 113:
						msg = tempPeopleQualiInfoService.record(depCode, sheet, bacthNO);
						IBatchServiceList.add(tempPeopleQualiInfoService);
						break;
						
					case 200:
					case 202:
						msg = tempHealthLicenceInfoService.record(depCode, sheet, bacthNO);
						IBatchServiceList.add(tempHealthLicenceInfoService);
						break;
						
					case 201:
						msg = tempHealthYearcheckInfoService.record(depCode, sheet, bacthNO);
						IBatchServiceList.add(tempHealthYearcheckInfoService);
						break;
						
					case 203:
					case 204:
						msg = tempHealthQualiInfoService.record(depCode, sheet, bacthNO);
						IBatchServiceList.add(tempHealthQualiInfoService);
						break;
						
					case 24:
						msg = tempConstructPersonnelCertificateInfoService.record(depCode, sheet, bacthNO);
						IBatchServiceList.add(tempConstructPersonnelCertificateInfoService);
						break;
					case 25:
						msg = tempAdminPermitService.record(depCode, sheet, bacthNO);
						IBatchServiceList.add(tempAdminPermitService);
						break;
					case 26:
						msg = tempAdminPunishService.record(depCode, sheet, bacthNO);
						IBatchServiceList.add(tempAdminPunishService);
						break;

					case 50:
						msg = tempEnvirEffectCheckInfoService.record(depCode, sheet, bacthNO);
						 IBatchServiceList.add(tempEnvirEffectCheckInfoService);
						break;
					case 51:
						msg = tempEnvirClassEvaluateInfoService.record(depCode, sheet, bacthNO);
						 IBatchServiceList.add(tempEnvirClassEvaluateInfoService);
						break;
					case 52:
						msg = tempOfficeBaseInfoService.record(depCode, sheet, bacthNO);
						 IBatchServiceList.add(tempOfficeBaseInfoService);
						break;

					case 53:
						msg = tempOfficeUnitBaseInfoService.record(depCode, sheet, bacthNO);
						 IBatchServiceList.add(tempOfficeUnitBaseInfoService);
						break;
					case 54:
						msg = tempMarriageInfoService.record(depCode, sheet, bacthNO);
						 IBatchServiceList.add(tempMarriageInfoService);
						break;

					case 55:
						msg = tempLowLivingHomeInfoService.record(depCode, sheet, bacthNO);
						 IBatchServiceList.add(tempLowLivingHomeInfoService);
						break;
					case 56:
						msg = tempLowLivingPeopleInfoService.record(depCode, sheet, bacthNO);
						 IBatchServiceList.add(tempLowLivingPeopleInfoService);
						break;
					case 57:
						msg = tempHelpBaseInfoService.record(depCode, sheet, bacthNO);
						 IBatchServiceList.add(tempHelpBaseInfoService);
						break;
					case 58:
						msg = tempSociaOrganInfoService.record(depCode, sheet, bacthNO);
						 IBatchServiceList.add(tempSociaOrganInfoService);
						break;	
					case 27:
						msg=tempProjectApproveService.record(depCode, sheet, bacthNO);
						IBatchServiceList.add(tempProjectApproveService);	
						break;
					case 28:
						msg = tempFinanceGuaranteeCompanyService.record(depCode, sheet, bacthNO);
						IBatchServiceList.add(tempFinanceGuaranteeCompanyService);
						break;
					case 29:
						msg = tempReviewAcceptanceInfoService.record(depCode, sheet, bacthNO);
						IBatchServiceList.add(tempReviewAcceptanceInfoService);
						break;
					case 30:
						msg = tempTraditionalArtInditifyInfoService.record(depCode, sheet, bacthNO);
						IBatchServiceList.add(tempTraditionalArtInditifyInfoService);
						break;
					case 31:
						msg=tempMaterialAcceptanceUnqualifyInfoService.record(depCode, sheet, bacthNO);
						IBatchServiceList.add(tempMaterialAcceptanceUnqualifyInfoService);
						break;
					case 32:
						msg = tempSecurityApproveInfoService.record(depCode, sheet, bacthNO);
						IBatchServiceList.add(tempSecurityApproveInfoService);
						break;
					case 33:
						msg = tempHotelSpecialtyApproveInfoService.record(depCode, sheet, bacthNO);
						IBatchServiceList.add(tempHotelSpecialtyApproveInfoService);
						break;
					case 34:
						msg = tempOfficialSealApproveInfoService.record(depCode, sheet, bacthNO);
						IBatchServiceList.add(tempOfficialSealApproveInfoService);
						break;
					case 35:
						msg = tempFireControlLicenceInfoService.record(depCode, sheet, bacthNO);
						IBatchServiceList.add(tempFireControlLicenceInfoService);
						break;
					case 36:
						msg = tempMajorFireInfoService.record(depCode, sheet, bacthNO);
						IBatchServiceList.add(tempMajorFireInfoService);
						break;
					case 37:
						msg = tempFireAccidentInfoService.record(depCode, sheet, bacthNO);
						IBatchServiceList.add(tempFireAccidentInfoService);
						break;
					case 38:
						msg = tempGaAdminForceInfoService.record(depCode, sheet, bacthNO);
						IBatchServiceList.add(tempGaAdminForceInfoService);
						break;
					case 59:
						msg = tempSociaOrganClassInfoService.record(depCode, sheet, bacthNO);
						IBatchServiceList.add(tempSociaOrganClassInfoService);
						break;
					case 60:
						msg = tempSociaOrganCheckInfoService.record(depCode, sheet, bacthNO);
						IBatchServiceList.add(tempSociaOrganCheckInfoService);
						break;
					case 61://基层法律服务所信息
					case 62://律师事务所信息
					case 63://公证机构基本信息
						msg = tempJudicialUnitInfoService.record(depCode, sheet, bacthNO);
						IBatchServiceList.add(tempJudicialUnitInfoService);	
						break;
					case 39:
						msg = tempViolateSportInfoService.record(depCode, sheet, bacthNO);
						IBatchServiceList.add(tempViolateSportInfoService);
						break;
					case 40:
						msg = tempSuperviseInspectDeceptionInfoService.record(depCode, sheet, bacthNO);
						IBatchServiceList.add(tempSuperviseInspectDeceptionInfoService);
						break;
					case 41:
						msg = tempPrintActivityInfoService.record(depCode, sheet, bacthNO);
						IBatchServiceList.add(tempPrintActivityInfoService);
						break;
					case 42:
						msg = tempPrintActivityInfoService.record(depCode, sheet, bacthNO);
						IBatchServiceList.add(tempPrintActivityInfoService);
						break;
					case 43:
						msg = tempRewardInfoService.record(depCode, sheet, bacthNO);
						IBatchServiceList.add(tempRewardInfoService);
						break;
					case 64://律师基本信息
					case 65://基层法律服务工作者基本信息
					case 66://公证员基本信息
						msg = tempJudicialBaseInfoService.record(depCode, sheet, bacthNO);
						IBatchServiceList.add(tempJudicialBaseInfoService);
						break;
					case 67 ://律师事务所年度考核信息
//						mgs = tempLawFirmAssessInfoService.recodee
					}

					String[] msgs = msg.split(",");
					if ("error".equals(msgs[0])) {
						for (IBatchService iBatchService : IBatchServiceList) {
							iBatchService.deleteByBatchNo(bacthNO);
						}
						return msg;
					}
				}
			}
		}
		//插入文件导入详情
		ndUploadHandleService.insert(new NdUploadHandle(depCode,fileName,sysUser.getUsername(),bacthNO));
		
		return "success,文件上传成功";
	}

	/**
	 * 描述：有效的sheet数量统计
	 * 
	 * @author MaYawei
	 * @date 2015-12-28
	 * @param sheetNamesArr
	 * @param workbook
	 * @return
	 */
	private int validSheetCount(String[] sheetNamesArr, HSSFWorkbook workbook) {
		StringBuffer tempStr = new StringBuffer();
		int count = 0;
		for (String sheetName : sheetNamesArr) {
			tempStr.append(sheetName.split("_")[1] + "-");
		}
		for (int i = 0; i < workbook.getNumberOfSheets(); i++) {
			if (tempStr.toString().contains(workbook.getSheetAt(i).getSheetName()))
				count++;
		}
		return count;
	}

	@RequestMapping("/goSelectgUploadPage")
	public ModelAndView goSelectgUploadPage(HttpServletRequest req) throws Exception {
		SysUser sysUser = (SysUser) req.getSession().getAttribute(Constants.SESSION_SYS_USER);
		String depCode = sysUser.getDept();
		ModelAndView mav = ndTempService.doGetViews(depCode);
		mav.addObject("depCode", depCode);
		return mav;
	}

	/**
	 * 下载模板
	 * 
	 * @author zjj
	 */
	@RequestMapping("/downTemple")
	public ResponseEntity<byte[]> downTemple(HttpSession session, HttpServletRequest request) throws Exception {
		SysUser user = (SysUser) session.getAttribute(Constants.SESSION_SYS_USER);
		NdDept ndDept = ndDeptService.findByDepCode(user.getDept());
		String fileName = uploadService.doGetFileName(ndDept.getDepName());
		return uploadService.downTemple(fileName, request, ndDept.getDepName());
	}
}
