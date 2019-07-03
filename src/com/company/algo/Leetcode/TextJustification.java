package com.company.algo.Leetcode;

import java.util.ArrayList;

/* Given an array of words and a length L, format the text such that each line has exactly L characters and is fully 
 * (left and right) justified.You should pack your words in a greedy approach; that is, pack as many words as you can 
 * in each line. Pad extra spaces ' ' when necessary so that each line has exactly L characters.
 * Extra spaces between words should be distributed as evenly as possible. If the number of spaces on a line do not 
 * divide evenly between words, the empty slots on the left will be assigned more spaces than the slots on the right.
 * For the last line of text, it should be left justified and no extra space is inserted between words.
 * For example,
 * words: ["This", "is", "an", "example", "of", "text", "justification."]
 * L: 16.
 * Return the formatted lines as:
 * [
 *    "This    is    an",
 *    "example  of text",
 *    "justification.  "
 * ]
 * Note: Each word is guaranteed not to exceed L in length.
 */
public class TextJustification {
	public ArrayList<String> fullJustify(String[] words, int L) {
		int len = 0;
		int count = 0;
		ArrayList<String> list = new ArrayList<String>();
		if (words.length == 1) {
			list.add(words[0]);
			return list;
		}
		int spacenum = 0;
		StringBuilder str = new StringBuilder();
		if (L == 1) {
			StringBuilder s0 = new StringBuilder();
			for (int i = 0; i < words.length; i++) {
				spacenum = L - words[i].length();
				while (spacenum-- > 0)
					s0.append(" ");
				str.append(words[i]).append(s0);
			}
		}
		for (int i = 0; i < words.length; i++) {
			len += words[i].length() + 1;
			count++;

			if (len > L) {
				StringBuilder s = new StringBuilder();
				StringBuilder s1 = new StringBuilder();

				spacenum = (L - (len - words[i].length() - 1)) / (count - 1);
				int more = (L - (len - words[i].length() - 1)) % (count - 1);
				while (spacenum-- > 0)
					s.append(" ");
				s1.append(" ");
				if (more == 0) {
					for (int j = count; i > 0; j--)
						str.append(words[i - j]).append(s);
					str.delete(str.length() - spacenum, str.length());
				} else {
					while (more-- > 0) {
						str.append(words[i - count]).append(s1);
						count--;
					}
					while (count-- > 0)
						str.append(words[i - count]).append(s);
					str.delete(str.length() - spacenum, str.length());
				}
				list.add(str.toString());
			}

			count = 0;
			len = 0;
		}
		return list;
	}
}
