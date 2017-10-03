<%@ include file="common/header.jspf" %>

<table>
<thead>
<tr>
<td>
Request received
</td>
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
${emp.getReceived()}
</td>
</tr>
</c:forEach>
</tbody>

</table>

<script src="/js/adminScript.js"