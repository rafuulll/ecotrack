# EcoTrack - Gestão de Curadoria e Vendas

O **EcoTrack** é uma solução Full Stack desenvolvida para otimizar o gerenciamento de produtos em brechós parceiros ou para vendedores independentes. O foco do projeto é permitir que o usuário tenha controle total sobre o ciclo de vida de cada peça, garantindo uma operação organizada e eficiente.

## 📋 O Fluxo de Negócio
O sistema reflete as etapas reais do processo de revenda de itens usados (Economia Circular):

1.  **Curadoria:** Avaliação técnica da peça para verificar estado e viabilidade de venda.
2.  **Higienização:** Controle do processo de limpeza e pequenos reparos.
3.  **Anunciar:** Preparação do item para plataformas de venda.
4.  **Vendido:** Conclusão do ciclo, gerando baixa automática no sistema.

## 🚀 Tecnologias Utilizadas

### Backend
- **Java 17** com **Spring Boot 3**
- **Spring Data JPA**: Para persistência e manipulação de dados.
- **MySQL**: Banco de dados relacional para armazenamento seguro.
- **Relacionamentos SQL**: Implementação de `@ManyToOne`.
- **Maven**: Gerenciamento de dependências.

### Frontend
- **HTML5 & CSS3**: Interface intuitiva e responsiva.
- **JavaScript (ES6+)**: Consumo de API REST utilizando **Fetch API** para uma experiência dinâmica.

## 🛠️ Funcionalidades
- **CRUD Completo:** Criação, leitura, atualização e exclusão de itens.
- **Gestão de Status:** Atualização em tempo real da etapa em que o produto se encontra.
- **Integração Front-Back:** Comunicação fluida entre a interface e o servidor MySQL.

## 🔧 Como Executar o Projeto

### Pré-requisitos
- Java 17 ou superior instalado.
- MySQL Server ativo.
- Uma IDE de sua preferência (IntelliJ IDEA recomendada).

### Passo a Passo
1.  **Clone o repositório:**
    ```bash
    git clone [https://github.com/rafuulll/ecotrack.git](https://github.com/rafuulll/ecotrack.git)
    ```
2.  **Configuração do Banco:**
    No arquivo `backend/src/main/resources/application.properties`, ajuste as credenciais do seu banco de dados:
    ```properties
    spring.datasource.url=jdbc:mysql://localhost:3306/NOME_DO_BANCO_CRIADO
    spring.datasource.username=USUARIO
    spring.datasource.password=SENHA
    ```
3.  **Rodar o Backend:**
    Execute a aplicação através do IntelliJ (classe `EcoTrackApplication`).
4.  **Rodar o Frontend:**
    Basta abrir o arquivo `frontend/index.html` em qualquer navegador moderno.

---
### Contato
Desenvolvido por **Rafael Maschietto Mastromauro** [LinkedIn]https://www.linkedin.com/in/rafael-maschietto-mastromauro-6632aa2b8/?trk=opento_sprofile_topcard | [E-mail] rafammastro@gmail.com