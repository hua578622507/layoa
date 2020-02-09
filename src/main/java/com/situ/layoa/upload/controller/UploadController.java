/**
 * @Company:中享思途   
 * @Title:UploadController.java 
 * @Author:Administrator   
 * @Date:2020年2月7日 上午9:54:23     
 */
package com.situ.layoa.upload.controller;

import java.io.Serializable;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.situ.layoa.commons.LayResult;
import com.situ.layoa.commons.UploadFile;

/**
 * @ClassName:UploadController
 * @Description:(这里用一句话描述这个类的作用)
 */
@Controller
public class UploadController implements Serializable {

	private static final long serialVersionUID = 1L;

	@ResponseBody
	@RequestMapping("/upload")
	public LayResult doUploadFile(UploadFile uploadFile) {
		System.out.println(uploadFile.getFile());
		// 将上传的文件写出到磁盘后得到一个文件的路径
		String src = "layoafile/xxxxxx.png";
		return new LayResult(0, "",0, src);
	}
}
