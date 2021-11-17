package com.kh.hw.member.view;

import java.util.Scanner;

import com.kh.hw.member.controller.MemberController;

public class MemberMenu {

	private Scanner sc = new Scanner(System.in);
	private MemberController mc = new MemberController();

	public MemberMenu() {
	}

	public void mainMenu() {
		while (true) {
			System.out.println();
			System.out.println(
					"최대 등록 가능한 회원 수는 " + mc.SIZE + "명입니다." + "\n현재 등록된 회원 수는 " + mc.existMemberNum() + "명입니다.");

			if (mc.existMemberNum() < mc.SIZE) {
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
			int menuNum = Integer.parseInt(sc.nextLine());

			switch (menuNum) {
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
			case 5:
				printAll();
			case 9:
				System.out.println("프로그램을 종료합니다.");
				System.exit(0);
			default:
				System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
			}
		}
	}

	public void insertMember() {

		while (true) {
			System.out.println();
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
			char gender = sc.nextLine().charAt(0);
			while (!(gender == 'm' || gender == 'M' || gender == 'f' || gender == 'F')) {
				System.out.println("성별을 다시 입력하세요.");
				System.out.print("성별(M/F) : ");
				gender = sc.nextLine().charAt(0);
			}
			System.out.print("나이 : ");
			int age = Integer.parseInt(sc.nextLine());

			mc.insertMember(id, name, password, email, gender, age);
			return;
		}
	}

	public void searchMember() {
		System.out.println("1. 아이디로 검색하기");
		System.out.println("2. 이름으로 검색하기");
		System.out.println("3. 이메일로 검색하기");
		System.out.println("9. 메인으로 돌아가기");
		System.out.print("메뉴 번호 : ");
		int menuNum = Integer.parseInt(sc.nextLine());

		switch (menuNum) {
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
			return;
		}

	}

	public void searchId() {
		System.out.print("검색할 아이디 : ");
		String id = sc.nextLine();
		if (mc.searchId(id) != null) {
			System.out.println("찾으신 회원 조회 결과입니다.");
			System.out.println(mc.searchId(id));
		} else {
			System.out.println("검색 결과가 없습니다.");
			mainMenu();
		}

	}

	public void searchName() {

		// 검색할 이름을 사용자에게 입력 받고 입력 받은 데이터를
		// mc의 searchName() 메소드의 매개변수로 넘김, 반환 값에 따라
		// 검색 결과 없으면 “검색 결과가 없습니다.” 출력 후 mainMenu()로 돌아감
		// 검색 결과가 있으면 “찾으신 회원 조회 결과입니다.” 출력 후
		// 회원 검색 결과 출력
		System.out.print("검색할 이름 : ");
		String name = sc.nextLine();

		if (mc.searchName(name) != null) {
			System.out.println("찾으신 회원 조회 결과입니다.");
			for (int i = 0; i < mc.searchName(name).length; i++) {
				if (mc.searchName(name)[i] != null) {
					System.out.println(mc.searchName(name)[i].inform());
				}
			}
		} else {
			System.out.println("검색 결과가 없습니다.");
			mainMenu();
		}

	}

	public void searchEmail() {

		// 검색할 아이디를 사용자에게 입력 받고 입력 받은 데이터를
		// mc의 searchEmail() 메소드의 매개변수로 넘김, 반환 값에 따라
		// 검색 결과 없으면 “검색 결과가 없습니다.” 출력 후 mainMenu()로 돌아감
		// 검색 결과가 있으면 “찾으신 회원 조회 결과입니다.” 출력 후
		// 회원 검색 결과 출력
		System.out.print("검색할 이메일 : ");
		String email = sc.nextLine();
		if (mc.searchEmail(email) != null) {
			System.out.println("찾으신 회원 조회 결과입니다.");
			for (int i = 0; i < mc.searchEmail(email).length; i++) {
				if (mc.searchEmail(email)[i] != null) {
					System.out.println(mc.searchEmail(email)[i].inform());
				}
			}
		} else {
			System.out.println("검색 결과가 없습니다.");
			mainMenu();
		}

	}

	public void updateMember() {
		while (true) {
			System.out.println("1. 비밀번호 수정하기");
			System.out.println("2. 이름 수정하기");
			System.out.println("3. 이메일 수정하기");
			System.out.println("9. 메인으로 돌아가기");
			System.out.print("메뉴 번호 : ");
			int menuNum = Integer.parseInt(sc.nextLine());

			switch (menuNum) {
			case 1:
				updatePassword();
				break;
			case 2:
				updateName();
				break;
			case 3:
				updateEamil();
				break;
			case 9:
				System.out.println("메인 메뉴로 돌아갑니다.");
				return;
			default:
				System.out.println("잘못 입력하셨습니다.");
				return;
			}
		}
	}

	public void updatePassword() {
		System.out.print("수정할 회원의 아이디 : ");
		String id = sc.nextLine();
		System.out.print("수정할 비밀번호 : ");
		String password = sc.nextLine();
		if (!mc.updatePassword(id, password)) {
			System.out.println("존재하지 않는 아이디입니다.");
			mainMenu();
		}
		System.out.println("성공적으로 비밀번호를 수정하였습니다.");
		mainMenu();
	}

	public void updateName() {
		System.out.print("수정할 회원의 아이디 : ");
		String id = sc.nextLine();
		System.out.print("수정할 이름 : ");
		String name = sc.nextLine();

		if (!mc.updateName(id, name)) {
			System.out.println("존재하지 않는 아이디입니다.");
			mainMenu();
		}
		System.out.println("성공적으로 이름을 수정하였습니다.");
		mainMenu();

	}

	public void updateEamil() {
		System.out.print("수정할 회원의 아이디 : ");
		String id = sc.nextLine();
		System.out.print("수정할 이메일 : ");
		String email = sc.nextLine();

		if (!mc.updateEmail(id, email)) {
			System.out.println("존재하지 않는 아이디입니다.");
			mainMenu();
		}
		System.out.println("성공적으로 이메일을 수정하였습니다.");
		mainMenu();

	}

	public void deleteMember() {
		while (true) {
			System.out.println("1. 특정 회원 삭제하기");
			System.out.println("2. 모든 회원 삭제하기");
			System.out.println("9. 메인으로 돌아가기");
			System.out.print("메뉴 번호 : ");
			int menuNum = Integer.parseInt(sc.nextLine());
			switch (menuNum) {
			case 1:
				deleteOne();
				break;
			case 2:
				deleteAll();
				break;
			case 9:
				System.out.println("메인으로 돌아갑니다.");
				mainMenu();
				break;
			default:
				System.out.println("잘못 입력하셨습니다.");
				mainMenu();
			}
		}
	}

	public void deleteOne() {
		System.out.print("삭제할 회원의 아이디 : ");
		String id = sc.nextLine();
		System.out.print("정말 삭제하시겠습니까 ?(Y/N) : ");
		String agree = sc.nextLine();
		if (agree.equals("Y") || agree.equals("y")) {
			if (mc.delete(id)) {
				System.out.println("성공적으로 삭제하였습니다.");
				mainMenu();
			} else {
				System.out.println("존재하지 않는 아이디 입니다.");
				mainMenu();
			}
		} else {
			System.out.println("메인으로 돌아갑니다.");
			mainMenu();
		}

	}

	public void deleteAll() {
		System.out.print("정말 모두 삭제하시겠습니까?(Y/N) : ");
		String agree = sc.nextLine();
		if (agree.equals("Y") || agree.equals("y")) {
			System.out.println("성공적으로 삭제하였습니다.");
			mc.delete();
			mainMenu();
		} else {
			System.out.println("메인으로 돌아갑니다.");
			mainMenu();
		}
	}

	public void printAll() {
		if (mc.existMemberNum() != 0) {
			for (int i = 0; i < mc.printAll().length; i++) {
				if (mc.printAll()[i] != null) {
					System.out.println(mc.printAll()[i].inform());
				}
			}
			mainMenu();
		} else {
			System.out.println("저장된 회원이 없습니다.");
			mainMenu();
		}
	}

}
