package lxp.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.ObjectMetadata;
import com.aliyun.oss.model.PutObjectResult;
import com.aliyun.oss.model.UploadFileRequest;

import lxp.config.OSSConfig;


public class AliOSSUtils {
	
	
	public static String upload(String localFile) throws Throwable{
		String url = "";
		// 创建OSSClient实例
		OSSClient ossClient = new OSSClient(OSSConfig.oss_endpoint, OSSConfig.access_id, OSSConfig.access_key);
		// 设置断点续传请求
		String key = FileUtil.getNewFileName()+"."+FileUtil.getSuffix(localFile);
		UploadFileRequest uploadFileRequest = new UploadFileRequest(OSSConfig.bucket_name, key);
		// 指定上传的本地文件
		uploadFileRequest.setUploadFile(localFile);
		// 指定上传并发线程数
		uploadFileRequest.setTaskNum(5);
		// 指定上传的分片大小
		uploadFileRequest.setPartSize(1 * 1024 * 1024);
		// 开启断点续传
		uploadFileRequest.setEnableCheckpoint(true);
		// 断点续传上传
		ossClient.uploadFile(uploadFileRequest);
		// 关闭client
		ossClient.shutdown();
		url = "https://" + OSSConfig.bucket_name + "." + OSSConfig.oss_endpoint + "/" + key;
		return url;
	}
	
	
	public static void main(String[] args) throws FileNotFoundException {
//		try {
//			String url = AliOSSUtils.upload("D:\\forbidden.jpg");
//			System.out.println(url);
//		} catch (Throwable e) {
//			e.printStackTrace();
//		}
		
//		File file =new File("D:\\lxp.jpg");
//		String uploadObject2OSS = uploadObject2OSS(file);
//		System.out.println(uploadObject2OSS);
		
		File file =new File("D:\\lxp.jpg");
		InputStream is = new FileInputStream(file); 
		String uploadObject2OSS = uploadObject2OSS(is,"lxp.jpg");
		System.out.println(uploadObject2OSS);
	}
	
	
	 /** 
     * 上传图片至OSS 
     * @param ossClient  oss连接 
     * @param file 上传文件（文件全路径如：D:\\image\\cake.jpg） 
     * @param bucketName  存储空间 
     * @param folder 模拟文件夹名 如"qj_nanjing/" 
     * @return String 返回的唯一MD5数字签名 
	 * @throws IOException 
     * */  
    public static String uploadObject2OSS(InputStream is,String fileName)  {  
    	
    	//File file =new File("D:\\lxp.jpg");
    	
    	//String bucketName="lxp14";
    	
    	// oss连接 
    	OSSClient ossClient = new OSSClient(OSSConfig.oss_endpoint, OSSConfig.access_id, OSSConfig.access_key);
    	
    	//名字
    	String key = null;
    	
    	String resultStr = null;  
        try { 
        	
        	key =FileUtil.getNewFileName()+"."+FileUtil.getSuffix(fileName);
            //以输入流的形式上传文件  
            //InputStream is = new FileInputStream(file);  
            //文件名  
            //String fileName = file.getName();   
            //文件大小  
            //Long fileSize = file.length();   
            //创建上传Object的Metadata    
            ObjectMetadata metadata = new ObjectMetadata();  
            //上传的文件的长度  
            metadata.setContentLength(is.available());    
            //指定该Object被下载时的网页的缓存行为  
            metadata.setCacheControl("no-cache");   
            //指定该Object下设置Header  
            metadata.setHeader("Pragma", "no-cache");    
            //指定该Object被下载时的内容编码格式  
            metadata.setContentEncoding("utf-8");    
            //文件的MIME，定义文件的类型及网页编码，决定浏览器将以什么形式、什么编码读取文件。如果用户没有指定则根据Key或文件名的扩展名生成，  
            //如果没有扩展名则填默认值application/octet-stream  
            metadata.setContentType(getContentType(fileName));    
            //指定该Object被下载时的名称（指示MINME用户代理如何显示附加的文件，打开或下载，及文件名称）  
            //metadata.setContentDisposition("filename/filesize=" + fileName + "/" + fileSize + "Byte.");    
            //上传文件   (上传文件流的形式)  
            PutObjectResult putResult = ossClient.putObject(OSSConfig.bucket_name,key,is, metadata);    
            //解析结果  
            resultStr = putResult.getETag();  
        } catch (Exception e) {  
            e.printStackTrace();  
            //logger.error("上传阿里云OSS服务器异常." + e.getMessage(), e);    
        }  
        
        String url = "https://" + OSSConfig.bucket_name + "." + OSSConfig.oss_endpoint + "/" + key;
		return url;
        
        //return resultStr;  
    }
    
    
    /** 
     * 通过文件名判断并获取OSS服务文件上传时文件的contentType 
     * @param fileName 文件名 
     * @return 文件的contentType 
     */  
    public static  String getContentType(String fileName){  
        //文件的后缀名  
        String fileExtension = fileName.substring(fileName.lastIndexOf("."));  
        if(".bmp".equalsIgnoreCase(fileExtension)) {  
            return "image/bmp";  
        }  
        if(".gif".equalsIgnoreCase(fileExtension)) {  
            return "image/gif";  
        }  
        if(".jpeg".equalsIgnoreCase(fileExtension) || ".jpg".equalsIgnoreCase(fileExtension)  || ".png".equalsIgnoreCase(fileExtension) ) {  
            return "image/jpeg";  
        }  
        if(".html".equalsIgnoreCase(fileExtension)) {  
            return "text/html";  
        }  
        if(".txt".equalsIgnoreCase(fileExtension)) {  
            return "text/plain";  
        }  
        if(".vsd".equalsIgnoreCase(fileExtension)) {  
            return "application/vnd.visio";  
        }  
        if(".ppt".equalsIgnoreCase(fileExtension) || "pptx".equalsIgnoreCase(fileExtension)) {  
            return "application/vnd.ms-powerpoint";  
        }  
        if(".doc".equalsIgnoreCase(fileExtension) || "docx".equalsIgnoreCase(fileExtension)) {  
            return "application/msword";  
        }  
        if(".xml".equalsIgnoreCase(fileExtension)) {  
            return "text/xml";  
        }  
        //默认返回类型  
        return "image/jpeg";  
    }
}
