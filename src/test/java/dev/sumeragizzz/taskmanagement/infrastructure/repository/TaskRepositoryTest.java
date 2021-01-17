package dev.sumeragizzz.taskmanagement.infrastructure.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDateTime;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import dev.sumeragizzz.taskmanagement.infrastructure.entity.TaskEntity;

@DataJpaTest
class TaskRepositoryTest {

	@Autowired
	TestEntityManager entityManager;

	@Autowired
	TaskRepository repository;

	@BeforeEach
	void setUp() throws Exception {
		TaskEntity beforeEntity = new TaskEntity("aaa", "bbb", 0, LocalDateTime.of(2021, 1, 16, 12, 34, 56),
				LocalDateTime.of(2022, 2, 17, 13, 35, 57));
		TaskEntity afterEntity = entityManager.persist(beforeEntity);
	}

	@Test
	void test() {
		Optional<TaskEntity> actual = repository.findById(1);

		TaskEntity expected = new TaskEntity("aaa", "bbb", 0, LocalDateTime.of(2021, 1, 16, 12, 34, 56),
				LocalDateTime.of(2022, 2, 17, 13, 35, 57));
		expected.setId(1);

		assertThat(actual).isPresent().get().usingRecursiveComparison().isEqualTo(expected);
	}

}
