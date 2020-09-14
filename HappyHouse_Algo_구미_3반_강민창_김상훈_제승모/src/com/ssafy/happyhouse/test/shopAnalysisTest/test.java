package com.ssafy.happyhouse.test.shopAnalysisTest;

public class test {
	public static void main(String[] args) throws Exception {
		{
			analysisDAO dao=new analysisDAOImpl();
			System.out.println(dao.Search("창신동"));
		}
	}

}
