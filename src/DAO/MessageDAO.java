package DAO;

import java.util.List;

import entity.MessageEntity;

public interface MessageDAO {
	String insertMessage(MessageEntity message);
	String updateMessage(MessageEntity message);
	String deleteMessage(MessageEntity message);
	List queryMessage(String type,Object value);
}
