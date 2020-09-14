package com.ssafy.happyhouse.test.environment;

import java.io.IOException;
import java.util.List;

public interface environmentDao {
	List<Environment> Search(String area);
	void getList() throws IOException;
}
