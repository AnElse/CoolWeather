package com.coolweather.app.model;

/**
 * @项目名称: CoolWeather
 * @包名: com.coolweather.app.model
 * @类名: CityBean
 * @时间: 下午1:32:58
 * @作者: AnElse
 * 
 * @描述: 城市表的实体bean
 * 
 * @当前版本号: $Rev$
 * @更新人: $Author$
 * @更新的时间: $Date$
 * @更新的描述: TODO
 * 
 */
public class CityBean {
	private int		id;
	private String	cityName;
	private String	cityCode;
	private int		provinceId;

	public int getProvinceId() {
		return provinceId;
	}

	public void setProvinceId(int provinceId) {
		this.provinceId = provinceId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getCityCode() {
		return cityCode;
	}

	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}

}
