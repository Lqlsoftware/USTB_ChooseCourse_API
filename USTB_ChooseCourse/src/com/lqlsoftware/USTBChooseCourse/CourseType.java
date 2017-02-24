package com.lqlsoftware.USTBChooseCourse;

public class CourseType {
	// 学过的公共选修课
	private String learnedPublicCourses;
	// 选中的课程
	private String selectedCourses;
	// 可选的课程
	private String alternativeCourses;
	public String getLearnedPublicCourses() {
		return learnedPublicCourses;
	}
	public void setLearnedPublicCourses(String learnedPublicCourses) {
		this.learnedPublicCourses = learnedPublicCourses;
	}
	public String getSelectedCourses() {
		return selectedCourses;
	}
	public void setSelectedCourses(String selectedCourses) {
		this.selectedCourses = selectedCourses;
	}
	public String getAlternativeCourses() {
		return alternativeCourses;
	}
	public void setAlternativeCourses(String alternativeCourses) {
		this.alternativeCourses = alternativeCourses;
	}
	
	
}
