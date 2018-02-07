package lxp.util.http;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

/**
 * @author lxp  httpclient
 * @date 2018年2月7日 上午10:37:44
 * @param
 * @return
 */
public class HttpUtils {
	
	private static RequestConfig requestConfig;
	
	/*
	 * 将http://链接地址文件保存到指定位置
	 * 
	 */
	public static void downLoad(String apiUrl,String saveUrl,String filename){
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpGet httpGet = new HttpGet(apiUrl);
		CloseableHttpResponse response = null;
		try {
			httpGet.setConfig(requestConfig);
			response = httpClient.execute(httpGet);
			int s =response.getStatusLine().getStatusCode();
			if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
				HttpEntity entity = response.getEntity();
				if (entity != null) {
					InputStream is = entity.getContent();
					File file = new File(saveUrl+filename);
					FileOutputStream fos = new FileOutputStream(file);
					byte[] buffer = new byte[2048];
					int len = -1;
					while ((len = is.read(buffer)) != -1) {
						fos.write(buffer, 0, len);
					}
					fos.close();
					is.close();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
