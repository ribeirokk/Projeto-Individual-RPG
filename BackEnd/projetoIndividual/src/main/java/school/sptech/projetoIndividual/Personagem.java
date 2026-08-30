package school.sptech.projetoIndividual;

import java.time.LocalDate;
import java.util.List;

public class Personagem {
    private Integer id;
    private String nome;
    private String raca;
    private LocalDate idade;
    private String origem;
    private String alinhamento;
    private Integer forca;
    private Integer velocidade;
    private Integer agilidade;
    private Integer resistencia;
    private Integer inteligencia;
    private Integer sorte;
    private String tituloHistoria;
    private String historia;
    private String genero;
    private List<Integer> classes;

    public Personagem() {
    }

    public Personagem(Integer id, String nome, String raca, LocalDate idade, String origem, String alinhamento, Integer forca, Integer velocidade, Integer agilidade, Integer resistencia, Integer inteligencia, Integer sorte, String tituloHistoria, String historia, String genero, List<Integer> classes) {
        this.id = id;
        this.nome = nome;
        this.raca = raca;
        this.idade = idade;
        this.origem = origem;
        this.alinhamento = alinhamento;
        this.forca = forca;
        this.velocidade = velocidade;
        this.agilidade = agilidade;
        this.resistencia = resistencia;
        this.inteligencia = inteligencia;
        this.sorte = sorte;
        this.tituloHistoria = tituloHistoria;
        this.historia = historia;
        this.genero = genero;
        this.classes = classes;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public LocalDate getIdade() {
        return idade;
    }

    public void setIdade(LocalDate idade) {
        this.idade = idade;
    }

    public String getOrigem() {
        return origem;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }

    public String getAlinhamento() {
        return alinhamento;
    }

    public void setAlinhamento(String alinhamento) {
        this.alinhamento = alinhamento;
    }

    public Integer getForca() {
        return forca;
    }

    public void setForca(Integer forca) {
        this.forca = forca;
    }

    public Integer getVelocidade() {
        return velocidade;
    }

    public void setVelocidade(Integer velocidade) {
        this.velocidade = velocidade;
    }

    public Integer getAgilidade() {
        return agilidade;
    }

    public void setAgilidade(Integer agilidade) {
        this.agilidade = agilidade;
    }

    public Integer getResistencia() {
        return resistencia;
    }

    public void setResistencia(Integer resistencia) {
        this.resistencia = resistencia;
    }

    public Integer getInteligencia() {
        return inteligencia;
    }

    public void setInteligencia(Integer inteligencia) {
        this.inteligencia = inteligencia;
    }

    public Integer getSorte() {
        return sorte;
    }

    public void setSorte(Integer sorte) {
        this.sorte = sorte;
    }

    public String getTituloHistoria() {
        return tituloHistoria;
    }

    public void setTituloHistoria(String tituloHistoria) {
        this.tituloHistoria = tituloHistoria;
    }

    public String getHistoria() {
        return historia;
    }

    public void setHistoria(String historia) {
        this.historia = historia;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public List<Integer> getClasses() {
        return classes;
    }

    public void setClasses(List<Integer> classes) {
        this.classes = classes;
    }
}


