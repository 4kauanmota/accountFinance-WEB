<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="formOrganization">
  <form action="/control" method="POST" class="informationsForm">
    <input type="hidden" name="ac" value="accountsPayable/register" />

    <fieldset>
      <p>
        <input type="text" placeholder="Provider" name="provider" required>
      </p>

      <p>
        <input type="text" placeholder="Description" name="description" required>
      </p>

      <p>
        <input type="number" placeholder="Value" name="value" required>
      </p>

      <p>
        <input type="date" placeholder="Expiration Date" name="expirationDate" required>
      </p>

      <p class="center">
        <input type="submit" value="Register" class="pointer" />
      </p>
    </fieldset>
  </form>
</div>