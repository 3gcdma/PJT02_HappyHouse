package com.ssafy.happyhouse.test.environment;

public class Test {
	public static void main(String[] args) throws Exception {
		// 환경 정보
		// euc-kr
		environmentDaoImpl mgr = new environmentDaoImpl();
		mgr.getList(); // 엑셀 파일 불러오기
		System.out.println(mgr.Search("주교동"));
	}
}
