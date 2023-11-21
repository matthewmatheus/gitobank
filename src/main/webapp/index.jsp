<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Cadastro GitoBank</title>
    <%@ include file="header.jsp" %>
</head>
<body>
<%@ include file="menu.jsp" %>
<div class="container">
    <h1>Torne-se um Gito hoje mesmo!</h1>
    <c:if test="${not empty msg }">
        <div class="alert alert-success">${msg}</div>
    </c:if>
    <c:if test="${not empty erro }">
        <div class="alert alert-danger">${erro}</div>
    </c:if>
    <form action="novoCliente" method="post">
        <input type="hidden" value="cadastrar" name="acao">
        <div class="form-group">
            <label for="id-nome">Nome</label>
            <input type="text" name="nome" id="id-nome" class="form-control">
        </div>
        <div class="form-group">
            <label for="id-sobrenome">Sobrenome</label>
            <input type="text" name="sobrenome" id="id-sobrenome" class="form-control">
        </div>
        <div class="form-group">
            <label for="id-email">Email</label>
            <input type="text" name="email" id="id-email" class="form-control">
        </div>
        <input type="submit" value="Cadastrar" class="btn btn-primary">
    </form>
</div>
<%@ include file="footer.jsp" %>
</body>
</html>