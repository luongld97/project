package com.luog.onlinemusic.helpers;

import java.beans.PropertyEditorSupport;
import java.text.SimpleDateFormat;

public class DateHelper extends PropertyEditorSupport{
	@Override
	public void setAsText(String dateString) throws IllegalArgumentException {
		try {
			SimpleDateFormat simpleDateFomat = new SimpleDateFormat("yyyy-MM-dd");
			this.setValue(simpleDateFomat.parse(dateString));
		} catch (Exception e) {
			this.setValue(null);
		}
	}
}
