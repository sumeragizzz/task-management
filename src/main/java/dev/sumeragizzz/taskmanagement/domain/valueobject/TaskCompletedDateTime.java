package dev.sumeragizzz.taskmanagement.domain.valueobject;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Optional;

public final class TaskCompletedDateTime implements Serializable {

	@Serial
	private static final long serialVersionUID = 5815392561044577461L;

	private final LocalDateTime completedDateTime;

	private final TaskCreatedDateTime createdDateTime;

	public TaskCompletedDateTime(TaskCreatedDateTime createdDateTime) {
		this(createdDateTime, null);
	}

	private TaskCompletedDateTime(TaskCreatedDateTime createdDateTime, LocalDateTime completedDateTime) {
		this.createdDateTime = Objects.requireNonNull(createdDateTime);
		this.completedDateTime = validate(createdDateTime, completedDateTime);
	}

	private LocalDateTime validate(TaskCreatedDateTime createdDateTime, LocalDateTime completedDateTime) {
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
