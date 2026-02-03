const API_URL = "http://localhost:8080/api/produtos";

async function listarProdutos() {
    const resp = await fetch(API_URL);
    const produtos = await resp.json();
    const div = document.getElementById("listaProdutos");

    div.innerHTML = "";

    produtos.forEach(p => {
        let textoBotao = "";

        if (p.status === "CURADORIA") textoBotao = "Higienizar";
        else if (p.status === "HIGIENIZADO") textoBotao = "Anunciar";
        else if (p.status === "ANUNCIADO") textoBotao = "Vender";

        div.innerHTML += `
            <div class="card">
                <div class="produto-header">
                    <h3 class="produto-titulo">${p.nome}</h3>
                    <span class="badge bg-info">
                        ${p.categoria ? p.categoria.nome : "Geral"}
                    </span>
                </div>

                <div class="preco">
                    <p>
                        Venda: R$ ${p.precoBruto}
                        <small style="color:orange">(${p.taxa}% taxa)</small>
                    </p>
                    <p class="lucro">
                        Lucro: R$ ${p.precoLiquido.toFixed(2)}
                    </p>
                </div>

                <div class="footer-card">
                    <span class="badge bg-secondary">${p.status}</span>
                    <div class="actions">
                        ${p.status !== "VENDIDO"
                            ? `<button onclick="avancarStatus(${p.id}, '${p.status}')"
                                class="btn-rosa btn-sm">${textoBotao}</button>`
                            : ""
                        }
                        <button onclick="excluir(${p.id})"
                            class="btn-vermelho">🗑️</button>
                    </div>
                </div>
            </div>
        `;
    });
}

async function cadastrar() {
    const nome = document.getElementById("nome").value;
    const precoBruto = document.getElementById("preco").value;
    const taxa = document.getElementById("taxa").value;
    const categoriaId = document.getElementById("categoriaSelect").value;

    if (parseFloat(precoBruto) < 5) {
        alert("O preço mínimo é R$ 5,00.");
        return;
    }

    if (taxa < 0 || taxa > 100) {
        alert("A taxa deve estar entre 0% e 100%.");
        return;
    }

    const produto = {
        nome,
        precoBruto: parseFloat(precoBruto),
        taxa: parseFloat(taxa),
        categoria: categoriaId ? { id: parseInt(categoriaId) } : null
    };

    await fetch(API_URL, {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(produto)
    });

    listarProdutos();

    document.getElementById("nome").value = "";
    document.getElementById("preco").value = "";
    document.getElementById("taxa").value = "20";
    document.getElementById("categoriaSelect").value = "";
}

async function excluir(id) {
    await fetch(`${API_URL}/${id}`, { method: "DELETE" });
    listarProdutos();
}

async function avancarStatus(id, statusAtual) {
    let novoStatus = "";

    if (statusAtual === "CURADORIA") novoStatus = "HIGIENIZADO";
    else if (statusAtual === "HIGIENIZADO") novoStatus = "ANUNCIADO";
    else if (statusAtual === "ANUNCIADO") novoStatus = "VENDIDO";
    else return;

    await fetch(`${API_URL}/${id}/status?novoStatus=${novoStatus}`, {
        method: "PUT"
    });

    listarProdutos();
}

async function carregarCategorias() {
    const resp = await fetch("http://localhost:8080/api/categorias");
    const categorias = await resp.json();
    const select = document.getElementById("categoriaSelect");

    select.innerHTML = '<option value="">Sem Categoria</option>';

    categorias.forEach(cat => {
        const option = document.createElement("option");
        option.value = cat.id;
        option.text = cat.nome;
        select.appendChild(option);
    });
}

listarProdutos();
carregarCategorias();