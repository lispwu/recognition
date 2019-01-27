package com.speech.recognition.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class EmojiToChinese {

    @Id
    @GeneratedValue
    private long pk;

    @Column
    private String emojiUnicode;

    @Column
    private String word;

    @Column
    private String pinyin;

    @Column
    private long correlation;

    public long getPk() {
        return pk;
    }

    public void setPk(long pk) {
        this.pk = pk;
    }

    public String getEmojiUnicode() {
        return emojiUnicode;
    }

    public void setEmojiUnicode(String emojiUnicode) {
        this.emojiUnicode = emojiUnicode;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getPinyin() {
        return pinyin;
    }

    public void setPinyin(String pinyin) {
        this.pinyin = pinyin;
    }

    public long getCorrelation() {
        return correlation;
    }

    public void setCorrelation(long correlation) {
        this.correlation = correlation;
    }

    @Override
    public String toString() {
        return "EmojiToChinese{" +
                "pk=" + pk +
                ", emojiUnicode='" + emojiUnicode + '\'' +
                ", word='" + word + '\'' +
                ", pinyin='" + pinyin + '\'' +
                ", correlation=" + correlation +
                '}';
    }
}
