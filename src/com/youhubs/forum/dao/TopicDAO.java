package com.youhubs.forum.dao;

import java.util.List;
import com.youhubs.forum.bean.Topic;

public interface TopicDAO {

	List<Topic> listTopic();

	List<String> listImage();

}
