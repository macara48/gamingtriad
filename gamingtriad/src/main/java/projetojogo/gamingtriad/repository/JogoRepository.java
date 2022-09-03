package projetojogo.gamingtriad.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import projetojogo.gamingtriad.domain.Jogo;

import java.util.List;


public interface JogoRepository extends JpaRepository<Jogo, Long> {
    List<Jogo>findByName(String name);
}
