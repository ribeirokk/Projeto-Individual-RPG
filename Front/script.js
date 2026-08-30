var personagens = [];

function carregarTela() {
  fetch("http://localhost:8080/personagens")
    .then(function (resposta) {
      return resposta.json();
    })
    .then(function (dados) {
      personagens = dados;
      select_personagem.innerHTML = "";
      personagens.forEach(function (personagem) {
        select_personagem.innerHTML += `<option value="${personagem.id}">${personagem.nome}</option>`;
      });
      if (personagens.length > 0) {
        mostrarPersonagem(personagens[0]);
      }
    }).catch(function (erro) {
      console.error("Erro", erro);
    });
}

function trocarPersonagem() {
  var idSelecionado = Number(select_personagem.value);
  var personagemEncontrado = personagens.find(function (personagem) {
    return personagem.id == idSelecionado;
  });
  if (personagemEncontrado) {
    mostrarPersonagem(personagemEncontrado);
  }
}

function mostrarPersonagem(personagem) {
  val_nome.innerHTML = personagem.nome;
  val_raca.innerHTML = personagem.raca;
  val_classe.innerHTML = personagem.classe;
  val_idade.innerHTML = personagem.idade;
  val_origem.innerHTML = personagem.origem;
  val_alinhamento.innerHTML = personagem.alinhamento;
  val_tituloHistoria.innerHTML = personagem.tituloHistoria;
  val_historia.innerHTML = personagem.historia;
  val_atr_forca.innerHTML = personagem.forca;
  val_atr_velocidade.innerHTML = personagem.velocidade;
  val_atr_agilidade.innerHTML = personagem.agilidade;
  val_atr_resistencia.innerHTML = personagem.resistencia;
  val_atr_inteligencia.innerHTML = personagem.inteligencia;
  val_atr_sorte.innerHTML = personagem.sorte;
  val_genero.innerHTML = personagem.genero;
  val_registro.innerHTML = "Registrado por Kaliroth";
  trocar(personagem.raca);
}

 function trocar(raca) {
    // var raca = val_raca.value;
    var personagem = document.getElementById("img_personagem");

    if (raca == "Anão") {
      personagem.src = "./img/anao.jpg"
    } else if (raca == "Elfo") {
      personagem.src = "./img/elfo.jpg"
    } else if (raca == "Humano") {
      personagem.src = "./img/humano.jpg"
    } else if (raca == "Orc") {
      personagem.src = "./img/orc.jpg"
    } else if (raca == "Halfling") {
      personagem.src = "./img/halfling.jpg"
    }
  }
