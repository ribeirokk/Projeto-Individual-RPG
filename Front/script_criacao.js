function escolherRaca(raca) {
    input_raca.value = raca;
    trocar(raca)
}

function alterarAtributo(input_elemento, valor) {
    var valor_atual = Number(input_elemento.value);
    var novo_valor = valor_atual + valor;
    if (novo_valor >= 1 && novo_valor <= 20) {
        input_elemento.value = novo_valor;
    }
}

function salvarPersonagem() {

    var nome = input_nome.value;
    var raca = input_raca.value;
    var classeSelecionada = Array.from(document.querySelectorAll('input[name="classe"]:checked')).map(function(classe) {
    return classe.value;}).join(", ");
    var idade = input_idade.value;
    var origem = input_origem.value;
    var alinhamento = input_alinhamento.value;
    var tituloHistoria = input_tituloHistoria.value;
    var historia = input_historia.value;
    var forca = Number(input_forca.value);
    var velocidade = Number(input_velocidade.value);
    var agilidade = Number(input_agilidade.value);
    var resistencia = Number(input_resistencia.value);
    var inteligencia = Number(input_inteligencia.value);
    var sorte = Number(input_sorte.value);
    var generoSelecionado = document.querySelector('input[name="genero"]:checked').value;

    var personagem = {
        nome: nome,
        raca: raca,
        classe: classeSelecionada,
        idade: idade,
        origem: origem,
        alinhamento: alinhamento,
        tituloHistoria: tituloHistoria,
        historia: historia,
        forca: forca,
        velocidade: velocidade,
        agilidade: agilidade,
        resistencia: resistencia,
        inteligencia: inteligencia,
        sorte: sorte,
        genero: generoSelecionado
    };
    console.log("personagem criado:", personagem);
    console.log(JSON.stringify(personagem));

    fetch("http://localhost:8080/personagens", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(personagem)
    })
    .then(function(resposta) {
        if (resposta.status == 201) {
            alert("Personagem " + nome + " criado com sucesso!");
            window.location.href = "index.html";
        } else {
            alert("Erro ao criar personagem.");
        }
    })
    .catch(function(erro) {
        console.error("Erro com a API:", erro);
        alert("n foi possível conectar com a api.");
    });
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
    sessionStorage.RACA_USUARIO = personagem
  }
