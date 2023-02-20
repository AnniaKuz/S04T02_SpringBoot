package cat.itacademy.barcelonactiva.kuzmina.ganna.s04.t02.n02.S04T02N02KuzminaGanna.model.services;

import cat.itacademy.barcelonactiva.kuzmina.ganna.s04.t02.n02.S04T02N02KuzminaGanna.model.domain.Fruit;

import java.util.Optional;

public interface FruitService {

    public Iterable<Fruit> findAll();

    public Fruit save(Fruit fruit);

    public void deleteById(Integer id);

    public Optional<Fruit> findById(Integer id);

    public Fruit update(Integer id, Fruit newFruit);
}
