
<nav class="navbar navbar-expand-lg bg-body-tertiary" data-bs-theme="dark">
    <div class="container-fluid">
        <a class="navbar-brand" href="#"> <i class="fas fa-shield-cat"></i> GitoBank</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
                data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent"
                aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="#">Página Inicial</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Quem somos</a>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown"
                       aria-expanded="false">
                        Pra você
                    </a>
                    <ul class="dropdown-menu">
                        <li><a class="dropdown-item" href="#">Pessoa Física</a></li>
                        <hr class="dropdown-divider">
                        <li><a class="dropdown-item" href="#">Pessoa Jurídica</a></li>
                        <li>
                            <hr class="dropdown-divider">
                        </li>
                        <li><a class="dropdown-item" href="#">Seguros</a></li>
                        <hr class="dropdown-divider">
                        <li><a class="dropdown-item" href="#">Crédito</a></li>
                        <hr class="dropdown-divider">
                        <li><a class="dropdown-item" href="#">Investimentos</a></li>
                        <hr class="dropdown-divider">
                        <li><a class="dropdown-item" href="#">Empréstimos</a></li>
                    </ul>
                </li>
                <li class="nav-item">
                    <a class="nav-link ">Fale conosco</a>
                </li>
            </ul>
                <form class="form-inline my-2 my-lg-0" action="login" method="post">
                    <input class="form-control mr-sm-2" type="text" name="email" placeholder="E-mail">
                    <input class="form-control mr-sm-2" type="password" name="senha" placeholder="Senha">
                    <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Entrar</button>
                </form>


        </div>
    </div>
</nav>

