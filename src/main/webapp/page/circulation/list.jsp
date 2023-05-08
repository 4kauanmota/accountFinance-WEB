<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@ taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core" %>

<div>
  <form action="/control" method="GET" class="informationsForm">
    <fieldset>
      <input type="hidden" name="ac" value="circulation/list" />
      <p>
        <button type="submit" class="pointer">
            <lord-icon src="https://cdn.lordicon.com/rlizirgt.json" trigger="hover" colors="primary:#fff" class="iIcon"></lord-icon>
        </button>
      </p>

      <p>
        <input type="text" placeholder="Description" name="description" />
      </p>
    </fieldset>
  </form>

  <h1 class="listTitle">Total (${ requestScope.list.size() }) </h1>

  <table cellspacing="0">
    <thead>
      <tr>
        <th>Id</th>
        <th>Date</th>
        <th>Description</th>
        <th>Value</th>
        <th>Category</th>
      </tr>
    </thead>

    <tbody>
      <c:forEach var="crl" items="${ requestScope.list }">
        <tr>
          <td>${ crl.id }</td>
          <td>${ crl.date }</td>
          <td>${ crl.description }</td>
          <td>${ crl.value }</td>
          <td>${ crl.category.name }</td>
        </tr>
      </c:forEach>
    </tbody>
  </table>

  <div class="actionsOrganization">
      <form action="/control" method="GET">
        <fieldset>
            <input type="hidden" name="ac" value="circulation/register" />

            <p>
              <input type="submit" value="New" class="pointer" />
            </p>
        </fieldset>
      </form>
  </div>
</div>
