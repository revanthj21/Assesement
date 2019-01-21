package com.Retail.Application;
import java.util.Comparator;

import com.Retail.POJO.Paper;

public class SortByPrice implements Comparator<Paper> {

	@Override
	public int compare(Paper arg0, Paper arg1) {
		return (int) (arg0.getPrice() - arg1.getPrice());
	}

}
