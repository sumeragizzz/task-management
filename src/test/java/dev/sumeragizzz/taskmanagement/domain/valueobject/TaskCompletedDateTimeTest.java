package dev.sumeragizzz.taskmanagement.domain.valueobject;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class TaskCompletedDateTimeTest {

	@Test
	void 生成した時点では未完了状態() {
		TaskCreatedDateTime createdDateTime = new TaskCreatedDateTime();
		TaskCompletedDateTime actual = new TaskCompletedDateTime(createdDateTime);

		assertThat(actual.getCompletedDateTime()).isEmpty();
	}

	@Test
	void 完了にする() {
		TaskCreatedDateTime createdDateTime = new TaskCreatedDateTime();
		TaskCompletedDateTime target = new TaskCompletedDateTime(createdDateTime);

		TaskCompletedDateTime actual = target.toComplete();

		assertThat(actual.getCompletedDateTime()).isNotEmpty();
	}

	@Test
	void 未完了に戻す() {
		TaskCreatedDateTime createdDateTime = new TaskCreatedDateTime();
		TaskCompletedDateTime target = new TaskCompletedDateTime(createdDateTime).toComplete();

		TaskCompletedDateTime actual = target.toIncomplete();

		assertThat(actual.getCompletedDateTime()).isEmpty();
	}

}
