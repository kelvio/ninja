/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ninja.text;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.MessageFormat;
import java.util.Scanner;
import java.util.StringTokenizer;
import ninja.collection.List;
import ninja.collection.MutableList;
import ninja.console.Console;
import ninja.consumer.Consumer;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.WordUtils;

/**
 *
 * @author kelvio
 */
class TextImpl implements Text {

    private final StringBuilder data = new StringBuilder();

    public TextImpl() {
    }

    public TextImpl(CharSequence source) {
        data.append(source);
    }

    @Override
    public void foreachInteger(Consumer<Integer> consumer) {
        try (Scanner sc = new Scanner(data.toString())) {

            while (sc.hasNextInt()) {
                consumer.consume(sc.nextInt());
            }

        }
    }

    @Override
    public void foreachLong(Consumer<Long> consumer) {
        try (Scanner sc = new Scanner(data.toString())) {

            while (sc.hasNextLong()) {
                consumer.consume(sc.nextLong());
            }

        }
    }

    @Override
    public void foreachFloat(Consumer<Float> consumer) {
        try (Scanner sc = new Scanner(data.toString())) {

            while (sc.hasNextFloat()) {
                consumer.consume(sc.nextFloat());
            }

        }
    }

    @Override
    public void foreachDouble(Consumer<Double> consumer) {
        try (Scanner sc = new Scanner(data.toString())) {

            while (sc.hasNextDouble()) {
                consumer.consume(sc.nextDouble());
            }

        }
    }

    @Override
    public void foreachBoolean(Consumer<Boolean> consumer) {
        try (Scanner sc = new Scanner(data.toString())) {

            while (sc.hasNextBoolean()) {
                consumer.consume(sc.nextBoolean());
            }

        }
    }

    @Override
    public void foreachByte(Consumer<Byte> consumer) {
        try (Scanner sc = new Scanner(data.toString())) {

            while (sc.hasNextByte()) {
                consumer.consume(sc.nextByte());
            }

        }
    }

    @Override
    public void foreachShort(Consumer<Short> consumer) {
        try (Scanner sc = new Scanner(data.toString())) {

            while (sc.hasNextShort()) {
                consumer.consume(sc.nextShort());
            }

        }
    }

    @Override
    public void foreachToken(Text pattern, Consumer<Text> consumer) {

        foreachToken(pattern.toString(), consumer);
    }

    @Override
    public boolean contains(Text other) {
        return data.toString().contains(((TextImpl) other).data.toString());
    }

    @Override
    public boolean startsWith(Text other) {
        return data.toString().startsWith(((TextImpl) other).data.toString());
    }

    @Override
    public Text replace(Text term, Text substitute) {
        return Text.of(new StringBuilder(data.toString().replace(((TextImpl) term).data.toString(), ((TextImpl) substitute).data.toString())));
    }

    @Override
    public Text uppercase() {
        return Text.of(new StringBuilder(data.toString().toUpperCase()));
    }

    @Override
    public Text downcase() {
        return Text.of(new StringBuilder(data.toString().toLowerCase()));
    }

    @Override
    public Text capitalize() {
        return Text.of(new StringBuilder(WordUtils.capitalizeFully(data.toString())));
    }

    @Override
    public Text center(int width) {
        return center(width, " ");
    }

    @Override
    public Text center(int width, String padStr) {

        StringBuilder newData = new StringBuilder(data.toString());
        for (int i = 0; i < width; i++) {
            newData.insert(0, padStr);
            newData.append(padStr);
        }
        return Text.of(newData);
    }

    @Override
    public Text reverse() {
        return Text.of(new StringBuilder(data.toString()).reverse());
    }

    @Override
    public boolean endsWith(Text text) {
        return data.toString().endsWith(((TextImpl) text).data.toString());
    }

    @Override
    public boolean isEmpty() {
        return data.length() == 0;
    }

    @Override
    public int size() {
        return data.length();
    }

    @Override
    public List<Text> lines() {
        MutableList<Text> lines = MutableList.newEmptyList();
        foreachLine(lines::add);
        return List.of(lines);
    }

    @Override
    public List<Text> words() {
        MutableList<Text> words = MutableList.newEmptyList();
        foreachWord(words::add);
        return List.of(words);
    }

    @Override
    public Text cut(int start) {
        return Text.of(new StringBuilder(data.substring(start)));
    }

    @Override
    public Text cut(int start, int end) {
        StringBuilder newData = new StringBuilder(data.substring(start, end));
        return Text.of(newData);
    }

    @Override
    public Text append(Text... parts) {
        StringBuilder newData = new StringBuilder(data.toString());
        for (Text t : parts) {
            newData.append(t.toString());
        }
        return Text.of(newData);
    }

    @Override
    public Text remove(Text term) {
        return remove(term.toString());
    }

    @Override
    public Text remove(CharSequence term) {
        StringBuilder newData = new StringBuilder(data.toString().replace(term.toString(), ""));
        return Text.of(newData);
    }

    @Override
    public String toString() {
        return data.toString();
    }
    
    
    @Override
    public Text append(CharSequence... parts) {
        StringBuilder newData = new StringBuilder(data.toString());
        for (CharSequence part : parts) {
            newData.append(part);
        }
        return Text.of(newData);
    }

    @Override
    public Text append(Object... parts) {
        StringBuilder newData = new StringBuilder(data.toString());
        for (Object part : parts) {
            newData.append(String.valueOf(part));
        }
        return Text.of(newData);
    }

    @Override
    public Text prepend(Text... parts) {
        StringBuilder newData = new StringBuilder(data.toString());
        for (Text part : parts) {
            newData.insert(0, part);
        }
        return Text.of(newData);
    }

    @Override
    public Text prepend(CharSequence... parts) {
        StringBuilder newData = new StringBuilder(data.toString());
        for (CharSequence part : parts) {
            newData.insert(0, part);
        }
        return Text.of(newData);
    }

    @Override
    public Text prepend(Object... parts) {
        StringBuilder newData = new StringBuilder(this.data.toString());
        for (Object part : parts) {
            newData.insert(0, part);
        }
        return Text.of(newData);
    }

    @Override
    public void foreachToken(CharSequence pattern, Consumer<Text> consumer) {

        StringTokenizer tokenizer = new StringTokenizer(pattern.toString());
        while (tokenizer.hasMoreTokens()) {
            consumer.consume(Text.of(tokenizer.nextToken()));
        }

    }

    @Override
    public Text sha256(Text salt) {
        return sha256(salt.toString());
    }

    @Override
    public Text sha256(CharSequence salt) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            String text = data.toString();

            if (salt != null) {
                text += salt;
            }

            md.update(text.getBytes("UTF-8"));
            byte[] digest = md.digest();
            return Text.of(convertByteArrayToHexString(digest));
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException ex) {
            throw new RuntimeException(ex);
        }

    }

    private static String convertByteArrayToHexString(byte[] arrayBytes) {
        StringBuilder stringBuffer = new StringBuilder();
        for (int i = 0; i < arrayBytes.length; i++) {
            stringBuffer.append(Integer.toString((arrayBytes[i] & 0xff) + 0x100, 16)
                    .substring(1));
        }
        return stringBuffer.toString();
    }

    @Override
    public Text sha256() {
        return sha256((CharSequence) null);
    }

    @Override
    public Text sha512(Text salt) {
        return sha512(salt.toString());
    }

    @Override
    public Text sha512(CharSequence salt) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-512");
            String text = data.toString();

            if (salt != null) {
                text += salt;
            }

            md.update(text.getBytes("UTF-8"));
            byte[] digest = md.digest();
            return Text.of(convertByteArrayToHexString(digest));
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException ex) {
            throw new RuntimeException(ex);
        }

    }

    @Override
    public Text sha512() {
        return sha512((CharSequence) null);
    }

    @Override
    public void foreachWord(Consumer<Text> consumer) {
        try (Scanner sc = new Scanner(data.toString())) {
            while (sc.hasNext()) {
                consumer.consume(Text.of(sc.next()));
            }
        }
    }

    @Override
    public void foreachLine(Consumer<Text> consumer) {
        try (Scanner sc = new Scanner(data.toString())) {
            while (sc.hasNextLine()) {
                consumer.consume(Text.of(sc.nextLine()));
            }
        }
    }

    @Override
    public boolean containsIgnoreCase(Text other) {
        return containsIgnoreCase(other.toString());
    }

    @Override
    public boolean startsWithIgnoreCase(Text other) {
        return startsWithIgnoreCase(other.toString());
    }

    @Override
    public Text replaceIgnoreCase(Text term, Text substitute) {
        return replaceIgnoreCase(term.toString(), substitute.toString());
    }

    @Override
    public Text removeIgnoreCase(Text term) {
        return removeIgnoreCase(term.toString());
    }

    @Override
    public Text removeIgnoreCase(CharSequence term) {
        return Text.of(data.toString().replaceAll("(?i)" + term.toString(), ""));
    }

    @Override
    public Text leftPad(int width) {
        return leftPad(width, " ");
    }

    @Override
    public Text leftPad(int width, String padStr) {
        return Text.of(StringUtils.leftPad(data.toString(), width, padStr));
    }

    @Override
    public Text rightPad(int width) {
        return rightPad(width, " ");
    }

    @Override
    public Text rightPad(int width, String padStr) {
        return Text.of(StringUtils.rightPad(data.toString(), width, padStr));
    }

    @Override
    public boolean endsWithIgnoreCase(Text text) {
        return endsWithIgnoreCase(text.toString());
    }

    @Override
    public Text abbreviate(int maxWidth) {
        return Text.of(StringUtils.abbreviate(data.toString(), maxWidth));
    }

    @Override
    public Text leftTrim() {
        return Text.of(data.toString().replaceAll("^\\s+", ""));
    }

    @Override
    public Text rightTrim() {
        return Text.of(data.toString().replaceAll("\\s+$", ""));
    }

    @Override
    public Text trim() {
        return Text.of(data.toString().trim());
    }

    @Override
    public boolean endsWithAny(Text... candidate) {
        String[] d = new String[candidate.length];
        for (int i = 0; i < candidate.length; i++) {
            d[i] = String.valueOf(candidate[i]);
        }
        return StringUtils.endsWithAny(data.toString(), d);
    }

    @Override
    public boolean endsWithAny(CharSequence... candidate) {
        String[] d = new String[candidate.length];
        for (int i = 0; i < candidate.length; i++) {
            d[i] = String.valueOf(candidate[i]);
        }
        return StringUtils.endsWithAny(data.toString(), d);
    }

    @Override
    public boolean endsWithAnyIgnoreCase(Text... candidate) {

        String str = data.toString();
        for (Text candidate1 : candidate) {
            if (StringUtils.endsWithIgnoreCase(str, String.valueOf(candidate1))) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean endsWithAnyIgnoreCase(CharSequence... candidate) {
        String str = data.toString();
        for (CharSequence candidate1 : candidate) {
            if (StringUtils.endsWithIgnoreCase(str, String.valueOf(candidate1))) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int countMatches(CharSequence pattern) {
        return StringUtils.countMatches(data.toString(), pattern.toString());
    }

    @Override
    public Text uncapitalize() {
        return Text.of(StringUtils.uncapitalize(data.toString()));
    }

    @Override
    public boolean containsOnly(CharSequence validChars) {
        return StringUtils.containsOnly(data.toString(), validChars.toString());
    }

    @Override
    public Text removeWhitespaces() {
        return Text.of(StringUtils.deleteWhitespace(data.toString()));
    }

    @Override
    public Text swapCase() {
        return Text.of(StringUtils.swapCase(data.toString()));
    }

    @Override
    public Text repeat(int times) {
        return Text.of(StringUtils.repeat(data.toString(), times));
    }

    @Override
    public Text replaceOnce(CharSequence text, CharSequence candidate) {
        return Text.of(StringUtils.replaceOnce(data.toString(), text.toString(), candidate.toString()));
    }

    @Override
    public Text replaceOnce(Text text, Text candidate) {
        return Text.of(StringUtils.replaceOnce(data.toString(), text.toString(), candidate.toString()));
    }

    @Override
    public Text normalizeSpaces() {
        return Text.of(StringUtils.normalizeSpace(data.toString()));
    }

    @Override
    public Text format(Object... args) {
        return Text.of(new MessageFormat(data.toString()).format(args));
    }

    @Override
    public boolean containsIgnoreCase(CharSequence part) {
        return StringUtils.containsIgnoreCase(data.toString(), part.toString());
    }

    @Override
    public boolean startsWithIgnoreCase(CharSequence other) {
        return StringUtils.startsWithIgnoreCase(data.toString(), other.toString());
    }

    @Override
    public Text replaceIgnoreCase(CharSequence term, CharSequence substitute) {
        return Text.of(data.toString().replaceAll("(?i)" + term.toString(), substitute.toString()));
    }

    @Override
    public boolean endsWithIgnoreCase(CharSequence text) {
        return StringUtils.endsWithIgnoreCase(data.toString(), text.toString());
    }

    @Override
    public char charAt(int index) {
        return data.charAt(index);
    }

    @Override
    public int indexOf(CharSequence term) {
        return data.indexOf(term.toString());
    }

    @Override
    public int indexOf(Text term) {
        return data.indexOf(term.toString());
    }

    @Override
    public int indexOf(char item) {
        return data.indexOf(String.valueOf(item));
    }

    @Override
    public int lastIndexOf(CharSequence term) {
        return data.lastIndexOf(term.toString());
    }

    @Override
    public int lastIndexOf(Text term) {
        return data.lastIndexOf(term.toString());
    }

    @Override
    public int lastIndexOf(char item) {
        return data.lastIndexOf(String.valueOf(item));
    }

    @Override
    public int lastIndexOf(CharSequence term, int fromIndex) {
        return data.lastIndexOf(term.toString(), fromIndex);
    }

    @Override
    public int lastIndexOf(Text term, int fromIndex) {
        return data.lastIndexOf(term.toString(), fromIndex);
    }

    @Override
    public int lastIndexOf(char item, int fromIndex) {
        return data.lastIndexOf(String.valueOf(item), fromIndex);
    }

    @Override
    public int indexOf(char item, int fromIndex) {
        return data.indexOf(String.valueOf(item), fromIndex);
    }

    @Override
    public int indexOf(CharSequence item, int fromIndex) {
        return data.indexOf(item.toString(), fromIndex);
    }

    @Override
    public int indexOf(Text item, int fromIndex) {
        return data.indexOf(item.toString(), fromIndex);
    }

    @Override
    public boolean matches(CharSequence pattern) {
        return data.toString().matches(pattern.toString());
    }

    @Override
    public boolean matches(Text pattern) {
        return matches(pattern.toString());
    }

    @Override
    public byte[] getBytes() {
        return data.toString().getBytes();
    }

    @Override
    public void foreachCharacter(Consumer<Character> consumer) {
        for (int i = 0; i < data.length(); i++) {
            consumer.consume(data.charAt(i));
        }
    }
    
    

    public static void main(String[] args) {
        Text.of("Kelvio Matias").reverse().swapCase().foreachCharacter(Console::writeLine);
    }

    @Override
    public boolean contains(CharSequence other) {
        return data.toString().contains(other);
    }
}
