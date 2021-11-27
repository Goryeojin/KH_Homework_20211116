package com.kh.hw.member.controller;

import java.util.ArrayList;

import com.kh.hw.member.model.vo.Member;

public class MemberController {

	public static final int SIZE = 10;
	private Member[] m = new Member[SIZE];

	public int existMember() {

		int count = 0;

		for (int i = 0; i < m.length; i++) {
			if (m[i] != null) {
				count++;
			}
		}

		return count;
	}

	public boolean checkId(String inputId) {
		boolean check = false;
		for (int i = 0; i < m.length; i++) {
			if (m[i] != null && inputId.equals(m[i].getId())) {
				check = true;
				break;
			}

		}

		return check;
	}

	public void insertMember(String id, String name, String password, String email, char gender, int age) {

		for (int i = 0; i < m.length; i++) {
			if (m[i] == null) {
				m[i] = new Member(id, name, password, email, gender, age);
				break;
			}
		}

	}

	public Member searchId(String id) {

		Member returnM = null;

		for (int i = 0; i < m.length; i++) {
			if (m[i] != null && m[i].getId().equals(id)) {
				returnM = m[i];
			}
		}

		return returnM;
	}

	public ArrayList<Member> searchName(String name) {

		ArrayList<Member> list = new ArrayList<>();

		for (int i = 0; i < m.length; i++) {
			if (m[i] != null && m[i].getName().equals(name)) {
				list.add(m[i]);
			}
		}

		return list;
	}

	public Member searchEmail(String email) {

		Member returnM = null;

		for (int i = 0; i < m.length; i++) {
			if (m[i] != null && m[i].getEmail().equals(email)) {
				returnM = m[i];
			}
		}

		return returnM;
	}

	public int updatePassword(String id, String password) {

		int result = 0;

		for (int i = 0; i < m.length; i++) {
			if (m[i] != null && m[i].getId().equals(id)) {
				m[i].setPassword(password);
				result++;
				break;
			}
		}

		return result;
	}

	public int updateName(String id, String name) {
		int result = 0;

		for (int i = 0; i < m.length; i++) {
			if (m[i] != null && m[i].getId().equals(id)) {
				m[i].setPassword(name);
				result++;
				break;
			}
		}

		return result;
	}

	public int updateEmail(String id, String email) {
		int result = 0;

		for (int i = 0; i < m.length; i++) {
			if (m[i] != null && m[i].getId().equals(id)) {
				m[i].setPassword(email);
				result++;
				break;
			}
		}

		return result;
	}

	public int delete(String id) {
		
		int result = 0;
		for(int i=0; i<m.length; i++) {
			if(m[i]!=null && m[i].getId().equals(id)) {
				m[i] = null;
				result++;
				break;
			}
		}
		
		return result;
	}

	public void delete() {
		
		m = null;
		
	}

	public ArrayList<Member> printAll() {
		
		ArrayList<Member> list = new ArrayList<>();
		for(int i=0; i<m.length; i++) {
			if(m[i]!=null)
				list.add(m[i]);
		}
		
		return list;
	}

}
