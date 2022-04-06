<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <title>App.2022 - Java</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<c:import url="/WEB-INF/jsp/menu.jsp"/>

<div class="container fixed-top" >

    <h4>Cadastramento de empresas:</h4>

    <c:if test="${not empty mensagem}">
        <div class="alert alert-success">
            <strong>Confirmação!</strong> ${mensagem}
        </div>
    </c:if>

    <c:if test="${not empty empresaLista}">
        <p>Quantidade de empresas cadastradas: ${empresaLista.size()}</p>
        <table class="table table-striped">
            <thead>
            <tr>
                <th>Nome</th>
                <th>CNPJ</th>
                <th></th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="u" items="${empresaLista}">
                <tr>
                    <td>${u.nome}</td>
                    <td>${u.cnpj}</td>
                    <td>
                        <c:if test="${user.admin}">
                            <c:if test="${user.id != u.id}">
                                <a href="/empresa/${u.id}/excluir">Excluir</a>
                            </c:if>
                        </c:if>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
            <tfoot>
            <tr>
                <th>Nome</th>
                <th>CNPJ</th>
                <th></th>
            </tr>
            </tfoot>
        </table>
    </c:if>

    <c:if test="${empty empresaLista}">
        <p>Não existem usuários cadastrados!!!</p>
    </c:if>
</div>
</body>

<c:import url="/WEB-INF/jsp/footer.jsp"/>
</html>