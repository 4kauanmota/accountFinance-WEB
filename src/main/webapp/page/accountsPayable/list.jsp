<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@ taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core" %>

<div>
  <form action="/control" method="GET" class="informationsForm">
    <fieldset>
      <input type="hidden" name="ac" value="accountsPayable/list" />
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
      <c:forEach var="ap" items="${ requestScope.list }">
        <tr>
          <td>${ ap.id }</td>
          <td>${ ap.provider }</td>
          <td>${ ap.description }</td>
          <td>R$ ${ ap.value }</td>
          <td>${ ap.expirationDate }</td>
          <td>${ ap.paymentDate }</td>
          <td>${ ap.paymentMethod }</td>
        </tr>
      </c:forEach>
    </tbody>
  </table>

  <div class="actionsOrganization">
      <form action="/control" method="GET">
         <fieldset>
            <input type="hidden" name="ac" value="accountsPayable/pay" />

            <p>
              <input type="submit" value="Pay" class="pointer" />
            </p>
        </fieldset>
      </form>

      <form action="/control" method="GET">
        <fieldset>
            <input type="hidden" name="ac" value="accountsPayable/register" />

            <p>
              <input type="submit" value="New" class="pointer" />
            </p>
        </fieldset>
      </form>
  </div>
</div>
