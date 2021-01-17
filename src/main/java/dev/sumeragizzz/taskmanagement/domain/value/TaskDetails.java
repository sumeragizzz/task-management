package dev.sumeragizzz.taskmanagement.domain.value;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

public final class TaskDetails implements Serializable {

	public static final TaskDetails BLANK = new TaskDetails("");

	@Serial
	static final long serialVersionUID = 4064383275863206195L;

	static final int MAX_LENGTH = 256;

	final String details;

	public TaskDetails(String details) {
		this.details = validate(details);
	}

	String validate(String details) {
		Objects.requireNonNull(details);
		if (details.length() > MAX_LENGTH) {
			throw new IllegalArgumentException();
		}
		return details;
	}

	public String getDetails() {
		return details;
	}

	@Override
	public int hashCode() {
		return Objects.hash(details);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof TaskDetails)) {
			return false;
		}
		TaskDetails other = (TaskDetails) obj;
		return Objects.equals(details, other.details);
	}

	@Override
	public String toString() {
		return details;
	}

}
