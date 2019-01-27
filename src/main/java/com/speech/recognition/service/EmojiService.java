package com.speech.recognition.service;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EmojiService {

    String translateChineseToEmoji(List<String> sentence);


    void addAssociationBetweenEmojiAndWord(List<String> emojis,List<String> words);

}
