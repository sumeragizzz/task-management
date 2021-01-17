package dev.sumeragizzz.taskmanagement.infrastructure.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "task")
public class TaskEntity {

	@Id
	@GeneratedValue
	@Column(name = "id")
	Integer id;

	@Column(name = "overview")
	String overview;

	@Column(name = "details")
	String details;

	@Column(name = "status")
	Integer status;

	@Column(name = "created_at")
	LocalDateTime createdAt;

	@Column(name = "completed_at")
	LocalDateTime completedAt;

	public TaskEntity() {
		// NOP
	}

	public TaskEntity(String overview, String details, Integer status, LocalDateTime createdAt,
			LocalDateTime completedAt) {
		this.overview = overview;
		this.details = details;
		this.status = status;
		this.createdAt = createdAt;
		this.completedAt = completedAt;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getOverview() {
		return overview;
	}

	public void setOverview(String overview) {
		this.overview = overview;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public LocalDateTime getCompletedAt() {
		return completedAt;
	}

	public void setCompletedAt(LocalDateTime completedAt) {
		this.completedAt = completedAt;
	}

}
