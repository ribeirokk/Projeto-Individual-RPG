package school.sptech.projetoIndividual;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/personagens")
public class PersonagemController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @GetMapping
    public ResponseEntity<List<Personagem>> listar() {

        String sql = "SELECT * FROM personagens";

        List<Personagem> personagensDoBanco =
                jdbcTemplate.query(
                        sql,
                        new BeanPropertyRowMapper<>(Personagem.class)
                );

        return ResponseEntity.status(200).body(personagensDoBanco);
    }

    @PostMapping
    public ResponseEntity<Personagem> cadastrar(@RequestBody Personagem personagem) {
        String sql = """
            INSERT INTO personagens
            (nome, raca, classe, idade, origem, alinhamento,
             forca, velocidade, agilidade, resistencia,
             inteligencia, sorte, tituloHistoria, historia, genero)
            VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
            """;

        jdbcTemplate.update(
                sql,
                personagem.getNome(),
                personagem.getRaca(),
                personagem.getClasse(),
                personagem.getIdade(),
                personagem.getOrigem(),
                personagem.getAlinhamento(),
                personagem.getForca(),
                personagem.getVelocidade(),
                personagem.getAgilidade(),
                personagem.getResistencia(),
                personagem.getInteligencia(),
                personagem.getSorte(),
                personagem.getTituloHistoria(),
                personagem.getHistoria(),
                personagem.getGenero()

        );

        return ResponseEntity.status(201).body(personagem);
    }
}