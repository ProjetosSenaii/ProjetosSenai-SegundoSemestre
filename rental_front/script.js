function mostrarCadastro() {
    document.getElementById("loginArea").classList.add("hidden");
    document.getElementById("cadastroArea").classList.remove("hidden");

    document.getElementById("mensagem").textContent = "";
}


function mostrarLogin() {
    document.getElementById("cadastroArea").classList.add("hidden");
    document.getElementById("loginArea").classList.remove("hidden");

    document.getElementById("mensagem").textContent = "";
}


function cadastrar() {

    const nome = document.getElementById("nome").value;
    const email = document.getElementById("email").value;
    const senha = document.getElementById("senha").value;

    if (nome === "" || email === "" || senha === "") {

        mostrarMensagem("Preencha todos os campos.", "red");

        return;
    }

    const usuario = {
        nome: nome,
        email: email,
        senha: senha
    };

    localStorage.setItem("usuario", JSON.stringify(usuario));

    mostrarMensagem(
        "Cadastro realizado com sucesso!",
        "green"
    );

    setTimeout(() => {
        mostrarLogin();
    }, 1500);
}


function fazerLogin() {

    const email = document.getElementById("loginEmail").value;
    const senha = document.getElementById("loginSenha").value;

    const usuarioSalvo = localStorage.getItem("usuario");

    if (!usuarioSalvo) {

        mostrarMensagem(
            "Nenhum usuário cadastrado.",
            "red"
        );

        return;
    }

    const usuario = JSON.parse(usuarioSalvo);

    if (email === usuario.email && senha === usuario.senha) {

        mostrarMensagem(
            "Login realizado com sucesso! 🎉",
            "green"
        );

    } else {

        mostrarMensagem(
            "E-mail ou senha incorretos.",
            "red"
        );
    }
}


function mostrarMensagem(texto, cor) {

    const mensagem = document.getElementById("mensagem");

    mensagem.textContent = texto;
    mensagem.style.color = cor;
}