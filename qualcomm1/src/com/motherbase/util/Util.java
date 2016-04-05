package com.motherbase.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.motherbase.dbmodel.City;
import com.motherbase.dbmodel.Country;


public class Util {
	
	public HashMap<String, ArrayList<City>> countryCityMap = new HashMap<String, ArrayList<City>>();
	public HashMap<String, Country> countryMap = new HashMap<String, Country>();
	public ArrayList<Country> listOfCountries = new ArrayList<Country>();
	public ArrayList<City> listOfCity = new ArrayList<City>();
	
	public void readFile() throws ParseException
	{
		BufferedReader br = null;
		JSONParser parser = new JSONParser();
		try 
		{
			String sCurrentLine;
			br = new BufferedReader(new FileReader("weather_14.json"));
			while ((sCurrentLine = br.readLine()) != null) 
			{
				Object obj = parser.parse(sCurrentLine);
				JSONObject jsonObject = (JSONObject) obj;
				JSONObject cityObject = (JSONObject)jsonObject.get("city");
				JSONObject tempObject = (JSONObject)jsonObject.get("main");
				
				//System.out.println(city);

				String country = cityObject.get("country").toString();
				String city = cityObject.get("name").toString();
				String id = cityObject.get("id").toString();
				String temp =  tempObject.get("temp").toString();
				String temp_max =  tempObject.get("temp_max").toString();
				String temp_min =  tempObject.get("temp_min").toString();
				
				City cityObj = new City(id);
				cityObj.setName(city);
				cityObj.setTemp(Double.valueOf(temp));
				cityObj.setTemp_max(Double.valueOf(temp_max));
				cityObj.setTemp_min(Double.valueOf(temp_min));
				listOfCity.add(cityObj);
				if(countryCityMap.containsKey(country))
				{
					ArrayList<City> cityList = countryCityMap.get(country);
					cityList.add(cityObj);
					countryCityMap.put(country, cityList);
				}
				else
				{
					ArrayList<City> cityList = new ArrayList<City>();
					cityList.add(cityObj);
					countryCityMap.put(country, cityList);
					
				}
			}
			
			//populate the country objects
			populateCountries();

		} 
		catch (IOException e) 
		{
			//e.printStackTrace();
		} 
		finally 
		{
			try 
			{
				if (br != null) br.close();
			} 
			catch (IOException ex) 
			{
				//ex.printStackTrace();
			}
		}
	}
	
	public void populateCountries()
	{
		int id = 0;
		for(Map.Entry<String, ArrayList<City>> entry : countryCityMap.entrySet())
		{		
			String countryName = entry.getKey();
			ArrayList<City> cityList = entry.getValue();
			Country country = new Country(countryName);
			country.setCityList(cityList);
			//country.setCityCount(cityList.size());
			country.setAveTemp(getAvgTempForCountry(cityList));
			country.setId(++id);
			countryMap.put(countryName, country);
			listOfCountries.add(country);
		}
	}
	
	public double getAvgTempForCountry(ArrayList<City> cityList)
	{
		double retVal = 0.0;
		for(City city : cityList)
		{		
			Double avgTemp = Double.valueOf(city.getTemp());
			retVal += avgTemp;
		}
		DecimalFormat df = new DecimalFormat("#.00"); 
		df.setMaximumFractionDigits(2);
		return Double.valueOf(df.format(retVal/(cityList.size())));
	}
	
	public ArrayList<Country> getCountriesInRange(double min, double max){
		
		ArrayList<Country> retList = new ArrayList<Country>();
		
		for(Country country : listOfCountries)
		{
			int count = 0;
			for(City city : country.getCityList())
			{
				if(city.getTemp()>=min && city.getTemp()<=max)
					count++;
			}
			country.setCityCount(count);
			retList.add(country);
		}
		CountryComparator comparator = new CountryComparator();
		Collections.sort(retList, comparator);
		
		return retList;
	}
}

