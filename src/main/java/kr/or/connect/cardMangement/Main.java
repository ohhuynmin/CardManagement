package kr.or.connect.cardMangement;

import java.util.Scanner;

import kr.or.connect.cardMangement.carddto.Card;
import kr.or.connect.cardMangement.dao.CardDao;

public class Main {
	private static CardDao dao =new CardDao();
	private static Card card = null;
	public static void main(String[] args) {
		boolean check = true;
		System.out.println("-----------------------");
		while(check) {
			System.out.println("1. 명함 입력");
			System.out.println("2. 명함 검색");
			System.out.println("3. 명함 삭제");
			System.out.println("4. 종료");
			System.out.println("-----------------------");
			Scanner sc = new Scanner(System.in);
			System.out.print("Entry Number >>");
			switch(sc.next()){
			case "1":
				createCard();
				break;
			case "2":
				searchCard();
				break;
			case "3":
				deleteCard();
				break;
			case "4":
				check = false;
				break;
				default:
					System.out.println("잘못 입력하셨습니다.");
					break;
			
			}
		}
		System.out.println(" --Program Exit--\n --ByeBye--");
	}

	
	public static void createCard() {
		String name,phone,compony;
		Scanner sc = new Scanner(System.in);
		System.out.print("Entry Name>>");
		name = sc.next();
		System.out.println("Entry Phone Number>>");
		phone = sc.next();
		System.out.println("Entry Compony>>");
		compony = sc.next();
		card = new Card(name,phone,compony);
		dao.addCard(card);
		System.out.println("Create Complete!");
		System.out.println("-----------------------");
		
	}
	public static void searchCard() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Entry Name>>");
	 	String name = sc.next();
	 	dao = new CardDao();
	 	card = dao.searchCard(name);
	 	if(card == null) {
			System.out.println("Nonexistent Card!");
	 	}else {
	 		System.out.println(card.toString());
	 	}
	 	System.out.println("-----------------------");
	}
	public static void deleteCard() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Entry Name>>");
		String name = sc.next();
		card = dao.searchCard(name);
		if(card != null) {
			CardDao dao = new CardDao();
		 	dao.deleteCard(name);
		 	System.out.println("Delete Complete!");
	 	}else {
	 		System.out.println("Nonexistent Card!");
	 	}
		
	 	System.out.println("-----------------------");
	}
}
