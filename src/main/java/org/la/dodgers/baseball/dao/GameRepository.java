package org.la.dodgers.baseball.dao;

 
import org.la.dodgers.baseball.domain.Game;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GameRepository extends JpaRepository<Game, Long> {}
