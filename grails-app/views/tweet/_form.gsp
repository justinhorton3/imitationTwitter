<%@ page import="mytwitter.Tweet" %>



<div class="fieldcontain ${hasErrors(bean: tweetInstance, field: 'content', 'error')} required">
	<label for="content">
		<g:message code="tweet.content.label" default="Content" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="content" required="" value="${tweetInstance?.content}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: tweetInstance, field: 'user', 'error')} required">
	<label for="user">
		<g:message code="tweet.user.label" default="User" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="user" name="user.id" from="${mytwitter.User.list()}" optionKey="id" required="" value="${tweetInstance?.user?.id}" class="many-to-one"/>

</div>

