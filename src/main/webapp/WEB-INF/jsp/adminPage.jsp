<%@ include file="common/header.jspf" %>

<section id="call-to-action">
<div class="container">
<table class="table table-striped">
<caption>Request received</caption>
<thead>
<tr>
<td>
From
</td>
<td>
Email
</td>
<td>
Subject
</td>
<td>
Message
</td>
</tr>
</thead>
<tbody>
<c:forEach items="${contactEntities}" var="emp">
<tr>
<td>
${emp.name}
</td>
<td>
${emp.email}
</td>
<td>
${emp.subject}
</td>
<td>
${emp.message}
</td>
</tr>
</c:forEach>
</tbody>

</table>
</div>
<section>
<script src="/js/adminScript.js"