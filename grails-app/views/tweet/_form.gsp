<%@ page import="sftwitter.Tweet" %>



<div class="fieldcontain ${hasErrors(bean: tweetInstance, field: 'content', 'error')} required">
	<label for="content">
		<g:message code="tweet.content.label" default="Content" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="content" required="" value="${tweetInstance?.content}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: tweetInstance, field: 'author', 'error')} required">
	<label for="author">
		<g:message code="tweet.author.label" default="Author" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="author" name="author.id" from="${sftwitter.User.list()}" optionKey="id" required="" value="${tweetInstance?.author?.id}" class="many-to-one"/>

</div>

<div class="fieldcontain ${hasErrors(bean: tweetInstance, field: 'sent', 'error')} required">
	<label for="sent">
		<g:message code="tweet.sent.label" default="Sent" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="sent" precision="day"  value="${tweetInstance?.sent}"  />

</div>

