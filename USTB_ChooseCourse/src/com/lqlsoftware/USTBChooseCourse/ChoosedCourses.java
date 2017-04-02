package com.lqlsoftware.USTBChooseCourse;

public class ChoosedCourses {
	// ID
	private String ID;
	
	// 课程号
	private String KCH;
	
	// 课序号
	private String KXH;
	
	// 课程名
	private String KCM;     //1945年以来外交与国际关系
	
	// 课程类别   7--公共选修课
	private String KCLB;
	
	// 学时
	private String XS;
	
	// 学分
	private String XF;
	
	// 补选截止时间
	private String BXJZRQ;

	// 上课时间地点STR
	private String SKSJDDSTR;     //(周3,第6节,9-16周 逸夫楼107) 	
	
	// 校内学期
	private String XNXQ;
	
	// 教师名
	private String JSM;				//	"JSM":"外教(M.B)"

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String getKCH() {
		return KCH;
	}

	public void setKCH(String kCH) {
		KCH = kCH;
	}

	public String getKXH() {
		return KXH;
	}

	public void setKXH(String kXH) {
		KXH = kXH;
	}

	public String getKCM() {
		return KCM;
	}

	public void setKCM(String kCM) {
		KCM = kCM;
	}

	public String getKCLB() {
		return KCLB;
	}

	public void setKCLB(String kCLB) {
		KCLB = kCLB;
	}

	public String getXS() {
		return XS;
	}

	public void setXS(String xS) {
		XS = xS;
	}

	public String getXF() {
		return XF;
	}

	public void setXF(String xF) {
		XF = xF;
	}

	public Long getKRL() {
		return KRL;
	}

	public void setKRL(Long kRL) {
		KRL = kRL;
	}

	public Long getSKRS() {
		return SKRS;
	}

	public void setSKRS(Long sKRS) {
		SKRS = sKRS;
	}

	public String getBXJZRQ() {
		return BXJZRQ;
	}

	public void setBXJZRQ(String bXJZRQ) {
		BXJZRQ = bXJZRQ;
	}

	public String getSKSJDDSTR() {
		return SKSJDDSTR;
	}

	public void setSKSJDDSTR(String sKSJDDSTR) {
		SKSJDDSTR = sKSJDDSTR;
	}

	public String getXNXQ() {
		return XNXQ;
	}

	public void setXNXQ(String xNXQ) {
		XNXQ = xNXQ;
	}

	public String getJSM() {
		return JSM;
	}

	public void setJSM(String jSM) {
		JSM = jSM;
	}

}
