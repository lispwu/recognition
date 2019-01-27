package com.speech.recognition.dao;

import com.speech.recognition.model.EmojiToChinese;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EmojiDAO extends CrudRepository<EmojiToChinese,Long>{

    List<EmojiToChinese> findAllByWord(String word);

    EmojiToChinese findByEmojiUnicode(String emoji);

}
