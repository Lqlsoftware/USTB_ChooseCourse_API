package com.lqlsoftware.USTBChooseCourse;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.LaxRedirectStrategy;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import com.alibaba.fastjson.JSON;


@SuppressWarnings("deprecation")
public class ChooseCourse {
	private static DefaultHttpClient httpclient;
	// 学号
	private String username = "41524194";
	
	// 密码
	private String password = "Lqlluyuli123";
	
	// 默认参数(学生)
	private static String Parameter = ",undergraduate";

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public void helloworld () {
		System.out.println("hello world!");	
	}
	
	public Boolean getLogin(DefaultHttpClient httpclient) {
		HttpPost httppost = null;
		try {
			// post连接URL
			httppost = new HttpPost("http://elearning.ustb.edu.cn/choose_courses/j_spring_security_check");
			// 设置Header
			httppost.setHeader("UserAgent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/51.0.2704.79 Safari/537.36 Edge/14.14393");
			httppost.setHeader("X-Requested-With", "XMLHttpRequest");
			httppost.setHeader("Accept-Language", "zh-CN");
			httppost.setHeader("Accept-Encoding", "gzip, deflate");
			httppost.setHeader("Accept", "*/*");
			// 设置参数
	        List<NameValuePair> params = new ArrayList<NameValuePair>();
	        params.add(new BasicNameValuePair("j_username", this.username+ChooseCourse.Parameter));
	        params.add(new BasicNameValuePair("j_password", this.password));
	        httppost.setEntity(new UrlEncodedFormEntity(params));
	        // 发送请求
	        HttpResponse  response = httpclient.execute(httppost);
	        
		    HttpEntity entity = response.getEntity();
		    String postResult = EntityUtils.toString(entity,"UTF-8");
	        login userLogin = JSON.parseObject(postResult,login.class);
	        if (userLogin.getSuccess().equals("true")) {
	        	System.out.println(this.username + " 登录成功");
	        	return true;
	        }
	        else {
	        	System.out.println(this.username + "登录失败");
	        	return false;
     		}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			httppost.releaseConnection();
		}
		return false;
	}
	
	public ArrayList<AlternativeCourses> getAlternativeCourses(DefaultHttpClient httpclient) {
		ArrayList<AlternativeCourses> AC = null;
		HttpGet httpget = null;
		try {
			String uri = "http://elearning.ustb.edu.cn/choose_courses/choosecourse/normalChooseCourse_normalPublicSelective_loadFormalNormalPublicSelectiveCourses.action?";
			StringBuffer url = new StringBuffer(uri);
			url.append("xqj=").append("null");
			url.append("&jc=").append("null");
			url.append("&kcm=");
			url.append("&_dc=").append(new Date().getTime());
			url.append("&limit=").append(5000);
			url.append("&start=").append(0);
			url.append("&uid=").append(this.username);
			httpget = new HttpGet(url.toString());
	        HttpResponse  response = httpclient.execute(httpget);
	        HttpEntity entity = response.getEntity();
	        String postResult = EntityUtils.toString(entity,"UTF-8");
	        
	        CourseType CT = JSON.parseObject(postResult, CourseType.class);
	        AC =  (ArrayList<AlternativeCourses>) JSON.parseArray(CT.getAlternativeCourses(),AlternativeCourses.class);
	        for (AlternativeCourses ac : AC)
	        	if (ac.getSKRS()<ac.getKRL())
	        		System.out.println(String.format("%4s", ac.getSKRS()) + "/" + String.format("%-4s", ac.getKRL()) + "         " + ac.getKCM());
			else
				AC.sub(ac);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			httpget.releaseConnection();
		}
		return AC;
	}
	
	public ArrayList<ChoosedCourses> getChoosedCourses(DefaultHttpClient httpclient) {
		ArrayList<ChoosedCourses> CC = null;
		HttpGet httpget = null;
		try {
			String uri = "http://elearning.ustb.edu.cn/choose_courses/choosecourse/normalChooseCourse_normalPublicSelective_loadFormalNormalPublicSelectiveCourses.action?";
			StringBuffer url = new StringBuffer(uri);
			url.append("xqj=").append("null");
			url.append("&jc=").append("null");
			url.append("&kcm=");
			url.append("&_dc=").append(new Date().getTime());
			url.append("&limit=").append(5000);
			url.append("&start=").append(0);
			url.append("&uid=").append(this.username);
			httpget = new HttpGet(url.toString());
	        HttpResponse  response = httpclient.execute(httpget);
	        HttpEntity entity = response.getEntity();
	        String postResult = EntityUtils.toString(entity,"UTF-8");
	        
	        CourseType CT = JSON.parseObject(postResult, CourseType.class);
	        CC =  (ArrayList<ChoosedCourses>) JSON.parseArray(CT.getChoosedCourses(),ChoosedCourses.class);      
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			httpget.releaseConnection();
		}
		return CC;
	}
	
	public Boolean addCourses(AlternativeCourses AC, DefaultHttpClient httpclient) {
		HttpPost httppost = null;
		try {
			// post连接URL
			httppost = new HttpPost("http://elearning.ustb.edu.cn/choose_courses/choosecourse/normalChooseCourse_normalPublicSelective_addFormalNormalPublicSelectiveCourse.action");
			// 设置Header
			httppost.setHeader("UserAgent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/51.0.2704.79 Safari/537.36 Edge/14.14393");
			httppost.setHeader("X-Requested-With", "XMLHttpRequest");
			httppost.setHeader("Accept-Language", "zh-CN");
			httppost.setHeader("Accept-Encoding", "gzip, deflate");
			httppost.setHeader("Accept", "*/*");
			// 设置参数
	        List<NameValuePair> params = new ArrayList<NameValuePair>();
	        params.add(new BasicNameValuePair("id", AC.getID()));
	        params.add(new BasicNameValuePair("uid", username));
	        params.add(new BasicNameValuePair("xf", AC.getXF()));
	        params.add(new BasicNameValuePair("xkfs", "公共选修课"));
	        params.add(new BasicNameValuePair("xh", ""));
	        httppost.setEntity(new UrlEncodedFormEntity(params));
	        // 发送请求
	        HttpResponse  response = httpclient.execute(httppost);
	        
		    HttpEntity entity = response.getEntity();
		    String postResult = EntityUtils.toString(entity,"UTF-8");
	        responseMassage msg = JSON.parseObject(postResult,responseMassage.class);
	        if (msg.getSuccess().equals("true")) {
	        	System.out.println(AC.getKCM() + " 选课成功");
	        	return true;
	        }
	        else {
	        	System.out.println(AC.getKCM() + " 选课失败");
	        	return false;
     		}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			httppost.releaseConnection();
		}
		return false;
	}
	
	
	public static void main (String[] argv) throws InterruptedException {
		DefaultHttpClient httpclient = new DefaultHttpClient();
		httpclient.setRedirectStrategy(new LaxRedirectStrategy());
		ChooseCourse cc = new ChooseCourse();
		cc.getLogin(httpclient);
		cc.getAlternativeCourses(httpclient);
		httpclient.close();
	}
}
