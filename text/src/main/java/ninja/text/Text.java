/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ninja.text;

import ninja.collection.List;
import ninja.consumer.Consumer;

/**
 *
 * @author kelvio
 */
public interface Text {
    
    void foreachWord(Consumer<Text> consumer);
    
    void foreachCharacter(Consumer<Character> consumer);
    
    void foreachInteger(Consumer<Integer> consumer);
    
    void foreachLong(Consumer<Long> consumer);
    
    void foreachFloat(Consumer<Float> consumer);
    
    void foreachDouble(Consumer<Double> consumer);
    
    void foreachBoolean(Consumer<Boolean> consumer);
    
    void foreachByte(Consumer<Byte> consumer);
    
    void foreachShort(Consumer<Short> consumer);
    
    void foreachLine(Consumer<Text> consumer);
    
    void foreachToken(Text pattern, Consumer<Text> consumer);
    
    void foreachToken(CharSequence pattern, Consumer<Text> consumer);
    
    boolean contains(Text other);
    
    boolean contains(CharSequence other);
    
    boolean containsIgnoreCase(Text other);
    
    boolean startsWith(Text other);
    
    boolean startsWithIgnoreCase(Text other);
    
    Text replace(Text term, Text substitute);
    
    Text replaceIgnoreCase(Text term, Text substitute);
    
    Text remove(Text term);
    
    Text removeIgnoreCase(Text term);
    
    Text remove(CharSequence term);
    
    Text removeIgnoreCase(CharSequence term);
    
    Text uppercase();
    
    Text downcase();
    
    Text capitalize();
    
    Text center(int width);
    
    Text center(int width, String padStr);
    
    Text leftPad(int width);
    
    Text leftPad(int width, String padStr);
    
    Text rightPad(int width);
    
    Text rightPad(int width, String padStr);
    
    Text reverse();
    
    boolean endsWith(Text text);
    
    boolean endsWithIgnoreCase(Text text);
    
    boolean isEmpty();
    
    int size();
    
    Text sha256(Text salt);
    
    Text sha256(CharSequence salt);  
    
    Text sha256();    
    
    Text sha512(Text salt);
    
    Text sha512(CharSequence salt);  
    
    Text sha512();
    
    List<Text> lines();
            
    List<Text> words();
    
    Text cut(int start);
    
    Text cut(int start, int end);
   
    Text append(Text ... parts);
    
    Text append(CharSequence ... parts);
    
    Text append(Object ... parts);
    
    Text prepend(Text ... parts);
    
    Text prepend(CharSequence ... parts);
    
    Text prepend(Object ... parts);
    
    Text abbreviate(int maxWidth);
    
    Text leftTrim();
    
    Text rightTrim();
    
    Text trim();
    
    boolean endsWithAny(Text ... candidate);
    
    boolean endsWithAny(CharSequence ... candidate);
    
    boolean endsWithAnyIgnoreCase(Text ... candidate);
    
    boolean endsWithAnyIgnoreCase(CharSequence ... candidate);
    
    char charAt(int index);
    
    int indexOf(CharSequence term);
    
    int indexOf(Text term);
    
    int indexOf(char item);
    
    int lastIndexOf(CharSequence term);
    
    int lastIndexOf(Text term);
    
    int lastIndexOf(char item);
    
    int lastIndexOf(CharSequence term, int fromIndex);
    
    int lastIndexOf(Text term, int fromIndex);
    
    int lastIndexOf(char item, int fromIndex);
    
    int indexOf(char item, int fromIndex);
    
    int indexOf(CharSequence item, int fromIndex);
    
    int indexOf(Text item, int fromIndex);
    
    int countMatches(CharSequence pattern);
    
    Text uncapitalize();
    
    Text swapCase();
    
    Text format(Object ... args);
        
    
    Text repeat(int times);
    
    default Text repeat() {
        return repeat(2);
    }
    
    boolean endsWithIgnoreCase(CharSequence text);
    
    Text replaceOnce(CharSequence text, CharSequence candidate);
    
    Text replaceOnce(Text text, Text candidate);
    
    Text normalizeSpaces();
    
    boolean startsWithIgnoreCase(CharSequence other);
    
    Text replaceIgnoreCase(CharSequence term, CharSequence substitute);
    
    default boolean containsOnly(Text validChars) {
        
        //8d969eef6ecad3c29a3a629280e686cf0c3f5d5a86aff3ca12020c923adc6c92
        //8d969eef6ecad3c29a3a629280e686cf0c3f5d5a86aff3ca12020c923adc6c92
        
        return containsOnly(validChars.toString());
    }
    
    boolean containsOnly(CharSequence validChars);
    
    
    
    Text removeWhitespaces();
    
    boolean containsIgnoreCase(CharSequence part);
    
    default int countMatches(Text pattern) {
        return countMatches(pattern.toString());
    }
    
    byte[] getBytes();
    
    boolean matches(CharSequence pattern);
    
    boolean matches(Text pattern);
            
    public static Text empty() {
        
        return new TextImpl();
    }
    
    public static Text of(CharSequence source) {
        return new TextImpl(source);
    }
    
    public static Text of(Text ... parts) {
        return Text.empty().append(parts);        
    }
}
