<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div>
  <form action="/control" method="GET" class="informationsForm">
    <fieldset>
      <input type="hidden" name="ac" value="user/list" />
      <p>
          <button type="submit" class="pointer">
              <lord-icon src="https://cdn.lordicon.com/rlizirgt.json" trigger="hover" colors="primary:#fff" class="iIcon"></lord-icon>
          </button>
      </p>

      <p>
        <input type="text" placeholder="Name" name="name" id="name" />
      </p>

      <p>
        <input type="text" placeholder="Email" name="email" id="email" />
      </p>

      <p>
        <input type="text" placeholder="Login" name="login" id="login" />
      </p>
    </fieldset>
  </form>

  <h1 class="listTitle">Total (${ requestScope.list.size() }) </h1>

  <table cellspacing="0">
    <thead>
      <tr>
          <th>Id</th>
          <th>Name</th>
          <th>Email</th>
          <th>Login</th>
          <th>Password</th>
          <th>Acess date</th>
          <th>Salary</th>
          <th>Number of accounts</th>
          <th>Actions</th>
      </tr>
    </thead>

    <tbody>
      <c:forEach var="u" items="${ requestScope.list }">
        <tr>
          <td>${ u.id }</td>
          <td>${ u.name }</td>
          <td>${ u.email }</td>
          <td>${ u.login }</td>
          <td>${ u.password }</td>
          <td>${ u.acessDate }</td>
          <td>R$ ${ u.salary }</td>
          <td>${ u.accounts.size() }</td>
          <td>0</td>
        </tr>
      </c:forEach>
    </tbody>
  </table>

  <div class="actionsOrganization">
      <form action="/control" method="GET">
        <fieldset>
            <input type="hidden" name="ac" value="user/register" />

            <p>
              <input type="submit" value="New" class="pointer" />
            </p>
        </fieldset>
      </form>
  </div>
</div>
