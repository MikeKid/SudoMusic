package com.evolusound.sudomusic.constant;

public enum CommonContentCode {
	
	MANDATORY_FIELD_EMPTY("mandatoryFieldEmpty"),
	INVALID_FORMAT("invalidFormat");
	
	private String codeStem;
	public static final String ERROR = "error";
	public static final String SEPARATOR = ".";
	
	private CommonContentCode(String codeStem) {
		this.codeStem = codeStem;
	}
	
	public String errorCode() {
		return buildCode(this.codeStem, ERROR);
	}
	
	public String errorCode(String errorField) {
		return buildCode(this.codeStem, errorField, ERROR);
	}
	
	protected String buildCode(String stem, String... suffixes) {
		StringBuilder code = new StringBuilder();
		code.append(stem);
		for (String suffix : suffixes) {
			code.append(SEPARATOR);
			code.append(suffix);
		}
		return code.toString();
	}

}
