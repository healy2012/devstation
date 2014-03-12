insertMessage=insert into message(message_id, message_author, message_content, message_time) values(?,?,?,now())
listMessage=select * from message
getMessageCount=select count(1) from message
