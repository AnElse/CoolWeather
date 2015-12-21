package com.coolweather.app.dao;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.coolweather.app.db.CoolWeatherOpenHelper;
import com.coolweather.app.model.CityBean;
import com.coolweather.app.model.CountyBean;
import com.coolweather.app.model.ProvinceBean;

/**
 * @项目名称: CoolWeather
 * @包名: com.coolweather.app.dao
 * @类名: CoolWeatherDBDao
 * @时间: 下午1:40:12
 * @作者: AnElse
 * 
 * @描述: 这个类把一些常用的数据库操作封装起来,以方便我们在程序中使用.
 * 
 * @当前版本号: $Rev$
 * @更新人: $Author$
 * @更新的时间: $Date$
 * @更新的描述: TODO
 * 
 */
public class CoolWeatherDBDao {
	/**
	 * 数据库名
	 */
	public static final String		DB_NAME	= "cool_weather";

	/**
	 * 数据库版本
	 */
	public static final int			VERSION	= 1;

	private static CoolWeatherDBDao	coolWeatherDBDao;
	private SQLiteDatabase			db;

	/**
	 * 将构造方法私有化
	 * 
	 * @param context
	 *            上下文
	 */
	private CoolWeatherDBDao(Context context) {
		CoolWeatherOpenHelper dbHelper = new CoolWeatherOpenHelper(context, DB_NAME, null, VERSION);
		db = dbHelper.getWritableDatabase();
	}

	/**
	 * 获取CoolweatherDBDao的实例
	 * 
	 * @param context
	 * @return
	 */
	public synchronized static CoolWeatherDBDao getInstance(Context context) {
		if (coolWeatherDBDao == null) {
			coolWeatherDBDao = new CoolWeatherDBDao(context);
		}
		return coolWeatherDBDao;
	}

	/**
	 * 将province实例存储到数据库
	 * 
	 * @param provinceBean
	 *            省类实体bean
	 */
	public void saveProvince(ProvinceBean provinceBean) {
		if (provinceBean != null) {
			ContentValues values = new ContentValues();
			values.put("province_name", provinceBean.getProvinceName());
			values.put("province_code", provinceBean.getProvinceCode());
			db.insert("Province", null, values);
		}
	}

	/**
	 * 从数据库读取全国所有的省份信息
	 * 
	 * @return 返回全国所有的省份信息的集合
	 */
	public List<ProvinceBean> loadProvince() {
		List<ProvinceBean> list = new ArrayList<ProvinceBean>();
		Cursor cursor = db.query("Province", null, null, null, null, null, null, null);
		while (cursor.moveToNext()) {
			ProvinceBean bean = new ProvinceBean();
			bean.setId(cursor.getInt(cursor.getColumnIndex("id")));
			bean.setProvinceName(cursor.getString(cursor.getColumnIndex("Province_name")));
			bean.setProvinceCode(cursor.getString(cursor.getColumnIndex("Province_code")));
			list.add(bean);
		}

		if (cursor != null) {
			cursor.close();
		}
		return list;
	}

	/**
	 * 将city实例存储到数据库
	 * 
	 * @param cityBean
	 *            城市实体bean
	 */
	public void saveCity(CityBean cityBean) {
		if (cityBean != null) {
			ContentValues values = new ContentValues();
			values.put("city_name", cityBean.getCityName());
			values.put("city_code", cityBean.getCityCode());
			values.put("province_id", cityBean.getProvinceId());
			db.insert("City", null, values);
		}
	}

	/**
	 * 根据省编号从数据库读取所有的城市信息
	 * 
	 * @param provinceId
	 *            省编号
	 * @return
	 */
	public List<CityBean> loadCities(int provinceId) {
		List<CityBean> list = new ArrayList<CityBean>();
		Cursor cursor = db.query("City", null, "province_id = ?", new String[] { String.valueOf(provinceId) }, null, null, null, null);
		while (cursor.moveToNext()) {
			CityBean bean = new CityBean();
			bean.setId(cursor.getInt(cursor.getColumnIndex("id")));
			bean.setCityName(cursor.getString(cursor.getColumnIndex("city_name")));
			bean.setCityCode(cursor.getString(cursor.getColumnIndex("city_code")));
			bean.setProvinceId(provinceId);
			list.add(bean);
		}

		if (cursor != null) {
			cursor.close();
		}
		return list;
	}

	/**
	 * 将county实例存入都数据库
	 * 
	 * @param countyBean
	 */
	public void saveCounty(CountyBean countyBean) {
		if (countyBean != null) {
			ContentValues values = new ContentValues();
			values.put("county_name", countyBean.getCountyName());
			values.put("county_code", countyBean.getCountyCode());
			values.put("city_id", countyBean.getCityId());
			db.insert("County", null, values);
		}
	}

	/**
	 * 根据城市编号从数据库读取所有的县信息
	 * 
	 * @param cityId 城市id
	 * @return
	 */
	public List<CountyBean> loadCounty(int cityId) {
		List<CountyBean> list = new ArrayList<CountyBean>();
		Cursor cursor = db.query("County", null, "city_Id = ?", new String[] { String.valueOf(cityId) }, null, null, null, null);
		while (cursor.moveToNext()) {
			CountyBean bean = new CountyBean();
			bean.setId(cursor.getInt(cursor.getColumnIndex("id")));
			bean.setCountyName(cursor.getString(cursor.getColumnIndex("County_name")));
			bean.setCountyCode(cursor.getString(cursor.getColumnIndex("CountyB_code")));
			bean.setCityId(cityId);
			list.add(bean);
		}

		if (cursor != null) {
			cursor.close();
		}
		return list;
	}
}
