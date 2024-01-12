class Solution {
  public boolean isSubsequence(String s, String t) {
    int curI = 0;

    for (int i = 0; i < t.length(); i++) {
      if (curI == s.length()) return true;
      if (t.charAt(i) == s.charAt(curI)) curI++;
    }

    return curI == s.length();
  }
}
