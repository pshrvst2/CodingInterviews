package com.motherbase.dbmodel;

import java.util.ArrayList;

public class Country {
	private int id;
	private int cityCount = 0;
	private String name; 
	private double aveTemp;
	private ArrayList<City> cityList;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getAveTemp() {
		return aveTemp;
	}
	public void setAveTemp(double aveTemp) {
		this.aveTemp = aveTemp;
	}
	public ArrayList<City> getCityList() {
		return cityList;
	}
	public void setCityList(ArrayList<City> cityList) {
		this.cityList = cityList;
	}
	public Country(String name){
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCityCount() {
		return cityCount;
	}
	public void setCityCount(int cityCount) {
		this.cityCount = cityCount;
	}
}
	
	
