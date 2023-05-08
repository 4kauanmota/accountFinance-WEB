<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@ taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core" %>

<div>
  <c:forEach var="ap" items="${ requestScope.list }">
    <c:if test="${ ap.isExpirated == false }">
        <div class="card greenBorder">
    </c:if>
    <c:if test="${ ap.isExpirated == true }">
        <div class="card redBorder">
    </c:if>
      <form action="/control" method="POST">
        <fieldset>
          <input type="hidden" name="ac" value="accountsPayable/pay" />
          <input type="hidden" name="id" value="${ ap.id }" />

          <p class="informations">
            <span>
              <label for="provider">Provider: </label>
              <input
                type="text"
                name="provider"
                value="${ ap.provider }"
                id="provider"
                onchange="checkUpdate(this)"
              />
            </span>

            <span>
              <label for="description">Description: </label>
              <input
                type="text"
                name="description"
                value="${ ap.description }"
                id="description"
                onchange="checkUpdate(this)"
              />
            </span>
          </p>

          <p class="informations">
            <span>
              <label for="value">Value: </label>
              <input
                type="number"
                name="value"
                value="${ ap.value }"
                id="value"
                onchange="checkUpdate(this)"
              />
            </span>

            <span>
              <label for="expirationDate">Expiration Date: </label>
              <input
                type="date"
                name="expirationDate"
                value="${ ap.expirationDate }"
                id="expirationDate"
                onchange="checkUpdate(this)"
              />
            </span>
          </p>

          <c:if test="${ ap.isExpirated == false }">
            <p>
              <select name="paymentMethod" id="paymentMethod" placeholder="Payment Method" onchange="checkPay(this)">
                <option value=""></option>
                <option value="Credit Card">Credit Card</option>
                <option value="Debit Card">Debit Card</option>
                <option value="Transfer">Transfer</option>
                <option value="Billet">Billet</option>
                <option value="Pix">Pix</option>
                <option value="Money">Money</option>
              </select>
            </p>
          </c:if>

          <p class="center" id="actionArea">
          </p>
        </fieldset>
      </form>
    </div>
  </c:forEach>
</div>

<script src="../../js/accountPayable/pay.js" defer></script>
