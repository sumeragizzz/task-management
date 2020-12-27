package dev.sumeragizzz.taskmanagement.valueobject;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

import dev.sumeragizzz.taskmanagement.domain.valueobject.TaskOverview;

class TaskOverviewTest {

	@Test
	void 正常値でインスタンス生成できること() {
		String overview = "正常データ";

		TaskOverview target = new TaskOverview(overview);
		String actual = target.getOverview();

		assertThat(actual).isEqualTo(overview);
	}

	@Test
	void 空文字でインスタンス生成できること() {
		String overview = "";

		TaskOverview target = new TaskOverview(overview);
		String actual = target.getOverview();

		assertThat(actual).isEqualTo(overview);
	}

	@Test
	void 最大文字数でインスタンス生成できること() {
		String overview = "a".repeat(TaskOverview.MAX_LENGTH);

		TaskOverview target = new TaskOverview(overview);
		String actual = target.getOverview();

		assertThat(actual).isEqualTo(overview);
	}

	@Test
	void nullは例外が発生すること() {
		String overview = null;

		assertThatThrownBy(() -> new TaskOverview(overview)).isInstanceOf(NullPointerException.class);
	}

	@Test
	void 最大文字数を超える場合は例外が発生すること() {
		String overview = "a".repeat(TaskOverview.MAX_LENGTH + 1);

		assertThatThrownBy(() -> new TaskOverview(overview)).isInstanceOf(IllegalArgumentException.class);
	}

}
