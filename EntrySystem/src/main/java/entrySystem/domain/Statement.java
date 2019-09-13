package entrySystem.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "statement")
public class Statement {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name = "user_id", referencedColumnName = "id")
	private Integer userId;
	
	@ManyToOne
	@JoinColumn(name = "faculty_id", referencedColumnName = "id")
	private Integer facultyId;
	
	@Enumerated(EnumType.STRING)
	private Subjects subject;
	
	@Column
	private double mark;

	public Statement() {
	}

	public Statement(Integer userId, Integer facultyId, Subjects subject, double mark) {
		this.userId = userId;
		this.facultyId = facultyId;
		this.subject = subject;
		this.mark = mark;
	}

	public Statement(Integer id, Integer userId, Integer facultyId, Subjects subject, double mark) {
		this.id = id;
		this.userId = userId;
		this.facultyId = facultyId;
		this.subject = subject;
		this.mark = mark;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getFacultyId() {
		return facultyId;
	}

	public void setFacultyId(Integer facultyId) {
		this.facultyId = facultyId;
	}

	public Subjects getSubject() {
		return subject;
	}

	public void setSubject(Subjects subject) {
		this.subject = subject;
	}

	public double getMark() {
		return mark;
	}

	public void setMark(double mark) {
		this.mark = mark;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((facultyId == null) ? 0 : facultyId.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		long temp;
		temp = Double.doubleToLongBits(mark);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((subject == null) ? 0 : subject.hashCode());
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
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
		Statement other = (Statement) obj;
		if (facultyId == null) {
			if (other.facultyId != null)
				return false;
		} else if (!facultyId.equals(other.facultyId))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (Double.doubleToLongBits(mark) != Double.doubleToLongBits(other.mark))
			return false;
		if (subject != other.subject)
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Statement [id=" + id + ", userId=" + userId + ", facultyId=" + facultyId + ", subject=" + subject
				+ ", mark=" + mark + "]";
	}
}
