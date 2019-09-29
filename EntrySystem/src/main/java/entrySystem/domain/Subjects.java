package entrySystem.domain;

public enum Subjects {
	MATHEMATIC("Mathematic"),
	ENGLISH("English"),
	DEUTSCH("Deutsch"),
	UKRAINIAN_LANGUAGE("Ukrainian language"),
	HISTORY("History"),
	PHYSIC("Physic"),
	GEOGRAPHY("Geography"),
	FOREIGN_LITERATURE("Foreign literature"),
	INFORMATIC("Informatic"),
	BIOLOGY("Biology"),
	CHEMISTRY("Chemistry"),
	SPORTS("Sports"),
	CERTIFICATE_MARK("Certificate mark");
	
	private String title;
	
	Subjects(String title) {
		this.title = title;
	}
	
	public String getTitle() {
		return title;
	}
	
	@Override
	public String toString() {
		return title;
	}
}
