package cat.itacademy.barcelonactiva.kuzmina.ganna.s04.t02.n02.S04T02N02KuzminaGanna.model.repository;

import cat.itacademy.barcelonactiva.kuzmina.ganna.s04.t02.n02.S04T02N02KuzminaGanna.model.domain.Fruit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FruitRepository extends JpaRepository<Fruit, Integer> {
}
