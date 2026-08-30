package school.sptech.projetoIndividual;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.web.bind.annotation.*;

import java.sql.PreparedStatement;
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
                        sql, new BeanPropertyRowMapper<>(Personagem.class));
        String sqlClasses = """
        SELECT classe_id
        FROM personagem_classe
        WHERE personagem_id = ?
        """;

        for (Personagem personagem : personagensDoBanco) {
            List<Integer> classes = jdbcTemplate.queryForList(
                    sqlClasses, Integer.class, personagem.getId()
            );
            personagem.setClasses(classes);
        }
        return ResponseEntity.status(200).body(personagensDoBanco);
    }

    @PostMapping
    public ResponseEntity<Personagem> cadastrar(@RequestBody Personagem personagem) {
        String sql = """
            INSERT INTO personagens
            (nome, raca, idade, origem, alinhamento,
             forca, velocidade, agilidade, resistencia,
             inteligencia, sorte, tituloHistoria, historia, genero)
            VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
            """;
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            PreparedStatement statement = connection.prepareStatement(
                    sql, new String[]{"id"}
            );
            statement.setString(1, personagem.getNome());
            statement.setString(2, personagem.getRaca());
            statement.setObject(3, personagem.getIdade());
            statement.setString(4, personagem.getOrigem());
            statement.setString(5, personagem.getAlinhamento());
            statement.setInt(6, personagem.getForca());
            statement.setInt(7, personagem.getVelocidade());
            statement.setInt(8, personagem.getAgilidade());
            statement.setInt(9, personagem.getResistencia());
            statement.setInt(10, personagem.getInteligencia());
            statement.setInt(11, personagem.getSorte());
            statement.setString(12, personagem.getTituloHistoria());
            statement.setString(13, personagem.getHistoria());
            statement.setString(14, personagem.getGenero());
            return statement;
        }, keyHolder);
        Integer personagemId = keyHolder.getKey().intValue();
        personagem.setId(personagemId);

        String sqlClasse = """
            INSERT INTO personagem_classe
            (personagem_id, classe_id)
            VALUES (?, ?)
            """;
        for (Integer classeId : personagem.getClasses()) {
            jdbcTemplate.update(sqlClasse, personagemId, classeId
            );
        }
        return ResponseEntity.status(201).body(personagem);
    }
}