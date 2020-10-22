<#macro layout>
<!DOCTYPE html>
<html>
<head>
<#include "../header.ftl" />
</head>
<body>
<#include "../navbar.ftl" />

<#nested>

<#include "../footer.ftl"/>
</body>
</html>
</#macro>