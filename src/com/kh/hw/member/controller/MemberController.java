package com.kh.hw.member.controller;

import com.kh.hw.member.model.vo.Member;

public class MemberController {

	private Member[] m = new Member[SIZE];
	public static final int SIZE = 10;

	public int existMemberNum() {
		int count = 0;
		for (int i = 0; i < m.length; i++) {
			if (m[i] != null) {
				count++;
			}
		}
		return count;
	}

	public Boolean checkId(String inputId) {
		boolean check = false;
		for (int i = 0; i < m.length; i++) {
			if (m[i] != null) {
				if (inputId.equals(m[i].getId())) {
					check = true;
					break;
				}
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

	public String searchId(String id) {
		String info = null;
		for (int i = 0; i < m.length; i++) {
			if (m[i] != null && id.equals(m[i].getId())) {
				info = m[i].inform();
			}
		}
		return info;
	}

	public Member[] searchName(String name) {
		boolean exist = false;
		Member[] mem = new Member[m.length];
		for (int i = 0; i < m.length; i++) {
			if (m[i] != null && name.equals(m[i].getName())) {
				mem[i] = m[i];
				exist = true;
			}
		}
		if (exist == false) {
			mem = null;
		}
		return mem;
	}

	public Member[] searchEmail(String email) {
		boolean exist = false;
		Member[] mem = new Member[m.length];
		for (int i = 0; i < m.length; i++) {
			if (m[i] != null && email.equals(m[i].getEmail())) {
				mem[i] = m[i];
				exist = true;
			}

		}

		if (exist == false) {
			mem = null;
		}
		return mem;

	}

	public Boolean updatePassword(String id, String password) {
		boolean same = false;
		for (int i = 0; i < m.length; i++) {
			if (m[i] != null && id.equals(m[i].getId())) {
				m[i].setPassword(password);
				same = true;
				break;
			}

		}
		return same;
	}

	public Boolean updateName(String id, String name) {
		boolean same = false;
		for (int i = 0; i < m.length; i++) {
			if (m[i] != null && id.equals(m[i].getId())) {
				m[i].setName(name);
				same = true;
				break;
			}

		}
		return same;
	}

	public Boolean updateEmail(String id, String email) {
		boolean same = false;
		for (int i = 0; i < m.length; i++) {
			if (m[i] != null && id.equals(m[i].getId())) {
				m[i].setEmail(email);
				same = true;
				break;
			}

		}
		return same;
	}

	public Boolean delete(String id) {
		boolean delete = false;
		for (int i = 0; i < m.length; i++) {
			if (id.equals(m[i].getId())) {
				m[i] = null;
				delete = true;
				break;
			}
		}
		return delete;
	}

	public void delete() {

		m = new Member[SIZE];

	}

	public Member[] printAll() {
		return m;
	}

}
