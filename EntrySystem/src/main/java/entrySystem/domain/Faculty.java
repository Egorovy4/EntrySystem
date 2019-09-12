package entrySystem.domain;

import java.util.List;

public class Faculty {
	private Integer id;
	private FacultyNames name;
	private Integer quantityOfStudents;
	private List<Subjects> subjects;

	public Faculty() {
	}

	public Faculty(FacultyNames name, Integer quantityOfStudents, List<Subjects> subjects) {
		this.name = name;
		this.quantityOfStudents = quantityOfStudents;
		this.subjects = subjects;
	}

	public Faculty(Integer id, FacultyNames name, Integer quantityOfStudents, List<Subjects> subjects) {
		this.id = id;
		this.name = name;
		this.quantityOfStudents = quantityOfStudents;
		this.subjects = subjects;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public FacultyNames getName() {
		return name;
	}

	public void setName(FacultyNames name) {
		this.name = name;
	}

	public Integer getQuantityOfStudents() {
		return quantityOfStudents;
	}

	public void setQuantityOfStudents(Integer quantityOfStudents) {
		this.quantityOfStudents = quantityOfStudents;
	}

	public List<Subjects> getSubjects() {
		return subjects;
	}

	public void setSubjects(List<Subjects> subjects) {
		this.subjects = subjects;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((quantityOfStudents == null) ? 0 : quantityOfStudents.hashCode());
		result = prime * result + ((subjects == null) ? 0 : subjects.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Faculty other = (Faculty) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name != other.name)
			return false;
		if (quantityOfStudents == null) {
			if (other.quantityOfStudents != null)
				return false;
		} else if (!quantityOfStudents.equals(other.quantityOfStudents))
			return false;
		if (subjects == null) {
			if (other.subjects != null)
				return false;
		} else if (!subjects.equals(other.subjects))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Faculties [id=" + id + ", name=" + name + ", quantityOfStudents=" + quantityOfStudents + ", subjects="
				+ subjects + "]";
	}
}
