package dev.sumeragizzz.taskmanagement.domain.valueobject;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public final class TaskCreatedDate implements Serializable {

	@Serial
	private static final long serialVersionUID = 4879032373918845394L;

	private final LocalDate date;

	public TaskCreatedDate() {
		this.date = LocalDate.now();
	}

	public LocalDate getDate() {
		return date;
	}

	@Override
	public int hashCode() {
		return Objects.hash(date);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof TaskCreatedDate)) {
			return false;
		}
		TaskCreatedDate other = (TaskCreatedDate) obj;
		return Objects.equals(date, other.date);
	}

	@Override
	public String toString() {
		return date.toString();
	}

}
