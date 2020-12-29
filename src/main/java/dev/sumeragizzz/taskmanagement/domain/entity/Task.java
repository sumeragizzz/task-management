package dev.sumeragizzz.taskmanagement.domain.entity;

import java.io.Serial;
import java.io.Serializable;

import dev.sumeragizzz.taskmanagement.domain.enumeration.TaskStatus;
import dev.sumeragizzz.taskmanagement.domain.valueobject.TaskCompletedDateTime;
import dev.sumeragizzz.taskmanagement.domain.valueobject.TaskCreatedDateTime;
import dev.sumeragizzz.taskmanagement.domain.valueobject.TaskDetails;
import dev.sumeragizzz.taskmanagement.domain.valueobject.TaskOverview;

public class Task implements Serializable {

	@Serial
	private static final long serialVersionUID = 4192288660531262710L;

	private TaskOverview overview;

	private TaskDetails details;

	private TaskStatus status;

	private final TaskCreatedDateTime createdDateTime;

	private TaskCompletedDateTime completedDateTime;

	public Task() {
		this.overview = TaskOverview.BLANK;
		this.details = TaskDetails.BLANK;
		this.status = TaskStatus.INCOMPLETE;
		this.createdDateTime = new TaskCreatedDateTime();
		this.completedDateTime = new TaskCompletedDateTime(createdDateTime);
	}

	public void incomplete() {
		status = TaskStatus.INCOMPLETE;
		completedDateTime = completedDateTime.toIncomplete();
	}

	public void complete() {
		status = TaskStatus.COMPLETED;
		completedDateTime = completedDateTime.toComplete();
	}

	public TaskOverview getOverview() {
		return overview;
	}

	public void setOverview(TaskOverview overview) {
		this.overview = overview;
	}

	public TaskDetails getDetails() {
		return details;
	}

	public void setDetails(TaskDetails details) {
		this.details = details;
	}

	public TaskStatus getStatus() {
		return status;
	}

	public TaskCreatedDateTime getCreatedDateTime() {
		return createdDateTime;
	}

	public TaskCompletedDateTime getCompletedDateTime() {
		return completedDateTime;
	}

}
