<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="pt-br">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Form Pessoa Fisica</title>
    <%@ include file="header.jsp" %>
</head>
<body>
<%@ include file="menu.jsp" %>
<div class="container">
    <h1>Informe Seus Dados</h1>
    <c:if test="${not empty msg}">
        <div class="alert alert-success">${msg}</div>
    </c:if>
    <c:if test="${not empty erro}">
        <div class="alert alert-danger">${erro}</div>
    </c:if>
    <form action="novoClienteFisica" method="post">
        <input type="hidden" name="tipoPessoa" value="fisica">

        <div class="form-group">
            <label for="id-rg">RG</label>
            <input type="text" name="rg" id="id-rg" class="form-control" required>
        </div>

        <div class="form-group">
            <label for="id-cpf">CPF</label>
            <input type="text" name="cpf" id="id-cpf" class="form-control" required>
        </div>

        <div class="form-group">
            <label for="id-dtNascimento">Data de Nascimento</label>
            <input type="date" name="dtNascimento" id="id-dtNascimento" class="form-control" required>
        </div>

        <div class="form-group">
            <label for="id-sexo">Sexo</label>
            <select name="sexo" id="id-sexo" class="form-control" required>
                <option value="" selected disabled>Selecione</option>
                <option value="H">Homem Cisgênero</option>
                <option value="M">Mulher Cisgênero</option>
                <option value="MT">Mulher Transgênero</option>
                <option value="HT">Homem Transgênero</option>
                <option value="NB">Não-binário</option>
            </select>
        </div>

        <div class="form-group">
            <label for="id-idade">Idade</label>
            <input type="number" name="idade" id="id-idade" class="form-control" required>
        </div>

        <input type="submit" value="Cadastrar" class="btn btn-primary">
    </form>



</div>
<%@ include file="footer.jsp" %>
</body>
</html>
