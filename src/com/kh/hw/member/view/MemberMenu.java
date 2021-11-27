package com.kh.hw.member.view;

import java.util.ArrayList;
import java.util.Scanner;

import com.kh.hw.member.controller.MemberController;
import com.kh.hw.member.model.vo.Member;

public class MemberMenu {

	private MemberController mc = new MemberController();
	private Scanner sc = new Scanner(System.in);

	public void mainMenu() {

		while (true) {
			System.out.println();
			System.out.println("최대 등록 가능한 회원 수는 " + mc.SIZE + "명 입니다.");
			System.out.println("현재 등록된 회원 수는 " + mc.existMember() + "명 입니다.");

			if (mc.existMember() < mc.SIZE) {
				System.out.println("1. 새 회원 등록");
			} else {
				System.out.println("회원 수가 모두 꽉 찼기 때문에 일부 메뉴만 오픈됩니다.");
			}
			System.out.println("2. 회원 검색");
			System.out.println("3. 회원 정보 수정");
			System.out.println("4. 회원 삭제");
			System.out.println("5. 모두 출력");
			System.out.println("9. 끝내기");
			System.out.print("메뉴 번호 : ");
			int menu = Integer.parseInt(sc.nextLine());

			switch (menu) {
			case 1:
				insertMember();
				break;
			case 2:
				searchMember();
				break;
			case 3:
				updateMember();
				break;
			case 4:
				deleteMember();
				break;
			case 5:
				printAll();
				break;
			case 9:
				System.out.println("프로그램을 종료합니다.");
				return;
			default:
				System.out.println("메뉴 번호를 잘못 입력하셨습니다.");
			}

		}

	}

	public void insertMember() {

		System.out.println();
		System.out.println("----- 회원 등록 -----");
		System.out.print("아이디 : ");
		String id = sc.nextLine();
		while (mc.checkId(id)) {
			System.out.println("중복된 아이디입니다. 다시 입력해주세요.");
			System.out.print("아이디 : ");
			id = sc.nextLine();
		}
		System.out.print("이름 : ");
		String name = sc.nextLine();
		System.out.print("비밀번호 : ");
		String password = sc.nextLine();
		System.out.print("이메일 : ");
		String email = sc.nextLine();
		System.out.print("성별(M/F) : ");
		char gender = sc.nextLine().toUpperCase().charAt(0);
		while (!(gender == 'M' || gender == 'F')) {
			System.out.println("성별을 다시 입력하세요.");
			System.out.print("성별(M/F) : ");
			gender = sc.nextLine().toUpperCase().charAt(0);
		}
		System.out.print("나이 : ");
		int age = Integer.parseInt(sc.nextLine());

		mc.insertMember(id, name, password, email, gender, age);

	}

	public void searchMember() {
		while (true) {
			System.out.println("1. 아이디로 검색하기");
			System.out.println("2. 이름으로 검색하기");
			System.out.println("3. 이메일로 검색하기");
			System.out.println("9. 메인으로 돌아가기");
			System.out.print("메뉴 번호 : ");
			int menu = Integer.parseInt(sc.nextLine());

			switch (menu) {
			case 1:
				searchId();
				break;
			case 2:
				searchName();
				break;
			case 3:
				searchEmail();
				break;
			case 9:
				System.out.println("메인으로 돌아갑니다.");
				return;
			default:
				System.out.println("잘못 입력하셨습니다.");
			}
		}
	}

	public void searchId() {
		System.out.println();
		System.out.print("검색할 아이디 : ");
		String id = sc.nextLine();

		Member m = mc.searchId(id);
		if(m != null) {
			System.out.println("회원 조회 결과입니다.");
			System.out.println(m);
		} else {
			System.out.println("검색 결과가 없습니다.");
		}

	}

	public void searchName() {
		System.out.println();
		System.out.print("검색할 이름 : ");
		String name = sc.nextLine();
		
		ArrayList<Member> list = mc.searchName(name);
		
		if(list.isEmpty()) {
			System.out.println("검색하신 결과가 없습니다.");
		} else {
			System.out.println("회원 조회 결과입니다.");
			for(Member m : list) {
				System.out.println(m);
			}
		}
	}

	public void searchEmail() {
		System.out.println();
		System.out.print("검색할 이메일 : ");
		String email = sc.nextLine();

		Member m = mc.searchEmail(email);
		if(m != null) {
			System.out.println("회원 조회 결과입니다.");
			System.out.println(m);
		} else {
			System.out.println("검색 결과가 없습니다.");
		}
	}
	
	public void updateMember() {
		while (true) {
			System.out.println();
			System.out.println("1. 비밀번호 수정하기");
			System.out.println("2. 이름 수정하기");
			System.out.println("3. 이메일 수정하기");
			System.out.println("9. 메인으로 돌아가기");
			System.out.print("메뉴 번호 : ");
			int menu = Integer.parseInt(sc.nextLine());

			switch (menu) {
			case 1:
				updatePassword();
				break;
			case 2:
				updateName();
				break;
			case 3:
				updateEmail();
				break;
			case 9:
				System.out.println("메인 메뉴로 돌아갑니다.");
				return;
			default:
				System.out.println("잘못 입력하셨습니다.");
			}
		}
		
	}
	
	public void updatePassword() {
		System.out.print("수정할 회원의 아이디 : ");
		String id = sc.nextLine();
		System.out.print("수정할 비밀번호 : ");
		String password = sc.nextLine();
		
		int result = mc.updatePassword(id, password);
		if(result > 0) {
			System.out.println("성공적으로 비밀번호를 수정하였습니다.");
		} else {
			System.out.println("존재하지 않는 아이디입니다.");
		}
	}
	
	public void updateName() {
		System.out.print("수정할 회원의 아이디 : ");
		String id = sc.nextLine();
		System.out.print("수정할 이름 : ");
		String name = sc.nextLine();
		int result = mc.updateName(id, name);
		if(result > 0) {
			System.out.println("성공적으로 이름을 수정하였습니다.");
		} else {
			System.out.println("존재하지 않는 아이디입니다.");
		}
		
	}
	
	public void updateEmail() {
		System.out.print("수정할 회원의 아이디 : ");
		String id = sc.nextLine();
		System.out.print("수정할 이메일 : ");
		String email = sc.nextLine();
		int result = mc.updateEmail(id, email);
		if(result > 0) {
			System.out.println("성공적으로 이메일을 수정하였습니다.");
		} else {
			System.out.println("존재하지 않는 아이디입니다.");
		}
	}
	
	public void deleteMember() {
		while (true) {
			System.out.println("1. 특정 회원 삭제하기");
			System.out.println("2. 모든 회원 삭제하기");
			System.out.println("9. 메인으로 돌아가기");
			System.out.print("메뉴 번호 : ");
			int menu = Integer.parseInt(sc.nextLine());
			switch (menu) {
			case 1:
				deleteOne();
				break;
			case 2:
				deleteAll();
				break;
			case 9:
				System.out.println("메인으로 돌아갑니다.");
				return;
			default:
				System.out.println("잘못 입력하셨습니다.");
			}
		}
	}
	
	public void deleteOne() {
		System.out.print("삭제할 회원의 아이디 : ");
		String id = sc.nextLine();
		System.out.print("정말 삭제하시겠습니까 ?(Y/N) : ");
		char agree = sc.nextLine().toUpperCase().charAt(0);
		if(agree == 'Y') {
			int result = mc.delete(id);
			if(result > 0) {
				System.out.println("성공적으로 삭제하였습니다.");
			} else {
				System.out.println("존재하지 않는 아이디입니다.");
			}
		} else {
			System.out.println("이전 화면으로 돌아갑니다.");
		}
	}
	
	public void deleteAll() {
		
		System.out.print("정말 모두 삭제하시겠습니까?(Y/N) : ");
		char agree = sc.nextLine().toUpperCase().charAt(0);
		if(agree == 'Y') {
			mc.delete();
			System.out.println("성공적으로 삭제하였습니다.");
		} else {
			System.out.println("이전 화면으로 돌아갑니다.");
		}
		
	}
	
	public void printAll() {
		
		System.out.println("전체 회원을 조회합니다.");
		
		ArrayList<Member> list = mc.printAll();
		
		if(list.isEmpty()) {
			System.out.println("회원이 존재하지 않습니다.");
		} else {
			for(Member m : list) {
				System.out.println(m);
			}
		}
		
		
	}

}
