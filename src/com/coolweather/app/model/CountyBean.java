package com.coolweather.app.model;

/**
 * @项目名称: CoolWeather
 * @包名: com.coolweather.app.model
 * @类名: CountyBean
 * @时间: 下午1:34:44
 * @作者: AnElse
 * 
 * @描述: 县表的实体bean
 * 
 * @当前版本号: $Rev$
 * @更新人: $Author$
 * @更新的时间: $Date$
 * @更新的描述: TODO
 * 
 */
public class CountyBean {
	private int		id;
	private String	countyName;
	private String	countyCode;
	private int		cityId;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCountyName() {
		return countyName;
	}

	public void setCountyName(String countyName) {
		this.countyName = countyName;
	}

	public String getCountyCode() {
		return countyCode;
	}

	public void setCountyCode(String countyCode) {
		this.countyCode = countyCode;
	}

	public int getCityId() {
		return cityId;
	}

	public void setCityId(int cityId) {
		this.cityId = cityId;
	}

}
