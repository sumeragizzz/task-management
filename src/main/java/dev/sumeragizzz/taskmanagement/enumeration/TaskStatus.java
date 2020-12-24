package dev.sumeragizzz.taskmanagement.enumeration;

import java.util.Objects;
import java.util.Optional;
import java.util.stream.Stream;

public enum TaskStatus {

	INCOMPLETE("0"),

	COMPLETED("1");

	private String value;

	private TaskStatus(String value) {
		this.value = Objects.requireNonNull(value);
	}

	public String getValue() {
		return value;
	}

	public static Optional<TaskStatus> of(String value) {
		return Stream.of(values()).filter(status -> status.getValue().equals(value)).findAny();
	}

}
