/**
 * 文件名：Student.java
 * 创建人：李春雨
 * 创建时间：2018年7月5日 下午4:15:35
 * 版权所有：知识产权出版社
 */
package com.cnipr.open.ms.test.pd.reflect;

/**
 * <p>[TODO 简要描述该类功能]</p>
 *
 * @version v2.0
 * @since v2.0
 * @author 李春雨
 * @date 2018年7月5日 下午4:15:35
 * @Copyright 知识产权出版社
 */
public class Student extends Person {
	
	public String desc;
	
	private int score;
	
	private User user;

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	private void drawStudent(){
        System.out.println("draw Student");
    }
	
	public String drawStudent(String desc, int score){
        System.out.println("draw Student: " + desc + ", score" + score);
        return "您正在调用Student方法。";
    }
	
    public int countClass(){
        return 100;
    }

	@Override
	public String toString() {
		return "Student [desc=" + desc + ", score=" + score + ", user=" + user + ", getName()=" + getName() + ", getAge()=" + getAge() + "]";
	}

}
