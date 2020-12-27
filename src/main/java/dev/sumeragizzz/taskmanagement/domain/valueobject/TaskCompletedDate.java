package dev.sumeragizzz.taskmanagement.domain.valueobject;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;
import java.util.Optional;

public final class TaskCompletedDate implements Serializable {

	@Serial
	private static final long serialVersionUID = 5815392561044577461L;

	private final LocalDate completedDate;

	private final TaskCreatedDate createdDate;

	public TaskCompletedDate(TaskCreatedDate createdDate) {
		this.completedDate = null;
		this.createdDate = Objects.requireNonNull(createdDate);
	}

	private TaskCompletedDate(LocalDate completedDate, TaskCreatedDate createdDate) {
		this.completedDate = validate(completedDate, createdDate);
		this.createdDate = Objects.requireNonNull(createdDate);
	}

	private LocalDate validate(LocalDate completedDate, TaskCreatedDate createdDate) {
		Objects.requireNonNull(completedDate);
		if (completedDate.isBefore(createdDate.getDate())) {
			throw new IllegalArgumentException();
		}
		return completedDate;
	}

	public TaskCompletedDate incomplete() {
		return new TaskCompletedDate(createdDate);
	}

	public TaskCompletedDate complete() {
		return new TaskCompletedDate(LocalDate.now(), createdDate);
	}

	public Optional<LocalDate> getCompletedDate() {
		return Optional.ofNullable(completedDate);
	}

}
