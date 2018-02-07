package lxp.controller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.annotations.Param;
import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItem;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import lxp.util.AliOSSUtils;
import lxp.util.Result;

/**
 * @author lxp   图片上传 到oss
 * @date 2018年2月7日 下午2:33:32
 * @param
 * @return
 */
@RestController
public class ImageUploadController {
	
	@RequestMapping("/upload")
	public Result upload(@Param("file")MultipartFile file) throws IOException {
		
		//将MultipartFile 转换成  File
		String fileName =file.getOriginalFilename();
		InputStream inputStream = file.getInputStream();
		String uploadObject2OSS = AliOSSUtils.uploadObject2OSS(inputStream,fileName);
		
		
		//InputStream inputStream = file.getInputStream();
		//AliOSSUtils.uploadObject2OSS(file);
		
//		try {
//			//file.transferTo(new File("D://"));
//		} catch (IllegalStateException | IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		return new Result(uploadObject2OSS); 
	}
	
}

