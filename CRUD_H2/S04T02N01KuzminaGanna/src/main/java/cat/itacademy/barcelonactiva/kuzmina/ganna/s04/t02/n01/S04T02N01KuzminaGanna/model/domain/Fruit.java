package cat.itacademy.barcelonactiva.kuzmina.ganna.s04.t02.n01.S04T02N01KuzminaGanna.model.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@Entity
@Table(name = "fruits")
public class Fruit implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    Integer id;
    @Column(name="f_name")
    String name;
    @Column(name="f_quantityKg")
    int quantityKg;
}
