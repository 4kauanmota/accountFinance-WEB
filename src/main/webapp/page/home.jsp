<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="card">
    <div class="textCard">
        <h1>Zezin</h1>
        <span>
            <lord-icon src="https://cdn.lordicon.com/qtxqkhzr.json" trigger="loop"  delay="15000" colors="primary:#000" class=""></lord-icon>
            10/10
            <b>&nbsp; (35 Anos)</b>
        </span>
    </div>

    <lord-icon src="https://cdn.lordicon.com/xxdqfhbi.json" trigger="loop" delay="10000" colors="primary:#000,secondary:#ffb55c" class="bigIcon"></lord-icon>
</div>

<c:if test="${sessionScope.user == null}">
    <h1>Home</h1>
</c:if>

<c:if test="${sessionScope.user != null}">
    <h1>Hello ${sessionScope.user.name}</h1>
</c:if>