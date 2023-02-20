package cat.itacademy.barcelonactiva.kuzmina.ganna.s04.t02.n01.S04T02N01KuzminaGanna.model.services;

import cat.itacademy.barcelonactiva.kuzmina.ganna.s04.t02.n01.S04T02N01KuzminaGanna.model.domain.Fruit;
import cat.itacademy.barcelonactiva.kuzmina.ganna.s04.t02.n01.S04T02N01KuzminaGanna.model.repository.FruitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FruitServiceImpl implements FruitService{

    @Autowired
    private FruitRepository fruitRepository;

    @Override
    public Iterable<Fruit> findAll() {
        return fruitRepository.findAll();
    }


    @Override
    public Fruit save(Fruit fruit) {
        return fruitRepository.save(fruit);
    }

    @Override
    public void deleteById(Integer id) {
        Optional fruitOptional = fruitRepository.findById(id);
        if(!fruitOptional.isPresent()){
            throw new IllegalArgumentException("Could not found any fruit with ID "+id);
        }
        fruitRepository.deleteById(id);
    }

    @Override
    public Optional<Fruit> findById(Integer id) throws IllegalArgumentException{
        Optional fruitOptional = fruitRepository.findById(id);
        if(!fruitOptional.isPresent()){
            throw new IllegalArgumentException("Could not found any fruit with ID "+id);
        }
        return fruitOptional;
    }

    @Override
    public Fruit update(Integer id, Fruit newFruit) {
        Optional fruitOptional = fruitRepository.findById(id);
        if(!fruitOptional.isPresent()){
            throw new IllegalArgumentException("Could not found any fruit with ID "+id);
        }else{
            fruitRepository.findById(id).get().setName(newFruit.getName());
            fruitRepository.findById(id).get().setQuantityKg(newFruit.getQuantityKg());
        }
        Fruit updatedFruit = fruitRepository.save(newFruit);
        return updatedFruit;
    }


}
