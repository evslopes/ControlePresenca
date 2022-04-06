<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <title>Controle de presença</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<c:import url="/WEB-INF/jsp/menu.jsp"/>

<div class="container fixed-top" >

    <h4>Cadastramento de participantes:</h4>

    <c:if test="${not empty mensagem}">
        <div class="alert alert-success">
            <strong>Confirmação!</strong> ${mensagem}
        </div>
    </c:if>

    <c:if test="${not empty participanteLista}">
        <p>Quantidade de participantes cadastrados: ${participanteLista.size()}</p>
        <table class="table table-striped">
            <thead>
            <tr>
                <th>Nome</th>
                <th>E-mail</th>
                <th>Telefone</th>
                <th></th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="u" items="${participanteLista}">
                <tr>
                    <td>${u.nome}</td>
                    <td>${u.email}</td>
                    <td>${u.telefone}</td>

                    <td>
                        <c:if test="${user.admin}">
                            <c:if test="${user.id != u.id}">
                                <a href="/participante/${u.id}/excluir">Excluir</a>
                            </c:if>
                        </c:if>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
            <tfoot>
            <tr>
                <th>Nome</th>
                <th>E-mail</th>
                <th>Telefone</th>

                <th></th>
            </tr>
            </tfoot>
        </table>
    </c:if>

    <c:if test="${empty participanteLista}">
        <p>Não existem usuários cadastrados!!!</p>
    </c:if>
</div>
</body>

<c:import url="/WEB-INF/jsp/footer.jsp"/>
</html>