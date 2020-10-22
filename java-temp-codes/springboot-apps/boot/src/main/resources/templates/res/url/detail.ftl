<#import "/comm/layout/default.ftl" as layout_default>
<@layout_default.layout>
<div class="container">
	<div class="row">
		<div class="col-md-12">
			<h1>Hello Bootstrap 3.0 world - url </h1>
			<br/><a href=".">index</a>
			<br/><a href="url/2">url/2</a>:url -> ${count}
			<br/><a href="api/url/list?page=1&size=3">api/url/list 1,3</a>
		</div>
	</div>
</div>
</@layout_default.layout>
