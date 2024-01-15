class Solution {
  public boolean wordPattern(String pattern, String s) {
    String[] map = new String[26];
    HashSet<String> m = new HashSet<String>();
    String[] words = s.split(" ");
    if (words.length != pattern.length()) return false;

    for (int i = 0; i < pattern.length(); i++) {
      char ch = pattern.charAt(i);
      if (map[ch - 'a'] == null) {
        if (m.contains(words[i])) return false;
        map[ch - 'a'] = words[i];
        m.add(words[i]);
      } else if (!map[ch - 'a'].equals(words[i])) return false;
    }

    return true;
  }
}
