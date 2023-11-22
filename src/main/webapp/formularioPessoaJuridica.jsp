<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="pt-br">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Form Pessoa Juridica</title>
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
    <form action="novoClienteJuridica" method="post">
        <input type="hidden" name="tipoPessoa" value="juridica">

        <div class="form-group">
            <label for="id-razaoSocial">Razão Social</label>
            <input type="text" name="razaoSocial" id="id-razaoSocial" class="form-control" required>
        </div>

        <div class="form-group">
            <label for="id-cnpj">CNPJ</label>
            <input type="text" name="cnpj" id="id-cnpj" class="form-control" required>
        </div>

        <div class="form-group">
            <label for="id-inscricaoEstadual">Inscrição Estadual</label>
            <input type="text" name="inscricaoEstadual" id="id-inscricaoEstadual" class="form-control" required>
        </div>

        <div class="form-group">
            <label for="id-inscricaoMunicipal">Inscrição Municipal</label>
            <input type="text" name="inscricaoMunicipal" id="id-inscricaoMunicipal" class="form-control" required>
        </div>

        <div class="form-group">
            <label for="id-dataAbertura">Data de Abertura</label>
            <input type="date" name="dataAbertura" id="id-dataAbertura" class="form-control" required>
        </div>

        <input type="submit" value="Cadastrar" class="btn btn-primary">
    </form>



</div>
<%@ include file="footer.jsp" %>
</body>
</html>
