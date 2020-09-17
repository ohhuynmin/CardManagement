package kr.or.connect.cardMangement.carddto;

public class Card {
	private String name;
	private String phone;
	private String compony;
	
	public Card(String name, String phone, String compony) {
		super();
		this.name = name;
		this.phone = phone;
		this.compony = compony;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getCompony() {
		return compony;
	}

	public void setCompony(String compony) {
		this.compony = compony;
	}

	@Override
	public String toString() {
		return "Card [name=" + name + ", phone=" + phone + ", compony=" + compony + "]";
	}
	
	
}
