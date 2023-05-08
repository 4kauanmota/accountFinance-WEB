<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="shortcut icon" href="/assets/icons/icon.png" type="image/x-icon">

    <title>Birthday App</title>

    <link rel="stylesheet" href="/css/style.css">

    <link rel="stylesheet" href="/css/shared/${param.cssPackage}.css">
    <link rel="stylesheet" href="/css/shared/${param.cssPackage2}.css">

    <c:if test="${param.page == null}">
        <link rel="stylesheet" href="/css/home.css">
    </c:if>
    <c:if test="${param.page != null}">
        <link rel="stylesheet" href="/css/${param.page}.css">
    </c:if>

    <script src="https://cdn.lordicon.com/ritcuqlt.js" defer></script>
</head>

<body>
<div class="container">
    <header>
        <div class="headerOrganization">
            <h1> ${param.title} </h1>
            <form action="/help" method="GET">
                <button type="submit">
                    <lord-icon src="https://cdn.lordicon.com/nocvdjmh.json" trigger="hover" colors="primary:#fff" class="icon pointer"></lord-icon>
                </button>
            </form>
        </div>
    </header>

    <main>
        <section class="mainOrganization">
            <c:if test="${requestScope.error != null}">
              <div class="errorArea">
                <lord-icon src="https://cdn.lordicon.com/wdqztrtx.json" trigger="loop" delay="10000" colors="primary:#fff" class="icon"></lord-icon>
                <span> ${ requestScope.error } </span>
              </div>
            </c:if>

            <c:if test="${param.page == null}">
               <jsp:include page="/page/home.jsp"/>
            </c:if>
            <c:if test="${param.page != null}">
               <jsp:include page="/page/${param.page}.jsp"/>
            </c:if>

        </section>
    </main>
    
    <footer>
        <div class="footerOrganization">
            <c:if test="${sessionScope.user == null}">
                <a href="control?ac=user/login" class="icon pointer">
                    <lord-icon src="https://cdn.lordicon.com/xdakhdsq.json" trigger="hover" colors="primary:#fff,secondary:#fff" class="iIcon pointer"></lord-icon>
                </a>
            </c:if>

            <c:if test="${sessionScope.user != null}">
                <a href="control?ac=signOut" class="icon pointer">
                    <lord-icon src="https://cdn.lordicon.com/albqovim.json" trigger="hover" colors="primary:#fff,secondary:#fff" class="iIcon pointer"></lord-icon>
                </a>

                <a href="control?ac=menu" class="icon pointer">
                    <lord-icon src="https://cdn.lordicon.com/fcrbbplx.json" trigger="hover" colors="primary:#fff" class="iIcon"></lord-icon>
                </a>

                <a href="control" class="icon pointer">
                    <lord-icon src="https://cdn.lordicon.com/msetysan.json" trigger="hover" colors="primary:#fff" class="iIcon"></lord-icon>
                </a>

                <a href="control" class="icon pointer">
                    <lord-icon src="https://cdn.lordicon.com/yzqrwwtj.json" trigger="hover" colors="primary:#ffb55c" class="iIcon"></lord-icon>
                </a>
            </c:if>
        </div>
    </footer>
</div>
</body>

</html>