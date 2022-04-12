<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no"/>
    <meta name="description" content=""/>
    <meta name="author" content=""/>
    <title>Controle de Presen�a</title>
    <!-- Favicon-->
    <link rel="icon" type="image/x-icon" href="../../assets/favicon.ico"/>
    <!-- Font Awesome icons (free version)-->
    <script src="https://use.fontawesome.com/releases/v6.1.0/js/all.js" crossorigin="anonymous"></script>
    <!-- Google fonts-->
    <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css"/>
    <link href="https://fonts.googleapis.com/css?family=Lato:400,700,400italic,700italic" rel="stylesheet"
          type="text/css"/>
    <!-- Core theme CSS (includes Bootstrap)-->
    <link href="../../css/styles.css" rel="stylesheet"/>
</head>
<body id="page-top">
<!-- Navigation-->
<c:import url="/WEB-INF/jsp/menu.jsp"/>
<!-- Masthead-->
<header class="masthead bg-primary text-white text-center">
    <div class="container d-flex align-items-center flex-column">
        <div class="container">

            <h1>Cadastramento de eventos</h1>

            <c:if test="${not empty mensagem}">
                <div class="alert alert-success">
                    <strong>Confirma��o!</strong> ${mensagem}
                </div>
            </c:if>

            <c:if test="${not empty eventoLista}">
                <h2>${eventoLista.size()} eventos cadastrados</h2>
            </c:if>
        </div>
    </div>
</header>
<!-- Portfolio Section-->
<section class="page-section portfolio" id="portfolio">
    <div class="container">

        <c:if test="${not empty mensagem}">
            <div class="alert alert-success">
                <strong>Confirma��o!</strong> ${mensagem}
            </div>
        </c:if>

        <c:if test="${not empty eventoLista}">
            <table class="table table-striped">
                <thead>
                <tr>
                    <th>Nome</th>
                    <th>Data</th>
                    <th></th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="u" items="${eventoLista}">
                    <tr>
                        <td>${u.nome}</td>
                        <td>${u.dataInicio}</td>
                        <td>
                            <c:if test="${user.admin}">
                                <c:if test="${user.id != u.id}">
                                    <a href="/evento/${u.id}/excluir">Excluir</a>
                                </c:if>
                            </c:if>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>

            </table>
        </c:if>

        <c:if test="${empty eventoLista}">
            <p>N�o existem eventos cadastrados!!!</p>
        </c:if>
    </div>
</section>

<c:import url="/WEB-INF/jsp/footer.jsp"/>

<!-- Bootstrap core JS-->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
<!-- Core theme JS-->
<script src="../../js/scripts.js"></script>
<!-- * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *-->
<!-- * *                               SB Forms JS                               * *-->
<!-- * * Activate your form at https://startbootstrap.com/solution/contact-forms * *-->
<!-- * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *-->
<script src="https://cdn.startbootstrap.com/sb-forms-latest.js"></script>
</body>
</html>






