<%@ taglib prefix="c" uri="/WEB-INF/c.tld" %>

<html>
    <head>
        <title>Globalcode</title>
    </head>
    <body>
        <h3>Resultado da busca</h3>
        <c:choose>
            <c:when test="${requestScope.funcionarios == null}">
                <p><font size="+2" color="red">Não foi possível encontrar nenhum funcionário com este nome.</font></p>
            </c:when>
            <c:otherwise>
                <c:forEach var="funcionario" begin="0" items="${requestScope.funcionarios}">
                    <p><a href="completarFuncionarios?action=lookup&id=${funcionario.id}">${funcionario.nome} ${funcionario.sobrenome}</a></p>
                </c:forEach>
            </c:otherwise>
        </c:choose>
        <br/>
        <p>
            <a href="index.jsp">Menu de busca</a>
        </p>
    </body>
</html>

