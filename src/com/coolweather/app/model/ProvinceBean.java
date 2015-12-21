package com.coolweather.app.model;

/**
 * @项目名称: CoolWeather
 * @包名: com.coolweather.app.model
 * @类名: Province
 * @时间: 下午1:28:09
 * @作者: AnElse
 * 
 * @描述: 省表的实体bean
 * 
 * @当前版本号: $Rev$
 * @更新人: $Author$
 * @更新的时间: $Date$
 * @更新的描述: TODO
 * 
 */
public class ProvinceBean {
	private int		id;
	private String	provinceName;
	private String	provinceCode;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProvinceName() {
		return provinceName;
	}

	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}

	public String getProvinceCode() {
		return provinceCode;
	}

	public void setProvinceCode(String provinceCode) {
		this.provinceCode = provinceCode;
	}

}
