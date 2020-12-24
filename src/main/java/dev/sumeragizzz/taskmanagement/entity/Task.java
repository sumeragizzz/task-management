package dev.sumeragizzz.taskmanagement.entity;

import java.io.Serial;
import java.io.Serializable;

import dev.sumeragizzz.taskmanagement.enumeration.TaskStatus;
import dev.sumeragizzz.taskmanagement.valueobject.TaskCompletedDate;
import dev.sumeragizzz.taskmanagement.valueobject.TaskCreatedDate;
import dev.sumeragizzz.taskmanagement.valueobject.TaskDetails;
import dev.sumeragizzz.taskmanagement.valueobject.TaskOverview;

public class Task implements Serializable {

	@Serial
	private static final long serialVersionUID = 4192288660531262710L;

	private TaskOverview overview;

	private TaskDetails details;

	private TaskStatus status;

	private final TaskCreatedDate createdDate;

	private TaskCompletedDate completedDate;

	public Task() {
		this.overview = TaskOverview.BLANK;
		this.details = TaskDetails.BLANK;
		this.status = TaskStatus.INCOMPLETE;
		this.createdDate = new TaskCreatedDate();
		this.completedDate = new TaskCompletedDate(createdDate);
	}

	public void incomplete() {
		status = TaskStatus.INCOMPLETE;
		completedDate = completedDate.incomplete();
	}

	public void complete() {
		status = TaskStatus.COMPLETED;
		completedDate = completedDate.complete();
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

	public TaskCreatedDate getCreatedDate() {
		return createdDate;
	}

	public TaskCompletedDate getCompletedDate() {
		return completedDate;
	}

}
