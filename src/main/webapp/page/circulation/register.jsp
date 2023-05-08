<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="formOrganization">
  <form action="/control" method="POST" class="informationsForm">
    <input type="hidden" name="ac" value="circulation/register" />

    <fieldset>
      <p>
        <input type="text" placeholder="Description" name="description" required>
      </p>

      <p>
        <input type="number" placeholder="Value" name="value" required>
      </p>

      <p>
        <select name="category" id="category">
          <option value=""></option>
          <c:forEach var="cty" items="${ requestScope.list }">
            <option value="${ cty.name }"> ${cty.name} </option>
          </c:forEach>
        </select>
      </p>

      <p class="center">
        <input type="submit" value="Register" class="pointer" />
      </p>
    </fieldset>
  </form>
</div>