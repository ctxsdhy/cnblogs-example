package org.xs.demo;

import java.io.File;
import java.util.UUID;

import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import com.qiniu.storage.UploadManager;
import com.qiniu.util.Auth;

/**
 * 七牛上传帮助类
 */
public class QiniuHelper {
	
    /**
     * 空间名
     */
    private static String Scope = "test";
    
    /**
     * 域名
     */
    private static String Url = "oaxe0ctnh.bkt.clouddn.com";
    
    /**
     * 公钥
     */
    private static String ACCESS_KEY = "9whRm1DW4wOAohxp-qDmZqA2XVkM0f64hJdiEf0V";
    
    private static String SECRET_KEY = "n6rAKRX2F29Kg_Gj0S0SjJAsJFxwhtD6akFdUvB8";
    
    /**
     * 上传附件
     * @throws QiniuException 
     */
    public static String UploadFile(File file) throws QiniuException {
    	
    	String key = UUID.randomUUID().toString().replaceAll("-", "");
    	
    	try {
	    	//创建上传对象
	    	UploadManager uploadManager = new UploadManager();
	    	
	    	//密钥配置
	    	Auth auth = Auth.create(ACCESS_KEY, SECRET_KEY);
	    	
	    	//上传文件
	    	Response res = uploadManager.put(file, key, auth.uploadToken(Scope, key));
    	} catch (Exception e) {
    		return "";
    	}
    	return key;
    }
    
    /**
     * 获得url地址
     */
    public static String GetUrl(String key)
    {
        return String.format ("http://%s/%s", Url, key);
    }
}
