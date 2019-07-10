package com.bysj.work.babylatter.web;

import java.io.File;
import java.lang.Thread.State;
import java.util.List;
import java.util.UUID;

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.multipart.MultipartFile;

import com.bysj.work.babylatter.model.Product;
import com.bysj.work.babylatter.model.UserAddress;
import com.bysj.work.babylatter.service.ProductService;
import com.bysj.work.babylatter.util.LayuiData;
import com.google.gson.Gson;
import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;
@MultipartConfig
@Controller
public class ProductController {
	@Autowired	private ProductService productService;
	
	@RequestMapping("upProduct")
	public String upProduct(){
		
		return "upProduct";
	}
	
	@RequestMapping("upProductData")
	@ResponseBody
	public LayuiData<Product> upProductData(Integer page,Integer limit,String productName){
		LayuiData<Product> result=new LayuiData<>();
		if(productName==null){
			int tpage=(page-1)*limit;
			List<Product> list=productService.findAllproduct(tpage,limit);
			int count=productService.total();
			result.setData(list);
			result.setCount(count);
		}else{
			int tpage=(page-1)*limit;
			List<Product> list=productService.findByproductName(tpage,limit,productName);
			result.setData(list);
			//一个商品总数
			int count=productService.Onetotal(productName);
			result.setCount(count);
		}
		
		
		return result;
	}
	
	
	@RequestMapping("downproduct")
	public String downproduct(Integer productId){
		productService.productshow(productId);
		return "redirect:/upProduct";
	}
	
	
	@RequestMapping("editproduct")
	public String editproduct(Integer productId,HttpServletRequest request,HttpSession session){
	
		Product product=productService.getOneproduct(productId);
		request.setAttribute("product", product);
		session.setAttribute("productId", productId);
		return "editproduct";
	}
	
	
	//编辑产品信息
	@RequestMapping("updateProduct")
	@ResponseBody
	public void updateProduct(Product product,HttpSession session){
		
		int productId= (int) session.getAttribute("productId");
		
		productService.updateProduct(productId,product);
		
		
	}
	
	
	@RequestMapping("underProduct")
	public String underProduct(){
		
		return "underProduct";
	}
	//下架逻辑
	@RequestMapping("underProductData")
	@ResponseBody
	public LayuiData<Product> underProductData(Integer page,Integer limit,String productName){
		LayuiData<Product> result=new LayuiData<>();
		if(productName==null){
			int tpage=(page-1)*limit;
			List<Product> list=productService.findAllunderproduct(tpage,limit);
			int count=productService.undertotal();
			result.setData(list);
			result.setCount(count);
		}else{
			int tpage=(page-1)*limit;
			List<Product> list=productService.findByproductName(tpage,limit,productName);
			result.setData(list);
			//一个商品总数
			int count=productService.Onetotal(productName);
			result.setCount(count);
		}
		
		
		return result;
	}
	
	@RequestMapping("onproduct")
	public String onproduct(Integer productId){
		productService.productshowup(productId);
		return "redirect:/underProduct";
	}
	
	
	@RequestMapping("addProduct")
	public String addProduct(){
		
		return "addProduct";
	}
	
	@RequestMapping("insertProduct")
	public String insertProduct(Product product,HttpServletRequest request,@RequestParam(value="upfile")MultipartFile file){
		System.out.println("========进入方法了============");
		
		try {
			String originName=file.getOriginalFilename();
			String fileName=UUID.randomUUID().toString().replace("-","");
			//获取文件的信息
			String realName=file.getOriginalFilename();
			//获取文件后缀
			String typeName=realName.substring(realName.lastIndexOf("."));
			String saveFileName=fileName+typeName;
			file.transferTo(new File("d:/change/"+saveFileName));
			//上传到服务器
			//构造一个带指定Zone对象的配置类
			Configuration cfg = new Configuration(Zone.zone2());
			//...其他参数参考类注释

			UploadManager uploadManager = new UploadManager(cfg);
			//...生成上传凭证，然后准备上传
			String accessKey = "vJbNVC0mkWmXHN9X4qwRiuBllebfIbsNgJKokt3y";
			String secretKey = "yCpQcTCy8R8gMZeAS0UQcUqz8rPr0JmTDFwrySE2";
			String bucket = "fengliang2";
			//如果是Windows情况下，格式是 D:\\qiniu\\test.png
			String localFilePath = "d:/change/"+saveFileName;
			//默认不指定key的情况下，以文件内容的hash值作为文件名
			String key = saveFileName;

			Auth auth = Auth.create(accessKey, secretKey);
			String upToken = auth.uploadToken(bucket);
			System.out.println(upToken);
			product.setProductImg(saveFileName);
			productService.insertProduct(product);
			try {
			    Response response = uploadManager.put(localFilePath, key, upToken);
			    //解析上传成功的结果
			    DefaultPutRet putRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);
			    System.out.println(putRet.key);
			    System.out.println(putRet.hash);
			} catch (QiniuException ex) {
			    Response r = ex.response;
			    System.err.println(r.toString());
			    try {
			        System.err.println(r.bodyString());
			    } catch (QiniuException ex2) {
			        //ignore
			    }
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "redirect:/addsuccess";
	}
	@RequestMapping("addsuccess")
	public String addsuccess(){
		
		return "addsuccess";
	}
	@ResponseBody
	@RequestMapping("delproduct")
	public String delproduct(Integer productId){
		System.out.println("==================="+productId);
		productService.delproduct(productId);
		return "1";
	}
	
}
