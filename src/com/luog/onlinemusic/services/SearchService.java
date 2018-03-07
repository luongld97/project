package com.luog.onlinemusic.services;

import java.util.List;

public interface SearchService {

	public List<Object> searchWS(String keyWord);
	
	public List<Object> search(String keyWord);
}
