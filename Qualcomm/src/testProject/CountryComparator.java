package testProject;

import java.util.Comparator;

import com.motherbase.dbmodel.Country;

class CountryComparator implements Comparator<Country> 
{
	  public int compare(Country c1, Country c2)
	  {
		  if(c1.getCityCount()>c2.getCityCount())
			  return 1;
		  else if(c1.getCityCount()<c2.getCityCount())
			  return -1;
		  else 
			  return 0;
	  }
}
