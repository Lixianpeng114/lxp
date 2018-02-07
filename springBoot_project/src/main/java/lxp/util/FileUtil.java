package lxp.util;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Iterator;
import java.util.UUID;

import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import lxp.util.date.DateUtils;



/**
 * 文件处理工具类
 * <功能详细描述>
 * 
 * @author  lunzn
 * @version  [版本号, 2017年4月5日]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
public abstract class FileUtil
{
    
    /**
    * 日志记录器
    **/
	private static final Logger LOGGER = LoggerFactory.getLogger(FileUtil.class);
    
    /**
	 * 文件转储
	 * 
	 * @param file
	 * @param request
	 * @return
	 * @throws IOException
	 */
	public static File transferTo(MultipartFile file, String download) throws IOException {

		// 获取当前工程上传目录绝对路径
		String dir =  download;//servletContext.getRealPath("/upload");

		// 拼装新文件名称
		StringBuffer sb = new StringBuffer();
		sb.append(dir);
		//sb.append(File.separator);
		sb.append(System.currentTimeMillis());
		sb.append('.');
		sb.append(FileUtil.getSuffix(file.getOriginalFilename()));

		// 转储文件
		File newFile = new File(sb.toString());

		// 判断图片转储目录是否存在，如果不存在则创建
		if (null != newFile.getParentFile() && !newFile.getParentFile().exists()) {
			boolean flag = newFile.getParentFile().mkdirs();
			LOGGER.info("图片转储目录不存在,重新创建:{}", flag);
		}

		// 文件转储
		file.transferTo(newFile);

		return newFile;
	}
    
    /** 
     * 获取上传文件的真实上传物理地址<br>
     * 返回校验后的图片真实地址
     * @param dir 文件存储目录
     * @param tempPath 临时url
     * @return filepath 校验后的真实文件路径
     * @throws IndexOutOfBoundsException 下标越界异常
     * @throws IOException IO异常
     * @see [类、类#方法、类#成员]
     */
    public static String findUploadRealPath(String dir, String tempPath)
        throws IndexOutOfBoundsException, IOException
    {
        dir = null == dir ? "" : dir;
        tempPath = null == tempPath ? "" : tempPath;
        int lastIndex = tempPath.lastIndexOf("/") + 1;
        String fileName = "";
        if (tempPath.length() > lastIndex)
        {
            fileName = tempPath.substring(lastIndex);
        }
        StringBuilder filePath = new StringBuilder();
        filePath.append(dir).append(File.separator).append(fileName);
        LOGGER.info("查询上传文件的真实路径");
        File file = new File(filePath.toString());
        
        return file.getCanonicalPath();
    }
    
    
    /** 获取文件类型后缀
     * 
     * @param file 文件对象
     * @return 文件后缀
     * @see [类、类#方法、类#成员]
     */
    public static String getSuffix(File file)
    {
        String fileName = file.getName();
        int index = fileName.lastIndexOf(".") + 1;
        String suffix = fileName.substring(index);
        return suffix;
    }
    
    /** 获取文件类型后缀
     * 
     * @param file 文件名
     * @return 文件后缀
     * @throws IOException  IO异常
     * @see [类、类#方法、类#成员]
     */
    public static String getSuffix(String file)
        throws IOException
    {
        String fileName = new File(file).getCanonicalPath();
        int index = fileName.lastIndexOf(".") + 1;
        String suffix = fileName.substring(index);
        return suffix;
    }
    
    /** 
     * 校验文件是否是图片类型
     * 
     * @param file 文件对象
     * @throws IOException IO异常
     * @return boolean
     * @see [类、类#方法、类#成员]
     */
    public static boolean checkFileIsPic(File file)
        throws IOException
    {
        ImageInputStream iis = null;
        try
        {
            iis = ImageIO.createImageInputStream(file);
            Iterator<ImageReader> iter = ImageIO.getImageReaders(iis);
            if (iter.hasNext())
            {
                LOGGER.info("校验的文件 {} 是图片类型", file.getName());
                return true;
            }
            LOGGER.info("校验的文件 {} 不是图片类型", file.getName());
        }
        finally
        {
            iis.close();
        }
        return false;
    }
    
    public static String getNewFileName(){
		Date date = new Date();
		String uuid = UUID.randomUUID().toString().replaceAll("-", "");
		String timeStr = DateUtils.getDateTimeLong(date);
		String name = timeStr + "-" + uuid;// 新的文件名
		return name;
		
	}
    
    /**
     * 获取新的文件名
     * @author tanxin 18/1/12
     * @param fileName 原文件名
     * @return
     */
	public static String getNewFileName(String fileName){
		String suffixName = fileName.substring(fileName.lastIndexOf("."));// 获取文件后缀名
		// 使用uuid+时间当文件名
		Date date = new Date();
		String uuid = UUID.randomUUID().toString().replaceAll("-", "");
		String timeStr = DateUtils.getDateTimeLong(date);
		String name = timeStr + "-" + uuid + suffixName;// 新的文件名
		return name;
	}
	
    
}
