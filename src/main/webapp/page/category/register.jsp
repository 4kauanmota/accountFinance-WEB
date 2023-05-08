<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="formOrganization">
  <form action="/control" method="POST" class="informationsForm">
    <input type="hidden" name="ac" value="category/register" />

    <fieldset>
      <p>
        <input type="text" placeholder="Name" name="name" required>
      </p>

      <p class="center">
        <input type="submit" value="Register" class="pointer" />
      </p>
    </fieldset>
  </form>
</div>