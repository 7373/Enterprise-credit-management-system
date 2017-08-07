package com.icinfo.ndrc.factory;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.chinaoly.oss.SgsOSSClient;
import com.icinfo.ndrc.support.Constants;

@Component
public class OssClientFactory implements FactoryBean<SgsOSSClient>{
	
	@Value("${oss.serverUrl}")
	private  String serverUrl;// oss域名

	@Value("${oss.bucketName}")
	private  String bucketName;// oss bucket名
	
	@Value("${oss.appName}")
	private  String appName;// oss 应用名
	
	@Value("${cloudModel}")
	private String cloudModel;//云模式

	@Override
	public SgsOSSClient getObject() throws Exception {
		if(Constants.CLOUDMODEL_OPEN.equalsIgnoreCase(cloudModel)){
			return new SgsOSSClient(serverUrl, bucketName, appName);
		}
		return null;
	}

	@Override
	public Class<?> getObjectType() {
		return SgsOSSClient.class;
	}

	@Override
	public boolean isSingleton() {
		return true;
	}

	
	public void setServerUrl(String serverUrl) {
		this.serverUrl = serverUrl;
	}

	public void setBucketName(String bucketName) {
		this.bucketName = bucketName;
	}

	public void setAppName(String appName) {
		this.appName = appName;
	}

	public void setCloudModel(String cloudModel) {
		this.cloudModel = cloudModel;
	}
	
	

}
