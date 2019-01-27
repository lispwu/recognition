package com.speech.recognition.service.impl;

import com.speech.recognition.dao.EmojiDAO;
import com.speech.recognition.model.EmojiToChinese;
import com.speech.recognition.service.EmojiService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.TreeMap;

public class EmojiServiceImpl implements EmojiService{

    @Autowired
    EmojiDAO emojiDAO;

    @Override
    public String translateChineseToEmoji(List<String> sentence) {

        if(sentence == null || sentence.size() < 1){
            return "";
        }

        StringBuilder result = new StringBuilder();

        //根据汉字查询对应的emoji
        for(String word:sentence){
            List<EmojiToChinese> matchList =  emojiDAO.findAllByWord(word);
            EmojiToChinese emoji = findSuitableEmoji(matchList);
            result.append(emoji.getEmojiUnicode());
        }

        return result.toString();
    }

    @Override
    public void addAssociationBetweenEmojiAndWord(List<String> emojis,List<String> words) {

        if(emojis == null || emojis.size() < 1){
            return;
        }

        if(words == null || words.size() < 1){
            return;
        }

        if(words.size() != emojis.size()){
            return;
        }

        int index = 0;
        for(String emoji:emojis){
            EmojiToChinese emojiToChinese = emojiDAO.findByEmojiUnicode(emoji);
            if(emojiToChinese == null){
                EmojiToChinese newEmoji = new EmojiToChinese();
                newEmoji.setEmojiUnicode(emoji);
                newEmoji.setWord(words.get(index));
                newEmoji.setCorrelation(2L);
                emojiDAO.save(newEmoji);
            }else {
                emojiToChinese.setCorrelation(emojiToChinese.getCorrelation() + 2);
                emojiDAO.save(emojiToChinese);
            }
            index++;
        }
    }

    /**
     * 通过关联度，找出最适合的emoji
     * @param matchList
     * @return
     */
    private EmojiToChinese findSuitableEmoji(List<EmojiToChinese> matchList){

        TreeMap<Long,Integer> map = new TreeMap<>();
        Integer pos = 0;
        for(EmojiToChinese emojiToChinese:matchList){
            map.put(emojiToChinese.getCorrelation(),pos);
        }
        return matchList.get(map.get(map.firstKey()));
    }
}
