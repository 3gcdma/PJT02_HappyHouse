package com.ssafy.happyhouse.test.shopAnalysisTest;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class analysisDAOImpl implements analysisDAO{
	@Override
	public List<Shop> Search(String area) {
		List<Shop> shopList=new ArrayList<>();
		String csvFileName = "res/상가업소정보_201912_01.csv";
		try (BufferedReader br = new BufferedReader(new FileReader(csvFileName))) {
		    String line;
		    int idx=0;
		    while ((line = br.readLine()) != null && idx < 20) {
		    	Shop temp = new Shop();
		    	String[] values = line.split("\\|");
		    	temp.setsName(values[1]);
		    	temp.setmType(values[6]);
		    	temp.setsType(values[8]);
		    	temp.setsCity(values[12]);
		    	temp.setsDong(values[18]);
		    	temp.setNewLoc(values[26]);
		    	if(values[18].equals(area)) {
		    		idx++;
		    		shopList.add(temp);
		    	}    		    	
		    }
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return shopList;
	}
}
