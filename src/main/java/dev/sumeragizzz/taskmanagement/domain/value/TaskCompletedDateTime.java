package dev.sumeragizzz.taskmanagement.domain.value;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Optional;

public final class TaskCompletedDateTime implements Serializable {

	@Serial
	static final long serialVersionUID = -1927202687672984684L;

	final LocalDateTime completedDateTime;

	final TaskCreatedDateTime createdDateTime;

	public TaskCompletedDateTime(TaskCreatedDateTime createdDateTime) {
		this(createdDateTime, null);
	}

	TaskCompletedDateTime(TaskCreatedDateTime createdDateTime, LocalDateTime completedDateTime) {
		this.createdDateTime = Objects.requireNonNull(createdDateTime);
		this.completedDateTime = validate(createdDateTime, completedDateTime);
	}

	LocalDateTime validate(TaskCreatedDateTime createdDateTime, LocalDateTime completedDateTime) {
		if (completedDateTime == null) {
			return null;
		}
		if (completedDateTime.isBefore(createdDateTime.getCreatedDateTime())) {
			throw new IllegalArgumentException();
		}
		return completedDateTime;
	}

	public TaskCompletedDateTime toComplete() {
		return new TaskCompletedDateTime(createdDateTime, LocalDateTime.now());
	}

	public TaskCompletedDateTime toIncomplete() {
		return new TaskCompletedDateTime(createdDateTime);
	}

	public Optional<LocalDateTime> getCompletedDateTime() {
		return Optional.ofNullable(completedDateTime);
	}

}
