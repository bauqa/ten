package com.demo.d.repositiry;

import com.demo.d.model.Message;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MessageRepository  extends CrudRepository<Message,Long> {
    List findAll();
    Message findByTag(String tag);
}
