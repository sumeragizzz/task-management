package dev.sumeragizzz.taskmanagement.domain.valueobject;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

public final class TaskCreatedDateTime implements Serializable {

	@Serial
	private static final long serialVersionUID = 4879032373918845394L;

	private final LocalDateTime createdDateTime;

	public TaskCreatedDateTime() {
		this.createdDateTime = LocalDateTime.now();
	}

	public LocalDateTime getCreatedDateTime() {
		return createdDateTime;
	}

	@Override
	public int hashCode() {
		return Objects.hash(createdDateTime);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof TaskCreatedDateTime)) {
			return false;
		}
		TaskCreatedDateTime other = (TaskCreatedDateTime) obj;
		return Objects.equals(createdDateTime, other.createdDateTime);
	}

	@Override
	public String toString() {
		return createdDateTime.toString();
	}

}
