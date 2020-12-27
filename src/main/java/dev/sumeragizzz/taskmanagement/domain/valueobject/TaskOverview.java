package dev.sumeragizzz.taskmanagement.domain.valueobject;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

public final class TaskOverview implements Serializable {

	public static final TaskOverview BLANK = new TaskOverview("");

	static final int MAX_LENGTH = 64;

	@Serial
	private static final long serialVersionUID = -7756688280903889755L;

	private final String overview;

	public TaskOverview(String overview) {
		this.overview = validate(overview);
	}

	private String validate(String overview) {
		Objects.requireNonNull(overview);
		if (overview.length() > MAX_LENGTH) {
			throw new IllegalArgumentException();
		}
		return overview;
	}

	public String getOverview() {
		return overview;
	}

	@Override
	public int hashCode() {
		return Objects.hash(overview);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof TaskOverview)) {
			return false;
		}
		TaskOverview other = (TaskOverview) obj;
		return Objects.equals(overview, other.overview);
	}

	@Override
	public String toString() {
		return overview;
	}

}
