<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<div class="formOrganization">
  <form action="/control" method="GET" class="informationsForm">
    <input type="hidden" name="ac" value="signIn" />

    <fieldset>
      <p>
        <input type="text" placeholder="Login" name="login" required>
      </p>
  
      <p>
        <input type="password" placeholder="Password" name="password" required>
      </p>
  
      <p class="center">
        <input type="submit" value="Sign in" class="pointer">
      </p>
    </fieldset>
  </form>
</div>