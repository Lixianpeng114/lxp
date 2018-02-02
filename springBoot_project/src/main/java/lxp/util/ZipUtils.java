package lxp.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import org.apache.commons.compress.archivers.zip.ZipArchiveEntry;
import org.apache.commons.compress.archivers.zip.ZipArchiveInputStream;
import org.slf4j.Logger;

public class ZipUtils {
	private static byte[] _byte = new byte[2048];

	static Logger log = org.slf4j.LoggerFactory.getLogger(ZipUtils.class);

	/**
	 * 解压到指定目录
	 * 
	 * @param zipPath
	 * @param descDir
	 */
	public static void unZipFiles(String zipPath, String descDir) throws IOException {
		unZipFiles(new File(zipPath), descDir);
	}

	/**
	 * 解压文件到指定目录 解压后的文件名，和之前一致
	 * 
	 * @param zipFile
	 *            待解压的zip文件
	 * @param descDir
	 *            指定目录
	 * @return 返回解压后的文件目录
	 */
	public static List<String> unZipFiles(File zipFile, String descDir) throws IOException {
		if (zipFile == null || descDir == null) {
			return null;
		}
		List<String> fileUrls = new ArrayList<String>();
		ZipFile zip = new ZipFile(zipFile, Charset.forName("GBK"));// 解决中文文件夹乱码
		String name = zip.getName().substring(zip.getName().lastIndexOf('\\') + 1, zip.getName().lastIndexOf('.'));
		File pathFile = new File(descDir + name);
		if (!pathFile.exists()) {
			pathFile.mkdirs();
		}
		for (Enumeration<? extends ZipEntry> entries = zip.entries(); entries.hasMoreElements();) {
			ZipEntry entry = (ZipEntry) entries.nextElement();
			String zipEntryName = entry.getName();
			InputStream in = zip.getInputStream(entry);
			String outPath = (descDir + name + "/" + zipEntryName).replaceAll("\\*", "/");
			log.debug("fileUrl ===> " + outPath);
			// 判断路径是否存在,不存在则创建文件路径
			File file = new File(outPath.substring(0, outPath.lastIndexOf('/')));
			if (!file.exists()) {
				file.mkdirs();
			}
			if (new File(outPath).isDirectory()) {
				continue;
			}
			FileOutputStream out = new FileOutputStream(outPath);
			int len;
			while ((len = in.read(_byte)) > 0) {
				out.write(_byte, 0, len);
			}
			fileUrls.add(outPath);
			in.close();
			out.close();
		}
		zip.close();
		return fileUrls;
	}

	// 测试
//	public static void main(String[] args) throws FileNotFoundException {
//		try {
//			// unZipFiles(new File("E:/bill_test/aliBill.zip"),
//			// "E:/bill_test/");
//			FileInputStream csv = new FileInputStream("E:/bill_test/aliBill/20886219329816520156_20171029_业务明细.csv"); // CSV文件路径
//			BufferedReader br = null;
//			br = new BufferedReader(new InputStreamReader(csv, "GBK"));
//			String line = "";
//			String csvStr = "";
//			try {
//				// 读取到的内容给line变量
//				while ((line = br.readLine()) != null) {
//					csvStr += (line +"\n");
//				}
//				System.out.println(csvStr);
//				String test = csvStr.substring(csvStr.indexOf("支付宝交易号"));
//				String t2 = test.substring(0,test.indexOf("#")); 
//				//System.out.println( test);
//				//System.out.println(t2);
//				csvTest(t2);
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
	
	
//	public static void csvTest(String aliCsv) {
//		System.out.println("================================================");
//		String titleStr = aliCsv.substring(0, aliCsv.indexOf("\n"));
//		String contentStr = aliCsv.substring(aliCsv.indexOf("\n"));
//		String titles[] = titleStr.split(",");
//		String contents[] = contentStr.split("\n");
//		for (String str : contents) {
//			String content[] = str.split(",");
//			System.out.println("------一个对象解析开始---------");
//			for(int i = 0 ;i <content.length ; i++){
//				System.out.println(titles[i].trim() + "\t" + ":" + content[i].trim());
//			}
//			System.out.println("-------一个对象解析结束----------");
//		}
//	}
	
	
	public static List<String> unzip(File zipFile, String descDir) {
		List<String> fileUrls = new ArrayList<String>();
	    try (ZipArchiveInputStream inputStream = getZipFile(zipFile)) {
	        File pathFile = new File(descDir);
	        if (!pathFile.exists()) {
	            pathFile.mkdirs();
	        }
	        ZipArchiveEntry entry = null;
	        String name = zipFile.getName().substring(zipFile.getName().lastIndexOf('\\') + 1, zipFile.getName().lastIndexOf('.'));
	        while ((entry = inputStream.getNextZipEntry()) != null) {
	            if (entry.isDirectory()) {
	                File directory = new File(descDir, entry.getName());
	                directory.mkdirs();
	            } else {
	                //OutputStream os = null;
	                try {
	                	String outPath = (descDir + name + "/" +  entry.getName()).replaceAll("\\*", "/");
	                    //os = new BufferedOutputStream(new FileOutputStream(new File(outPath)));
	                    //输出文件路径信息
	                    log.debug("解压文件的当前路径为:{}", outPath);
	                    File file = new File(outPath.substring(0, outPath.lastIndexOf('/')));
	        			if (!file.exists()) {
	        				file.mkdirs();
	        			}
	        			if (new File(outPath).isDirectory()) {
	        				continue;
	        			}
	        			FileOutputStream out = new FileOutputStream(outPath);
	        			int len;
	        			while ((len = inputStream.read(_byte)) > 0) {
	        				out.write(_byte, 0, len);
	        			}
	        			fileUrls.add(outPath);
	        		
	        			out.close();
	                } finally {
	                   // IOUtils.closeQuietly(os);
	                	inputStream.close();
	                }
	            }
	        }
//	        final File[] files = pathFile.listFiles();
//	        if (files != null && files.length == 1 && files[0].isDirectory()) {
//	            // 说明只有一个文件夹
//	            FileUtils.copyDirectory(files[0], pathFile);
//	            //免得删除错误， 删除的文件必须在/data/demand/目录下。
//	            boolean isValid = files[0].getPath().contains("/data/www/");
//	            if (isValid) {
//	                FileUtils.forceDelete(files[0]);
//	            }
//	        }
//	        LOG.info("******************解压完毕********************");

	    } catch (Exception e) {
	        log.error("[unzip] 解压zip文件出错", e);
	    }
	    
	    return fileUrls;
	}

	private static ZipArchiveInputStream getZipFile(File zipFile) throws Exception {
	    return new ZipArchiveInputStream(new BufferedInputStream(new FileInputStream(zipFile)));
	}
}
