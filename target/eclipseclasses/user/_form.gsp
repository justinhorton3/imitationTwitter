<%@ page import="mytwitter.User" %>



<div class="fieldcontain ${hasErrors(bean: userInstance, field: 'name', 'error')} required">
	<label for="name">
		<g:message code="user.name.label" default="Name" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="name" pattern="${userInstance.constraints.name.matches}" required="" value="${userInstance?.name}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: userInstance, field: 'tweets', 'error')} ">
	<label for="tweets">
		<g:message code="user.tweets.label" default="Tweets" />
		
	</label>
	<g:select name="tweets" from="${mytwitter.Tweet.list()}" multiple="multiple" optionKey="id" size="5" value="${userInstance?.tweets*.id}" class="many-to-many"/>

</div>

