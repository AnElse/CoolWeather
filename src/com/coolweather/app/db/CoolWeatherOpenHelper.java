package com.coolweather.app.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * @项目名称: CoolWeather
 * @包名: com.coolweather.app.db
 * @类名: CoolWeatherOpenHelper
 * @时间: 下午1:02:26
 * @作者: AnElse
 * 
 * @描述: 建立数据库省表,城市表,县表的帮助类
 * 
 * @当前版本号: $Rev$
 * @更新人: $Author$
 * @更新的时间: $Date$
 * @更新的描述: TODO
 * 
 */
public class CoolWeatherOpenHelper extends SQLiteOpenHelper {

	/**
	 * Province表建表语句
	 */
	public static final String	CREATE_PROVINCE	= "ceate table Province ("
													+ "id integer primary key autoincrement,"
													+ "province_name text,"
													+ "province_code text)";

	/**
	 * City表建表语句
	 */
	public static final String	CREATE_CITY		= "ceate table City ("
													+ "id integer primary key autoincrement,"
													+ "city_name text,"
													+ "city_code text,"
													+ "province_id integer)";

	/**
	 * County表建表语句
	 */
	public static final String	CREATE_COUNTY	= "ceate table County ("
													+ "id integer primary key autoincrement,"
													+ "county_name text,"
													+ "county_code text,"
													+ "city_id integer)";

	public CoolWeatherOpenHelper(Context context, String name, CursorFactory factory, int version) {
		super(context, name, factory, version);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL(CREATE_PROVINCE);// 创建province表
		db.execSQL(CREATE_CITY);// 创建city表
		db.execSQL(CREATE_COUNTY);// 创建county表
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

	}

}
