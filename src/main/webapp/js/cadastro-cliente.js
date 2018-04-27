function salvar() {
    // Criando um objeto vazio
    var cliente = {};

    // Pegando o nome do cliente
    cliente.nome = document.getElementById("inputNome").value

    // Pegando o email do cliente
    cliente.email = document.getElementById("inputEmail").value

    // Pegando o cpf do cliente
    cliente.cpf = document.getElementById("inputCpf").value

    // Criando uma requisição
    var request = new XMLHttpRequest();
    request.open("post", "http://localhost:8080/jweb1/clientes", true);
    request.send(JSON.stringify(cliente));
}