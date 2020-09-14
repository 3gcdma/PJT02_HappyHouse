package com.ssafy.happyhouse.test.environment;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class environmentDaoImpl implements environmentDao {
	
	List<Environment> envAreaList = new ArrayList<Environment>();
	@Override
	public List<Environment> Search(String area) {
		List<Environment> tmp = new ArrayList<Environment>();
		for(Environment env : envAreaList ) {
			if(env.getArea().equals(area)) {
				tmp.add(env);
			}
		}
		return tmp;
	}


	public void getList() throws IOException {
		// TODO Auto-generated method stub
		String csvFileName = "res/서울시 종로구 환경 지도점검 내역 현황.csv";
		try (BufferedReader br = new BufferedReader(new FileReader(csvFileName))) {
		    String line;
		    if((line = br.readLine()) != null);
		    while ((line = br.readLine()) != null) {
		    	String[] values = line.split(",");
		    	
		    	String factory = values[0].replaceAll("\"","");
		    	String license = values[1].replaceAll("\"","");
		    	int code = Integer.parseInt(values[2].replaceAll("\"",""));
		    	int date = Integer.parseInt(values[4].replaceAll("\"",""));
		    	String check = values[7].replaceAll("\"","");	
		    	if(values[8].length()==2) values[8]="undifined";
		    	String disposal = values[8].replaceAll("\"","");
		    	String task = values[9].replaceAll("\"","");
		    	String locations = values[12].replaceAll("\"","");; 
		    	
		    	
		  
		        String areas [] = locations.split(" ");
		    	String area = areas[2];
		    	envAreaList.add(new Environment(factory, license, code, date, check, disposal, task, locations, area));
		       
		    }
		}
	}
}
