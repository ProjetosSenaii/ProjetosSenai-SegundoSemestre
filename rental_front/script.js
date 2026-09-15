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

async function cadastrar() {
    const nome = document.getElementById("nome").value.trim();
    const email = document.getElementById("email").value.trim();
    const senha = document.getElementById("senha").value;

    if (!nome || !email || !senha) {
        mostrarMensagem("Preencha todos os campos.", "red");
        return;
    }

    try {
        const resposta = await fetch("http://localhost:8080/api/v1/auth/register", {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify({
                username: nome,
                email: email,
                password: senha
            })
        });

        const dados = await resposta.json();

        if (!resposta.ok) {
            throw new Error(dados.message || "Não foi possível cadastrar.");
        }

        localStorage.setItem("token", dados.token || "");
        mostrarMensagem("Cadastro realizado com sucesso!", "green");

        setTimeout(() => {
            mostrarLogin();
        }, 1500);
    } catch (erro) {
        mostrarMensagem(erro.message || "Erro ao cadastrar.", "red");
    }
}

async function fazerLogin() {
    const email = document.getElementById("loginEmail").value.trim();
    const senha = document.getElementById("loginSenha").value;

    if (!email || !senha) {
        mostrarMensagem("Informe e-mail e senha.", "red");
        return;
    }

    try {
        const resposta = await fetch("http://localhost:8080/api/v1/auth/login", {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify({
                username: "",
                email: email,
                password: senha
            })
        });

        const dados = await resposta.json();

        if (!resposta.ok) {
            throw new Error(dados.message || "E-mail ou senha incorretos.");
        }

        localStorage.setItem("token", dados.token || "");
        mostrarMensagem("Login realizado com sucesso! 🎉", "green");
    } catch (erro) {
        mostrarMensagem(erro.message || "E-mail ou senha incorretos.", "red");
    }
}

function mostrarMensagem(texto, cor) {
    const mensagem = document.getElementById("mensagem");
    mensagem.textContent = texto;
    mensagem.style.color = cor;
}