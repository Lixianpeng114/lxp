package lxp.util;

import java.io.File;
import java.io.FileNotFoundException;

import org.springframework.util.ResourceUtils;

/**
 * 获取模版文件
 * 
 * @author tanxin dateTime
 *
 */
public class TempUtils {

	/** 获取周边商品的订单模版 */
	public static File getTemplate() throws FileNotFoundException {
		return ResourceUtils.getFile("conf/productOrderTemp.xls");
	}

	/** 获取周边商品的订单退款模版 */
	public static File getTemplate2() throws FileNotFoundException {
		return ResourceUtils.getFile("conf/pOrderRefundTemp.xls");
	}
	
	/** 获取车的订单模版 */
	public static File getTemplate3() throws FileNotFoundException {
		return ResourceUtils.getFile("conf/carOrderTemp.xls");
	}
	
	/** 获取车的订单退款模版 */
	public static File getTemplate4() throws FileNotFoundException {
		return ResourceUtils.getFile("conf/carOrderRefundTemp.xls");
	}
	
	/** 获取周边商品的订单模版 */
	public static File getBillTotalTemplate() throws FileNotFoundException {
		return ResourceUtils.getFile("conf/billTotalTemp.xls");
	}
	
	/** 获取库存vin导入模版 */
	public static File getUploadVin() throws FileNotFoundException{
		return ResourceUtils.getFile("conf/vin.xml");
	}
	
	/** 获取库存vsn导入模版 */
	public static File getUploadVsn() throws FileNotFoundException{
		return ResourceUtils.getFile("conf/vsn.xml");
	}
	
	/** 获取库存vin导出模版 */
	public static File getDownloadVin() throws FileNotFoundException{
		return ResourceUtils.getFile("conf/VinDownload.xlsx");
	}
	
	/** 获取库存vsn导出模版 */
	public static File getDownloadVsn() throws FileNotFoundException{
		return ResourceUtils.getFile("conf/VsnDownload.xlsx");
	}
	
	/** 获取银联导入模版 */
	public static File getunionpay() throws FileNotFoundException{
		return ResourceUtils.getFile("conf/unionpay.xml");
	}
	
	/** 获取分期配置导入模版 */
	public static File getInstalment() throws FileNotFoundException{
		return ResourceUtils.getFile("conf/Instalment.xml");
	}
	/** 获取开票导入模版 */
	public static File getUploadInvoice() throws FileNotFoundException {
		return ResourceUtils.getFile("conf/invoiceUpload.xml");
	}
	
	/** 获取合同导出模版 */
	public static File getDownloadAllowance() throws FileNotFoundException{
		return ResourceUtils.getFile("conf/allowanceDownload.xlsx");
	}
	
	/** 获取合同分期导出模版 */
	public static File getDownloadInstalment() throws FileNotFoundException{
		return ResourceUtils.getFile("conf/instalmentDownload.xlsx");
	}

	/** 获取合同导出模版 */
	public static File getDownloadInvoice() throws FileNotFoundException{
		return ResourceUtils.getFile("conf/invoiceDownload.xlsx");
	}
	
	/** 获取分期配置结果导入模版 */
	public static File getInstalmentDTO() throws FileNotFoundException{
		return ResourceUtils.getFile("conf/StagesProductDTO.xml");
	}
	

	/** 获取价格导出模版 */
	public static File getCarPrice() throws FileNotFoundException{
		return ResourceUtils.getFile("conf/carPrice.xlsx");
	}

	/** 获取SAP导出模版 */
	public static File getDownloadSAP() throws FileNotFoundException {
		return ResourceUtils.getFile("conf/SAP.xlsx");
	}
	public static File getDownloadContractTemp() throws FileNotFoundException {
		return ResourceUtils.getFile("conf");
	}

	public static File getDownloadContract() throws FileNotFoundException {
		return ResourceUtils.getFile("conf/contractDownload.xml");
	}
	
	public static File getChecking() throws FileNotFoundException {
		
		return ResourceUtils.getFile("conf/checking.xls");
	} 
	/** 获取测试导出的模版文件 */
	public static File getWordTest() throws FileNotFoundException {
		return ResourceUtils.getFile("conf/test_word.xml");
	}
	
	/** 获取合同导出的模版  */
	public static File getContractTemp() throws FileNotFoundException {
		return ResourceUtils.getFile("conf/contrantTemp.xml");
	}
	
	/**
	 * Ali 导出摸板
	 */
	public static File getAliDownload() throws FileNotFoundException {
		return ResourceUtils.getFile("conf/aliDownload.xlsx");
	}
	
	/*
	 * weixin 导出模版
	 * 
	 */
	public static File getWeixinDownload() throws FileNotFoundException {
		return ResourceUtils.getFile("conf/weixinDownload.xlsx");
	}
	
	/*
	 * 银联导出模版
	 * 
	 */
	public static File getnionpayDownload() throws FileNotFoundException {
		return ResourceUtils.getFile("conf/unionpayDownload.xlsx");
	}
	
	/**
	 * billPos 导出模版
	 * 
	 */
	public static File getBillPos() throws FileNotFoundException {
		return ResourceUtils.getFile("conf/billPos.xml");
	}
	
	/**
	 * 抵押合同导出模版
	 * 
	 */
	public static File getPledgeContract() throws FileNotFoundException {
		return ResourceUtils.getFile("conf/pledgeContract.xml");
	}
	
	
	public static File getRefundPlans() throws FileNotFoundException {
		return ResourceUtils.getFile("conf/refundPlansTemp.xlsx");
	}
	
	/**
	 * 建行付款授权书
	 */
	public static File getShouPower() throws FileNotFoundException {
		return ResourceUtils.getFile("conf/shouPower.xml");
	}
	
	/**
	 * 导出 分期审核 信息
	 */
	public static File getAuditInstalment() throws FileNotFoundException {
		return ResourceUtils.getFile("conf/instalmentAudit.xlsx");
	}
	
}


