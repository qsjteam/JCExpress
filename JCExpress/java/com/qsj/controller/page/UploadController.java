package com.qsj.controller.page;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qsj.util.FastDFSClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import net.sf.json.JSONObject;

/**   
 * Copyright © 2018  Sometimes perseverance does win out.
 * 图片上传
 * @Package: org.mao.controller.page 
 * @author:作者 Mao   
 * @date:创建时间 2018年2月18日 下午4:47:51 
 */
@Controller
public class UploadController {
	@RequestMapping("upLoad")
	@ResponseBody
	public String upLoad(HttpServletRequest request, HttpServletResponse response) {
		MultipartHttpServletRequest Murequest = (MultipartHttpServletRequest) request;
		JSONObject json = new JSONObject();
		try {
			String uploadFile = "";
			FastDFSClient fastDFSClient = new FastDFSClient("classpath:conf/client.conf");
			Map<String, MultipartFile> files = Murequest.getFileMap();
			for (MultipartFile file : files.values()) {
				String fileName = file.getOriginalFilename();
				String extName = fileName.substring(fileName.lastIndexOf(".") + 1);
				uploadFile = fastDFSClient.uploadFile(file.getBytes(), extName);
			}
			json.put("path", "http://192.168.80.101/" + uploadFile);// 引用路径
			json.put("servicePath", uploadFile);// 实际路径
			json.put("flag", true);
		} catch (Exception e) {
			e.printStackTrace();
			json.put("flag", false);
		}
		return json.toString();
	}
}
