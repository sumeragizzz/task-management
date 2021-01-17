package dev.sumeragizzz.taskmanagement.domain.value;

import java.util.Optional;
import java.util.stream.Stream;

public enum TaskStatus {

	INCOMPLETE(0),

	COMPLETED(1);

	int value;

	TaskStatus(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}

	public static Optional<TaskStatus> of(int value) {
		return Stream.of(values()).filter(status -> status.getValue() == value).findAny();
	}

}
