package dev.sumeragizzz.taskmanagement.domain.model;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

import dev.sumeragizzz.taskmanagement.domain.value.TaskCompletedDateTime;
import dev.sumeragizzz.taskmanagement.domain.value.TaskCreatedDateTime;
import dev.sumeragizzz.taskmanagement.domain.value.TaskDetails;
import dev.sumeragizzz.taskmanagement.domain.value.TaskOverview;
import dev.sumeragizzz.taskmanagement.domain.value.TaskStatus;

public class Task implements Serializable {

	@Serial
	static final long serialVersionUID = -8791394832638705118L;

	Integer id;

	TaskOverview overview;

	TaskDetails details;

	TaskStatus status;

	final TaskCreatedDateTime createdAt;

	TaskCompletedDateTime completedAt;

	public Task() {
		this.overview = TaskOverview.BLANK;
		this.details = TaskDetails.BLANK;
		this.status = TaskStatus.INCOMPLETE;
		this.createdAt = new TaskCreatedDateTime();
		this.completedAt = new TaskCompletedDateTime(createdAt);
	}

	public static Task create(String overview, String details, int status, LocalDateTime createdAt, LocalDateTime completedAt) {
		// TODO 未実装
		Task task = new Task();
		task.overview = new TaskOverview(overview);
		return task;
	}

	public void incomplete() {
		status = TaskStatus.INCOMPLETE;
		completedAt = completedAt.toIncomplete();
	}

	public void complete() {
		status = TaskStatus.COMPLETED;
		completedAt = completedAt.toComplete();
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

	public TaskCreatedDateTime getCreatedAt() {
		return createdAt;
	}

	public TaskCompletedDateTime getCompletedAt() {
		return completedAt;
	}

}
