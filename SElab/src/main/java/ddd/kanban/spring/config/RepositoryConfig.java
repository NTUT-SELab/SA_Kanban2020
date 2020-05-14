package ddd.kanban.spring.config;

import ddd.kanban.adapter.repository.board.SqliteBoardRepository;
import ddd.kanban.usecase.repository.BoardRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RepositoryConfig {

    @Bean
    public BoardRepository BoardRepositoryFactory() {
        return new SqliteBoardRepository();
    }
}
