<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@ taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core" %>

<div>
  <form action="/control" method="GET" class="informationsForm">
    <fieldset>
      <input type="hidden" name="ac" value="accountsReceivable/list" />
      <p>
        <button type="submit" class="pointer">
            <lord-icon src="https://cdn.lordicon.com/rlizirgt.json" trigger="hover" colors="primary:#fff" class="iIcon"></lord-icon>
        </button>
      </p>

      <p>
        <input type="text" placeholder="Provider" name="provider" id="provider" />
      </p>

      <p>
        <input type="text" placeholder="Description" name="description" id="description" />
      </p>
    </fieldset>
  </form>

  <h1 class="listTitle">Total (${ requestScope.list.size() }) </h1>

  <table cellspacing="0">
    <thead>
      <tr>
        <th>Id</th>
        <th>Provider</th>
        <th>Description</th>
        <th>Value</th>
        <th>Expiration Date</th>
        <th>Payment Date</th>
        <th>Payment Method</th>
      </tr>
    </thead>

    <tbody>
      <c:forEach var="ar" items="${ requestScope.list }">
        <tr>
          <td>${ ar.id }</td>
          <td>${ ar.provider }</td>
          <td>${ ar.description }</td>
          <td>R$ ${ ar.value }</td>
          <td>${ ar.expirationDate }</td>
          <td>${ ar.paymentDate }</td>
          <td>${ ar.paymentMethod }</td>
        </tr>
      </c:forEach>
    </tbody>
  </table>

  <div class="actionsOrganization">
      <form action="/control" method="GET">
        <fieldset>
            <input type="hidden" name="ac" value="accountsReceivable/register" />

            <p>
              <input type="submit" value="New" class="pointer" />
            </p>
        </fieldset>
      </form>
  </div>
</div>
