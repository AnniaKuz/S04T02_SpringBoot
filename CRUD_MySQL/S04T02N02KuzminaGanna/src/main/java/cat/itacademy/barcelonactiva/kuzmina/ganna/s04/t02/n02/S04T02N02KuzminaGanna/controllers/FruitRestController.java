package cat.itacademy.barcelonactiva.kuzmina.ganna.s04.t02.n02.S04T02N02KuzminaGanna.controllers;

import cat.itacademy.barcelonactiva.kuzmina.ganna.s04.t02.n02.S04T02N02KuzminaGanna.model.domain.Fruit;
import cat.itacademy.barcelonactiva.kuzmina.ganna.s04.t02.n02.S04T02N02KuzminaGanna.model.services.FruitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fruit")
public class FruitRestController {

    @Autowired
    //final
    private FruitService fruitService;

    @GetMapping("/getAll")
    //@RequestMapping(value = {"/getAll"}, method = RequestMethod.GET)
    public ResponseEntity<List<Fruit>> get(){
        List<Fruit> fruits = (List<Fruit>) fruitService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(fruits);
    }

    @PostMapping("/add")
    //@RequestMapping(value = {"/add"}, method =  RequestMethod.POST)
    public ResponseEntity<?> add(@RequestBody Fruit fruit){
        return ResponseEntity.status(HttpStatus.CREATED).body(fruitService.save(fruit));
    }

    @GetMapping("/getOne/{id}")
    //@RequestMapping(value = {"/getOne/{id}"}, method = RequestMethod.GET)
    public ResponseEntity<?> getOne (@PathVariable Integer id){
        Fruit optFruit = null;
        try {
            optFruit = fruitService.findById(id).get();
        }catch (IllegalArgumentException ex){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
        return ResponseEntity.status(HttpStatus.OK).body(optFruit);
    }

    @PutMapping("/update/{id}")
    //@RequestMapping(value = {"/update/{id}"}, method = RequestMethod.PUT)
    public ResponseEntity<?> update(@RequestBody Fruit fruitInfo, @PathVariable Integer id){
        try{
                fruitInfo.setId(id);
                Fruit updatedFruit = fruitService.update(id,fruitInfo);
            return ResponseEntity.status(HttpStatus.CREATED).body(fruitService.save(updatedFruit));
        }catch(IllegalArgumentException ex){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }

    }

    @DeleteMapping("/delete/{id}")
    //@RequestMapping(value = {"/delete/{id}"}, method =  RequestMethod.DELETE)
    public ResponseEntity<?> delete (@PathVariable Integer id){
        try{
        if(fruitService.findById(id).isPresent()){
            fruitService.deleteById(id);
        }
        }catch(IllegalArgumentException ex){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
        return ResponseEntity.status(HttpStatus.OK).body(fruitService.findAll());
    }


}
