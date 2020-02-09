/**
 * @Company:中享思途   
 * @Title:UploadFile.java 
 * @Author:Administrator   
 * @Date:2020年2月7日 上午9:57:18     
 */
package com.situ.layoa.commons;

import java.io.Serializable;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

/**
 * @ClassName:UploadFile
 * @Description:(文件上传的通用类)
 */
public class UploadFile implements Serializable {
	private static final long serialVersionUID = 1L;
	private CommonsMultipartFile file;//

	public CommonsMultipartFile getFile() {
		return file;
	}

	public void setFile(CommonsMultipartFile file) {
		this.file = file;
	}

}
