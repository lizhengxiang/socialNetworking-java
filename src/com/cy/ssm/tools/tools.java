package com.cy.ssm.tools;

import java.util.HashMap;
import java.util.Map;

import com.cy.ssm.beans.UserBean;
/**
 * @author lizhengxiang
 *
 * @param <K>
 * 工具类，返回结果格式化
 */
public class tools<K> {

    private K data; //数据
    private int status ; //状态
    private int code;

    public tools(K data, Integer status, Integer code) {
        this.data = data;
        this.status = status;
        this.code = code;
    }
    
    public K getData() {
		return data;
	}

	public void setData(K data) {
		this.data = data;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public int getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public Map<String, Object> getRestult(){
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("result", this.getData());
		data.put("status", this.getStatus());
		data.put("code", this.getCode());
		return data;
	}
	
	
} 